package edu.utm.behavioural;

import java.util.ArrayList;

//Mediator interface
interface DarkMarkMediator {
	public void send(String message, DeathEater dethy);
}

// Collegue Interface
abstract class DeathEater {
	private DarkMarkMediator darkMark;
	
	public DarkMarkMediator getDarkMark() {
		return darkMark;
	}

	public DeathEater(DarkMarkMediator d){
		darkMark = d;
	}
	
	public void send(String message){
		darkMark.send(message, this);
	}
	
	public abstract void receive(String message);
	
}

//Concrete mediator
class ConcreteMark implements DarkMarkMediator {
	private ArrayList<DeathEater> deathies;
	
	public ConcreteMark(){
		deathies = new ArrayList<>();
	}
	
	public void addDeathies(DeathEater deathy){
		deathies.add(deathy);
	}
	
	public void send(String message, DeathEater voldemort){
		for (DeathEater deathy: deathies) {
			if (deathy != voldemort){
				deathy.receive(message);
			}
		}
	}
}


//Concrete Collegue
class ConcreteDeathEater extends DeathEater{
	public ConcreteDeathEater(DarkMarkMediator d) {
		super(d);
		// TODO Auto-generated constructor stub
	}

	public void receive(String message){
		System.out.println("Concrete Deathy: "+message);
	}
}

public class Mediator {

	public static void main(String[] args) {
		ConcreteMark mark = new ConcreteMark();
		
		ConcreteDeathEater voldemort = new ConcreteDeathEater(mark);
		ConcreteDeathEater snape = new ConcreteDeathEater(mark);
		ConcreteDeathEater peter = new ConcreteDeathEater(mark);
		ConcreteDeathEater bellatrix = new ConcreteDeathEater(mark);
		ConcreteDeathEater lucius = new ConcreteDeathEater(mark);

		mark.addDeathies(lucius);
		mark.addDeathies(snape);
		mark.addDeathies(peter);
		mark.addDeathies(bellatrix);
		mark.addDeathies(voldemort);
		
		mark.send("Come",voldemort);
	}

}
