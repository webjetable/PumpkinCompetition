
public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		
		System.out.println("Test Neuer Kuerbis" + "\n");
		testNeuerKuerbis();
		
		System.out.println("Test Gewichtszunahme unter normalen Bedingungen");
		testStandardGrow();

	}

	// Test der Klasse Pumpkin
	private static void testNeuerKuerbis(){
		Pumpkin p = new Pumpkin();
		System.out.println("Gewicht: " + p.getWeight()); // erwarteter Wert: 1
		System.out.println("Alter: " + p.getAge()); // erwarteter Wert: 0
		System.out.println();
	}

	/*
		Test Gewichtszunahme unter normalen Bedingungen (5Prozent Wachstum bei 100Prozent Licht,
		sonst anteilsmaessig geringer)		
	 */
	private static void testStandardGrow(){
		
		Pumpkin p = new Pumpkin();

		Day firstDay = new Day(20); // 1.Tag: 80 Prozent Sonne -> 4 Prozent Wachstum
		p.grow(firstDay);
		System.out.println("Gewicht Tag 1: " + p.getWeight()); //erwarteter Wert: 1,04
		
		Day secondDay = new Day(30); // 2.Tag: 70 Prozent Sonne -> 3,5 Prozent Wachstum
		p.grow(secondDay);
		System.out.println("Gewicht Tag 2: " + p.getWeight()); //erwarteter Wert: 1,0764
	}

}

/*
 * 
 * Jonas      , Matrnr           : Klasse Pumpkin
 * Angelika Fürndraht-Grossschopf, Matrnr       : Klassen Competition und Day
 * Brigitte Withalm, Matrnr 1126733: Testklasse
 * 
 * gemeinsam: Interpretation der Aufgabenstellung und Konzept
 * 
 */

/*
weiters zu testen

In Trockenperioden stellt der Kürbis das Wachstum ein. Hat es in den letzten 5 Tagen 
zusammengenommen weniger als 10% Wasser gegeben, geht das Wachstum auf die Hälfte zurück. 
Hat es in den letzten 10 Tagen zusammengenommen weniger als 10% Wasser gegeben, wird das 
Wachstum sogar ganz eingestellt.

Schnecken lieben Feuchtigkeit, vor allem gleichmäßige Feuchtigkeit. An jedem Tag mit 
mindestens 50% Wasser machen sie sich über die Blätter her und sorgen dafür, dass der Kürbis 
1% seines Gewichts verliert. Ab 30% Wasser in den letzten 2 Tagen verliert der Kürbis 
ebenso 1% des Gewichts, genauso wie ab 10% Wasser in den letzten 4 Tagen.

Die tatsächlichen klimatischen Bedingungen dürfen nicht ganz außer Acht gelassen werden. 
Daher muss es mindestens 10 Tage mit 100% Wasser und mindestens 10 Tage mit 100% Sonne geben.
Wird der Kürbis an einem Tag gar nicht versorgt, erhält er weder Wasser noch Licht.
 */