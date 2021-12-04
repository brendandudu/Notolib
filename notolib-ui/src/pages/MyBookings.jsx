import React from 'react';
import { useState, useEffect } from 'react';
import Card from 'react-bootstrap/Card';
import "bootstrap/dist/css/bootstrap.min.css";
import Button from 'react-bootstrap/Button'

const MyBooking = () => {

    const [bookings, setBookings] = useState(null);

    const fetchAllBookings = async () => {
        const res = await fetch("http://localhost:8080/booking/user/39/bookings", {
            headers : { 
              'Content-Type': 'application/json',
              'Accept': 'application/json'
             }
      
          })
        const json = await res.json();

        console.log(json)
    
        setBookings(json);
    };

    useEffect(() => {
        fetchAllBookings();
    }, []);

    return (
        <div>
            <h1 className="mb-5">
                Vos rendez-vous :
            </h1>
            {bookings && 
            <Card border="dark" style={{ width: '18rem' }}>
            <Card.Body>
                <Card.Title>Notaire : {bookings[0].id.timeSlot.notary.firstName} {bookings[0].id.timeSlot.notary.lastName}</Card.Title>
                <Card.Subtitle className="mb-2 text-muted">{bookings[0].id.date}</Card.Subtitle>
                <Card.Text>
                {bookings[0].id.timeSlot.startTime}  -> {bookings[0].id.timeSlot.endTime}
                </Card.Text>
                <Button variant="danger">Annuler</Button>
            </Card.Body>
            </Card>
            }
        </div>
    );
};

export default MyBooking;