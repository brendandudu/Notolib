import logo from './logo.svg';
import './App.css';
import FindBooking from './pages/FindBooking';
import Apropos from './pages/Apropos';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import MyBookings from './pages/MyBookings';
import Notification from './pages/Notification';
import { useState, useEffect } from 'react';
import profilChoice from './context/profilChoice';
import AcquirerRoute from './component/AcquirerRoute';
import ProfileChoicePage from './pages/ProfileChoicePage';
import Navbar from './component/Navbar';


function App() {

  const [userProfil, setUserProfil] = useState(1);
  const value = { userProfil, setUserProfil };

  return (
    <profilChoice.Provider value={value}>
      <Router>
        <Switch>
          <Route exact path="/">
            <ProfileChoicePage />
          </Route>
          <AcquirerRoute path="/find" component={FindBooking} />
          <Route path="/apropos">
            <Apropos />
          </Route>
          <Route path="/mybookings">
            <MyBookings/>
          </Route>
          <Route path="/notifications">
            <Notification/>
          </Route>
        </Switch >
      </Router >
      </profilChoice.Provider>
  );
}

export default App;
