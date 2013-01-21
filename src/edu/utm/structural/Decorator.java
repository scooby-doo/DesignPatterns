package edu.utm.structural;

import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;

/** 
 * Component
 */
interface Message{
	String getMessage();
}

/**
 * Concrete Component
 */
class SomeMessage implements Message{
	private String message;
	
	public SomeMessage(String sms){
		this.message = sms;
	}
	
	@Override
	public String getMessage(){
		return message;
	}
}


/**
 * Decorator
 */
abstract class MessageDecorator implements Message{
	Message message;
}

/**
 * Concrete Decorator 
 */
class SecuredMessageDecorator extends MessageDecorator{
	private static final String  ALGO = "AES";
	private static final byte[] keys = new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't','S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };
	private String securedMessage;
	
	public SecuredMessageDecorator(Message initialMessage){
		message = initialMessage;
	}
	
	@Override
	public String getMessage(){
		try {
			securedMessage = addEncryption(message.getMessage());;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return securedMessage;
	}

	private String addEncryption(String message) throws NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException{
		Key key = new SecretKeySpec(keys,ALGO);
		Cipher c = Cipher.getInstance(ALGO);
		c.init(Cipher.ENCRYPT_MODE,key);
		byte[] encVal = c.doFinal(message.getBytes());
		String securedMessage = Base64.encodeBase64String(encVal);
		return securedMessage;
	}
}

class SignatureMessageDecorator extends MessageDecorator{
	private String signatureMessage;
	
	public SignatureMessageDecorator(Message initMessage){
		message = initMessage;
	}
	
	@Override
	public String getMessage(){
		signatureMessage = signMessage(message.getMessage());
		return signatureMessage;
	}
	
	private String signMessage(String pMessage){
		StringBuilder sb = new StringBuilder();
		sb.append(pMessage);
		sb.append("\nName Surname, from company X.\nCool long position name\nTel:12345678\nSkype:some.skypename\nCall me Maybe?");
		return sb.toString();
	}
}


public class Decorator {
	public static void main(String[] args){
		SomeMessage message = new SomeMessage("This is some email to the universe from UTM students. Why 42?");
		
		System.out.println("Secured message");
		SecuredMessageDecorator secured = new SecuredMessageDecorator(message);
		System.out.println(secured.getMessage());
		System.out.format("%n%n%n");
		
		System.out.println("With signature");
		SignatureMessageDecorator signature = new SignatureMessageDecorator(message);
		System.out.println(signature.getMessage());

	}

}
