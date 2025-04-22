public class FirstAndLastOccurance {

    public static int[] findFirstAndLast(int[] arr, int target){
        int firstIndex = -1;
        int lastIndex = -1;
        int l = 0;
        int r = arr.length-1;
        while (l<=r) {
            int mid = (l+r)/2;
            if(arr[mid]<target){
                l = mid+1;
            }
            else if(arr[mid]>target){
                r = mid-1;
            }
            else {
                firstIndex = mid;
                r = mid-1;
            }
        }

        l = 0;
        r = arr.length-1;
        while (l<=r) {
            int mid = (l+r)/2;
            if(arr[mid]<target){
                l = mid+1;
            }
            else if(arr[mid]>target){
                r = mid-1;
            }
            else {
                lastIndex = mid;
                l = mid+1;
            }
        }
    
    return new int[] {firstIndex,lastIndex};
}
    public static void main(String[] args){
        int[] arr = {1,2,2,3,4,4,4,5,6};
        
        int target = 5;
        int[] res = findFirstAndLast(arr,target);
        System.out.println("First Index : " + res[0]);
        System.out.println("Last Index : " + res[1]);
        }
    
}
