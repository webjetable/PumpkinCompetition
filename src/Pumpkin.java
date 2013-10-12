
public class Pumpkin implements Growable {
	
	//Gewicht des KŸrbisses
	double weight;
	//Alter in Tagen
	int age;
	
	public Pumpkin()
	{
		this.weight = 1;
		this.age = 0;
	}
	
	//Wachstum
	//public void grow(int percent)
	{
		
	}
	
	//Schrumpfung
	public void shrink()
	{
		//grow(-1);
	}

	@Override
	public void grow(Day d) {
		// TODO Auto-generated method stub
		weight += weight*growRate(d.getPerSun())/100;
	}
	
	private double growRate(double percent)
	{
		return percent*5/100;
	}

	@Override
	public double getWeight() {
		// TODO Auto-generated method stub
		return weight;
	}

	public int getAge() {
		// TODO Auto-generated method stub
		return age;
	}

}
