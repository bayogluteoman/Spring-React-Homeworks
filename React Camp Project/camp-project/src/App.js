import logo from './logo.svg';
import './App.css';
import Dashboard from './layouts/Dashboard';
import Navi from './layouts/Navi';
import { Container } from 'semantic-ui-react';
import 'semantic-ui-css/semantic.min.css';

function App() {
  return (
    <div className="App">
      <Navi/>
      <Container className="main">
      <Dashboard/>
      </Container>
    </div>
  );
}

export default App;
