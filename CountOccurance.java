import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class CountOccurance {
    
    public static void main(String[] args) throws IOException{
        String target = "nanoTime";
        int count =0;
        String filepath = "C:\\capgemini training\\Week3\\Linear and Binary Search\\PerformanceTest.java";
        BufferedReader br = new BufferedReader(new FileReader(filepath));
        String line;
        while((line = br.readLine()) != null){
            String[] words = line.split("\\W+");
            for(String word:words){
                if(word.equals(target)) count++;
            }
        }
        br.close();

        System.out.println(count);

    }
}
