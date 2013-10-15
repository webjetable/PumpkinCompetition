public class Day implements IntDay{

	/**
	 * @author Angelika
	 */

	private int percSun;
	private int percWater;

	/**
	 * Default constructor
	 * if no information about the day is given there is no sun nor rain.
	 */
	public Day()
	{
		this.percSun 	= 0;
		this.percWater 	= 0;
	}

	/**
	 * Constructor
	 * @param percentWater tells the percentage of water given
	 */
	public Day(int percentWater)
	{
		this.percSun 	= 100-percentWater;
		this.percWater 	= percentWater;
	}


	/**
	 * returns the percentage of sun on this day.
	 */
	@Override
	public int getPerSun()
	{
		return percSun;
	}

	/**
	 * returns the percentage of rain on this day.
	 */
	@Override
	public int getPerRain()
	{
		return percWater;
	}

	/**
	 * returns true if the percentage of sun is 100%
	 */
	@Override
	public boolean isSunny()
	{
		return percSun == 100 ? true:false;

	}

	/**
	 * returns true if the percentage of rain is 100%
	 */
	@Override
	public boolean isRainy()
	{
		return percWater == 100 ? true:false;
	}

}
