package de.oop2024.util;


import java.util.stream.IntStream;

public class Testprogramm1 {
	
    public static final int ALPHABET_SIZE = 26;  // Größe des Alphabets (Standard: 26 Buchstaben im Englischen)
    private int key ;
    private String operation ;

    // Methode zur Verschlüsselung oder Entschlüsselung von Text
    public void chiffer() {
    	
    	System.out.println("Chiffrier- und Dechiffiertabelle");
    	System.out.println("************************************************");
    	System.out.println("a b c d e f g h i j  k  l  m  n  o  p  q  r  s  t  u  v  w  x  y  z");
        System.out.println("0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25");
        System.out.println("************************************************");

        Dateioperationen dateioperationen = new Dateioperationen(); // Instanz der Klasse Dateioperationen, um Dateien zu lesen/schreiben

        operation = UserInterface.in.askQuestion("Geben Sie '1' (zum Verschlüsseln) oder '2' (zum Entschlüsseln) ein: ");

        if (operation.equals("1")) {
            key = UserInterface.in.requestInt("Geben Sie Schlüssel ein (Datentyp int): ");
            
            if (key != 3 && key != 5 && key != 7 && key != 9 && key != 11 &&
                    key != 15 && key != 17 && key != 19 && key != 21 && key != 23 && key != 25)
            {
            	System.out.println("Sie können nur folgende Schlüssel eingeben:{3,5,7,9,11,15,17,19,21,23,25}");
            	return ;
            }
            dateioperationen.verschltText(key);
            
            
        } else if (operation.equals("2")) {
            key = UserInterface.in.requestInt("Geben Sie Schlüssel ein (Datentyp int): ");
            
            if (key != 3 && key != 5 && key != 7 && key != 9 && key != 11 &&
                    key != 15 && key != 17 && key != 19 && key != 21 && key != 23 && key != 25)
            {
            	System.out.println("Sie können nur folgende Schlüssel eingeben:{3,5,7,9,11,15,17,19,21,23,25}");
            	return ;
            }
            dateioperationen.entschltText(key);
        } else {
            System.out.println("Ungültige Eingabe. Bitte geben Sie entweder 'encrypt' oder 'decrypt'.");
        }
    }
  
    // Methode zur Ermittlung des modularen Inversen einer Zahl im Bereich des Alphabets
    public int findModularInverse(int originalkey) {
        
         
        return IntStream.range(1, ALPHABET_SIZE)
                        .filter(x -> (originalkey * x) % ALPHABET_SIZE == 1)
                        .findFirst()
                        .orElse(1);
    }
    
}
