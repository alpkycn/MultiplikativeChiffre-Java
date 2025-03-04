package de.oop2024.util;



import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


public class Dateioperationen 
{
	 private String inputFilename ; 
	 private String outputFilename ;
	 private String plaintext ;
	 private String chiffertext ;
	 private String line;
	 
    
    public void verschltText(int key) 
    {
        inputFilename = "Gedicht.txt";
        outputFilename = "Geheim.txt";
        
        Verschluesseln ver = new Verschluesseln();
        
        try 
        {
            plaintext = readFile(inputFilename);
            chiffertext = ver.verschl(plaintext, key);
            writeFile(outputFilename, chiffertext);
            System.out.println("Verschluessseln ist erfolgreich. Geheimtext ist in " + outputFilename);
        } catch (IOException e) 
        {
            System.out.println("Error reading/writing file: " + e.getMessage());
        }
    }

    
    
    public void entschltText(int key) 
    {
        inputFilename = "Geheim.txt";
        outputFilename = "Klartext.txt";
        
    	Entschluesseln ent = new Entschluesseln();

        try 
        {
            chiffertext = readFile(inputFilename);
            plaintext = ent.entschl(chiffertext, key) ;
            writeFile(outputFilename, plaintext);
            System.out.println("Entschluessseln ist erfolgreich. Klartext ist in " + outputFilename);
        } catch (IOException e) 
        {
            System.out.println("Error reading/writing file: " + e.getMessage());
        }
    }
   
    
    public String readFile(String filename) throws IOException
    {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new FileReader(filename)))
        {
            while ((line = br.readLine()) != null) 
            {
                sb.append(line).append("\n");
            }
        }
        return sb.toString();
    }

    public void writeFile(String filename, String content) throws IOException 
    {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) 
        {
            bw.write(content);
        }
    }

}
