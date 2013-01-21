package edu.utm.creational;
abstract class OneWizard {
	public abstract String power();
	public abstract String spell();
	public abstract String name();
}

class AbstractFactoryOne {
	public OneWizardFactory getWizardsFactory(String type) {
		if ("Wise".equals(type)) {
			return new WiseFactory();
		} else {
			return new YoungFactory();
		}
	}
}

abstract class OneWizardFactory {
	public abstract OneWizard getOneWizard(String type);
}

class WiseFactory extends OneWizardFactory {
	public OneWizard getOneWizard(String type) {
		if ("Gandalf".equals(type)) {
			return new Gandalf();
		} else {
			return new Dumbledore();
		}
	}
}

class Gandalf extends OneWizard {
	public String power() {
		return "Defeat Saruman";
	}

	public String spell() {
		return "YOU SHALL NOT PASS";
	}

	public String name() {
		return "Gandalf";
	}
}

class Dumbledore extends OneWizard {
	public String power() {
		return "Great Wisdom";
	}

	public String spell() {
		return "Avada Kadavra";
	}

	public String name() {
		return "Dumbledore";
	}
}

class YoungFactory extends OneWizardFactory {
	public OneWizard getOneWizard(String type) {
		if ("Harry".equals(type)) {
			return new Harry();
		} else if ("Ron".equals(type)) {
			return new Ron();
		} else {
			return new Hermione();
		}
	}
}

class Harry extends OneWizard {
	public String power() {
		return "Possum tongue";
	}

	public String spell() {
		return "Expecto Patronum";
	}

	public String name() {
		return "Harry";
	}

}

class Ron extends OneWizard {
	public String power() {
		return "Chess Player";
	}

	public String spell() {
		return "Wingardium Leviosa";
	}

	public String name() {
		return "Ron";
	}
}

class Hermione extends OneWizard {
	public String power() {
		return "Cleverness";
	}

	public String spell() {
		return "Alohomora";
	}

	public String name() {
		return "Hermione";
	}
}

public class AbstractFactory {
	public static void main(String[] args) {
		AbstractFactoryOne abstractFactory = new AbstractFactoryOne();

		OneWizardFactory oneWizardFactory1 = abstractFactory
				.getWizardsFactory("Wise");
		OneWizard wizard1 = oneWizardFactory1.getOneWizard("Gandalf");
		System.out.println("Wizard " + wizard1.name());
		System.out.println("Power: " + wizard1.power());
		System.out.println("Spell: " + wizard1.spell());
		System.out.println("\n");

		OneWizard wizard2 = oneWizardFactory1.getOneWizard("Dumbledore");
		System.out.println("Wizard " + wizard2.name());
		System.out.println("Power: " + wizard2.power());
		System.out.println("Spell: " + wizard2.spell());
		System.out.println("\n");

		OneWizardFactory oneWizardFactory2 = abstractFactory
				.getWizardsFactory("Young");
		OneWizard wizard3 = oneWizardFactory2.getOneWizard("Harry");
		System.out.println("Wizard " + wizard3.name());
		System.out.println("Power: " + wizard3.power());
		System.out.println("Spell: " + wizard3.spell());
		System.out.println("\n");

		OneWizard wizard4 = oneWizardFactory2.getOneWizard("Ron");
		System.out.println("Wizard " + wizard4.name());
		System.out.println("Power: " + wizard4.power());
		System.out.println("Spell: " + wizard4.spell());
		System.out.println("\n");

		OneWizard wizard5 = oneWizardFactory2.getOneWizard("Hermione");
		System.out.println("Wizard " + wizard5.name());
		System.out.println("Power: " + wizard5.power());
		System.out.println("Spell: " + wizard5.spell());
		System.out.println("\n");
	}
}
