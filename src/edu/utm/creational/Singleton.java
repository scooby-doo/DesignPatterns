package edu.utm.creational;
class SingletonObject {
	private SingletonObject() {
	}

	//does not allow two thread to create two instances of the class
	public static synchronized SingletonObject getSingletonObject() {
		if (ref == null) {
			ref = new SingletonObject();
		}
		return ref;
	}

	//does not allow to use clone method
	public Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	private static SingletonObject ref;
	
	public void getInfo(){
		System.out.println( "There can only be just one Dumbledore\n");
	}
}

public class Singleton {
	
	public static void main (String[] args){
		SingletonObject sOne = SingletonObject.getSingletonObject();
		sOne.getInfo();
		SingletonObject sTwo = SingletonObject.getSingletonObject();
		
		//it's the same instance
		System.out.println(sOne);
		System.out.println(sTwo);
	}

}
