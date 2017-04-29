package Question10;

public class Permanenter implements EmployeeType {

	private String gender;
	
	@Override
	public String typeOfEmployee() {
		return "permanent";
	}

	public String getGender(int id) 
	{
		return this.gender;
	}
}
