import React from 'react';
import { useContext, useState, useEffect } from 'react';
import Card from 'react-bootstrap/Card';
import "bootstrap/dist/css/bootstrap.min.css";
import Button from 'react-bootstrap/Button';
import Footer from '../component/Footer';
import Navbar from '../component/Navbar';
import { CardGroup } from 'react-bootstrap';
import profilChoice from "../context/profilChoice";

const MyBooking = () => {

    const {userProfil} = useContext(profilChoice);

    const [bookings, setBookings] = useState(null);

    const fetchAllBookings = async () => {
        const res = await fetch("http://localhost:8080/booking/user/" + userProfil + "/bookings", {
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

                            <CardGroup>
                                {bookings.map(booking =>
                                <Card className="text-center rounded-5xl" border="dark" style={{ width: '30rem' }}>
                                    <Card.Body>
                                        <Card.Title>Notaire : {booking.id.timeSlot.notary.firstName} {booking.id.timeSlot.notary.lastName} </Card.Title>
                                        <Card.Subtitle className="mb-2 text-muted">{booking.id.date}</Card.Subtitle>
                                        <Card.Text>
                                            {booking.id.timeSlot.startTime}  - {booking.id.timeSlot.endTime}
                                        </Card.Text>
                                        <Button className="focus:outline-none bg-gradient-to-br from-pink-200 via-red-400 to-red-600 hover:from-red-600 hover:to-pink-200 rounded-xl absolute text-white font-bold px-6 py-8 left-1/2 transform -translate-x-1/2 " variant="danger">Annuler</Button>
                                    </Card.Body>
                                </Card>
                                )}
                            </CardGroup>
                        }
                    </div>
                </div>
            </section>
            <Footer/>
        </main>
    );
};

export default MyBooking;