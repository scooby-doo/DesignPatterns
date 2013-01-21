package edu.utm.behavioural;

import java.util.ArrayList;
import java.util.List;


//iterator interface
interface BookListIterator{
	public boolean hasNext();
	public void next();
	public String currentItem();
}

//aggregate interface
interface ShopListInterface {
	public ConcreteBookListIt getIterator();
}

//concrete aggregator
class ConcreteShopList implements ShopListInterface{
	private ConcreteBookListIt iterator;
	
	public ConcreteShopList(List<String> books){
		iterator = new ConcreteBookListIt(books);
	}
	public ConcreteBookListIt getIterator(){
		return iterator;
	}
}

class ConcreteBookListIt implements BookListIterator {
	private List<String> books = new ArrayList<>();
	private int currentPosition = 0;

	public ConcreteBookListIt(List<String> b){
		this.books = b;
	}
	
	public boolean hasNext(){
		if(currentPosition + 1 <= books.size()) {
			return true;
		} return false;
	}
	
	public void next(){
		currentPosition++;
	}
	
	public String currentItem(){
		return books.get(currentPosition);
	}
}


public class IteratorPattern {
	public static void main(String[] args) {
		List<String> books = new ArrayList<>();
		books.add("Defence Against Dark Arts - Grade 2");
		books.add("Potions brewing - Grade 2");
		books.add("Transiguration - Grade 2");
		books.add("Care of Magical Creatures - How to survive an encounter with acromantula");	
		ConcreteBookListIt it;
		ShopListInterface sli = new ConcreteShopList(books);
		it = sli.getIterator();
		while (it.hasNext()){
			System.out.println(it.currentItem());
			it.next();
		}
	}
}
