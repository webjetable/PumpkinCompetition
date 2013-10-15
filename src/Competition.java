import java.util.ArrayList;

public class Competition implements IntCompetition{

	/**
	 * @author Angelika
	 */
	private ArrayList<Day> comp;
	private int duration;
	private int today;

	/**
	 * creates a new competetion, 
	 * defines the amount of days in a competition
	 * @param duration amount of days the competition should last
	 */
	public Competition(int duration)
	{
		comp = new ArrayList<Day>();
		this.duration = duration;
	}

	/**
	 * inserts a new day to the competition, 
	 * counts which day, today is.
	 * @param day The day which will be inserted
	 * @throws CompException If the limit of Days is reached a CompException will be thrown.
	 */
	@Override
	public void setNextDay(Day day) throws CompException
	{
		comp.add(day);

		today = comp.size();

		if(today>duration)
		{
			throw new CompException("Competition is over!");
		}
	}

	/**
	 * Returns the average of percent of sun in the questioned amount of time.
	 * @param days Amount of days from "today" to compute the average
	 * @throws CompException if the Competition lasts not long enough to get the Average
	 */
	@Override
	public double getAvgSun(int days) throws CompException
	{
		int sum = 0;
		
		if( days>comp.size() )
			throw new CompException("Not enough Data!");

		for(int i = 1; i<=days; i++)
			sum += comp.get(comp.size()-i).getPerSun();
			
		return sum/days;
	}

	/**
	 * Returns the average of percent of rain in the questioned amount of time.
	 * @param days Amount of days from "today" to compute the average
	 * @throws CompException if the Competition lasts not long enough to get the Average
	 */
	@Override
	public double getAvgRain(int days) throws CompException
	{
		int sum = 0;
		
		if( days>comp.size() )
			throw new CompException("Not enough Data!");

		for(int i = 1; i<=days; i++)
			sum += comp.get(comp.size()-i).getPerRain();
			
		return sum/days;
	}
	
	public int getDuration()
	{
		return duration;
	}
	
}
