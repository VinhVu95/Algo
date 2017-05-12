package ACM;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class BusySchedule {
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		scan.useDelimiter(System.getProperty("line.separator"));
		List<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
		while(true){
			int N = scan.nextInt();
			ArrayList<String> schedule = new ArrayList<String>();
			if(N == 0)
				break;
			TimeSlot[] slots = new TimeSlot[N];
			for(int i = 0; i < N; i++)
			{
				String input = scan.next();
				TimeSlot slot = new TimeSlot(input);
				slots[i] = slot;
			}
			
			Arrays.sort(slots);
			for(int i = 0; i < N;i++)
				schedule.add(slots[i].input);
			res.add(schedule);
		}
		
		for(int i = 0; i < res.size();i++)
		{
			for(String slot: res.get(i)){
				System.out.println(slot);
			}
			System.out.println();
		}
		
		
	}
	
	public static class TimeSlot implements Comparable<TimeSlot>{
		String input;
		int minFromStart;
		
		public TimeSlot(String input){
			this.input = input;
			String[] data = input.split("[\\s:]+");
			
			int hour = Integer.parseInt(data[0]);
			int minute = Integer.parseInt(data[1]);
			this.minFromStart = hour*60 + minute;
			if(hour == 12 && data[2].equals("a.m.")){
				
				this.minFromStart = minute;
			} else if (hour == 12 && data[2].equals("p.m.")){
				this.minFromStart = 720 + minute;
			}else if(data[2].equals("p.m.")){
				this.minFromStart += 720;
			}
			//System.out.println(input + " " + minFromStart);
		}
		
		@Override
		public int compareTo(TimeSlot o) {
			
			int compareQuatity = ((TimeSlot) o).minFromStart;
			// TODO Auto-generated method stub
			return this.minFromStart - compareQuatity;
		}
		
		
	}
	
	
}
