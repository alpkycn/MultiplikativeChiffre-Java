package de.oop2024.util;

import java.io.IOException;
import java.util.Random;
import java.util.stream.IntStream;

public class Testprogramm2 
{
	Dateioperationen dateioperationen = new Dateioperationen();
	static Cryptanalysis analysis = new Cryptanalysis();
	Verschluesseln verschlusseln = new Verschluesseln();
	
	private int key ;
	public String plaintext ;
	private String ciphertext ;
    private String operation ;
    
    public static int ALPHABET_SIZE = 26;  
	 
	 Random random = new Random();

	   
	    public void chiffer() {
	    	
	    	System.out.println("Chiffrier- und Dechiffiertabelle");
	    	System.out.println("************************************************");
	    	System.out.println("a b c d e f g h i j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z");
	        System.out.println("0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25");
	        System.out.println("************************************************");

	        Dateioperationen dateioperationen = new Dateioperationen(); 

	        operation = UserInterface.in.askQuestion("Geben Sie '1' (zum Verschluesseln) oder '2' (zum Entschluesseln) ein: ");

	        if (operation.equals("1")) {
	            key = random.nextInt(27);
	            
	            while(key != 3 && key != 5 && key != 7 && key != 9 && key != 11 &&
	                    key != 15 && key != 17 && key != 19 && key != 21 && key != 23 && key != 25)
	            {
	            	key = random.nextInt(27);
	            }
	            dateioperationen.verschltText(key);
	            
	             
	        } 
	        else if(operation.equals("2"))
	        {
	        	try {
	        		plaintext = dateioperationen.readFile("Gedicht.txt");
	        		ciphertext = dateioperationen.readFile("Geheim.txt");
	        	
	        	
	        	} catch (IOException e) {
	        	    System.out.println("Fehler beim Lesen: " + e.getMessage());
	        	    return;
	        	}
	        	
	        	bruteForceDecryptLimitedKeys(ciphertext);
	       
	   
	        }

	    }
	    
	    public static String bruteForceDecryptLimitedKeys(String plaintext)  {
	    
	    	int[] allowedKeys = {3, 5, 7, 9, 11, 15, 17, 19, 21, 23, 25};
	    
	   
	    String decryptedText = "";

	   
	    for (int key : allowedKeys) {
	        
	        String decryptedAttempt = Cryptanalysis.decryptWithKey(plaintext, key);
	        

	 
	        
	
	        if (decryptedAttempt.contains("Schnee")) {
	        	System.out.println("Schluessel: " + key);
	        	 System.out.println("dechiffrierter Text: " + decryptedAttempt);
	            decryptedText = decryptedAttempt;
	            break;
	        }
	    }
	    return decryptedText;
	    }
	        
	   
	    public int findModularInverse(int originalkey) {
	        
	       
	        return IntStream.range(1, ALPHABET_SIZE)
	                        .filter(x -> (originalkey * x) % ALPHABET_SIZE == 1)
	                        .findFirst()
	                        .orElse(1);
	    }
	    

		
	}