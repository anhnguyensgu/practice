// import React, { Component } from "react";

// class SetState extends Component {
//   state = {
//     a: 1
//   };
//   handleSetState = () => {
//     // this.setState({
//     // a: 2
//     // }, () => {
//     // console.log("done");
//     // });
//     // setTimeout(() => {
//     // console.log("timeout");
//     // }, 0);
//     Promise.resolve(1).then(() => {
//       console.log("promise 1");
//     });
//   };
//   handleClick = async () => {
//     Promise.resolve(1).then(() => {
//       console.log("promise 2");
//     });
//     await this.handleSetState();
//     for (let i = 0; i < 1000000000; i++) {
//       //
//     }
//     console.log("next"); // normally, this will log a = 1
//   };
//   render() {
//     return (
//       <div>
//         <button onClick={this.handleClick}>set</button>
//       </div>
//     );
//   }
// }

// export default SetState;
const https = require("https");

function setState(callBack) {
  // new Promise(resolve => {
  //   ;
  // }).then(() => callBack());
  console.log('setState');
  // return Promise.resolve(https.get("https://kenh14.vn")).then(() => callBack());
  return new Promise(resolve => {
    https.get("https://kenh14.vn")
    resolve(1)
  }).then(() => callBack());
}

function resolveAfter2Seconds() {
  // for (var i = 0; i < 1000000000; i++) {
  // }
  return Promise.resolve(1);
}

const nonAsync = () => {
  setState(() => console.log("setting state is completed"));
};

function nonAsync2() {
  return setState(() => console.log("setting state is completed"));
}

async function asyncCall() {
  console.log("calling");
  await nonAsync2();
  console.log("end")
}

// asyncCall();

const async = generator => {
  const g = generator();
  function next(value) {
    const n = g.next(value);
    if (n.done) return;
    console.log(n);
    if (n.value) {
      n.value.then(next);
    } else {
      n.value = Promise.resolve(1).then(next);
      // next(Promise.resolve(1).then(next));
    }
  };
  next();
}

async(function* asyncCall() {
  console.log("calling");
  yield nonAsync();
  console.log("end");
});

function spawn(genFunc, self) {
  return new Promise(function(resolve, reject) {
    // start iterating the original function and set correct this pointer
    var iterator = genFunc.call(self);
    function step(nextFunc) {
      var next;
      try {
        next = nextFunc();
      } catch (e) {
        // finished with failure, reject the promise
        reject(e);
        return;
      }
      if (next.done) {
        // finished with success, resolve the promise
        resolve(next.value);
        return;
      }
      // not finished, chain off the yielded promise and `step` again
      Promise.resolve(next.value).then(
        function(v) {
          // keep stepping until next yield (original await) passing new value to yield
          step(function() {
            return iterator.next(v);
          });
        },
        function(e) {
          step(function() {
            return iterator.throw(e);
          });
        }
      );
    }
    // keep stepping until next yield (original await)
    step(function() {
      return iterator.next();
    });
  });
}

function chainAnimationsGenerator(elem, animations) {
  // spawn will return a Promise
  console.log("start");
  const a = spawn(function*() {
    let ret = null;
    try {
      // for(const anim of animations) {
      ret = yield setState(() => console.log("setting state is completed"));
      // }
    } catch (e) {
      /* ignore and keep going */
    }
    return ret;
  });
  console.log("end");
}
