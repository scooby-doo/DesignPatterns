package edu.utm.behavioural;


class RequestedSpell {
	private String name;
	private String description;
	
	public RequestedSpell (String value, String info){
		name = value;
		description = info;
	}
	
	public String getName() {
		return name;
	}
	public String getDescription() {
		return description;
	}
	
}


interface Handler {
	public void setSuccessor (Handler successor);
	public void handleRequest(RequestedSpell request);
}

class HermioneHandler implements Handler {
	protected Handler next;
	public void setSuccessor (Handler successor){
		next = successor;
	}
	public void handleRequest(RequestedSpell request){
		if(request.getName().equals("Alohamora")){
			System.out.println("Spell processed by HermioneHandler");
			System.out.format("Name %s %nDescription: %s %n%n",request.getName(), request.getDescription());
		} else {
			next.handleRequest(request);
		}
	}
}



class HarryHandler implements Handler {
	protected Handler next;
	public void setSuccessor (Handler successor){
		next = successor;
	}
	public void handleRequest(RequestedSpell request){
		if(request.getName().equals("Expecto Patronum")){
			System.out.println("Spell processed by HarryHandler");
			System.out.format("Name %s %nDescription: %s %n%n",request.getName(), request.getDescription());
		} else {
			next.handleRequest(request);
		}
	}
}



class RonHandler implements Handler {
	protected Handler next;
	public void setSuccessor (Handler successor){
		next = successor;
	}
	public void handleRequest(RequestedSpell request){
		if(request.getName().equals("Expeliarto")){
			System.out.println("Spell processed by RonHandler");
			System.out.format("Name %s %nDescription: %s %n%n",request.getName(), request.getDescription());
		} else {
			next.handleRequest(request);
		}
	}
}


public class ChainOfResp {
	public static void main(String[] args){
		//Chain
		Handler h1 = new HermioneHandler();
		Handler h2 = new HarryHandler();
		Handler h3 = new RonHandler();
		h1.setSuccessor(h2);
		h2.setSuccessor(h3);
		
		//Request to chain
		h1.handleRequest(new RequestedSpell("Expeliarto","Dizarm opponent"));
		h1.handleRequest(new RequestedSpell("Expecto Patronum","Protect against dementors"));
		h1.handleRequest(new RequestedSpell("Alohamora","Open doors"));
	}

}
