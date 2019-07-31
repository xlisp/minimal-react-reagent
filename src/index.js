import React from 'react';
import ReactDOM from 'react-dom';
import './index.css';
import App from './App';
import * as serviceWorker from './serviceWorker';

import { FixedSizeList as List } from "react-window";
import AutoSizer from "react-virtualized-auto-sizer";

import "./styles.css";

import Button from '@material-ui/core/Button';

//ReactDOM.render(<App2 />, document.getElementById('root'));
function App2() {
  return (
    <Button variant="contained" color="primary">
      Hello World
    </Button>
  );
}

const MyComponent = window.foo.core.MyComponent;

const MyComponent2 = window.foo.core.MyComponent2;

const RowComponent = window.foo.core.RowComponent;

const Row = ({ index, style }) => (
  <div className={index % 2 ? "ListItemOdd" : "ListItemEven"} style={style}>
      React {index} Row ,
      <MyComponent2 name={index}/>
  </div>
);

const Example = () => (
  <AutoSizer>
    {({ height, width }) => (
      <List
        className="List"
        height={height}
        itemCount={1000}
        itemSize={35}
        width={width}
      >
        {RowComponent}
      </List>
    )}
  </AutoSizer>
);

const Example2 = () => (
      <List
        className="List"
          height={1000}
        itemCount={1000}
        itemSize={35}
          width={500}
      >
          {RowComponent}
      </List>
);

class Hello extends React.Component {
  render() {
    return React.createElement('div', null, `Hello ${this.props.toWhat}`);
  }
}         

// Hello undefined 列表 OK: Hello必须是一个Component,{}是调用这个Component
const Example3 = () => (
      <List
        className="List"
          height={1000}
        itemCount={1000}
        itemSize={35}
          width={500}
      >
          {Hello}
      </List>
);
         
var stations = [
    {call:'station one',frequency:'000'},
    {call:'station two',frequency:'001'}
]

const Example4 = () => (
  <AutoSizer>
      {({ height, width }) => (
          <div>
              {stations.map(station => <div> {station.frequency} </div>)} 
       </div>
    )}
  </AutoSizer>
);
// ///
     
ReactDOM.render(<MyComponent />, document.getElementById('root'));
    
// If you want your app to work offline and load faster, you can change
// unregister() to register() below. Note this comes with some pitfalls.
// Learn more about service workers: https://bit.ly/CRA-PWA
serviceWorker.unregister();
