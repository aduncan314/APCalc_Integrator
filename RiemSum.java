/*  This calculates the Riemann Sum given the information from IntegratorCLI.java
 
    Andrew Duncan
    For AP Calculus
    12/2013

*/

public class RiemSum{
	public double Trapazoid(double a, double b, int n){
		Func F = new Func();
		double deltaX = (b-a)/n;
		double sum = 0;
		for(int i=0; i<n;i++){
			sum += F(a+deltaX*i)+F(a+deltaX*(i+1));
		}
		sum = sum*(deltaX/2);
	}

	private double Func(double x){
		double ans;
		ans = x*x+2*x+3;
		return ans;
	}
}