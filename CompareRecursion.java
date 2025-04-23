public class CompareRecursion {

    public static int fibonacciRecursive(int n){
        if(n<=1) return n;
        return fibonacciRecursive(n-1)+fibonacciRecursive(n-2);
    }

    public static void RecursiveTime(int n){
        long start = System.nanoTime();
        fibonacciRecursive(n);
        long end = System.nanoTime();
        System.out.println("Recursive Fibonacci : " + ((end-start)/1000000.0));
    }

    public static void iterativeTime(int n){
        long start = System.nanoTime();
        int a = 0, b = 1, sum;
        for (int i = 2; i <= n; i++) {
            sum = a + b;
            a = b;
            b = sum;
        }
        long end = System.nanoTime();
        System.out.println("Iterative Fibonacci : " + ((end-start)/1000000.0));        
    }
    
    public static void main(String[] main){
        int n = 10;
        RecursiveTime(n);
        iterativeTime(n);
    }
}
