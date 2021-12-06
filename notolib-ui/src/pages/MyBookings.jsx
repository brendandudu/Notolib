import React from 'react';
import { useState, useEffect } from 'react';
import Card from 'react-bootstrap/Card';
import "bootstrap/dist/css/bootstrap.min.css";
import Button from 'react-bootstrap/Button';
import Footer from '../component/Footer';
import Navbar from '../component/Navbar';

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
        <main>
            <Navbar/>
            <section className=" herordv py-60 min-h-96">
                <div className="container max-w-8xl mx-auto h-full flex flex-col items-center gap-8">
                    <div className="items-center">
                        <h1 className="mb-3 text-white">
                            Vos rendez-vous :
                        </h1>
                        {bookings &&
                        <Card className="text-center rounded-5xl" border="dark" style={{ width: '30rem' }}>
                            <Card.Body>
                                <Card.Title>Notaire : {bookings[0].id.timeSlot.notary.firstName} {bookings[0].id.timeSlot.notary.lastName} </Card.Title>
                                <Card.Subtitle className="mb-2 text-muted"> 22-10-2021</Card.Subtitle>
                                <Card.Text>
                                    {bookings[0].id.timeSlot.startTime}  - {bookings[0].id.timeSlot.endTime}
                                </Card.Text>
                                <Button className="focus:outline-none bg-gradient-to-br from-pink-200 via-red-400 to-red-600 hover:from-red-600 hover:to-pink-200 rounded-xl absolute text-white font-bold px-6 py-8 left-1/2 transform -translate-x-1/2 " variant="danger">Annuler</Button>
                            </Card.Body>
                        </Card>
                        }
                    </div>
                </div>
            </section>
            <Footer/>
        </main>
    );
};

export default MyBooking;