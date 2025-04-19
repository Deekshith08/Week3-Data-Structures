

class MovieNode{
    String movieTitle;
    String director;
    int yearOfRelease;
    double rating;
    MovieNode prev;
    MovieNode next;

    MovieNode(String title, String director, int year, double rating){
        this.movieTitle = title;
        this.director = director;
        this.yearOfRelease = year;
        this.rating = rating;
        this.prev = null;
        this.next = null;
    }
}

public class MovieManagement {

    static MovieNode head = null;
    
    static void addBegin(MovieNode movie){
        if(head == null){
            head = movie;
            return;
        }
        head.prev = movie;
        movie.next = head;
        head = movie;
    }

    static void addEnd(MovieNode movie){
        if(head == null){
            head = movie;
            return;
        }
        MovieNode curr = head;
        while (curr.next != null) {
            curr = curr.next;            
        }
        curr.next = movie;
        movie.prev = curr;
    }

    static void addPostition(int pos, MovieNode movie){
        if(head == null || pos==1){
            addBegin(movie);
            return;
        }
        pos--;
        MovieNode curr = head;
        while (curr.next!=null && pos>1) {
            pos--;
            curr = curr.next;
        }
        movie.next = curr.next;
        movie.prev = curr;
        curr.next = movie;
        if(curr.next !=null){
            movie.next.prev = movie;
        }
        
    }

    static void removeMovie(String title){
        MovieNode curr = head;
        if(head.movieTitle.equalsIgnoreCase(title)){
            if(head.next!=null){
                head.next.prev = null;
                head = head.next;
            }else{
                head = null;
            }
            
            return;
        }
        boolean removed = false;
        while (curr.next!=null) {
            if(curr.next.movieTitle.equalsIgnoreCase(title)){
                curr.next = curr.next.next;
                curr.next.prev = curr;
                removed = true;
                break;
            }
            curr = curr.next;
        }
        if(!removed) System.out.println("Movie title " + title  + " not found");
    }

    static void searchMovie(String director){
        MovieNode curr = head;
        boolean found = false;
        while (curr!=null) {
            if(curr.director.equalsIgnoreCase(director)){
                System.out.println("\nMovie Title : " + curr.movieTitle);
                System.out.println("Director : " + curr.director);
                System.out.println("Year of Release : " + curr.yearOfRelease);
                System.out.println("Rating : " + curr.rating);
                found = true;
                break;
            }
            curr = curr.next;
        }
        if(!found) System.out.println("Director not found");
    }

    static void updateRating(String title,double rating){
        MovieNode curr = head;
        boolean updated = false;
        while (curr!=null) {
            if(curr.movieTitle.equalsIgnoreCase(title)){
                curr.rating = rating;
                updated = true;
                break;
            }
            curr = curr.next;
        }
        if(!updated) System.out.println("MOvie title not found");
    }

    static void display(){
        MovieNode curr = head;
        while (curr != null) {
            System.out.print(curr.movieTitle + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    static void displayReverse(){
        MovieNode curr = head;
        while (curr.next!=null) {
            curr = curr.next;
        }
        while (curr!=null) {
            System.out.print(curr.movieTitle + " -> ");
            curr = curr.prev;
        }
        System.out.println("null");
    }



    public static void main(String[] args){
        MovieNode m1 = new MovieNode("Bahubali", "Rajamouli", 2014, 9.0);
        MovieNode m2 = new MovieNode("Bhadra", "Boyapati Srinu", 2005, 7 );
        MovieNode m3 = new MovieNode("Saaho", "Sujeeth", 2019, 6.50);
        MovieNode m4 = new MovieNode("Billa", "Meher", 2009, 8.5);
        addBegin(m3);
        addEnd(m2);
        addEnd(m1);
        //display();
        addPostition(3, m4);
        //display();
        //removeMovie("Bhadra");
        display();
        //searchMovie("Rajamouli");
        displayReverse();
    }
}