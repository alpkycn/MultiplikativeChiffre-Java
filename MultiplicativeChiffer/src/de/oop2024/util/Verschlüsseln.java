package de.oop2024.util;

public class Verschlüsseln 
{
	private int charNum ;
	private int verschlusselteCharNum ;
	private char base ;
	private char verschlusselteChar ;

	
	public String verschl(String plaintext,int key) 
	{      
		StringBuilder chiffertext = new StringBuilder();
        
		for (char ch : plaintext.toCharArray()) 
		{
            if (Character.isLetter(ch)) 
            {
                base = Character.isUpperCase(ch) ? 'A' : 'a';
               
                charNum = ch - base;
                
                verschlusselteCharNum = (charNum * key) % 26;
                
                verschlusselteChar = (char) (verschlusselteCharNum + base);
               
                chiffertext.append(verschlusselteChar);
            } 
            else 
            {
                chiffertext.append(ch);
            }
        }
        return chiffertext.toString();
    }



}
