package com.crg.test.test;

import com.crg.test.main.CurrentConditionsDisplay;
import com.crg.test.main.ForecastDisplay;
import com.crg.test.main.ThirdPartyDisplay;
import com.crg.test.main.WeatherData;

public class WeatherStation {

	/**
	 * @param args
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.out.println("第一次天气预报之后，每隔15个小时，播报一次");
		final WeatherData weatherData = new WeatherData();
		weatherData.setChanged();
		CurrentConditionsDisplay currentConditionsDisplay = new CurrentConditionsDisplay(
				weatherData);
		weatherData.setMeasurements(16, 30, 22);
		Thread.sleep(1000);
		weatherData.setMeasurements(17, 33, 20);
		System.out.println("有新的公司加入........................................");
		new Thread(new Runnable() {

			public void run() {
				// TODO Auto-generated method stub
				int i = 0;
				while (true) {
					try {
						Thread.sleep(5*1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					weatherData.setChanged();
					weatherData.setMeasurements(12 + i, 25 + i, 26 + i);
					i++;
				}
			}
		}).start();
		weatherData.setChanged();
		ForecastDisplay forecastDisplay = new ForecastDisplay(weatherData);
		Thread.sleep(5000);
		System.out.println("第三方公司加入........................................");
		ThirdPartyDisplay thirdPartyDisplay = new ThirdPartyDisplay(weatherData);
		Thread.sleep(6000);
		System.out.println("forecastDisplay一分钟后将被移除观察者阵营。。。。。。。。。。。。。。。。。。");
		Thread.sleep(1000);
		forecastDisplay.removeForecastDisplay();
		Thread.sleep(1 * 10 * 1000);
		System.out.println("第三方公司一分钟后将被移除观察者阵营。。...........................");
		Thread.sleep(1000);
		thirdPartyDisplay.removeThirdPartyDisplay();
		Thread.sleep(10000);
		weatherData.setChanged();
		System.out.println("第三方公司再次申请加入观察者...");
		weatherData.registerObserver(thirdPartyDisplay);
		Thread.sleep(3*1000);
		System.out.println("main 结束运行，退出");

	}

}
