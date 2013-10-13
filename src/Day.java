
public class Day implements IntDay{

	/**
	 * @author Angelika
	 */
	public static int dayCompetition;

	//gibt an, der wievielte Wettkampftag dieser Tag ist.
	private final int dayID;

	private int percSun;
	private int percWater;

	/**
	 * Konstruktor
	 * @param percentWater Gibt an, wieviel Prozent Wasser gegeben wurden
	 */
	public Day(int percentWater)
	{
		this.percSun = 100-percentWater;
		this.percWater = percentWater;
		Day.dayCompetition += 1;
		dayID = dayCompetition;
	}


	/**
	 * gibt an, wieviel Prozent Sonne an diesem Tag sind.
	 */
	@Override
	public int getPerSun() {
		// TODO Auto-generated method stub
		return percSun;
	}

	/**
	 * gibt an, wieviel Prozent Wasser an diesem Tag sind.
	 */
	@Override
	public int getPerRain() {
		// TODO Auto-generated method stub
		return percWater;
	}

	/**
	 * gibt true zurück, wenn 100 % Sonne an diesem Tag sind.
	 */
	@Override
	public boolean isSunny()
	{
		return (percSun == 100) ? true:false;

	}

	/**
	 * gibt true zurück, wenn 100 % Wasser an diesem Tag sind.
	 */
	@Override
	public boolean isRainy() {
		// TODO Auto-generated method stub
		return (percWater == 100) ? true:false;
	}

	/**
	 * Gibt zurück, der wievielte Wettkampftag dieser Tag ist.
	 */
	@Override
	public int getDayID() {
		return dayID;
	}


}
