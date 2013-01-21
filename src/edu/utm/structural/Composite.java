package edu.utm.structural;

import java.util.ArrayList;
import java.util.List;

interface SpellComponent {
	public void saySpell();
	public void getPage();
}


//Leaf 
class Leaf implements SpellComponent {
	String spell;
	String page;
	public Leaf(String spell, String page){
		this.spell = spell;
		this.page = page;
		}
	
	@Override
	public void saySpell(){
		System.out.println("Spell is "+spell);
	}
	
	@Override
	public void getPage(){
		System.out.println(page);
	}
}

//Composite
class CompositeElement implements SpellComponent {
	List<SpellComponent> components = new ArrayList<SpellComponent>();
	
	@Override
	public void saySpell(){
		for (SpellComponent component: components){
			component.saySpell();
		}
	}
	
	@Override
	public void getPage(){
		for (SpellComponent component: components){
			component.getPage();
		}
	}
	
	
	public void add(SpellComponent component){
		components.add(component);
	}
	
	public void remove(SpellComponent component){
		components.remove(component);
	}
	
	public List<SpellComponent> getComponents(){
		return components;
	}
	
	public SpellComponent getComponent(int index){
		return components.get(index);
	}
	
	
}

//Composite demo
public class Composite {
	public static void main (String [] args){
		Leaf openDoor = new Leaf("Alohomora", "Book> Magic for Beginners, page 25");
		Leaf patronum = new Leaf("Expecto Patronum","Book> Protection from the dark forces page 189");
		Leaf levitate = new Leaf("Wingardium Leviosa","Book> Magic for Beginners, page 5");
		Leaf eraseMemory = new Leaf("Obliviate","Book> Big book of spells, Apendix X");
		Leaf torture = new Leaf("Crucio","This spell will not be taught during the classes");
		Leaf kill = new Leaf("Avada Kadavra","This spell will not be taught during the classes");
		Leaf control = new Leaf("Imperio","This spell will not be taught during the classes");
		
		CompositeElement unforgivable = new CompositeElement();
		unforgivable.add(control);
		unforgivable.add(torture);
		unforgivable.add(kill);
		
		CompositeElement beginners = new CompositeElement();
		beginners.add(levitate);
		beginners.add(openDoor);
		
		CompositeElement advanced = new CompositeElement();
		advanced.add(patronum);
		
		CompositeElement exam = new CompositeElement();
		exam.add(beginners);
		exam.add(advanced);
		exam.add(eraseMemory);
		
		System.out.println("Leaf Open Door");
		openDoor.saySpell();
		openDoor.getPage();
		
		System.out.println("-----------------------------------\nLeaf Levitate");
		levitate.saySpell();
		levitate.getPage();
		
		System.out.println("-----------------------------------\nComposite Element Unforgivable");
		unforgivable.saySpell();
		unforgivable.getPage();
		
		System.out.println("-----------------------------------\nComposite Element beginners");
		for (SpellComponent component: beginners.getComponents()){
			component.saySpell();
			component.getPage();
			System.out.println();
		}
		
		System.out.println("-----------------------------------\nComposite element advanced");
		for (SpellComponent component: advanced.getComponents()){
			component.saySpell();
			component.getPage();
			System.out.println();
		}
				
		System.out.println("-----------------------------------\nComposite Element exam");
		System.out.println("The first component of this composite element is: ");
		exam.getComponent(0).saySpell();
		exam.getComponent(0).getPage();
		System.out.println("\nThe second component of this composite element is: ");
		exam.getComponent(1).saySpell();
		exam.getComponent(1).getPage();
		System.out.println("\nThe third component of this composite element is: ");
		exam.getComponent(2).saySpell();
		exam.getComponent(2).getPage();
		
		
	}

}
