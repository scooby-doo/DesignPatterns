package edu.utm.behavioural;

//Context
class LanguageContext {
	private String input;
	private String otput;
	public String getInput() {
		return input;
	}
	public LanguageContext(String in){
		this.input = in;
	}
	public void setInput(String input) {
		this.input = input;
	}
	public String getOtput() {
		return otput;
	}
	public void setOtput(String otput) {
		this.otput = otput;
	}
}

interface LanguageInterpretor {
	public void interpret(LanguageContext contex);
}

class EnglishInterpretor implements LanguageInterpretor {
	public void interpret(LanguageContext lc) {
		if(lc.getInput().equals("Buna dimineata")) {
			lc.setOtput("Good morning my dear lady");
		} else if(lc.getInput().equals("Ce faci?")) {
			lc.setOtput("What are you doing darling?");
		}
	}
}

class USEnglishInterpretor implements LanguageInterpretor {
	public void interpret(LanguageContext lc) {
		if(lc.getInput().equals("Buna dimineata")) {
			lc.setOtput("'mornin");
		} else if(lc.getInput().equals("Ce faci?")) {
			lc.setOtput("wasap");
		}
	}
}

class InterpretorPattern {
	public void translate(String text, LanguageInterpretor language){
		LanguageContext ls = new LanguageContext("Buna dimineata");
		language.interpret(ls);
		System.out.println(text + " : "+ls.getOtput());
	}
}

public class Interpreter {
	public static void main(String[] args){
		InterpretorPattern pt = new InterpretorPattern();
		LanguageInterpretor english = new EnglishInterpretor();
		LanguageInterpretor usEnglish = new USEnglishInterpretor();
		pt.translate("Buna dimineata", english);
		pt.translate("Buna dimineata", usEnglish);
	}
}
