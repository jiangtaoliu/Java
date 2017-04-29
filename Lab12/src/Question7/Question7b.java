package Question7;
/*
 * in: n, x, y
 * out: z
 */
public class Question7b {

	public void sum2Vectors(int n, double[][] x, double[][] y, double[][] z) {
		
		for (int i=0; i<n; i++)
		{
			for (int t=0; t<n; t++)
			{
				z[i][t] = x[i][t] + y[i][t];
				//System.out.println("i is " + i + " t is " + t + " and sum is " + z[i][t]);
			}
		}
	}

}
