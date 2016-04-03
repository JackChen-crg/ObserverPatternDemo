package com.crg.test.main;

import com.crg.test.DisplayElement;
import com.crg.test.Observer;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	private float pressure;
	private WeatherData weatherData;
	
	public CurrentConditionsDisplay(WeatherData weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}

	public void update(float temperature, float humidity, float pressure) {
		// TODO Auto-generated method stub
		this.temperature = temperature;
		this.humidity = humidity;
		this.pressure = pressure;
		display();
	}

	public void display() {
		// TODO Auto-generated method stub
		System.out.println("CurrentConditionsDisplay >>>>>>>>>>当前温度为：　" + temperature);
		System.out.println("CurrentConditionsDisplay >>>>>>>>>当前湿度为：　" + humidity);
		System.out.println("CurrentConditionsDisplay >>>>>>>>>当前气压为：　" + pressure);
	}

}
