public class Day implements IntDay{

	/**
	 * @author Angelika
	 */

	private int percSun;
	private int percWater;

	/**
	 * Defaultkonstruktor
	 * falls keine Angaben zum Tag gemacht werden gibt es weder Regen noch Sonne
	 */
	public Day()
	{
		this.percSun 	= 0;
		this.percWater 	= 0;
	}

	/**
	 * Konstruktor
	 * @param percentWater Gibt an, wieviel Prozent Wasser gegeben wurden
	 */
	public Day(int percentWater)
	{
		this.percSun 	= 100-percentWater;
		this.percWater 	= percentWater;
	}


	/**
	 * gibt an, wieviel Prozent Sonne an diesem Tag sind.
	 */
	@Override
	public int getPerSun()
	{
		return percSun;
	}

	/**
	 * gibt an, wieviel Prozent Wasser an diesem Tag sind.
	 */
	@Override
	public int getPerRain()
	{
		return percWater;
	}

	/**
	 * gibt true zur�ck, wenn 100 % Sonne an diesem Tag sind.
	 */
	@Override
	public boolean isSunny()
	{
		return percSun == 100 ? true:false;

	}

	/**
	 * gibt true zur�ck, wenn 100 % Wasser an diesem Tag sind.
	 */
	@Override
	public boolean isRainy()
	{
		return percWater == 100 ? true:false;
	}

}
