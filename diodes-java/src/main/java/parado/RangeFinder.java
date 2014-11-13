package parado;

import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;

/**
 * Created by parado on 2014-11-13.
 */
public class RangeFinder {

    GpioPinDigitalOutput triggerOutputPin;
    GpioPinDigitalInput resultInputPin;


    public RangeFinder(GpioPinDigitalOutput triggerOutputPin, GpioPinDigitalInput resultInputPin) {
        this.triggerOutputPin = triggerOutputPin;
        this.resultInputPin = resultInputPin;
    }

    public double getRange() {
        double result;
        try {
            triggerOutputPin.high();
            Thread.sleep(20);
        } catch (InterruptedException e) {

            System.out.println("Exception triggering range finder");
        }
        triggerOutputPin.low();

        double startTime = System.currentTimeMillis();
        System.out.println("START: " + startTime);
        do {

        } while (resultInputPin.getState() != PinState.HIGH);
        double stopTime = System.currentTimeMillis();
        System.out.println("END: " + stopTime);

//        if ((stopTime - startTime) <= 38) {
        result = (stopTime - startTime) * 165.7;
//        } else {
//            System.out.println("Timed out");
//            result = -1;
//        }

        return result;

    }
}
