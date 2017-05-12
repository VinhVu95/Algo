package skyscannerTest;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) throws FileNotFoundException{
        Scanner in = new Scanner(new File("C:\\Users\\Vu Anh Vinh\\workspace\\FirstProject\\src\\skyscannerTest\\input.txt"));
        int _count;
        _count = Integer.parseInt(in.nextLine());
        
        OutputCommonManager(_count, in);
        
    }
 static void OutputCommonManager(int count, Scanner in) {
     
     HashMap<String, ArrayList<String>> relation =  new HashMap<String,ArrayList<String>>();
     String name1 = in.nextLine();
     String name2 = in.nextLine();
     ArrayList<String> pathEmp1  = new ArrayList<String>();
     ArrayList<String> pathEmp2  = new ArrayList<String>();
    
     /*
     Get the start employee
     */
     
     String temp = in.nextLine();
     String[] temps = temp.split(" ");
     //System.out.println ("TEST " + temp);
     ArrayList<String> listEmp2 = new ArrayList<String>();
     listEmp2.add(temps[1]);
     relation.put(temps[0], listEmp2);
     String startNode = temps[0];
     
     for (int j = 0 ; j <count -2 ; j++){
         temp = in.nextLine();
         temps = temp.split(" ");
         if (relation.get(temps[0]) == null){
             listEmp2 = new ArrayList<String>();
             listEmp2.add(temps[1]);
             //printList(listEmp2);
             relation.put(temps[0], listEmp2);
         }else{
              listEmp2 = relation.get(temps[0]);
             listEmp2.add(temps[1]);
             //printList(listEmp2);
             relation.put(temps[0], listEmp2);
         }
     }
     System.out.println ("FINISH READING INPUT");
     //Find path for emp1
     DFS(relation,startNode,pathEmp1,name1);
     //Find path for emp2
     System.out.println ("END");
     DFS(relation,startNode,pathEmp2,name2);
     
     //Compare 2 List
    // printList(pathEmp1);
    // printList(pathEmp2);
    // System.out.println (pathEmp2.size());
     int i = 0;
     
     for (i = 0 ; i < Math.min(pathEmp1.size(), pathEmp2.size());i++){
    	// System.out.println (pathEmp1.get(i));
    	 //System.out.println (pathEmp2.get(i));
         if (!pathEmp1.get(i).equals(pathEmp2.get(i))){
             System.out.println (pathEmp1.get(i-1));
             return;
         }
         //
         //System.out.println (pathEmp1.get(i-1));
     }
     System.out.println (pathEmp1.get(i-1));
     return;
 }
  public static boolean DFS(HashMap<String, ArrayList<String>> relation, String start, ArrayList<String> path, String dest){
      boolean isFound = false;
      path.add(start);
      ArrayList<String> listChildren  = relation.get(start);
      //printList(path);
      if (start.equals (dest)){
          isFound = true;
          return true;
      }
    
      if (listChildren == null || listChildren.isEmpty()){
          path.remove(path.size()-1);
          return isFound;
      }else{
          for (String node : listChildren){
              isFound = DFS(relation,node,path, dest);
              if (isFound) break;
          }
      }
       //Meet the destination point
     
      if (!isFound){
           path.remove(path.size()-1);
      }
      return isFound;
     
  }
  public static void printList(ArrayList<String> arr){
	  for (String temp : arr){
		  System.out.print(temp + "-");
	  }
	  System.out.println();
  }
}
