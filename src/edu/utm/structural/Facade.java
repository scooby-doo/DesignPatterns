package edu.utm.structural;

import java.util.ArrayList;

class Book{
	public ArrayList<String> getBookNames(){
		ArrayList<String> bookList = new ArrayList<>();
		bookList.add("Defence Against Dark Arts - Grade 2");
		bookList.add("Potions brewing - Grade 2");
		bookList.add("Transiguration - Grade 2");
		bookList.add("Care of Magical Creatures - How to survive an encounter with acromantula");
		return bookList;
	}
}

class Potions {
	
	public ArrayList<String> getPotions(){ 
		ArrayList<String> potionList = new ArrayList<>();
		potionList.add("Polyjuice Potion - fluxweed, knotgrass. leeches, lacewing flies, boomslang skin, bicon horn,");
		return potionList;
	
	}
}

class Materials {
	public ArrayList<String> getMaterials(){
		ArrayList<String> materialsList = new ArrayList<>();
		materialsList.add("broomstick");
		materialsList.add("wand");	
		return materialsList;
	}
}

class ListFacade {
	private Book book = new Book();
	private Potions potion = new Potions();
	private Materials material = new Materials();
	
	public ArrayList<String> getAllInfo(){
		ArrayList<String> books = book.getBookNames();
		ArrayList<String> potions = potion.getPotions();
		ArrayList<String> materials = material.getMaterials();
		
		ArrayList<String> info = new ArrayList<>();
		info.addAll(books);
		info.addAll(potions);
		info.addAll(materials);
		return info;
	}
	
}

public class Facade {	
	public static void main(String[] args){
		ListFacade info = new ListFacade();
		ArrayList<String> element = info.getAllInfo();
		System.out.println("This year you will need:");
		for (String e : element){
			System.out.println(e);
		}
	}

}
