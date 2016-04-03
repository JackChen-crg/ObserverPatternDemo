package com.crg.test.main;

import com.crg.test.DisplayElement;
import com.crg.test.Observer;

public class ThirdPartyDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	private float pressure;
	private WeatherData weatherData;
	public ThirdPartyDisplay(WeatherData weatherData){
		this.weatherData = weatherData;
		weatherData.registerObserver(this);
	}
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("我是第三方 >>>>>>>>>>当前温度为：　" + temperature);
		System.out.println("我是第三方 >>>>>>>>>当前湿度为：　" + humidity);
		System.out.println("我是第三方  >>>>>>>>>当前气压为：　" + pressure);
	}

	public void update(float temp, float humidity, float presure) {
		// TODO Auto-generated method stub
		this.temperature = temp;
		this.humidity = humidity;
		this.pressure = presure;
		display();
	}
	public void removeThirdPartyDisplay(){
		weatherData.removeObserver(this);
	}

}
