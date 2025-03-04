package de.oop2024.util;

public class Entschluesseln 
{
	private int modInverse ;
	private int charNum ;
	private int entschlusselteCharNum ;
	private char entschlusselteChar ;
	private char base ;
	

	public String entschl(String chiffertext, int key) 
	{
		Testprogramm1 mult = new Testprogramm1();
       
		modInverse = mult.findModularInverse(key);
        
		StringBuilder plaintext = new StringBuilder();
        
        for (char ch : chiffertext.toCharArray()) 
        {
            if (Character.isLetter(ch)) 
            {
                base = Character.isUpperCase(ch) ? 'A' : 'a';
                charNum = ch - base;
                entschlusselteCharNum = (charNum * modInverse) % 26;
                if (entschlusselteCharNum < 0) 
                {
                	entschlusselteCharNum += 26;
                }
                entschlusselteChar = (char) (entschlusselteCharNum + base);
                plaintext.append(entschlusselteChar);
            } 
            else 
            {
                plaintext.append(ch);
            }
        }
        return plaintext.toString();
	}


	
	}

