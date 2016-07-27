/*  
    Integrator.java
    Simple Riemman Sum program for AP Calculus
    Andrew Duncan
    12/2013
 
	This program is a self-contained integrator that uses the "Trapazoidal Rule" to help approximate
	the definite integral. This is a single class program in order to keep the compsci simple and
	focus on the mathematics and application of the program.
*/

import java.util.Scanner;


public class IntegratorCLI{
    public static void main(String[] args){
        double a=0;   // lower endpoint of interval
        double b=0;   // upper endpoint of interval
        int N=0;      // number of divisions
        String trash = "empty"; // unwanted input
        Scanner scan = new Scanner(System.in);
       
        
        // Ask for a lower bound and respond if not a number.
        System.out.println("Enter a lower bound for the integral: ");
        while(!scan.hasNextDouble() && !scan.hasNextInt()){
            trash = scan.next();
            if(trash != "empty"){System.out.println(trash + " is not a number, punk.");}
        }
        if(scan.hasNextDouble()){a = scan.nextDouble();}            //if double
        else{
			if(scan.hasNextInt()){a = (double)scan.nextInt();}}          //if int
        trash = "empty";
        
        
        
        
        // Ask for an upper bound and respond if not a number
        System.out.println("Enter an upper bound for the integral: ");
        while(!scan.hasNextDouble() && !scan.hasNextInt()){
            trash = scan.next();
            if(trash != "empty"){System.out.println(trash + " is not a number! Cut it out.");}
        }
        if(scan.hasNextDouble()){b = scan.nextDouble();}            //if double
		else{
			if(scan.hasNextInt()){b = (double)scan.nextInt();}}          //if int
        trash = "empty";
        
        
        
        System.out.println("Enter a number of partitions: ");
        while(!scan.hasNextInt()){
            trash = scan.next();
            if(trash != "empty"){System.out.println(trash + " does not make sense. Please choose a positive integer.");}
        }
        if(scan.hasNextInt()){N = scan.nextInt();}
        trash = "empty";
        
		double area = Trapazoid(a,b,N);
		System.out.println(area);
    }
	
	
	
	
	// Trapazoid Method calculates the Trapazoidal estimate for the integral from a to b
	public static double Trapazoid(double a, double b, int n){
		double deltaX = (b-a)/n;
		double sum = 0;
		for(int i=0; i<n;i++){
			sum += Func(a+deltaX*i)+Func(a+deltaX*(i+1));
		}
		sum = sum*(deltaX/2);
		return sum;
	}
	
	
	// Simpson Method calculates an estimate for the integra from a to b using Simpson's rule
	public static double Simpson(double a, double b, int n){
		double deltaX = (b-a)/n;
		double sum = 0;
		for(int i=0; i<n;i++){
			sum += Func(a+deltaX*i)+4*Func(a+deltaX*2*(i+1))+Func(a+deltaX*(2*(i+1)+1));
		}
		sum = sum*(deltaX/3);
		return sum;
		
	}
	
	
	
	
	// Func is the definition of the function to be integrated
	private static double Func(double x){
		double ans;
		ans = x*x+2*x+3;
		return ans;
	}

}