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


def light(x0, x1, y0, y1):
    GPIO.output(GPIO_X0, x0 == 1)
    GPIO.output(GPIO_X1, x1 == 1)
    GPIO.output(GPIO_Y0, y0 == 1)
    GPIO.output(GPIO_Y1, y1 == 1)
    time.sleep(5)


light(0, 0, 0, 0)
iterator = 0

while iterator < 20:
    print "GORA!"
    light(0, 0, 0, 1)

    print "PRAWA!"
    light(1, 0, 1, 1)

    print "DOL!"
    light(0, 0, 1, 0)

    print "LEWA STRONA!"
    light(0, 1, 1, 1)


    iterator += 1