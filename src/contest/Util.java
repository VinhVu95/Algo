package contest;

import java.util.Scanner;

public class Util {
	public static void primeFactors(int n)
    {
        // Print the number of 2s that divide n
        while (n%2==0)
        {
            System.out.print(2 + " ");
            n /= 2;
        }
 
        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            // While i divides n, print i and divide n
            while (n%i == 0)
            {
                System.out.print(i + " ");
                n /= i;
            }
        }
 
        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if (n > 2)
            System.out.print(n);
    }
	
	static int gcd(int a, int b)
	{
	  while(a!=0 && b!=0) // until either one of them is 0
	  {
	     int c = b;
	     b = a%b;
	     a = c;
	  }
	  return a+b; // either one is 0, so return the non-zero value
	}
	
	static void primeSieve(int n){
		boolean[] isPrime = new boolean[n+1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        // mark non-primes <= n using Sieve of Eratosthenes
        for (int factor = 2; factor*factor <= n; factor++) {

            // if factor is prime, then mark multiples of factor as nonprime
            // suffices to consider mutiples factor, factor+1, ...,  n/factor
            if (isPrime[factor]) {
                for (int j = factor; factor*j <= n; j++) {
                    isPrime[factor*j] = false;
                }
            }
        }

        // count primes
        int primes = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) primes++;
        }
        System.out.println(primes);
	}
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		long n = scan.nextLong();
		primeSieve((int) n);
	}
}
