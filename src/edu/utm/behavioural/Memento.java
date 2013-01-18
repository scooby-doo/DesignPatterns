package edu.utm.behavioural;


//memento
class Horcrux {
	private final String horcrux;
	public Horcrux(String state){
		horcrux = state;
	}
	
	public String getVoldemort(){
		return horcrux;
	}
}

//Originator
class Voldemort{
	private String state;
	
	public void setState(String content){
		this.state = content;
	}
	
	public String getState() {
		return state;
	}

	public Horcrux save(){
		return new Horcrux(state);
	}
	
	public void restoreVoldemort(Horcrux horcrux){
		state = horcrux.getVoldemort();
	}
}


public class Memento {
	public static void main(String[] args) {
		Voldemort voldemort = new Voldemort();
		voldemort.setState("Dark lord, cam fly, bla bla bla, kills everyone");
		Horcrux horcrux = voldemort.save();
		voldemort.setState("");
		System.out.println(voldemort.getState());
		voldemort.restoreVoldemort(horcrux);
		System.out.println(voldemort.getState());
	}
}
