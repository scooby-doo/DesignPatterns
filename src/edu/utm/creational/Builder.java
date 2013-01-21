package edu.utm.creational;
//Product
class Wizards {
	private String power;
	private String rank;

	public void setPower(String power) {
		this.power = power;
	}

	public void setRank(String rank) {
		this.rank = rank;
	}

	public String getPower() {
		return power;
	}

	public String getRank() {
		return rank;
	}

}

//Abstract builder
abstract class WizardsBuilder {
	protected Wizards wizards;

	public Wizards getWizards() {
		return wizards;
	}

	public void createNewWizards() {
		wizards = new Wizards();
	}

	public abstract void buildPower();

	public abstract void buildRank();
}

//Concrete Builder
class TheWhite extends WizardsBuilder {
	public void buildPower() {
		wizards.setPower("Defeat Saruman");
	}

	public void buildRank() {
		wizards.setRank("Gandalf The White");
	}
}

//Concrete Builder
class TheGrey extends WizardsBuilder {
	public void buildPower() {
		wizards.setPower("Defeat Balrog");
	}

	public void buildRank() {
		wizards.setRank("Gandalf The Grey");
	}
}

//Director
class FrodoCampanion {
	private WizardsBuilder wizardsBuilder;

	public void setWizardsBuilder(WizardsBuilder wb) {
		wizardsBuilder = wb;
	}

	public Wizards getWizards() {
		return wizardsBuilder.getWizards();
	}

	public void constructWizards() {
		wizardsBuilder.createNewWizards();
		wizardsBuilder.buildRank();
		wizardsBuilder.buildPower();
	}
}

//Builder
public class Builder {
	public static void main(String[] args) {
		FrodoCampanion frodo = new FrodoCampanion();
		WizardsBuilder theGrey = new TheGrey();
		WizardsBuilder theWhite = new TheWhite();

		frodo.setWizardsBuilder(theWhite);
		frodo.constructWizards();

		Wizards wizards = frodo.getWizards();
		System.out.println(wizards.getRank());
		System.out.println(wizards.getPower());

		System.out.println("\n");
		frodo.setWizardsBuilder(theGrey);
		frodo.constructWizards();

		Wizards wizardsTwo = frodo.getWizards();
		System.out.println(wizardsTwo.getRank());
		System.out.println(wizardsTwo.getPower());
	}

}
