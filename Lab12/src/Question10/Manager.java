package Question10;

public class Manager extends Employee {

	public int salary(int hra, int da, int extra)
	{
		int total;
		total = hra + da*2 + extra;
		return total;
	}
}
