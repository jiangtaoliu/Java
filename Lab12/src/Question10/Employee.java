package Question10;

public abstract class Employee {
	private String name;
	
    public abstract int salary(int hra, int da, int extra);

    public String getName(int id)
    {
    	return this.name;
    }
}
