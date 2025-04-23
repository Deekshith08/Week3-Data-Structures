public class SearchTarget {

    public static void linearSearch(int[] arr, int target){
        long start = System.nanoTime();
        for(int i=0; i<arr.length; i++){
            if(arr[i] == target){
                break;
            }
        }
        long end = System.nanoTime();
        System.out.println("Linear Search : " + ((end-start)/1000000.0));

    }

    public static void binarySearch(int[] arr, int target){
        int l = 0;
        int r = arr.length-1;
        long start = System.nanoTime();
        while(l<=r){
            int mid = (l+r)/2;
            if(arr[mid] < target){
                l = mid+1;
            }
            else if(arr[mid] > target){
                r = mid -1;
            }
            else break;
        }
        long end = System.nanoTime();
        System.out.println("Binary Search : " + ((end-start)/1000000.0));

    }

    public static void main(){
        int[] arr = new int[1000];
        for(int i = 0; i<1000; i++){
            arr[i] = i;
        }
        int target = 999;
        linearSearch(arr, target);
        binarySearch(arr, target);
        
    }
}