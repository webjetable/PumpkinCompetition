import java.util.ArrayList;


public class Test {

	
	/**
	 * @author Brigitte Withalm (1126733)
	 */
	
	public static void main(String[] args) {


		System.out.println("Test New Pumpkin" + "\n");
		testPumpkin();
		
		System.out.println("Test New Competition");
		try {testCompetition();}
		catch (CompException ce){
			System.out.println(ce.getMessage());
		}

		System.out.println("Test Growth Under Normal Conditions");
		try {testStandardGrow();}
		catch (CompException ce){
			System.out.println(ce.getMessage());
		}

		System.out.println("Test 5-Day Dry-Spell");
		try{testDrought5Days();}
		catch (CompException ce){
			System.out.println(ce.getMessage());
		}

		

	}

	// Test the class Pumpkin
	private static void testPumpkin(){
		Pumpkin p = new Pumpkin();
		System.out.println("Weight: " + p.getWeight()); // Expected value: 1.0
		System.out.println("Age: " + p.getAge()); // Expected value: 0
		System.out.println();
	}
	
	/*
	 * Test the class Competition
	 * 
	 */

	private static void testCompetition() throws CompException{

		Competition c = new Competition(2);

		Day firstDay = new Day(20);
		Day secondDay = new Day(80);

		c.setNextDay(firstDay);
		
		c.setNextDay(secondDay);
		
		
		System.out.println("Duration of Competition: " + c.getDuration()); // Expected value: 2
		System.out.println();
		
	}
	

	/*
	 * Test the growth under normal Conditions (5% growth at 100% Sun,
	 * otherwise proportionally less)			
	 */

	private static void testStandardGrow() throws CompException{

		Pumpkin p = new Pumpkin();
		Competition c1 = new Competition(2);

		Day firstDay = new Day(20);
		Day secondDay = new Day(30);
		
		c1.setNextDay(firstDay); // 1st day: 80% Sun -> 4% growth
		
		// eigentlich will ich hier einfach den Kuerbis wachsen lassen, also mit p.grow(c1)
		p.grow(firstDay, c1); 
		System.out.println("Weight Day 1: " + p.getWeight()); //Expected value: 1,04

		c1.setNextDay(secondDay);
				
		p.grow(secondDay, c1); // 2.Tag: 70 Prozent Sonne -> 3,5 Prozent Wachstum
		System.out.println("Weight Day 2: " + p.getWeight()); //Expected value: 1,0764
		System.out.println();
	}

	/*
	 * Test Wachstumseinschraenkung durch 5-taegige Trockenperiode
	 * In Trockenperioden stellt der Kuerbis das Wachstum ein. Hat es in den letzten 5 Tagen 
	 * zusammengenommen weniger als 10 Prozent Wasser gegeben, geht das Wachstum auf die 
	 * Haelfte zurueck. 
	 */

	private static void testDrought5Days() throws CompException{

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

		System.out.println("Weight 2 Days after 5 Day Dry-Spell: " 
				+ p.getWeight()); //Expected value: 1,62
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

Schnecken lieben Feuchtigkeit, vor allem gleichmaeSzige Feuchtigkeit. An jedem Tag mit 
mindestens 50% Wasser machen sie sich ueber die Blaetter her und sorgen dafuer, dass der Kuerbis 
1% seines Gewichts verliert. Ab 30% Wasser in den letzten 2 Tagen verliert der Kuerbis 
ebenso 1% des Gewichts, genauso wie ab 10% Wasser in den letzten 4 Tagen.

Die tatsaechlichen klimatischen Bedingungen duerfen nicht ganz auSzer Acht gelassen werden. 
Daher muss es mindestens 10 Tage mit 100% Wasser und mindestens 10 Tage mit 100% Sonne geben.
Wird der Kuerbis an einem Tag gar nicht versorgt, erhaelt er weder Wasser noch Licht.
 */