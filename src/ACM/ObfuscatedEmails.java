	package ACM;
	
	import java.util.Scanner;
	
	public class ObfuscatedEmails {
		public static void main(String[] args){
			Scanner scan = new Scanner(System.in);
			int n = scan.nextInt();
			String[] res = new String[n];
			for(int i = 0; i< n;i++){

				String email = scan.next();
				res[i] = obfuscatedEmail(email);
			}
			for(String result: res){
				System.out.println(result);
			}
		}
		
		/*static String ReadLn (int maxLg){
			byte lin[] = new byte[maxLg];
			int lg = 0;
			String n = "";
			String line = "";
			
			try{
				while(lg < maxLg)
				{
					n = System.in.read();
					if((n < 0) || (n == '\n')) break;
					lin[lg++] += n;  
				}
			}
			
		}*/
		
		static String obfuscatedEmail(String email){
			char[] e = email.toCharArray();
			int mark = email.indexOf("@");
			for(int i = 1; i < mark - 1;i++){
				e[i] = '*';
			}
			return new String(e);
		}
	}
