package edu.utm.structural;

import java.util.ArrayList;
import java.util.List;

//Flyweight
interface ASCIIArtFlyweight {
	public StringBuilder printOut();
	public String getText();
}


//Concrete Flyweight
class Text implements ASCIIArtFlyweight {
	private String text;
	
	public Text(String t){
		text = t;
	}

	public String getText() {
		return text;
	}
	
	public StringBuilder printOut(){
		StringBuilder finalArt = new StringBuilder();
		String bender = String.format("\t  .-.%n"+
                "\t (   )%n"+
                "\t  '-'%n"+
                "\t  J L%n"+
                "\t  | |%n"+
               "\t  J   L%n"+
               "\t  |   |%n"+
              " \t  J     L%n"+
            "\t.-'.___.'-.%n"+
           "\t___________%n"+
      "  _.-'''           `bmw%n"+
    "  .'                       `.%n"+
 " J                            `.%n"+
" F                               L%n"+
"J                                 J%n"+
"J                                  `%n"+
"|                                   L%n"+
"|                                   |%n"+
"|                                   |%n"+
"|                                   J%n"+
"|                                    L%n"+
"|                                    |%n"+
"|             ,.___          ___....--._%n"+
"|           ,'     `'''''''''           `-._%n"+
"|          J           _____________________`-.%n"+
"|         F         .-'   `-88888-'    `Y8888b.`.%n"+
"|         |       .'         'P'         `88888b . %n"+
"|         |      J       #     L      #    q8888b L%n"+
"|         |      |             |           )8888D )%n"+
"|         J      /             J           d8888P P %n"+
"|          L      `.         .b.         ,88888P / %n"+
"|           `.      `-.___,o88888o.___,o88888P'.'%n"+
"|             `-.__________________________..-'%n"+
"|                                    |%n"+
"|         .-----.........____________J%n"+
"|       .' |       |      |       |%n"+
"|      J---|-----..|...___|_______|%n"+
"|      |   |       |      |       |%n"+
"|      Y---|-----..|...___|_______|%n"+
"|       `. |       |      |       |%n"+
"|         `'-------:....__|______.J%n"+
"|                                  |%n"+
"L___                              |%n"+
 "   '''----...______________....--'%n");
		finalArt.append(bender);
		
		finalArt.append(getText());
		return finalArt;
	}
	
}

//Flyweight Factory
class ASCIIArtFlyweightFactory {
	private List<ASCIIArtFlyweight> pool;
	//private StringBuilder finalArt;
	
	public ASCIIArtFlyweightFactory(){
		pool = new ArrayList<ASCIIArtFlyweight>();
	}
	
	public ASCIIArtFlyweight getText(String t){
		for(ASCIIArtFlyweight art: pool){
			if(art.getText().equals(t)){
				return art;
			}
		}
		ASCIIArtFlyweight text = new Text(t);
		pool.add(text);
		return text;
	}
}


public class Flyweight {
	public static void main(String[] args){
		ASCIIArtFlyweightFactory factory = new ASCIIArtFlyweightFactory();
		
		ASCIIArtFlyweight text1 = factory.getText("I support and oppose many things, but not strongly enough to pick up a pen.");
		ASCIIArtFlyweight text2 = factory.getText("Rrrrr... it's so cold, my processor is running at peak efficiency!");
		ASCIIArtFlyweight text3 = factory.getText("I support and oppose many things, but not strongly enough to pick up a pen.");
		
		System.out.println(text1.printOut());
		System.out.format("%n%n%n%n%n%n%n%n%n");
		System.out.println(text2.printOut());
		System.out.format("%n%n%n%n%n%n%n%n%n");
		System.out.println(text3.printOut());
		
		System.out.println("Is text1 the same object as text3: "+text3.equals(text1));
	}

}



















