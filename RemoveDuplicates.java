import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        HashSet<Character> c = new HashSet<>();
        System.out.print("Enter a String : ");
        String s = input.next();

        for(int i=0; i<s.length(); i++){
            if(!c.contains(s.charAt(i))){
                sb.append(s.charAt(i));
                c.add(s.charAt(i));
            }
        }

        sb.toString();
        System.out.println("Original String : " + s);
        System.out.println("After removing duplicates : " + sb);
        input.close();
    }
}
