package Question4;

public class PowersOfTwo {
	public static void main(String[] args) {
		// last power of two to print
		int N = Integer.parseInt(args[0]); 
		int i = 0; // loop control counter 
		int v = 1; // current power of two 
		for (i = 0; i <= N; i++) {
			System.out.println(i + " " + v); 
			v = 2 * v;
		} 
	}
}