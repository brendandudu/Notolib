import React from 'react';
import { useState, useEffect } from 'react';
import Card from 'react-bootstrap/Card';
import "bootstrap/dist/css/bootstrap.min.css";
import Navbar from '../component/Navbar';

const Notification = () => {

    const [notifications, setNotifications] = useState([]);
    const [isRead, setisRead]=useState(false);

    const fetchAllNotifications = async () => {
        const response = await fetch("http://localhost:8080/notification/user/21/notifications", {
            headers : {
                'Content-Type': 'application/json',
                'Accept': 'application/json'
            }

        })
        const data = await response.json();

        console.log(data)

        setNotifications(data);
        setisRead(true);

        window.scrollTo({
            top : 100,
            behavior : "smooth"
        })
    };

    useEffect(() => {
        fetchAllNotifications();
    }, []);

    return (
        <>
            {notifications &&
            <>
                <Navbar/>
                <h3 className="py-3 bg-yellow-100"> Vos notifications</h3>
                <section className="">
                    {notifications.map((notif)=> (
                        <Card  className="" border="" style={{ width: '40rem'}}>
                            <Card.Body className="bg-gray-100" >
                                <Card.Title className="">Notification</Card.Title>
                                <Card.Text>
                                    {notif.message}
                                </Card.Text>
                            </Card.Body>
                        </Card>
                    ))}
                </section>
            </>
            }
        </>
    );
};

export default Notification;