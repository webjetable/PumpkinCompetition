public interface IntCompetition {

	public void setNextDay( Day day ) throws CompException;
	public double getAvgSun( int days ) throws CompException;
	public double getAvgRain( int days ) throws CompException;
}
