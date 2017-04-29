package Question5and6;

public class TestCubes {

	public static void main(String[] args) { 
		
		Cubes cb = new Cubes();
		
		int N = Integer.parseInt(args[0]); 
		for (int i = 1; i <= N; i++)
			System.out.println(i + " " + cb.cube(i));
	}

}
