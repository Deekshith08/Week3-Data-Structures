import java.io.IOException;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.FileReader;

public class CompareFileReading {
    public static void testFR(String filepath) throws IOException{
        FileReader fr = new FileReader(filepath);
        int c;
        long start = System.nanoTime();
        while((c = fr.read())!=-1){
            continue;
        }
        fr.close();
        long end = System.nanoTime();
        System.out.println("File Reader : " + ((end-start)/1000000.0));
    }
    public static void testISR(String filepath) throws IOException{
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filepath));
        int c;
        long start = System.nanoTime();
        while((c = isr.read())!=-1){
            continue;
        }
        isr.close();
        long end = System.nanoTime();
        System.out.println("Input Stream Reader : " + ((end-start)/1000000.0));
    }
    public static void main(String[] args) throws IOException{
        String filepath = "C:\\capgemini training\\Week3\\RunTime Analysis\\CompareSorting.java";
        testFR(filepath);
        testISR(filepath);
    }
}
