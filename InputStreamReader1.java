import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.IOException;
public class InputStreamReader1 {
    public static void main(String[] args) throws IOException{
        String filepath = "C:\\capgemini training\\Week3\\Linear and Binary Search\\PerformanceTest.java";
        InputStreamReader isr = new InputStreamReader(new FileInputStream(filepath),"UTF-8");
        int ch;
        while((ch = isr.read()) != -1){
            System.out.print((char)ch);
        }
        isr.close();
    }
}
