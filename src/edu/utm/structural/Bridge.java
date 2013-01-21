package edu.utm.structural;

// abstraction
abstract class HogwardsHouses {
	HouseHead houseHead;
	
	public void setHouseHead(HouseHead houseHead){
		this.houseHead = houseHead;
	}
	public abstract String houseFounder();
	public abstract String houseColors();
	public abstract String houseValues();
	public abstract String houseHead();
	
}

//abstraction children - refined abstractions
class Gryffindor extends HogwardsHouses {
	public Gryffindor (HouseHead houseHead){
		this.houseHead = houseHead;
	}
	@Override
	public String houseFounder(){
		return "Godric Gryffindor";
	}
	
	@Override
	public String houseColors(){
		return "Scarlet and gold";
	}
	
	@Override
	public String houseValues(){
		return "Courage, bravery, nerve, and chivalry";
	}	
	
	@Override
	public String houseHead(){
		return houseHead.houseHead();
	}
}


class Slytherin extends HogwardsHouses {
	public Slytherin (HouseHead houseHead){
		this.houseHead = houseHead;
	}
	
	@Override
	public String houseFounder(){
		return "Salazar Slytherin";
	}
	
	@Override
	public String houseColors(){
		return "Green and silver";
	}
	
	@Override
	public String houseValues(){
		return "Ambition, cunning, leadership, and resourcefulness";
	}
	
	@Override
	public String houseHead(){
		return houseHead.houseHead();
	}
}

class Ravenclaw extends HogwardsHouses {
	public Ravenclaw (HouseHead houseHead){
		this.houseHead = houseHead;
	}
	
	@Override
	public String houseFounder(){
		return "Rowena Ravenclaw";
	}
	
	@Override
	public String houseColors(){
		return "Blue and bronze";
	}
	
	@Override
	public String houseValues(){
		return "Intelligence, creativity, learning, and wit";
	}
	
	@Override
	public String houseHead(){
		return houseHead.houseHead();
	}
}


class Hufflepuff extends HogwardsHouses {
	public Hufflepuff (HouseHead houseHead){
		this.houseHead = houseHead;
	}
	
	@Override
	public String houseFounder(){
		return "Helga Hufflepuff";
	}
	
	@Override
	public String houseColors(){
		return "Yellow and black";
	}
	
	@Override
	public String houseValues(){
		return "Hard work, patience, justice, and loyalty";
	}
	
	@Override
	public String houseHead(){
		return houseHead.houseHead();
	}
}
//////////
// Implementator
interface HouseHead {
	public String houseHead();
}

//concrete implemetators
class GHouseHead implements HouseHead {
	public String houseHead(){
		return "Minerva McGonagall";
	}
}

class SHouseHead implements HouseHead {
	public String houseHead(){
		return "Severus Snape";
	}
}

class RHouseHead implements HouseHead {
	public String houseHead(){
		return "Filius Flitwick, The Grey Lady";
	}
}

class HHouseHead implements HouseHead {
	public String houseHead(){
		return "Pomona Sprout, The Fat Friar";
	}
}

class SHouseHeadNew implements HouseHead {
	public String houseHead(){
		return "Horace Slughorn";
	}
}

//Bridge
public class Bridge {
	public static void main(String [] args){
		HogwardsHouses hH = new Gryffindor(new GHouseHead());
		System.out.println(hH.houseFounder());
		System.out.println(hH.houseHead()+"\n");
		
		HogwardsHouses slytherin = new Slytherin(new SHouseHead());
		System.out.println(slytherin.houseFounder());
		System.out.println(slytherin.houseHead());		
		slytherin.setHouseHead(new SHouseHeadNew());
		System.out.println(slytherin.houseHead());
		
		
	}

}
