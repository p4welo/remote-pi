package parado;

import com.pi4j.io.gpio.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by parado on 2014-11-09.
 */

public class Main {
    public static void main(String args[]) throws InterruptedException {
        blinkingLeds();
    }

    private static void checkDistance() throws InterruptedException {
        final GpioController gpio = GpioFactory.getInstance();
        GpioPinDigitalOutput triggerOutput = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "trigger", PinState.LOW);
        GpioPinDigitalInput echoInput = gpio.provisionDigitalInputPin(RaspiPin.GPIO_02, "echo");
        System.out.println("Rozpoczynam pomiar...");
        RangeFinder finder = new RangeFinder(triggerOutput, echoInput);


        do {
            double distance = finder.getRange();

            if (distance > -1) {
                System.out.println("RangeFinder result =" + distance + "mm");
            }
            Thread.sleep(2000);
        } while (true);
    }


    private static void blinkingLeds() throws InterruptedException {
        final GpioController gpio = GpioFactory.getInstance();

        List<GpioPinDigitalOutput> pins = new ArrayList<>();
        pins.add(gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "led01", PinState.LOW));
        pins.add(gpio.provisionDigitalOutputPin(RaspiPin.GPIO_02, "led02", PinState.LOW));
        pins.add(gpio.provisionDigitalOutputPin(RaspiPin.GPIO_03, "led03", PinState.LOW));
        pins.add(gpio.provisionDigitalOutputPin(RaspiPin.GPIO_04, "led04", PinState.LOW));

        while (true) {
            for (int i = 0; i < pins.size(); i++) {
                for (int j = 0; j < pins.size(); j++) {
                    if (i == j) pins.get(j).high();
                    else pins.get(j).low();
                }
                Thread.sleep(100);
            }
        }

//        for (int j = 0; j < pins.size(); j++) {
//            pins.get(j).low();
//        }
//
//        gpio.shutdown();
    }
}
