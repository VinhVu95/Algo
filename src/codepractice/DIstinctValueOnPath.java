package codepractice;

import java.util.*;

/**
 * Created by Vu Anh Vinh on 29/10/2016.
 */
public class DIstinctValueOnPath {

    public static void main(String[] args){
        Tree A = new Tree(4);
        Tree B = new Tree(5);
        Tree C = new Tree(6);
        Tree D = new Tree(3);
        Tree E = new Tree(1);
        Tree F = new Tree(6);
        Tree G = new Tree(1);
        A.l = B;
        A.r = C;
        B.l = D;
        C.l = E;
        C.r = F;
        D.l = G;
        System.out.println(solution(A));
    }

    public static int solution(Tree T){
        Stack<Tree> s = new Stack<Tree>();
        Map<Tree,Tree> prev = new HashMap<Tree,Tree>();
        List<Tree> leaves = new ArrayList<Tree>();
        Tree pt = T;
        while(!s.isEmpty() || pt != null){
            if(pt != null)
            {
                s.push(pt);
                if(pt.l != null)
                    prev.put(pt.l,pt);
                pt = pt.l;
            } else{
                Tree cur = s.pop();
                if(cur.l == null && cur.r == null)
                    leaves.add(cur);
                if(cur.r != null)
                    prev.put(cur.r,cur);
                pt = cur.r;
            }
        }
        int res = Integer.MIN_VALUE;
        for(Tree l: leaves){
            res = Math.max(res,numDistinct(l,prev));
        }

        return res;
    }

    public static int numDistinct(Tree t, Map<Tree,Tree> prev){
        HashSet<Integer> set = new HashSet<Integer>();
        while(prev.containsKey(t)){
            if(!set.contains(t.x))
                set.add(t.x);
            t = prev.get(t);
        }
        if(!set.contains(t.x))
            set.add(t.x);
        return set.size();
    }



    public static class Tree{
        int x;
        Tree l;
        Tree r;
        public Tree(int x){
            this.x = x;
        }
    }
}
