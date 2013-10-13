import java.util.ArrayList;

public class Competition implements IntCompetition{

	/**
	 * @author Angelika
	 */
	private ArrayList<Day> comp;
	private int days;
	private int today;

	/**
	 * legt einen neuen Wettkampf an, 
	 * legt die Anzahl der Tage des Wettkampfes fest
	 * @param days Anzahl der Tage, die der Wettkampf dauern soll
	 */
	public Competition(int days)
	{
		comp = new ArrayList<Day>();
		this.days = days;
	}

	/**
	 * fügt einen neuen Tag in den Wettkampf ein, 
	 * zählt, der wievielte Tag heute ist
	 * wenn die Anzahl der Wettkampftage überschritten wird, wird eine CompException geworfen.
	 * @param day Der Tag, der zum Wettkampf hinzugefügt wird.
	 * @throws Exception
	 */
	@Override
	public void setNextDay(Day day) throws CompException
	{
		comp.add(day);

		today = comp.size();

		if(today>days)
		{
			throw new CompException("Wettkampf bereits beendet!!!");
		}
	}

	/**
	 * Gibt den Durchschnitt der Sonnenprozente im abgefragen Zeitraum an.
	 * @param days Anzahl der Tage von heute zurück bis zum Tag x 
	 */
	@Override
	public double getAvgSun(int days) {
		// TODO Auto-generated method stub
		int average=0;

		for(int i = comp.size()-days; i<=comp.size();i++)
		{
			average+=comp.get(i).getPerSun();
		}

		return (int) (average/days);
	}

	/**
	 * Gibt den Durchschnitt der Wasserprozente im abgefragen Zeitraum an.
	 * @param days Anzahl der Tage von heute zurück bis zum Tag x 
	 */
	@Override
	public double getAvgRain(int days) {
		// TODO Auto-generated method stub
		int average=0;

		for(int i = comp.size()-days; i<=comp.size();i++)
		{
			average+=comp.get(i).getPerRain();
		}

		return (int) (average/days);
	}
}
