import logo from './logo.svg';
import './App.css';
import FindBooking from './pages/FindBooking';
import Apropos from './pages/Apropos';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
import MyBookings from './pages/MyBookings';
import Notification from './pages/Notification';


function App() {
  return (

      <Router>
        <Switch>
          <Route exact path="/">
            <FindBooking/>
          </Route>
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
  );
}

export default App;
