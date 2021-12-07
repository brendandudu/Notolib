import React, { useContext } from 'react'
import { Link } from 'react-router-dom';
import profilChoice from '../context/profilChoice';
import Button from 'react-bootstrap/Button';


const Navbar=()=>{

    const {userProfil} = useContext(profilChoice);

    return (
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Notolib</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarSupportedContent">
                <ul class="navbar-nav mr-auto">
                    { userProfil === 1 &&
                        <li class="nav-item active">
                            <a class="nav-link" href="/find">Accueil <span class="sr-only">(current)</span></a>
                        </li>
                    }
                    <li class="nav-item">
                        <a class="nav-link" href="/apropos">A propos</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/mybookings">Mes rendez-vous</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="/notifications">Alertes</a>
                    </li>
                </ul>
                Connecté en tant que { userProfil != 1 ? "Notaire Notaire (ID : 1) " : "Acquereur Acquereur (ID : 21) "}
                 <Link to="/"><Button>Changer</Button></Link> 
            </div>
        </nav>
    )
}
export default Navbar;