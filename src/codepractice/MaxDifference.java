package codepractice;

/**
 * Created by Vu Anh Vinh on 29/10/2016.
 */
public class MaxDifference {
    public static void main(String[] args){
        int[] A = {0,1,4,-3,6,-8};
        System.out.println(solution(A));
    }
    public static int solution(int[] A){
        int n = A.length;
        int[] max = new int[n];
        int[] reverse_max = new int[n];
        max[0] = A[0];
        for(int i = 1; i < n;i++)
        {
            if(max[i-1] < A[i])
                max[i] = A[i];
            else
                max[i] = max[i-1];
        }
        reverse_max[n-1] = A[n-1];
        for(int i = n-2; i >= 0; i--)
        {
            if(A[i] > reverse_max[i+1])
                reverse_max[i] = A[i];
            else
                reverse_max[i] = reverse_max[i+1];
        }
        int res = Integer.MIN_VALUE;
        for(int k = 0; k < n-1; k++)
        {
            res = Math.max(res, Math.abs(max[k]-reverse_max[k+1]));
        }
        return res;

    }

}
