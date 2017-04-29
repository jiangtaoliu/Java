package Question10;

public class Contractor implements EmployeeType, Gender {

	private String gender;
	
	@Override
	public String typeOfEmployee() {
		return "contractor";
	}
	
	public String getGender(int id) 
	{
		return this.gender;
	}

}
