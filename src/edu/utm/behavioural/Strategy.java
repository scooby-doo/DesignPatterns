package edu.utm.behavioural;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.util.Scanner;

interface StreamStrategy{
	public void streamFile(String filepath) throws Exception;
}

class ByteStreamStrategy implements StreamStrategy{
	public void streamFile(String filepath) throws Exception{
		
		FileInputStream in = null;

		try{
			in = new FileInputStream(filepath);
			int c;

			while((c = in.read()) != -1){
				System.out.println(c);
			}
		}
		finally{
			if( in != null){
				in.close();
			}
		}
		
		
		
	}
}

class ScannerStrategy implements StreamStrategy{
	public void streamFile(String filepath) throws Exception{
		Scanner s = null;
		try{
			s = new Scanner(new BufferedReader(new FileReader(filepath)));
			while(s.hasNext()) {
				System.out.println(s.next());
			}
		} finally{
			if (s != null) {
				s.close();
			}
		}
		
	}
}

class CharStreamStrategy implements StreamStrategy{
	public void streamFile(String filepath) throws Exception{
		
		
		FileReader inputStream = null;

		try{
			inputStream = new FileReader(filepath);

			int c;
			while((c = inputStream.read()) != -1){
				System.out.println(c);
			}

		} finally{
			if(inputStream != null){
				inputStream.close();
			}
		}
		
		
	}
}

class StreamContext {
	private StreamStrategy strategy;

	public void setStrategy(StreamStrategy strategy) {
		this.strategy = strategy;
	}
	
	public void readFile(String filepath) throws Exception{
		strategy.streamFile(filepath);
	}
}


public class Strategy {
	public static void main (String[] args) throws Exception{
		StreamContext st = new StreamContext();
		st.setStrategy(new ScannerStrategy());
		st.readFile("wizard.txt");	
	}

}
