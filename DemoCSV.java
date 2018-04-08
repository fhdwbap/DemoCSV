/**
 * Eine kleine Illustration zum Einlesen einer CSV-Datei,
 * hier am Beispiel des folgenden Formates.
 * <pre>
 * ID;Vorlesung;Dozent;Studiengruppen
 * 1601;OPR;BAP;BFWS417A,BFWI417A
 * 1602;OPR;BAP;MFWS417A,MFWI417A
 * </pre>
 * <br/>
 * Bei Bedarf gibt es auf
 * <a href="https://de.wikipedia.org/wiki/CSV_(Dateiformat)" target="_blank">Wikipedia</a>
 * weitere Informationen zum CSV-Format.
 */

package de.fhdw.java;

import java.util.*;
import java.io.*;

/**
 * Elementare Demonstration fuer das Einlesen und Parsen einer 
 * CSV-Datei. Angelehnt an das Buch &quot;Das Java-Praktikum&quot;
 * von Reinhard Schiedermeier und Klaus Koehler. 
 * Siehe hierzu auch die Webseite
 * <a href="http://sol.cs.hm.edu/dpunkt-java-praktikum/"
 * target="_blank">sol.cs.hm.edu/dpunkt-java-praktikum/</a>.
 * @author fhdwbap
 *
 */
public class DemoCSV
{

	/**
	 * Der Default-Konstruktor der Klasse DemoCSV.
	 * <br/>
	 * Dieser wird aktuell zwar nicht verwendet, da Java ihn aber ohnehin
	 * mit leerem Code anlegen wuerde, ist es besser, er ist in dieser
	 * Form explizit vorhanden.
	 * 
	 */
	public DemoCSV()
	{
		// zur Zeit nicht verwendet
		System.out.println("Aktuell werden keine DemoCSV-Objekte erzeugt.");
		System.out.println("Alles wird ueber static-Methoden abgewickelt.");
	}

	/**
	 * Einlesen einer CSV-Datei und anschliessendes Zerlegen in eine
	 * Liste von String-Listen. (Ok, klingt etwas komplex...)
	 * <br/>
	 * Bei der vorliegenden Implementierung wird ueber das Zeichen ';'
	 * zerlegt.
	 * 
	 * @param filename Name der einzulesenden CSV-Datei
	 * @return Die Liste der geparsten String-Listen 
	 * @throws IOException
	 */
	public static List<List<String>> loadAndParse(String filename)
	throws IOException
	{
		List<List<String>> result = new ArrayList<List<String>>();
		
		BufferedReader br = new BufferedReader( new FileReader(filename));
		
		for (String line = br.readLine(); line != null; line = br.readLine())
		{
			result.add(Arrays.asList(line.split(";")));
		}
		br.close();
		return result;
	}
	
	/**
	 * Demo-Hauptprogramm / -Einstiegspunkt fuer die statische loadAndParse()-Methode.
	 * @param args Soll den Namen der einzulesenden CSV-Datei enthalten.
	 */
	public static void main(String[] args)
	{
		if (args.length != 1)
		{
			System.out.println("usage: [java] DemoCSV filename");
			return;
		}
		
		List<List<String>> slist; 
		
		try
		{
			slist = loadAndParse(args[0]);
		}
		catch(IOException ioe)
		{
			System.out.println("IOException!");
			ioe.printStackTrace();
			return;
		}
		
      
		for (List<String> entry : slist)
		{
			System.out.println("entry: " + entry);
			
			String sid = entry.get(0);
			String svorl = entry.get(1);
			String sdoz = entry.get(2);
			String sgr = entry.get(3);
			
			System.out.println("ID: " + sid + " Vorl.: " + svorl 
					+ " Doz.: " + sdoz + " Stud.gr.: " + sgr);
		}
	}

} // end class DemoCSV




