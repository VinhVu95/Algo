
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class MapTitles{
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		List<String> results = new ArrayList<String>();
		
		while(scan.hasNextLine()){
			Scanner ss = new Scanner(scan.nextLine());
			
			if(!ss.hasNext())
				break;
			
			while(ss.hasNext()){
				results.add(position(ss.next()));
			}
		}
		
		
		/*while(true){
			String quadkey = scan.next();
			if(quadkey.equals("\n"))
				break;
			results.add(position(quadkey));
		}
		scan.close();*/
		for(String s: results)
			System.out.println(s);
		}

	public static String position(String quadkey){
		char[] ch = quadkey.toCharArray();
		int[] arr = new int[ch.length];
		for(int i = 0; i < ch.length; i++)
		{
			arr[i] = Integer.parseInt(quadkey.substring(i,i+1));
			//System.out.println(arr[i]);
		}
		
		int[] res = new int[3];
		res[0] = arr.length;
		//char[] ch = s.toCharArray();
		for(int i = 0;i<arr.length;i++){
			int c = arr[i];
			
			if(c == 0){
				res[1] = 2*res[1] + 0; 
				res[2] = 2*res[2] + 0;
//				prev_1 = 0;
//				prev_2 = 0;
			} else if (c == 1){
				res[1] = 2*res[1] + 1;
				res[2] = 2*res[2] + 0;
				//prev_1 ++;
			
			} else if (c == 2){
				res[1] = 2*res[1] + 0;
				res[2] = 2*res[2] + 1;
				
				//prev_2 ++;
			} else if (c == 3) {
				res[1] = 2*res[1] + 1;
				res[2] = 2*res[2] + 1;
			}
			//System.out.println(res[1] + " " + res[2] + " prev_1 :" + prev_1 + " prev_2 :" + prev_2);
				
		}
		StringBuffer sb = new StringBuffer();
		sb.append(res[0]+ " ").append(res[1] + " ").append(res[2]);
		return sb.toString();
	} 
}