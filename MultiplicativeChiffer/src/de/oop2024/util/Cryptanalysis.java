package de.oop2024.util;

public class Cryptanalysis 
{
	private static int charNum ;
	private static int decryptedCharNum ;
	private static char base ;
	private static char decryptedChar ;

    public static String decryptWithKey(String chiffertext, int key) 
    {
        StringBuilder plaintext = new StringBuilder();
        
        for (char ch : chiffertext.toCharArray()) 
        {
            if (Character.isLetter(ch))
            {
                base = Character.isUpperCase(ch) ? 'A' : 'a';
                charNum = ch - base;
                decryptedCharNum = (charNum * key) % 26;
                if (decryptedCharNum < 0) 
                {
                    decryptedCharNum += 26;
                }
                decryptedChar = (char) (decryptedCharNum + base);
                plaintext.append(decryptedChar);
            } 
            else 
            {
                plaintext.append(ch);
            }
        }
        return plaintext.toString();
    }
}
