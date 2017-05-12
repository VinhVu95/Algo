
public class RotationPoint {
    public static int rotationPoint(int[] arr) {
        // write the body of your function here
        int l = 0;
        int r = arr.length - 1;
        while(l <= r)
        {
            int mid = (l + r)/2;
            if(arr[mid] < arr[mid - 1])
                return arr[mid];
            if(arr[mid] > arr[r])
                l = mid + 1;
            if(arr[mid] < arr[l])
                r = mid - 1;
        }
        throw new IllegalArgumentException("There is no rotation point !!");
    }
    
    public static void main(String[] args) {
        // run your function through some test cases here
        // remember: debugging is half the battle!
        int[] testInput = {6,1,2,3,3,4,4,5};
        System.out.println(rotationPoint(testInput));
    }
}
