
public class Day implements IntDay{

	//public static int sunnyDays;
	//public static int rainyDays;
	public static int dayCompetition;

	private int percSun;
	private int percWater;

	public Day(int percentWater)
	{
		this.percSun = 100-percentWater;
		this.percWater = percentWater;
		Day.dayCompetition += 1;
	}

	@Override
	public int getPerSun() {
		// TODO Auto-generated method stub
		return percSun;
		}

	@Override
	public int getPerRain() {
		// TODO Auto-generated method stub
		return percWater;
	}
	
	@Override
	public boolean isSunny()
	{
		return (percSun == 100) ? true:false;

	}

	@Override
	public boolean isRainy() {
		// TODO Auto-generated method stub
		return (percWater == 100) ? true:false;
	}


}
