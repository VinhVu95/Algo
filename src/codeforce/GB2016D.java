package codeforce;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class GB2016D {
	public static int n;
	static int[][] plane = new int[150][150];
	static int t[];
	static int visited_cells;
	static int[] dir = {1, 2, 3, 4, 5, 6, 7, 8};
	static int[] x_coor = {0,-1,0,1,1,1,0,-1,-1};
	static int[] y_coor = {0,1,1,1,0,-1,-1,-1, 0};
	static HashSet<State> set = new HashSet<State>();
	
	public static void main(String[] args){
		Scanner scan = new Scanner(System.in);
		n = scan.nextInt();
		t = new int[n+1];
		for(int i = 1; i <= n; i++){
			t[i] = scan.nextInt();
		}
		State start = new State(1, 0, -1, 2);
		//firework(1, start, 2);
		List<State> list_state = new ArrayList<State>();
		list_state.add(start);
		for(int i = 1; i <= n; i++){
			List<State> next = new ArrayList<State>();
			for(State s: list_state){
				for(int j = 0; j < t[i]; j++){
					s = proceed(s,s.dir);
					if(!set.contains(s)){
						set.add(s);
						visited_cells++;
					}
				}
				int leftDir = s.dir == 1? 8: (s.dir - 1);
				int rightDir = s.dir == 8? 1: (s.dir + 1);
				next.add(new State(s.level + 1, s.x + x_coor[leftDir], s.y + y_coor[leftDir], leftDir ));
				next.add(new State(s.level + 1, s.x + x_coor[rightDir], s.y + y_coor[rightDir], rightDir));
			}
			list_state = next;
		}
		System.out.println(visited_cells);	
	}
	
	public static void firework(int level, State state, int direction){
		if(level > n)
			return;	
		for(int i = 0; i <t[level]; i++){
			state = proceed(state, direction);
			//if state appear before, not add to answer, otherwise add to Set
			if(!set.contains(state)){
				set.add(state);
				visited_cells++;
			}
		}
		//Change direction to 45 degree
		int leftDir = direction == 1? 8: (direction - 1);
		int rightDir = direction == 8? 1: (direction + 1);
		firework(level+1, state, leftDir);
		firework(level+1, state, rightDir);
	}
	
	public static State proceed(State state, int direction){		
		return new State(state.level, state.x + x_coor[direction], state.y + y_coor[direction], state.dir);
			
	}
	
	public static class State{
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + level;
			result = prime * result + x;
			result = prime * result + y;
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			State other = (State) obj;
			if (level != other.level)
				return false;
			if (x != other.x)
				return false;
			if (y != other.y)
				return false;
			return true;
		}
		int level;
		int x;
		int y;
		int dir;
		public State(int level, int x, int y, int dir){
			this.level = level;
			this.x = x;
			this.y = y;
			this.dir = dir;
		}
		public State() {
			// TODO Auto-generated constructor stub
		}
	}
}
