package edu.utm.behavioural;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


interface VoldemortSubject{
	public void addObserver(DeathEatersInt o);
	public void removeObserver(DeathEatersInt o);
	public String getState();
	public void setState(String state);
	public void notifyDeathEaters();
}

interface DeathEatersInt{
	public void update(VoldemortSubject vs);
}


class DeathEatersImp implements DeathEatersInt{
	public String state;
	public void update(VoldemortSubject vs){
		state = vs.getState();
		System.out.println("The state of the Dark Lord is "+state);
	}
}

class VoldemortImpl implements VoldemortSubject{
	private List<DeathEatersInt> deathEaters = new ArrayList<>();
	private String state;
	
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	public void addObserver(DeathEatersInt de){
		deathEaters.add(de);
	}
	public void removeObserver(DeathEatersInt de){
		System.out.println("The only way to unfollow the Dark Lord is to meet your doom. Avada Kedavra");
		deathEaters.remove(de);
	}
	
	public void notifyDeathEaters(){
		Iterator<DeathEatersInt> i = deathEaters.iterator();
		while(i.hasNext()){
			DeathEatersInt de = (DeathEatersInt) i.next();
			de.update(this);
		}
	}
}

public class Observer {
	public static void main(String[] args){
		DeathEatersInt snape = new DeathEatersImp();
		DeathEatersInt lucius = new DeathEatersImp();
		DeathEatersInt rudolf = new DeathEatersImp();
		VoldemortSubject vs = new VoldemortImpl();
		vs.addObserver(snape);
		vs.addObserver(lucius);
		vs.addObserver(rudolf);
		vs.setState("Returned in a new body");
		vs.notifyDeathEaters();
		vs.removeObserver(rudolf);
		vs.setState("Killed by Harry Potter");
		vs.notifyDeathEaters();
	}
}











