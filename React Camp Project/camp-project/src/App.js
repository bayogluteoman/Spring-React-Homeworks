import './App.css';
import 'semantic-ui-css/semantic.min.css'
import Navi from './layouts/Navi';
import Dashboard from './layouts/Dashboard';
import { Container } from 'semantic-ui-react';

function App() {
  return (
    <div className="App">
      <Navi></Navi>
      <Container className = "main">
        <Dashboard></Dashboard>
      </Container>
      
    </div>
  );
}

export default App;
