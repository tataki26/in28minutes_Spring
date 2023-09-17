import './App.css';

import Counter from './components/counter/Counter';

function App() {
  return (
    <div className="App">
      <Counter />
      <Counter by={2}/>
      <Counter by={5}/>
    </div>
  );
}

export default App;
