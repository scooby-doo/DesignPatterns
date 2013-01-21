package edu.utm.behavioural;

abstract class LetterDec {
	public final void decorate(){
		String greeting = getGreeting();
		String signature = getSignature();
		String address = getAddress();
		String content = getContent();
		
		System.out.println(greeting);
		System.out.println(address);
		System.out.println(content);
		System.out.println(signature);
		
	}
	
	protected abstract String getGreeting();
	protected abstract String getSignature();
	protected abstract String getAddress();
	protected abstract String getContent();
}


class Template extends LetterDec{
	private String content;
	private String greeting;
	private String signature;
	
	public Template(String c){
		this.content = c;
	}
	
	@Override
	protected String getGreeting(){
		greeting = String.format("Headmaster: Albus Dumbledore.%n"+
				"(Order of Merlin, First Class, Grand Sorc., Chf. Warlock,%n"+
				"Supreme Mugwump, International Confed. of Wizards)%n");
		return greeting;
	}
	
	@Override
	protected String getSignature(){
		signature = String.format("%nYours sincerely,%nMinerva McGonagall%nDeputy Headmistress");
		return signature;
	}
	
	@Override
	protected String getAddress(){
		return "Hogwarts School of Witchcraft and Wizardy";
	}
	
	@Override
	protected String getContent(){
		return content;
	}
}



public class TemplateMethod {
	
	public static void main(String[] args){
		LetterDec dec = new Template("Find all your marks at examination");
		dec.decorate();
	}

}
