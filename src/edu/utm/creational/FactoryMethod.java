package edu.utm.creational;

interface Spells {
String getSpells();
}
class OpenDoor implements Spells {
@Override
public String getSpells(){
return "Alohomora";
}
}
class Levitate implements Spells {
@Override
public String getSpells(){
return "Wingardium Leviosa";
}
}
class Patronus implements Spells{
@Override
public String getSpells(){
return "Expecto Patronum";
}
}
class EraseMemory implements Spells{
@Override
public String getSpells(){
return "Obliviate";
}
}
class SpellsFactory {
public static Spells createSpells (String need) {
if(need.equals("Open door")){
return new OpenDoor();
}else if (need.equals("Levitate")){
return new Levitate();
}else if(need.equals("Patronus")){
return new Patronus();
}else if(need.equals("Erase memory")){
return new EraseMemory();
}
throw new IllegalArgumentException("Can't provide a spell for this");
}
}
public class FactoryMethod {
public static void main(String args[]) {
String need = "Erase memory";
Spells spell = SpellsFactory.createSpells(need);
System.out.println("spell for: "+need+"- "+spell.getSpells());
}
}
