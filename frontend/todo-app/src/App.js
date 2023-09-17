import './App.css';
import FirstComponent from './components/learning-examples/FirstComponent';
import SecondComponent from './components/learning-examples/SecondComponent';
import ThirdComponent from './components/learning-examples/ThirdComponent';
import FourthComponent from './components/learning-examples/FourthComponent';
import { FifthComponent } from './components/learning-examples/FirstComponent';

function App() {
  return (
    <div className="App">
      <FirstComponent />
      <SecondComponent></SecondComponent>
      <ThirdComponent />
      <FourthComponent></FourthComponent>
      <FifthComponent />
    </div>
  );
}

export default App;
