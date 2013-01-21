package edu.utm.structural;

/////FACADE EXAMPLE ONE
class Stone {
	public String getStone(){
		System.out.println("do some complicated magic");
		return "Philosopher Stone in Harry's pocket";
	}
}

class Abasilisk {
	public String killAbasilisk(){
		System.out.println("Harry uses Griffindor sword");
		return "abasilisk killed";
	}
}

class Horcruxes{
	public String destroyHorcruxes(){
		System.out.println("Horcrux 1: Destroyed Dairy.");
		System.out.println("Horcrux 2: Destroyed Salazar Ring.");
		System.out.println("Horcrux 3: Destroyed Pendantive.");
		System.out.println("Horcrux 4: Destroyed Helga's cup.");
		System.out.println("Horcrux 5: Destroyed Ravenclaw's tiara.");
		System.out.println("Horcrux 6: Destroyed the part of Voldemort from Harry's soul.");
		System.out.println("Horcrux 7: Destroyed snake.");
		return "Horcruxes destroyed";
	}
}

class Voldemort{
	public String killVoldemort(){
		System.out.println("Voldemort killed");
		return "Voldemort is dead";
	}
}


class WizardClass {
	private boolean gotStone;
	private boolean killedAbasilisk;
	private boolean destroyedHorcruxes;
	private boolean killedVoldemort;
	
	public String getStone(){
		Stone stone = new Stone();
		this.gotStone = true;
		return stone.getStone();
	}
	
	public String killAbasilisk(){
		Abasilisk ab = new Abasilisk();
		this.killedAbasilisk = true;
		return ab.killAbasilisk();
	}
	
	public String destroyHorcruxes(){
		Horcruxes horcrux = new Horcruxes();
		this.destroyedHorcruxes = true;
		return horcrux.destroyHorcruxes();
	}
	
	public String killVoldermort(){
		Voldemort darkLord = new Voldemort();
		this.killedVoldemort = true;
		return darkLord.killVoldemort();
	}
	
	public void identity(){
		if(gotStone && killedAbasilisk && destroyedHorcruxes && killedVoldemort){
			System.out.println("This my friend, is Harry Potter");
		} else {
			System.out.println("Wizard unknown. He was closed to kill Voldemort");
		}
	}
	
}

public class Facade2 {
	public static void main(String[] args){
		WizardClass wizard = new WizardClass();
		wizard.destroyHorcruxes();
		wizard.getStone();
		wizard.identity();
		System.out.println("\n\n\n");
		WizardClass wizardHarry = new WizardClass();
		wizardHarry.getStone();
		wizardHarry.killAbasilisk();
		wizardHarry.destroyHorcruxes();
		wizardHarry.killVoldermort();
		wizardHarry.identity();
	}

}
