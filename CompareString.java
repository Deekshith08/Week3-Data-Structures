public class CompareString {

    public static void testString(){
        String text = "";
        long start = System.nanoTime();
        for(int i=0; i<1000; i++){
            text = text + "a";
        }
        long end = System.nanoTime();
        System.out.println("String : " + ((end-start)/1000000.0));
    }

    public static void testStringBuilder(){
        StringBuilder text = new StringBuilder("");
        long start = System.nanoTime();
        for(int i=0; i<1000; i++){
            text.append("a");
        }
        long end = System.nanoTime();
        System.out.println("String Builder : " + ((end-start)/1000000.0));
    }

    public static void testStringBuffer(){
        StringBuffer text = new StringBuffer("");
        long start = System.nanoTime();
        for(int i=0; i<1000; i++){
            text.append("a");
        }
        long end = System.nanoTime();
        System.out.println("String Buffer : " + ((end-start)/1000000.0));
    }
    
    public static void main(String[] arg){

        testString();
        testStringBuilder();
        testStringBuffer();
    }
}
