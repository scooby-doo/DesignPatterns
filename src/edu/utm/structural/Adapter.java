package edu.utm.structural;

class Celcius{
	double temperatureInC;
	public Celcius() {
		
	}
	public double getTemperature(){
		return temperatureInC;
	}
	public void setTemperature(double temperatureInC){
		this.temperatureInC = temperatureInC;
	}
}

interface TemperatureInfo {
	public double getTemperatureInF();
	public void setTemperatureInF(double temperatureInF);
	
	public double getTemperatureInC();
	public void setTemperatureInC(double temperatureInC);
}


class TempAdapter extends Celcius implements TemperatureInfo{
	
	@Override
	public double getTemperatureInC(){
		return temperatureInC;
	}
	
	@Override
	public double getTemperatureInF(){
		return cToF(temperatureInC);
	}
	
	@Override
	public void setTemperatureInC(double temperatureInC){
		this.temperatureInC = temperatureInC;
	}
	
	@Override
	public void setTemperatureInF(double temperatureInF){
		this.temperatureInC = fToC(temperatureInF);
	}
	
	private double fToC(double f){
		return ((f-32)*5/9);
	}
	
	private double cToF(double c){
		return ((c*9/5)+32);
	}
}

public class Adapter {
	
	
	public static void main (String[] args) {
		TemperatureInfo tempInfo = new TempAdapter();
		tempInfo.setTemperatureInC(0);
		System.out.println("Temp in C: "+tempInfo.getTemperatureInC());
		System.out.println("Temp in F: "+tempInfo.getTemperatureInF());
	}
	

}
