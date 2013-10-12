import java.util.ArrayList;

public class Competition implements IntCompetition{

	private ArrayList<Day> comp;
	private int days;
	private int today;

	public Competition(int days)
	{
		comp = new ArrayList<Day>();
		this.days = days;
	}

	public void setNextDay(Day day) throws Exception
	{
		comp.add(day);

		today = comp.size();

		if(today>days)
		{
			throw new CompException("Wettkampf bereits beendet!!!");
		}
	}

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
