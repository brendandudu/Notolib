import React from 'react';
import Card from 'react-bootstrap/Card';
import "bootstrap/dist/css/bootstrap.min.css";
import Button from 'react-bootstrap/Button'

const CardTimeSlot = ({timeSlot}) => {

    const sendBooking = () => {

    }
    
    return (
        <div>
            <Card border="dark" style={{ width: '18rem' }}>
            <Card.Body>
                <Card.Title>Notaire : {timeSlot.notary.firstName} {timeSlot.notary.lastName}</Card.Title>
                <Card.Subtitle className="mb-2 text-muted"></Card.Subtitle>
                <Card.Text>
                {timeSlot.startTime}  -> {timeSlot.endTime}
                </Card.Text>
                <Button onChange="" variant="danger">Prendre RDV</Button>
            </Card.Body>
            </Card>
        </div>
    );
};

export default CardTimeSlot;