import { useState, useEffect } from 'react';
import "bootstrap/dist/css/bootstrap.min.css";
import Button from 'react-bootstrap/Button';
import Card from 'react-bootstrap/Card';
import CardTimeSlot from '../component/CardTimeSlot';
import { CardGroup } from 'react-bootstrap';

const FindBooking = () => {

    const [timeSlots, setTimeSlots] = useState(null);
    const [date, setDate] = useState(null);

    const sendBooking = async (timeSlot) => {
        console.log("http://localhost:8080/booking/acquirer/21/timeslot/"+ timeSlot.id + "/" + date)
        await fetch("http://localhost:8080/booking/acquirer/21/timeslot/"+ timeSlot.id + "/" + date, {
            method: 'POST'
        });
    }

    const handleSubmit = async (event) => {

        event.preventDefault();
        setDate(event.target[0].value)
        console.log( event.target[0].value)
        const res = await fetch("http://localhost:8080/timeslot/find?date=" + event.target[0].value, {
            headers : { 
              'Content-Type': 'application/json',
              'Accept': 'application/json'
             }
          })

        const json = await res.json();
        setTimeSlots(json)
        console.log(json)
    }

    return (
        <div>
            <form onSubmit={handleSubmit}>
                <input type="date" name="date" required/>
                <input type="submit" value="Rechercher" />
            </form>
            {timeSlots && 
                <CardGroup>
                    {timeSlots.map((timeSlot) => (
                        <Card border="dark" style={{ width: '18rem' }}>
                        <Card.Body>
                            <Card.Title>Notaire : {timeSlot.notary.firstName} {timeSlot.notary.lastName}</Card.Title>
                            <Card.Subtitle className="mb-2 text-muted">{timeSlot.id}</Card.Subtitle>
                            <Card.Text>
                            {timeSlot.startTime}  -> {timeSlot.endTime}
                            
                            </Card.Text>
                            <Button onClick={() => sendBooking(timeSlot)} variant="danger">Prendre RDV</Button>
                        </Card.Body>
                        </Card>
                    ))}
                </CardGroup>

            }
        </div>
    );
};

export default FindBooking;