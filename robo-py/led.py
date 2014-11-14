import RPi.GPIO as GPIO

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)

# Define GPIO to use on Pi
GPIO_X0 = 17

GPIO.setup(GPIO_X0, GPIO.OUT)
GPIO.output(GPIO_X0, True)