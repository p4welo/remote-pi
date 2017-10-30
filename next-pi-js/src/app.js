const gpio = require('pi-gpio');

const PIN = 7;
gpio.open(PIN, "output", function(err) {
  gpio.write(PIN, 1, function() {
    gpio.close(PIN);
  });
});

console.log('dupa');