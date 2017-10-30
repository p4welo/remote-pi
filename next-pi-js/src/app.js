const gpio = require('pi-gpio');

const PIN = 8;
const PIN2 = 10;
const INTERVAL = 500;

var state = 0;

function toggle() {
  return state = state ? 0 : 1;
}

// gpio.open(PIN, 'output', function() {
//   setInterval(function() {
//     var newState = toggle();
//     gpio.write(PIN, newState, function() {
//
//     });
//   }, INTERVAL);
// });
gpio.open(PIN2, 'input', function () {
  setInterval(function () {
    gpio.read(PIN2, function (err, value) {
      if (err) throw err;
      console.log(value);
    })
  }, 100);
});

console.log('===> START <===');
