import { useState, useEffect } from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import { CardGroup, Container, Row } from 'react-bootstrap';

const FindBooking = () => {

    const [timeSlots, setTimeSlots] = useState(null);
    const [date, setDate] = useState(null);

    const sendBooking = async (timeSlot) => {
        await fetch("http://localhost:8080/booking/acquirer/21/timeslot/"+ timeSlot.id + "/" + date, {
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


    return (
        <Container>
            <Row className="text-center">
            <form onSubmit={handleSubmit}>
                <input type="date" name="date" required/>
                <input type="submit" value="Rechercher" />
            </form>
            </Row>
            {date && 
                <div>
                    Date : {date}
                </div>
            }
            {timeSlots && 
                <CardGroup className="mt-5">
                    {timeSlots.map((notary) => (
                        <Card border="dark" style={{ width: '18rem' }}>
                        <Card.Body>
                            <Card.Title>{notary[0].notary.firstName} {notary[0].notary.lastName}</Card.Title>
                            <Card.Subtitle className="mb-3 text-muted">Créneaux disponibles :</Card.Subtitle>
                            {notary.map((ts) => (
                                <>
                                    <Card.Text>
                                        <Button onClick={() => sendBooking(ts)} variant="success">{ts.startTime}</Button>
                                    </Card.Text>
                                
                                </>
                            ))}
                        </Card.Body>
                        </Card>
                    ))}
                </CardGroup>

            }
        </Container>
    );
};

export default FindBooking;