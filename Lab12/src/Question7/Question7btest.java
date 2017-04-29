package Question7;

public class Question7btest {

	public static void main(String[] args) {
		
		int N = Integer.parseInt(args[0]);
		
		double [][] a = new double[N][N];
		double [][] b = new double[N][N];
		double [][] c = new double[N][N];
		
		for (int i=0; i<N; i++)
		{
			for (int t=0; t<N; t++)
			{
				double r = Math.random();
				a[i][t] = r;
				double s = Math.random();
				b[i][t] = s;
				System.out.println("i is " + i + " t is " + t + " and a is " + a[i][t]+ " and b is " + b[i][t]);
			}
		}
		
		Question7b q7 = new Question7b();
		q7.sum2Vectors(N, a, b, c);
		
		System.out.println("==================================================");
		for (int i=0; i<N; i++)
		{
			for (int t=0; t<N; t++)
			{
				System.out.println("i is " + i + " t is " + t + " and sum is " + c[i][t]);
			}
		}
	}
}
