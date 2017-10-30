const gpio = require('pi-gpio');

const PIN = 8;
const INTERVAL = 500;

var state = 0;
function toggle() {
  return state = state ? 0 : 1;
}
gpio.open(PIN, 'output', function() {
  setInterval(function() {
    var newState = toggle();
    console.log(newState);
    gpio.write(PIN, newState, function() {
      
    });
  }, INTERVAL);
});
console.log('===> START <===');
