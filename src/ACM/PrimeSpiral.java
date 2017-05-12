package ACM;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeSpiral {
	public static final int dimension = 101;
	static int[] x_coor = new int[dimension*dimension+1];
	static int[] y_coor = new int[dimension*dimension+1];
	static boolean[] is_prime = new boolean[dimension*dimension+1];
	static int[][] spiral_matrix = new int[dimension][dimension];
	static boolean[] visited = new boolean[dimension * dimension + 1];

	public static void main(String[] args){
		for(int _i = 2; _i < is_prime.length; _i++){
			is_prime[_i] = true;
		}
		spiral_matrix[dimension/2][dimension/2] = 1;
		x_coor[1] = dimension/2;
		y_coor[1] = (dimension-1)/2;
		int k = 1;
		int i = 1;
		int j = 0;
		char d = 'E';
		boolean flag = false;
		while(i < dimension*dimension){
			if (k != Math.sqrt(i)){
				while(j < k-1){
					i++;
					proceed(x_coor,y_coor,d,i);
					j++;
				}
				if(j == k-1){
					j = 0;
					if(k != Math.sqrt(i)){
						if(d == 'N')
							d = 'W';
						else if(d == 'W')
							d = 'S';
						else if(d == 'S')
							d = 'E';
						else if(d == 'E')
							d = 'N';
					
					}
				}
			} else{
				i++;
				proceed(x_coor,y_coor,d,i);
				if(d == 'N')
					d = 'W';
				else if(d == 'W')
					d = 'S';
				else if(d == 'S')
					d = 'E';
				else if(d == 'E')
					d = 'N';
				k++;
			}
				
		}
		for(int _i = 1; _i <= dimension*dimension; _i++ ){
			//System.out.println("x : " + x_coor[_i] + " y: " + y_coor[_i]);
			spiral_matrix[x_coor[_i]][y_coor[_i]] = _i;
		}
		/*for(int _i = 0; _i <dimension;_i++)
		{
			for(int _j = 0; _j <dimension; _j++)
				System.out.print(spiral_matrix[_i][_j] + " ");
			System.out.println();
		}*/

		//prime array
		int _i = 2;
		while(_i < is_prime.length){

			if(is_prime[_i]){
				int _j = 2*_i;
				while(_j < is_prime.length){
					is_prime[_j] = false;
					_j += _i;
				}
			}
			_i++;
		}
		List<Integer> res = new ArrayList<Integer>();
		//File f = new File("C:\\Users\\Vu Anh Vinh\\workspace\\FirstProject\\src\\ACM\\PrimeSpiral.txt");
		try{
			Scanner in = new Scanner(System.in);
			while(in.hasNext()){
				//in.nextLine();
				int x = in.nextInt();
				int y = in.nextInt();
				//in.nextLine();
				//System.out.println(x + " " + y);
				res.add(bfs(x,y));
				for(int c = 0; c < visited.length;c++)
					visited[c] = false;
			}
		} catch (Exception e){
			e.printStackTrace();
		}


		//in.useDelimiter(System.getProperty("line.separator"));


		for(int c = 0; c < res.size();c++){
			if(res.get(c) != -1){
				System.out.println(String.format("Case %d: %d", c+1,res.get(c)));
			} else
				System.out.println(String.format("Case %d: impossible", c+1));
		}


	}

	public static int bfs(int x,int y){
		int[] dis = new int[dimension * dimension + 1];
		if(x == y)
			return dis[x];
		List<Integer> queue = new ArrayList<Integer>();
		queue.add(x);
		visited[x] = true;
		while(!queue.isEmpty()){
			int cur = queue.remove(0);
			for(int nei: adjacentList(cur)){
				if(!visited[nei]) {
					visited[nei] = true;
					queue.add(nei);
					dis[nei] = dis[cur] + 1;
					if (nei == y)
						return dis[nei];
				}
			}
		}
		return -1;
	}

	public static List<Integer> adjacentList(int n){
		List<Integer> adj = new ArrayList<Integer>();
		int x = x_coor[n];
		int y = y_coor[n];
		if(x > 0 && !is_prime[spiral_matrix[x-1][y]])
			adj.add(spiral_matrix[x-1][y]);
		if(y > 0 && !is_prime[spiral_matrix[x][y-1]])
			adj.add(spiral_matrix[x][y-1]);
		if(y < dimension - 1 && !is_prime[spiral_matrix[x][y+1]])
			adj.add(spiral_matrix[x][y+1]);
		if(x < dimension - 1 && !is_prime[spiral_matrix[x+1][y]])
			adj.add(spiral_matrix[x+1][y]);
		return adj;

	}
	public static void proceed(int[] x_coor,int[] y_coor,char d,int i){
		int a,b=0;
		if(d == 'E'){
			x_coor[i] = x_coor[i-1];
			y_coor[i] = y_coor[i-1] + 1;
		} else if( d == 'N'){
			x_coor[i] = x_coor[i-1] - 1;
			y_coor[i] = y_coor[i-1];
		} else if(d == 'S'){
			x_coor[i] = x_coor[i-1] + 1;
			y_coor[i] = y_coor[i-1];
		} else if(d == 'W'){
			x_coor[i] = x_coor[i-1];
			y_coor[i] = y_coor[i-1] -1;
		}
		a = x_coor[i];
		b = y_coor[i];
	}
	
	
}
