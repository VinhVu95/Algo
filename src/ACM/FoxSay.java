package ACM;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class FoxSay {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter(System.getProperty("line.separator"));
		int T = scan.nextInt();
		String[] res = new String[T];
		for(int i = 0; i< T;i++){
			String sound = scan.next();
			String[] record = sound.split(" ");

			Set<String> animalSound = new HashSet<String>();
			while(true){
				String animal = scan.next();
				if(animal.equals("what does the fox say?"))
					break;
				String[] data = animal.split("\\s+");
				//System.out.println(data[2]);
				animalSound.add(data[2]);
			}
			res[i] = foxWords(record,animalSound);
		}
		for(int i = 0; i < T; i++)
		{
			System.out.println(res[i]);
		}

	}

	public static String foxWords(String[] record,Set<String> animalSound){
		StringBuffer sb = new StringBuffer();
		for(String s: record ){
			if(animalSound.contains(s))
				continue;
			else
				sb.append(s).append(" ");
		}
		return sb.deleteCharAt(sb.length() - 1).toString();

	}
}
