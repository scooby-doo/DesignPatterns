package edu.utm.behavioural;

import java.util.Scanner;

//interface
interface Graduate {
	public abstract void graduate();
}

//Receiver class
class Student{
	public void practicSpells() {
		System.out.println("You need to practice spells");
	}
	
	public void WriteEssay(){
		System.out.println("You need to write an essay");
	}
	
	public void MakePotion(){
		System.out.println("Oh well, You have to impress professor Snape");
	}
	
	public void BreakRules(){
		Scanner input = new Scanner(System.in);
		System.out.println("You can get yourself killed, or worse, Expelled! Are you still going to do it? Yes/No%n");
		String answer = input.next();
		input.close();
		
		if(answer.equals("Yes")){
			System.out.format("The broken rules were:%n"+
					"1. Wandering at night outside of school%n"+
					"2. Tresspasing the third floor and discovering the three-headed dog%n"+
					"3. Breaking into the restrictin section in the library at night%n"+
					"4. Setting professor's Snape clock on fire during the Quidditch match...%n"+
					"The list is to masive to continue. You have broken more than 50 school rools%n"+
					"and proper action must be taken%n"+
					"Therefore, we are pleased to inform you that you have been awarded with 150 "+
					"points for your house and you have passed all your examinations%n"+
					"We are thanking you for saving Hogwards and the wizarding world from an unspeakable evil.%n%n"+
					"Yours sincerely,%nMinerva McGonagall%nDeupty Headmistress");
			
			
		} else {
			System.out.format("Headmaster: Albus Dumbledore.%n"+
					"(Order of Merlin, First Class, Grand Sorc., Chf. Warlock,%n"+
					"Supreme Mugwump, International Confed. of Wizards)%n%n"+
					"Dear Mr./Mrs. Student%n"+
					"We are pleased to inform you that you have graduated first year at Hogwarts School of Witchcraft and Wizardy.%n"+
					"Please find enclosed a list of all your marks received at examinations.%n%n"+
					"Yours sincerely,%nMinerva McGonagall%nDeupty Headmistress");
		}
	}
}

//concrete command class
class Spells implements Graduate{
	private Student student;
	public Spells(Student st){
		this.student = st;
	}
	
	public void graduate(){
		student.practicSpells();
	}
	
}

class Potions implements Graduate{
	private Student student;
	public Potions(Student st){
		this.student = st;
	}
	public void graduate(){
		student.MakePotion();
	}
}

class Essays implements Graduate{
	private Student student;
	public Essays (Student st){
		this.student = st;
	}
	public void graduate(){
		student.WriteEssay();
	}
}


class Rules implements Graduate{
	private Student student;
	public Rules(Student st){
		this.student = st;
	}
	public void graduate(){
		student.BreakRules();
	}
}

//Invoker
class Teacher {
	private Graduate grad;
	public void setCommand(Graduate grad){
		this.grad = grad;
	}
	
	public void startStudying(){
		grad.graduate();
	}
}

//Client
public class Command {
	public static void main(String[] args){
		Teacher teacher = new Teacher();
		
		Student student = new Student();
		
		Graduate spells = new Spells(student);
		Graduate potions = new Potions(student);
		Graduate essays = new Essays(student);
		Graduate rules = new Rules(student);
		
		teacher.setCommand(essays);
		teacher.startStudying();
		
		teacher.setCommand(spells);
		teacher.startStudying();
		
		teacher.setCommand(potions);
		teacher.startStudying();
		
		teacher.setCommand(rules);
		teacher.startStudying();
	}
}










