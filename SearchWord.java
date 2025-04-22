public class SearchWord {

    public static String wordSearch(String word, String[] sentences){
        for(String sentence : sentences){
            String[] words = sentence.split(" ");
            for(String w:words){
                if(w.equals(word)) return sentence;
            }
        }
        return "Not Found";

    }
    public static void main(String[] args){
        String[] sentences = {"I am Student", "I want to join here", "I am leaving" };
        System.out.println(wordSearch("leaving", sentences));
    }
}
