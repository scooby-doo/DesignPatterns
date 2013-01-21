package edu.utm.behavioural;

import java.util.ArrayList;

interface Visitable {
	public void accept(VisitorOb visitor);
}

interface VisitorOb {
	public void visit(Letter letter);
	public void visit(Howler howler);
}

class Letter implements Visitable{
	private String content;
	
	public Letter(String c){
		this.content = c;
	}
	
	public void accept(VisitorOb visitor){
		visitor.visit(this);
	}

	public String getContent() {
		return content;
	}
}

class Howler implements Visitable{
	private String content;
	private int selfDestructTime;
	
	public Howler(String c, int t){
		this.content = c;
		this.selfDestructTime = t;
	}
	
	public void accept(VisitorOb visitor){
		visitor.visit(this);
	}

	public String getContent() {
		return content;
	}

	public int getSelfDestructTime() {
		return selfDestructTime;
	}	
	
}

class OwlVisitor implements VisitorOb{
	private int total;
	public void visit(Letter letter){
		System.out.println("You've received a letter. Here it is what it's says");
		System.out.println(letter.getContent());
		total = 10;
	}
	
	public void visit(Howler howler){
		System.out.println("We are sorry. You've received a howler. It will scream it's content for you");
		System.out.println(howler.getContent());
		System.out.println("It will selfdestruct in "+howler.getSelfDestructTime());
		total = 5;
	}
	
	public int getTotal(){
		return total;
	}
}


public class Visitor {
	public static void main(String[] args){
		ArrayList<Visitable> items = new ArrayList<>();
		Letter letter = new Letter("Some content here");
		Howler howler = new Howler("angy text",2);
		items.add(letter);
		items.add(howler);
		
		OwlVisitor owl = new OwlVisitor();
		for(Visitable item: items){
			item.accept(owl);
			int cost = owl.getTotal();
			System.out.println("You will have to feed this owl for "+cost+" days");
			System.out.println("");
		}
		
	}

}
