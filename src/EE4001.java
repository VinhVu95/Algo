import java.util.Scanner;


public class EE4001 {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		while(true){
			double x = scan.nextDouble();
			double y = scan.nextDouble();
			double z = scan.nextDouble();
			System.out.println(assignment1(x, y, z));
			scan.nextLine();
		}
		
	}
	
	public static double assignment1(double x,double y,double z){
		if(x >= 50 && y >= 50 && z >= 50)
			return 0.2*x + 0.4*y + 0.4*z;
		else
			return 0.2*x + 0.3*y + 0.5*z;
	}
}
