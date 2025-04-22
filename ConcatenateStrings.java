public class ConcatenateStrings {
    public static void main(String[] args){
        StringBuffer sb = new StringBuffer();
        String[] arr = {"Hello", "this", "is" , "a" , "list"};
        for(String a: arr){
            sb.append(a);
            sb.append(" ");
        }
        System.out.println(sb);
    }
}
