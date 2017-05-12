package ACM;

import java.io.File;
import java.util.*;

/**
 * Created by Vu Anh Vinh on 8/10/2016.
 */
public class BigTruck {
    static List<HashMap<Integer,Integer>> map = new ArrayList<HashMap<Integer,Integer>>();
    //previous visited nodes
    static List<ArrayList<Integer>> prev = new ArrayList<ArrayList<Integer>>();
    //previous items
    static List<ArrayList<Integer>> prevItems = new ArrayList<ArrayList<Integer>>();
    // set of unvisited nodes
    static Set<Integer> set = new HashSet<Integer>();
    static int inf = Integer.MAX_VALUE;

    public static void main(String[] args){
        //File f = new File ("C:\\Users\\Vu Anh Vinh\\workspace\\FirstProject\\src\\ACM\\BigTruck.txt");
        try{
            Scanner in = new Scanner(System.in);
            //while(in.hasNextLine()) {
                int n = in.nextInt();
                int[] items = new int[n];
                for (int i = 0; i < n; i++) {
                    items[i] = in.nextInt();
                    map.add(new HashMap<Integer, Integer>());
                    prev.add(new ArrayList<Integer>());
                    prevItems.add(new ArrayList<Integer>());
                    set.add(i);
                }
                int m = in.nextInt();
                if(m == 0){
                	System.out.println("impossible");
                    return;
                }
                for (int i = 0; i < m; i++) {
                   int a = in.nextInt();
                    int b = in.nextInt();
                    int d = in.nextInt();
                    map.get(a - 1).put(b - 1, d);
                    map.get(b - 1).put(a - 1, d);
                }
               int[] dis = djisktra(items, n);
            //}
            /*for(ArrayList<Integer> lsPrev: prev){
                for(int p: lsPrev)
                    System.out.print(p + " ");
                System.out.println();
            }*/
            /*if(dis[n-1] == inf){
            	System.out.println("impossible");
            }*/
               if(dis[n-1] == inf){
            	   System.out.println("impossible");
            	   return;
               }
               //recursive(n-1, items)
            System.out.println(dis[n-1] + " " + (largestItems(prevItems.get(n-1)) + items[n-1]) ) ;
            
        } catch (Exception e){
            e.printStackTrace();
        }


    }

    public static int[] djisktra(int[] items,int n){
        int[] dis = new int[n];
        for(int i = 1; i< n;i++)
        {
            dis[i] = inf;
        }
        while(!set.isEmpty()){
            int smallest = smallestDistanceNode(dis);
            set.remove(smallest);
            for(int neighbor: map.get(smallest).keySet()){
                if(set.contains(neighbor) && dis[neighbor] >= dis[smallest] + map.get(smallest).get(neighbor))
                {
                    dis[neighbor] = dis[smallest] + map.get(smallest).get(neighbor);
                    prev.get(neighbor).add(smallest);
                    prevItems.get(neighbor).add(largestItems(prevItems.get(smallest)) + items[smallest]);
                }
            }
        }
        return dis;
    }

    public static int largestItems(List<Integer> list){
    	int max = 0;
    	for(Integer l: list){
    		max = Math.max(max,l);
    	}
    	return max;
    }
    
    public static int smallestDistanceNode(int[] dis){
        int smallest = inf;
        int res = 0;
        for(int i: set){
        	if(smallest >= dis[i])
            {
        		smallest = dis[i];
        		res = i;
            }
        }
        return res;
    }
    
    
    public static int recursive(int i,int[] items){
    	int max = 0;
    	if(i == 0)
    		return items[0];
    	else {
    		for(int prevNode: prev.get(i)){
    			int cur = recursive(prevNode,items);
    			if(max < cur)
    			{
    				max = cur;
    			}
    		}
    		return max + items[i];
    	}
    	
    		
    }
    


}
