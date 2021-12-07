import React from 'react';
import Button from 'react-bootstrap/Button';
import {useContext} from 'react';
import profilChoice from "../context/profilChoice";
import { useHistory } from 'react-router-dom';
import { Alert, Col, Container, Row } from 'react-bootstrap';

const ProfileChoicePage = () => {

    const {setUserProfil} = useContext(profilChoice);
    const history = useHistory();

    const handleAcq = () => {
        setUserProfil(21);
        history.push("/find");
    }

    const handleNot = () => {
        setUserProfil(1);
        history.push("/mybookings");
    }

    return (
        <Container>
            <Row className="text-center pt-4">
                <h1>Choisir votre profil</h1>
            <div className="mt-3">
                <Button className="mr-3" onClick={() => handleAcq()}>Profil Acquereur (id : 21)</Button>
                <Button variant="success" onClick={() => handleNot()}>Profil Notaire (id : 1)</Button>
            </div>
            <Alert variant="primary" className="mt-5">Info : En tant que notaire vous ne pouvez pas prendre de rendez-vous</Alert>
            <Alert variant="danger" className="mt-2">Attention : Pour pouvoir tester les deux profils, lors de votre prise de RDV, merci de selectionner uniquement les créneaux du notaire portant le nom : Notary Notary</Alert>
            <Alert variant="danger" className="mt-2">Veuillez également lancer Quarkus avant de choisir votre profil.</Alert>
            </Row>
        </Container>
    );
};

export default ProfileChoicePage;