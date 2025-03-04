package de.oop2024.util;

public class Main 
{
	public static String knownkey ;

	public static void main(String[] args) 
	{
			
		knownkey = UserInterface.in.askQuestion("Ist der Schluessel bekannt ?(Wenn ja geben Sie 1 ein sonst 2)");
		
		if(knownkey.equals("1"))
		{
			Testprogramm1 multich = new Testprogramm1();
			multich.chiffer();	
		}
		else if (knownkey.equals("2"))
		{
			Testprogramm2 programm2 = new Testprogramm2();
			programm2.chiffer();
		}
		
			
	}
}
	
		
		


   