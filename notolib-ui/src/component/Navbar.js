import React, {useContext, useEffect, useState} from 'react'
import {Link} from 'react-router-dom';
import profilChoice from '../context/profilChoice';
import Button from 'react-bootstrap/Button';


const Navbar = () => {

    const {userProfil} = useContext(profilChoice);

    const [notifcount, setNotifCount] = useState(0);

    const fetchAllNotifications = async () => {
        const response = await fetch("http://localhost:8080/notification/user/" + userProfil + "/notifications/new/count");
        const data = await response.json();

        setNotifCount(data);
    };

    useEffect(fetchAllNotifications, []);


    return (
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="/">Notolib</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                    aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    {userProfil === 21 &&
                    <li class="nav-item active">
                        <Link class="nav-link" to="/find">RDV <span class="sr-only">(current)</span></Link>
                    </li>
                    }
                    <li class="nav-item">
                        <Link class="nav-link" to="/apropos">A propos</Link>
                    </li>
                    <li class="nav-item">
                        <Link class="nav-link" to="/mybookings">Mes rendez-vous</Link>
                    </li>
                    <li class="nav-item">
                        <Link class="nav-link" to="/notifications">Alertes ({notifcount}) </Link>
                    </li>
                </ul>
                Connecté en tant que {userProfil != 21 ? "Notaire Notaire (ID : 1) " : "Acquereur Acquereur (ID : 21) "}
                <Link to="/"><Button className="ml-2">Changer</Button></Link>
            </div>
        </nav>
    )
}
export default Navbar;