import java.util.Map;
import java.util.HashMap;

public class SumTwo {
	public static int numPair(int[] arr, int key){
		int result = 0;
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for(int i = 0; i< arr.length; i++)
		{
			if(map.containsKey(arr[i]))
				{
					int freq = map.get(arr[i]);
					map.put(arr[i],freq + 1);
				}
			else
				map.put(arr[i], 1);
			int x = key - arr[i];
			if((key % 2 == 0) && (x == key/2)){
			}
			else if(map.containsKey(x))
			{
				result ++;
				removeOrReduce(map,x);
				removeOrReduce(map,arr[i]);
			}
		}

		if(key %2 == 0 && map.containsKey(key/2))
		{
			result += (map.get(key/2) / 2);
			//System.out.println(map.get(key/2) / 2);
		}
		return result;
	}

	public static void removeOrReduce(Map<Integer,Integer> map, int x)
	{
		if(map.get(x) < 2)
				map.remove(x);
		else{
				int freq2 = map.get(x);
				map.put(x,freq2 - 1);
		}
	}
	
	public static void main(String[] args){
		int[] test = {1,7,2,4,7,1,4,4,6,6,4,6,2};
		System.out.println(numPair(test,8));
	}
}
