public class RotationPoint {
    public static void main(String[] args) {
        
    
        int[] arr = {4,5,1,2,3,4};
        int left = 0;
        int n = arr.length;
        int right = n-1;

        while(left!=right){
            int mid = (left+right)/2;
            if(arr[mid]>arr[right]){
                left = mid+1;
            }
            if(arr[mid]<arr[right]){
                right = mid;
            }
        }
        System.out.println(arr[left]);
    }

}
