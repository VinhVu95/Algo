package codeforce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;

public class Div2R390C {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		int t = scan.nextInt();
		outer: for(int i = 0; i < t ;i++){
			int n = scan.nextInt();
			scan.nextLine();
			String input_names = scan.nextLine();
			String[] names = input_names.split("\\s+");
			Set<String> userNames = new HashSet<String>(Arrays.asList(names));
			int m = scan.nextInt();
			List<ArrayList<String>> possibleSenders = new ArrayList<ArrayList<String>>();
			scan.nextLine();
			String[] mess = new String[m];
			for(int j = 0; j < m; j++){
				ArrayList<String> chatSenders = new ArrayList<String>();
				String message = scan.nextLine();
				String[] senderAndMess = message.split(":");
				mess[j] = senderAndMess[1];
				if(!senderAndMess[0].equals("?")){
					chatSenders.add(senderAndMess[0]);
				} else {
					String[] tokens = senderAndMess[1].split("[\\s,.?!]+");
					Set<String> exclude = new HashSet<String>();
					for(String to: tokens){
						if(userNames.contains(to)){
							exclude.add(to);
						}
					}
					for(String na: userNames){
						if(!exclude.contains(na))
							chatSenders.add(na);
					}
				}
				possibleSenders.add(chatSenders);
			}
			
			String[] senders = new String[m+1];
			senders[0] = "AAAAAAAAAAAAAAAAAAAAAAA";
			Set<String> mem = new HashSet<String>();
			int chat = 1;
			boolean flag;
			while(chat <= m && chat > 0){
				flag = false;
				for(String sender: possibleSenders.get(chat-1)){
					if(!senders[chat-1].equals(sender) && !mem.contains(sender + String.valueOf(chat)))
						{
							senders[chat] = sender;
							mem.add(sender + String.valueOf(chat++));
							flag = true;
							break;
						}
				}
				if(!flag)
					chat--;
			}
			for(int j = 1; j <= m; j++){
				if(senders[j] == null){
					System.out.println("Impossible");
					continue outer;
				}
			}
			for(int j = 1; j <= m ; j++){
				System.out.println(senders[j] + ":" + mess[j-1]);
			}
		}
	}
}
