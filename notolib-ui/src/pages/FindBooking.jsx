import { useState, useEffect } from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import "../styles/findBooking.css";
import { CardGroup, Col, Container, Row, Spinner } from 'react-bootstrap';

const FindBooking = () => {

    const [timeSlots, setTimeSlots] = useState(null);
    const [lodgings, setLodgings] = useState(null);

    const [date, setDate] = useState(null);
    const [tsChoice, setTsChoice] = useState(null);
    const [lodgingChoice, setLodgingChoice] = useState(null);

    const [lodgingLoad, setLodgingLoad] = useState(false);

    const sendBooking = async (timeSlot) => {
        await fetch("http://localhost:8080/booking/acquirer/21/timeslot/"+ tsChoice + "/" + date, {
            method: 'POST'
        });
        
        window.alert("Rendez-vous effectué, vous allez être redirigé")
        window.location.href='/';
    }

    useEffect(async () => {
        const t = await fetch("http://localhost:8080/lodging/lodgings", {
            headers : { 
              'Content-Type': 'application/json',
              'Accept': 'application/json'
             }
          })
        const json = await t.json();
        setLodgings(json);
    }, [date])

    const handleSubmit = async (event) => {
        
        event.preventDefault();
        setDate(event.target[0].value)
        const res = await fetch("http://localhost:8080/timeslot/find?date=" + event.target[0].value, {
            headers : { 
              'Content-Type': 'application/json',
              'Accept': 'application/json'
             }
          })

        const json = await res.json();

        var results = json.reduce(function(results, notary) {
            (results[notary.notary.id] = results[notary.notary.id] || []).push(notary)
            return results;
        }, {})


        const resultsAsArray = [];

        for(var i in results){
            resultsAsArray.push(results[i])
        }

        setTimeSlots(resultsAsArray)
    }

    const handleSubmitPriceForm = async (event) => {
        
        event.preventDefault();

        if(event.target[0].value == "") 
           return

        setLodgingLoad(true);


        const res = await fetch("http://localhost:8080/lodging/lodgings/query?maxPrice=" + event.target[0].value, {
            headers : { 
              'Content-Type': 'application/json',
              'Accept': 'application/json'
             }
          })

        const json = await res.json();
        
        setLodgings(json);
        setLodgingLoad(false);
    }

    const setSelectedTs = (id) => {
        if(tsChoice){
            var ts = document.getElementById("ts-" + tsChoice);
            ts.classList.toggle("selected");
        }
        setTsChoice(id);
        var ts = document.getElementById("ts-" + id);
        ts.classList.toggle("selected");
    }

    const setSelectedLodging = (id) => {
        if(lodgingChoice){
            var lod = document.getElementById("lod-" + lodgingChoice);
            lod.classList.toggle("selected");
        }
        setLodgingChoice(id);
        var lod = document.getElementById("lod-" + id);
        lod.classList.toggle("selected");
    }

    useEffect(() => {
        setTsChoice(null);
        setLodgingChoice(null)
    }, [date]);



    return (
        <Container className="p-4">
            <Row className="text-center">
                <form onSubmit={handleSubmit}>
                    <input type="date" name="date" required/>
                    <input type="submit" value="Rechercher" />
                </form>
            </Row>

            {date && 
                <div>
                    <u>Date</u> : {date}
                </div>
            }

            {timeSlots && 
            <>
                <h3 className="mt-4">Etape 1:</h3> Choisir votre notaire et votre créneau
                <CardGroup className="mt-4">
                    {timeSlots.map((notary) => (
                        <Card border="dark" style={{ width: '18rem' }}>
                        <Card.Body>
                            <Card.Title>{notary[0].notary.firstName} {notary[0].notary.lastName}</Card.Title>
                            <Card.Subtitle className="mb-3 text-muted">Créneaux disponibles :</Card.Subtitle>
                            {notary.map((ts) => (
                                <>
                                    <Card.Text>
                                        <Button id={"ts-"+ ts.id} onClick={() => setSelectedTs(ts.id) } variant="success">{ts.startTime}</Button>
                                    </Card.Text>
                                
                                </>
                            ))}
                        </Card.Body>
                        </Card>
                    ))}
                </CardGroup>
                </>
            }

            {tsChoice &&
            <div> 
                <h3 className="mt-4">Etape 2:</h3> Choisir votre hébergement
                <Row>
                <form className="pt-3" onSubmit={handleSubmitPriceForm}>
                    Prix maximum : 
                    <input type="number" min="0"/>
                    <input type="submit" value="Filtrer" />
                    {lodgingLoad && <Spinner animation="border" variant="info"/>}
                </form>
                </Row>
            
                <Row className='row-cols-1 row-cols-md-4 g-4 mt-2'>

                    {lodgings.map((lodging) => (
                        <Col>
                        <Card border="dark" style={{ width: '18rem' }} id={"lod-" + lodging.id} className="lodCard h-100" onClick={() => setSelectedLodging(lodging.id)}>
                        <Card.Img variant="top" src={lodging.picture} />
                            <Card.Body>
                                <Card.Title>{lodging.title}</Card.Title>
                                <Card.Subtitle className="mb-3 text-muted">{lodging.price}€</Card.Subtitle>
                                        <Card.Text>    
                                            {lodging.description}            
                                        </Card.Text>
                            </Card.Body>
                            </Card>
                        </Col>
                    ))}

                </Row>
                </div>
            }

            {tsChoice && lodgingChoice && 

            <div class="mt-5">
            <Button variant="success" onClick={() => sendBooking() }>Réserver</Button>
            </div>
            }
        </Container>
    );
};

export default FindBooking;