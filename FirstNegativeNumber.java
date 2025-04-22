
public class FirstNegativeNumber {

    public static int  findnegative(int[] arr){
        for(int i=0; i<arr.length; i++){
            if(arr[i]<0) return arr[i];
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {2,3,4,5,2,-8,9,-9,-1};
        System.out.println(findnegative(arr));
    }
}
