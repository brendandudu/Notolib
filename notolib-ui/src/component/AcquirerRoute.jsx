import { Redirect, Route } from "react-router";
import profilChoice from "../context/profilChoice";
import {useContext} from 'react';

const AcquirerRoute = ({path, component}) =>{
    const {userProfil} = useContext(profilChoice);

    return userProfil === 1 ? (
        <Route exact path={path} component={component} />
    ) : (
        <Redirect to="/"/>
    )
}

export default AcquirerRoute;