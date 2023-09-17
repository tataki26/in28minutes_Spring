import './App.css';
import { Component } from 'react';

function App() {
  return (
    <div className="App">
      <FirstComponent />
      <SecondComponent></SecondComponent>
      <ThirdComponent />
      <FourthComponent></FourthComponent>
    </div>
  );
}

// function component

function FirstComponent() {
  return <div className="FirstComponent">First Component</div>
}

function SecondComponent() {
  return (
    <div className='SecondComponent'>Second Component</div>
  )
}

// class component

class ThirdComponent extends Component {
  render() {
    return (
      <div className='ThirdComponent'>Third Component</div>
    )
  }
}

class FourthComponent extends Component {
  render() {
    return (
      // parent
      <>
        <div className='FourthComponent'>Fourth Component 1</div>
        <div className='FourthComponent'>Fourth Component 2</div>
      </>
    )
  }
}

export default App;
