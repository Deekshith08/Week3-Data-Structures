import java.util.Arrays;
public class CompareSorting {

    public static void bubbleSort(int[] arr){
        int n = arr.length;
        long start = System.nanoTime();
        for(int i=0; i<n-1; i++){
            boolean swapped = false;
            for(int j=0; j<n-i-1; j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swapped = true;
                }
            }
            if(!swapped) break;
        }
        long end = System.nanoTime();
        System.out.println("Bubble Sort : " + ((end-start)/1000000.0));
    }

    public static void mergeSort(int[] arr){
        long start = System.nanoTime();
        Arrays.sort(arr);
        long end = System.nanoTime();
        System.out.println("Merge Sort : " + ((end-start)/1000000.0));
    }

    public static void quickSort(int[] arr){
        long start = System.nanoTime();
        Arrays.sort(arr);
        long end = System.nanoTime();
        System.out.println("Quick Sort : " + ((end-start)/1000000.0));
    }
    
    public static void main(String[] args){
        int[] arr = new int[1000];
        int n = arr.length;
        int index=n;
        for(int i = 0; i<n; i++){
            arr[i] = index;
            index--;
        }
        bubbleSort(arr);
        mergeSort(arr);
        quickSort(arr);
    }
}
