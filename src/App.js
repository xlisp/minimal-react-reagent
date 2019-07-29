import React from 'react';
import logo from './logo.svg';
import './App.css';

/*
IMPORTANT

If you introduce the compiled JavaScript by <script> tag in HTML,
That variable will be avaiable at runtime like this.

You can't "import" it in ES6 because it is not available at
ES6 compile stage.
*/
const MyComponent = window.foo.core.MyComponent;

function App() {
  return (
    <div className="App">
      <header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
        <MyComponent/>
      </header>
    </div>
  );
}

export default App;
