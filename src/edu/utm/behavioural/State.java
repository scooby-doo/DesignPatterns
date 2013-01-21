package edu.utm.behavioural;

interface StateInterface {
	public void enterClass(ClassContext labContext);
}

class ClassContext {
	private StateInterface stateInterface;
	
	public ClassContext(StateInterface si){
		this.stateInterface = si;
	}
	
	public void enter(){
		stateInterface.enterClass(this);
	}
	
	public void setState(StateInterface si){
		this.stateInterface = si;
	}
	public StateInterface getState(){
		return stateInterface;
	}	
}

class EnteredRoomState implements StateInterface{
	public void enterClass(ClassContext labContext){
		labContext.setState(new EmptyRoomState());
	}
}

class EmptyRoomState implements StateInterface{
	public void enterClass(ClassContext classContext){
		classContext.setState(new EnteredRoomState());
	}
}

public class State {
	public static void main(String[] args){
		ClassContext cContext = new ClassContext(new EmptyRoomState());
		System.out.println(cContext.getState());
		cContext.enter();
		System.out.println(cContext.getState());
		cContext.enter();
		System.out.println(cContext.getState());
	}

}
