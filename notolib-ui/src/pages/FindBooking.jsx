import { useState, useEffect } from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import "../styles/findBooking.css";
import { CardGroup, Col, Container, Row } from 'react-bootstrap';

const FindBooking = () => {

    const [timeSlots, setTimeSlots] = useState(null);
    const [date, setDate] = useState(null);
    const [tsChoice, setTsChoice] = useState(null);
    const [lodgingChoice, setLodgingChoice] = useState(null);

    const sendBooking = async (timeSlot) => {
        await fetch("http://localhost:8080/booking/acquirer/21/timeslot/"+ tsChoice + "/" + date, {
            method: 'POST'
        });

        window.location.href='/';
    }

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
            
                <Row className='row-cols-1 row-cols-md-4 g-4 mt-2'>
                    <Col>
                    <Card border="dark" style={{ width: '18rem' }} id={"lod-1"} className="lodCard" onClick={() => setSelectedLodging(1)}>
                    <Card.Img variant="top" src="https://www.astuces-express.com/wp-content/uploads/2019/04/donner-un-nouveau-look-a-votre-maison-1.jpg" />
                        <Card.Body>
                            <Card.Title>Maison 1</Card.Title>
                            <Card.Subtitle className="mb-3 text-muted">100 000€</Card.Subtitle>
                                    <Card.Text>    
                                        Jolie appartement vu sur la mer               
                                    </Card.Text>
                        </Card.Body>
                        </Card>
                    </Col>
                    <Col>
                        <Card border="dark" style={{ width: '18rem' }} id={"lod-2"} className="lodCard" onClick={() => setSelectedLodging(2)}>
                        <Card.Img variant="top" src="https://www.astuces-express.com/wp-content/uploads/2019/04/donner-un-nouveau-look-a-votre-maison-1.jpg" />
                        <Card.Body>
                            <Card.Title>Maison 1</Card.Title>
                            <Card.Subtitle className="mb-3 text-muted">170 000€</Card.Subtitle>
                                    <Card.Text>    
                                        Jolie appartement vu sur la mer               
                                    </Card.Text>
                        </Card.Body>
                        </Card>
                    </Col>
                    <Col>
                        <Card border="dark" style={{ width: '18rem' }}  id={"lod-3"} className="lodCard" onClick={() => setSelectedLodging(3)}>
                        <Card.Img variant="top" className="h-75" src="https://www.astuces-express.com/wp-content/uploads/2019/04/donner-un-nouveau-look-a-votre-maison-1.jpg"/>
                        <Card.Body>
                            <Card.Title>Maison 1</Card.Title>
                            <Card.Subtitle className="mb-3 text-muted">310 000€</Card.Subtitle>
                                    <Card.Text>    
                                        Jolie appartement vu sur la mer             
                                    </Card.Text>
                        </Card.Body>
                        </Card>
                    </Col>
                        
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