import java.util.HashSet;
import java.util.TreeSet;

public class CompareDataStructures {

    public static void testArray(){
        int[] arr = new int[1000];
        for(int i=0; i<arr.length; i++){
            arr[i] = i;
        }
        int target = 999;
        long start = System.nanoTime();
        for(int i=0;i<arr.length; i++){
            if(arr[i] == target) break;
        }
        long end = System.nanoTime();
        System.out.println("Array Time : " + ((end-start)/1000000.0));
    }

    public static void testHashSet(){
        HashSet <Integer> hs = new HashSet<>();
        for(int i=0; i<1000; i++){
            hs.add(i);
        }
        int target = 999;
        long start = System.nanoTime();
        
        boolean found = hs.contains(target);
        
        long end = System.nanoTime();
        System.out.println("Hash Set Time : " + ((end-start)/1000000.0));

    }

    public static void testTreeSet(){
        TreeSet <Integer> ts = new TreeSet<>();
        for(int i=0; i<1000; i++){
            ts.add(i);
        }
        int target = 999;
        long start = System.nanoTime();
        
        boolean found = ts.contains(target);
        
        long end = System.nanoTime();
        System.out.println("Tree Set Time : " + ((end-start)/1000000.0));

    }
    
    public static void main(String[] arg){
        testArray();
        testHashSet();
        testTreeSet();

    }
}
