
public class Test {

	
	/**
	 * @author Brigitte Withalm (1126733)
	 */
	
	public static void main(String[] args) {


		System.out.println("Test Neuer Kuerbis" + "\n");
		testPumpkin();
		
		System.out.println("Test Neue Competition");
		testCompetition();

		System.out.println("Test Gewichtszunahme unter normalen Bedingungen");
		testStandardGrow();

		System.out.println("Test 5-Tages Trockenphase");
		testDrought5Days();

		

	}

	// Test der Klasse Pumpkin
	private static void testPumpkin(){
		Pumpkin p = new Pumpkin();
		System.out.println("Gewicht: " + p.getWeight()); // erwarteter Wert: 1.0
		System.out.println("Gewicht: " + p.getAge()); // erwarteter Wert: 0
		System.out.println();
	}
	
	/*
	 * Test der Klasse Competition
	 * 
	 */

	private static void testCompetition(){

		Competition c = new Competition(2);

		Day firstDay = new Day(20);
		Day secondDay = new Day(80);

		try{
			c.setNextDay(firstDay);
		}
		catch (CompException ce){
			System.out.println(ce.getMessage());
		}
		
		try{
			c.setNextDay(secondDay);
		}
		catch (CompException ce){
			System.out.println(ce.getMessage());
		}
		
		System.out.println("Wettbewerbsdauer: " + c.getDuration()); // erwarteter Wert: 2
		System.out.println();
		
	}
	

	/*
	 * Test Gewichtszunahme unter normalen Bedingungen (5Prozent Wachstum bei 100Prozent Licht,
	 * sonst anteilsmaessig geringer)			
	 */

	private static void testStandardGrow(){

		Pumpkin p = new Pumpkin();
		Competition c1 = new Competition(2);

		Day firstDay = new Day(20); // 1.Tag: 80 Prozent Sonne -> 4 Prozent Wachstum
		p.grow(firstDay, c1);
		System.out.println("Gewicht Tag 1: " + p.getWeight()); //erwarteter Wert: 1,04

		Day secondDay = new Day(30); // 2.Tag: 70 Prozent Sonne -> 3,5 Prozent Wachstum
		p.grow(secondDay,c1);
		System.out.println("Gewicht Tag 2: " + p.getWeight()); //erwarteter Wert: 1,0764
		System.out.println();
	}

	/*
	 * Test Wachstumseinschraenkung durch 5-taegige Trockenperiode
	 * In Trockenperioden stellt der Kuerbis das Wachstum ein. Hat es in den letzten 5 Tagen 
	 * zusammengenommen weniger als 10 Prozent Wasser gegeben, geht das Wachstum auf die 
	 * Haelfte zurueck. 
	 */

	private static void testDrought5Days(){

		Pumpkin p = new Pumpkin();
		Competition c = new Competition(12);
		Day[] d = new Day[c.getDuration()];

		// 1. bis 5.Tag: je 80 Prozent Sonne -> 4 Prozent Wachstum
		for (int i =0; i<5; i++){
			d[i] = new Day(20);			
		}

		// 6. bis 10.Tag: je 99 Prozent Sonne (nur 1 Prozent Wasser) -> 4,95 Prozent Wachstum
		for (int i =5; i<10; i++){
			d[i] = new Day(1);
		}
		
		// 11. bis 12.Tag: je 20 Prozent Wasser -> nur 2 statt 4 Prozent Wachstum wg. Trockenphase
		for (int i =10; i<12; i++){
			d[i] = new Day(1);
		}


		for(int i=0; i<d.length; i++){
			p.grow(d[i],c);
		}

		System.out.println("Gewicht 2 Tage nach 5 taegiger Trockenphase: " 
				+ p.getWeight()); //erwarteter Wert: 1,62
		System.out.println();

	}







}

/*
 * 
 * Jonas Raditschnig, Matrnr 1021251: Klasse Pumpkin
 * Angelika Fuerndraht-Grossschopf, Matrnr 9300256: Klassen Competition und Day
 * Brigitte Withalm, Matrnr 1126733: Testklasse
 * 
 * gemeinsam: Interpretation der Aufgabenstellung und Konzept
 * 
 */

/*
weiters zu testen

 * trockenheit 2.fall
 * Hat es in den letzten 10 Tagen zusammengenommen weniger als 10% Wasser gegeben, wird das 
 * Wachstum sogar ganz eingestellt.

Schnecken lieben Feuchtigkeit, vor allem gleichmäßige Feuchtigkeit. An jedem Tag mit 
mindestens 50% Wasser machen sie sich über die Blätter her und sorgen dafür, dass der Kürbis 
1% seines Gewichts verliert. Ab 30% Wasser in den letzten 2 Tagen verliert der Kürbis 
ebenso 1% des Gewichts, genauso wie ab 10% Wasser in den letzten 4 Tagen.

Die tatsächlichen klimatischen Bedingungen dürfen nicht ganz außer Acht gelassen werden. 
Daher muss es mindestens 10 Tage mit 100% Wasser und mindestens 10 Tage mit 100% Sonne geben.
Wird der Kürbis an einem Tag gar nicht versorgt, erhält er weder Wasser noch Licht.
 */