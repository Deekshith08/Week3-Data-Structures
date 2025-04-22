import java.util.Scanner;
public class ReverseString {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter a String : ");
        String s = input.next();
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        sb.toString();
        System.out.println(sb);
        input.close();
    }
}