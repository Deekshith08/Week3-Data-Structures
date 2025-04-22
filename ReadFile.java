import java.io.IOException;
import java.io.FileReader;
import java.io.BufferedReader;


public class ReadFile {
    public static void main(String[] args){
        String filepath = "C:\\capgemini training\\Week3\\Linear and Binary Search\\PerformanceTest.java";
        try(BufferedReader br = new BufferedReader(new FileReader(filepath))){
            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

}
