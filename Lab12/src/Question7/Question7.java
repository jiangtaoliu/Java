package Question7;

public class Question7 {

	public static void main(String[] args) {
		double[] x = { 0.3, 0.6, 0.1 }; 
		double[] y = { 0.5, 0.1, 0.4 }; 
		int N = x.length;
		double sum = 0.0;
		for (int i=0; i<N; i++)
		{ 
			sum = sum + x[i]*y[i];
			System.out.println("i is " + i +" and sum is " + sum);
		}
	}
}
