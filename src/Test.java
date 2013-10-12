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
 * 
 * gemeinsam: Interpretation der Aufgabenstellung und Konzept
 * 
 */

/*
weiters zu testen

In Trockenperioden stellt der K�rbis das Wachstum ein. Hat es in den letzten 5 Tagen 
zusammengenommen weniger als 10% Wasser gegeben, geht das Wachstum auf die H�lfte zur�ck. 
Hat es in den letzten 10 Tagen zusammengenommen weniger als 10% Wasser gegeben, wird das 
Wachstum sogar ganz eingestellt.

Schnecken lieben Feuchtigkeit, vor allem gleichm��ige Feuchtigkeit. An jedem Tag mit 
mindestens 50% Wasser machen sie sich �ber die Bl�tter her und sorgen daf�r, dass der K�rbis 
1% seines Gewichts verliert. Ab 30% Wasser in den letzten 2 Tagen verliert der K�rbis 
ebenso 1% des Gewichts, genauso wie ab 10% Wasser in den letzten 4 Tagen.

Die tats�chlichen klimatischen Bedingungen d�rfen nicht ganz au�er Acht gelassen werden. 
Daher muss es mindestens 10 Tage mit 100% Wasser und mindestens 10 Tage mit 100% Sonne geben.
Wird der K�rbis an einem Tag gar nicht versorgt, erh�lt er weder Wasser noch Licht.
 */
