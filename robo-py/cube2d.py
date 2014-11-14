import time
import RPi.GPIO as GPIO

GPIO.setmode(GPIO.BCM)

# Define GPIO to use on Pi
GPIO_X0 = 17
GPIO_X1 = 18
GPIO_Y0 = 22
GPIO_Y1 = 23

print "Pomiar odleglosci"

GPIO.setup(GPIO_X0, GPIO.OUT)
GPIO.setup(GPIO_X1, GPIO.OUT)
GPIO.setup(GPIO_Y0, GPIO.OUT)
GPIO.setup(GPIO_Y1, GPIO.OUT)


def reset():
    GPIO.output(GPIO_X0, False)
    GPIO.output(GPIO_X1, False)
    GPIO.output(GPIO_Y0, False)
    GPIO.output(GPIO_Y1, False)
    time.sleep(0.1)

reset()
iterator = 0

while iterator < 20:

    # stan 1
    GPIO.output(GPIO_X0, False)
    GPIO.output(GPIO_X1, False)
    GPIO.output(GPIO_Y0, True)
    GPIO.output(GPIO_Y1, True)
    print "WSZYSTKIE ZAPALONE!"
    time.sleep(5)

    reset()

    # stan 2
    GPIO.output(GPIO_X0, False)
    GPIO.output(GPIO_X1, True)
    GPIO.output(GPIO_Y0, False)
    GPIO.output(GPIO_Y1, False)
    print "PRAWA STRONA"
    time.sleep(5)

    iterator+=1