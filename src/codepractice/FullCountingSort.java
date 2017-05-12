package codepractice;

import java.io.File;
import java.util.Scanner;

/**
 * Created by Vu Anh Vinh on 27/10/2016.
 */
public class FullCountingSort {
    public static void main(String[] args){
        try{
            File f = new File("C:\\Users\\Vu Anh Vinh\\workspace\\FirstProject\\src\\codepractice\\FullCountingSort.txt");
            Scanner scan = new Scanner(f);
            int n = scan.nextInt();
            Word[] words = new Word[n];
            for(int i = 0; i< n;i++)
            {
                int x = scan.nextInt();
                String s = scan.next();
                words[i] = new Word(i,s,x);
            }

            quickSort(words,0,n-1,true);
            int i = 0;
            while(i < n){
                int j = i;
                while( j < n-1 && words[j].x == words[j+1].x){
                    j++;
                }
                if(j > i)
                    quickSort(words,i,j,false);
                i = j + 1;
            }
            /*for(Word w: words){
                System.out.println("original index: " + w.originalIndex + " number: " + w.x + " string: " + w.s );
            }*/
            StringBuffer sb = new StringBuffer();
            for(Word w: words){
                if(w.originalIndex < n/2)
                    sb.append('-');
                else
                    sb.append(w.s);
                sb.append(" ");
            }
            sb.deleteCharAt(sb.length()-1);
            System.out.println(sb.toString());

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public static void quickSort(Word[] words,int from,int to,boolean sortedByX){
        if(from >= to)
            return;
        if(sortedByX){
            int pos = partitionX(words,from,to);
            quickSort(words,from,pos-1,sortedByX);
            quickSort(words,pos+1,to,sortedByX);
        } else {
            int pos = partitionOriIn(words, from, to);
            quickSort(words, from, pos - 1, false);
            quickSort(words, pos + 1, to, false);
        }
    }

    public static int partitionX(Word[] words,int start,int end){
        int c = words[start].x;
        int i = start;
        int j = end+1;
        while(true)
        {
            while(words[++i].x <= c)
                if(i == end) break;
            while(words[--j].x > c)
                if(j == start) break;
            if(i >= j)
                break;
            swap(words,i,j);
        }
        swap(words,start,j);
        return j;
    }

    public static void swap(Word[] words,int i,int j){
        Word temp = words[i];
        words[i] = words[j];
        words[j] = temp;
    }

    public static int partitionOriIn(Word[] words,int start,int end){
        int c = words[start].originalIndex;
        int i = start;
        int j = end+1;
        while(true)
        {
            while(words[++i].originalIndex <= c)
                if(i == end) break;
            while(words[--j].originalIndex > c)
                if(j == start) break;
            if(i >= j)
                break;
            swap(words,i,j);
        }
        swap(words,start,j);
        return j;
    }

    public static class Word{
        int originalIndex;
        String s;
        int x;
        public Word(int originalIndex,String s,int x){
            this.originalIndex = originalIndex;
            this.x = x;
            this.s = s;
        }
    }
}
