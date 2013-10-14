import java.util.ArrayList;

public class Competition implements IntCompetition{

	/**
	 * @author Angelika
	 */
	private ArrayList<Day> comp;
	private int duration;
	private int today;

	/**
	 * legt einen neuen Wettkampf an, 
	 * legt die Anzahl der Tage des Wettkampfes fest
	 * @param duration Anzahl der Tage, die der Wettkampf dauern soll
	 */
	public Competition(int duration)
	{
		comp = new ArrayList<Day>();
		this.duration = duration;
	}

	/**
	 * fŸgt einen neuen Tag in den Wettkampf ein, 
	 * zŠhlt, der wievielte Tag heute ist
	 * wenn die Anzahl der Wettkampftage Ÿberschritten wird, wird eine CompException geworfen.
	 * @param day Der Tag, der zum Wettkampf hinzugefŸgt wird.
	 * @throws Exception
	 */
	@Override
	public void setNextDay(Day day) throws CompException
	{
		comp.add(day);

		today = comp.size();

		if(today>duration)
		{
			throw new CompException("Wettkampf bereits beendet!!!");
		}
	}

	/**
	 * Gibt den Durchschnitt der Sonnenprozente im abgefragen Zeitraum an.
	 * @param days Anzahl der Tage von heute zurŸck bis zum Tag x 
	 */
	@Override
	public double getAvgSun(int days) {
		// TODO Auto-generated method stub
		int average=0;

		for(int i = comp.size()-duration; i>=comp.size();i++)
		{
			average+=comp.get(i).getPerSun();
		}

		return (int) (average/days);
	}

	/**
	 * Gibt den Durchschnitt der Wasserprozente im abgefragen Zeitraum an.
	 * @param days Anzahl der Tage von heute zurŸck bis zum Tag x 
	 */
	@Override
	public double getAvgRain(int days) {
		// TODO Auto-generated method stub
		int average=0;

		for(int i = comp.size()-duration; i>=comp.size();i++)
		{
			average+=comp.get(i).getPerRain();
		}

		return (int) (average/days);
	}
	
	public int getDuration()
	{
		return duration;
	}
}
