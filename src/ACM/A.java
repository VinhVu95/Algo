package ACM;
import java.util.Scanner;

public class A {
	public static void main(String[] args){
		Scanner s = new Scanner (System.in);
		int T = s.nextInt();
		s.nextLine();
		for (int i = 0; i < T; i++) {
			Point A1 = new Point (s.nextInt(), s.nextInt(), s.nextInt());
			Point B1 = new Point (s.nextInt(), s.nextInt(), s.nextInt());
			Point C1 = new Point (s.nextInt(), s.nextInt(), s.nextInt());
			s.nextLine();
			Point A2 = new Point (s.nextInt(), s.nextInt(), s.nextInt());
			Point B2 = new Point (s.nextInt(), s.nextInt(), s.nextInt());
			Point C2 = new Point (s.nextInt(), s.nextInt(), s.nextInt());
			s.nextLine();
			double[] plane = planeEquation(A1, B1, C1);
			
			Point X1 = pointIntersection (A2, B2, plane);
			Point X2 = pointIntersection (A2, C2, plane);
			Point X3 = pointIntersection (B2, C2, plane);
			
			int ins1 = 0;
			int ins2 = 0;
			int ins3 = 0;
			if (X1 != null) {
				if (checkInsideTriangle(X1, A1, B1, C1)) {
					ins1 = 1;
				}
			}
			
			if (X2 != null) {
				if (checkInsideTriangle(X2, A1, B1, C1)) {
					ins2 = 1;
				}
			}
			
			if (X3 != null) {
				if (checkInsideTriangle(X3, A1, B1, C1)) {
					ins3 = 1;
				}
			}
			
			if ( (ins1 + ins2 + ins3) == 1) {
				System.out.println("YES");
				continue;
			}
			
			if (ins1 == 1 & ins2 == 1) {
				if (equalDouble(X1.x, X2.x) & equalDouble(X1.y, X2.y) & equalDouble(X1.z, X2.z)) {
					
					if (equalDouble(X1.x, A1.x) & equalDouble(X1.y, A1.y) & equalDouble(X1.z, A1.z)) {
						System.out.println("NO");
						continue;
					}
					
					if (equalDouble(X1.x, B1.x) & equalDouble(X1.y, B1.y) & equalDouble(X1.z, B1.z)) {
						System.out.println("NO");
						continue;
					}
					
					if (equalDouble(X1.x, C1.x) & equalDouble(X1.y, C1.y) & equalDouble(X1.z, C1.z)) {
						System.out.println("NO");
						continue;
					}
					
					if (ins3 == 1) {
						System.out.println("NO");
						continue;
					}
					
					if (sameSide(B2, C2, plane)) {
						System.out.println("NO");
						continue;
					} else {
						System.out.println("YES");
						continue;
					}
				}
			}
			
			if (ins1 == 1 & ins3 == 1) {
				if (equalDouble(X1.x, X3.x) & equalDouble(X1.y, X3.y) & equalDouble(X1.z, X3.z)) {
					
					if (equalDouble(X1.x, A1.x) & equalDouble(X1.y, A1.y) & equalDouble(X1.z, A1.z)) {
						System.out.println("NO");
						continue;
					}
					
					if (equalDouble(X1.x, B1.x) & equalDouble(X1.y, B1.y) & equalDouble(X1.z, B1.z)) {
						System.out.println("NO");
						continue;
					}
					
					if (equalDouble(X1.x, C1.x) & equalDouble(X1.y, C1.y) & equalDouble(X1.z, C1.z)) {
						System.out.println("NO");
						continue;
					}
					
					if (ins2 == 1) {
						System.out.println("NO");
						continue;
					}
					
					if (sameSide(A2, C2, plane)) {
						System.out.println("NO");
						continue;
					} else {
						System.out.println("YES");
						continue;
					}
				}
			}
			
			if (ins3 == 1 & ins2 == 1) {
				if (equalDouble(X3.x, X2.x) & equalDouble(X3.y, X2.y) & equalDouble(X3.z, X2.z)) {
					
					if (equalDouble(X2.x, A1.x) & equalDouble(X2.y, A1.y) & equalDouble(X2.z, A1.z)) {
						System.out.println("NO");
						continue;
					}
					
					if (equalDouble(X2.x, B1.x) & equalDouble(X2.y, B1.y) & equalDouble(X2.z, B1.z)) {
						System.out.println("NO");
						continue;
					}
					
					if (equalDouble(X2.x, C1.x) & equalDouble(X2.y, C1.y) & equalDouble(X2.z, C1.z)) {
						System.out.println("NO");
						continue;
					}
					
					if (ins1 == 1) {
						System.out.println("NO");
						continue;
					}
					
					if (sameSide(A2, B2, plane)) {
						System.out.println("NO");
						continue;
					} else {
						System.out.println("YES");
						continue;
					}
				}
			}
			System.out.println("NO");
			continue;
		}
		
	}

	public static class Point {
		public double x;
		public double y;
		public double z;
		
		public Point (double x, double y, double z) {
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	
	public static double distance (Point A, Point B) {
		double d2 = (A.x - B.x)*(A.x - B.x) + (A.y - B.y)*(A.y - B.y) + (A.z - B.z)*(A.z - B.z);
		return Math.sqrt(d2);
	}
	
	public static double area (Point A, Point B, Point C) {
		double a = distance(C,B);
		double b = distance (A,C);
		double c = distance (A,B);
		double p = (a+b+c)/2;
		double square2 = p*(p-a)*(p-b)*(p-c);
		return Math.sqrt(square2);
	}
	
	public static double[] planeEquation (Point A, Point B, Point C) {
		double[] result = new double[4];
		double k1 = B.x - A.x;
		double k2 = B.y - A.y;
		double k3 = B.z - A.z;
		
		double h1 = C.x - A.x;
		double h2 = C.y - A.y;
		double h3 = C.z - A.z;
		
		result[0] = k2*h3 - h2*k3;
		result[1] = k3*h1 - k1*h3;
		result[2] = k1*h2 - h1*k2;
		
		result[3] = -result[0]*A.x - result[1]*A.y - result[2]*A.z;
		
		return result;
	}
	
	public static Point pointIntersection(Point A1, Point A2, double[] plane) {
		double alpha =  plane[0]*(A2.x - A1.x) +  plane[1]*(A2.y - A1.y) +  plane[2]*(A2.z - A1.z);
		double beta =  plane[0]*A1.x + plane[1]*A1.y + plane[2]*A1.z;
		if (Math.abs(alpha) < 0.001) {
			return null;
		} else {
			double t = -beta/alpha;
			if ( t >= 0 & t <=1) {
				return new Point (A1.x + (A2.x - A1.x)*t, A1.y + (A2.y - A1.y)*t, A1.z + (A2.z - A1.z)*t);
			}
			else {
				return null;
			}
		}
	}
	
	public static boolean checkInsideTriangle(Point X, Point A, Point B, Point C) {
		double sumArea = area(X, A, B) + area(X, A, C) + area(X, B, C);
		double areaABC = area(A,B,C);
		if (equalDouble(sumArea, areaABC)) {
			return true;
		}
		else {
			return false;
		}
	}
	
	public static boolean equalDouble (double a, double b) {
		if (Math.abs(a-b) < 0.000001) {
			return true;
		}
		else return false;
	}
	
	public static boolean sameSide(Point X1, Point X2, double[] plane) {
		if ((plane[0]*X1.x + plane[1]*X1.y + plane[2]*X1.z + plane[3])*(plane[0]*X2.x + plane[1]*X2.y + plane[2]*X2.z + plane[3]) < 0) { 
			return false;
		}
		return true;
	}
}
