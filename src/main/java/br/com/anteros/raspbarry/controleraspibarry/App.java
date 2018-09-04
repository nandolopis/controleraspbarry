package br.com.anteros.raspbarry.controleraspibarry;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;

public class App {
	public static void main(String[] args) throws InterruptedException {

		GpioController gpio = GpioFactory.getInstance();

		GpioPinDigitalOutput pin = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_01, "MyLED", PinState.HIGH);

		pin.setShutdownOptions(true, PinState.LOW);

		System.out.println("GPIO: ON ");

		Thread.sleep(5000);
		
		pin.low();
		
		System.out.println("GPIO: OFF ");
		
		Thread.sleep(5000);
		
		pin.toggle();
		
		Thread.sleep(5000);
		
		pin.toggle();
		
		
		Thread.sleep(5000);
		
		pin.pulse(1000, true);
		
		//stop gpio
		
		gpio.shutdown();
			

	}
}
