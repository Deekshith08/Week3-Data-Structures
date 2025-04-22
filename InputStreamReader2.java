import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.IOException;
public class InputStreamReader2 {
    public static void main(String[] args) throws IOException{
        InputStreamReader isr = new InputStreamReader(System.in);
        String filepath = "names.txt";
        FileWriter fr = new FileWriter(filepath);
        BufferedReader br = new BufferedReader(isr);
        String line;
        System.out.println("Enter text (type 'exit' to quit):");

        while((line = br.readLine())!=null){
            if(line.equalsIgnoreCase("exit")) break;
            fr.write(line + "\n");
        }
        fr.close();
        br.close();

    }
}
