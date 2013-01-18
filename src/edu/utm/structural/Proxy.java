package edu.utm.structural;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

interface BookInterface{
	public void getBook();
}

//RealBook
class RealBook implements BookInterface{
	private String filepath;
	public RealBook(String f){
		filepath = f;
	}
	
	public void getBook(){
		Scanner s = null;
		try{
			s = new Scanner(new BufferedReader(new FileReader(filepath)));
			while(s.hasNext()) {
				System.out.println(s.next());
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally{
			if (s != null) {
				s.close();
			}
		}
	}
}

//ProxyBook
class ProxyBook implements BookInterface{
	private String filepath;
	public ProxyBook(String t) {
		filepath = t;
	}
	
	public void getBook(){
		RealBook real = new RealBook(filepath);
		real.getBook();
	}
}

public class Proxy {
	public static void main(String[] args){
		ProxyBook proxy = new ProxyBook("wizard.txt");
		proxy.getBook();
	}
}
