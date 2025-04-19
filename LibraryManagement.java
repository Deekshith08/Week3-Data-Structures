
class BookNode{
    String bookTitle;
    String author;
    String genre;
    int bookId;
    boolean availabilityStatus;
    BookNode prev;
    BookNode next;

    BookNode(String title, String author, String genre, int id, boolean status){
        this.bookTitle = title;
        this.author = author;
        this.genre = genre;
        this.bookId = id;
        this.availabilityStatus = status;
        this.prev = null;
        this.next = null;
    }
}
public class LibraryManagement {
    static BookNode head = null;
    static BookNode tail = null;

    static void addBegin(BookNode book){
        if(head == null){
            head = book;
            tail = book;
            return;
        }
        head.prev = book;
        book.next = head;
        head = book;
    }

    static void addEnd(BookNode book){
        if(head == null){
            addBegin(book);
            return;
        }
        tail.next = book;
        book.prev = tail;
        tail = book;
    }

    static void addPosition(int pos, BookNode book){
        if(head == null || pos==1){
            addBegin(book);
            return;
        }
        BookNode curr = head;
        pos--;
        while (curr.next!=null && pos>1) {
            curr = curr.next;
            pos--;
        }
        if(curr.next == null){
            addEnd(book);
            return;
        }
        
        curr.next.prev = book;
        book.next = curr.next;
        curr.next = book;
        book.prev = curr;
    }

    static void removeBook(int bookId){
        if(head == null){
            System.out.println("List is empty");
            return;
        }

        if(head.bookId == bookId){
            if(head.next != null){
                head = head.next;
                head.prev = null;
            }
            else{
                head = null;
                tail = null;
            }
            return;
        }
        BookNode curr = head.next;
        while (curr!=null) {
            if(curr.bookId == bookId){
                if(curr.next != null){
                    curr.prev.next = curr.next;
                    curr.next.prev = curr.prev;
                }
                else{
                    curr.prev.next = null;
                    tail = curr.prev;
                }
                return;
            }
            curr = curr.next;
        }
        System.out.println("Book Id not found");
    }

    static void searchBook(String title){
        BookNode curr = head;
        boolean found = false;
        while(curr!=null){
            if(curr.bookTitle.equalsIgnoreCase(title)){
                System.out.println("\nBook Title : " + curr.bookTitle);
                System.out.println("Book Id : " + curr.bookId);
                System.out.println("Author : " + curr.author);
                System.out.println("Availability Status : " + curr.availabilityStatus);
                found = true;
                break;
            }
            curr = curr.next;
        }
        if(!found) System.out.println("Book Not Found");
    }

    static void updateStatus(int bookId, boolean status){
        BookNode curr = head;
        boolean updated = false;
        while(curr!=null){
            if(curr.bookId == bookId){
                curr.availabilityStatus = status;
                updated = true;
                break;
            }
            curr = curr.next;
        }
        if(!updated) System.out.println("Book Not Found");
    }
    

    static void display(){
        BookNode curr = head;
        while(curr!=null){
            System.out.print(curr.bookTitle + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    static void displayReverse(){
        BookNode curr = tail;
        while(curr!=null){
            System.out.print(curr.bookTitle + " -> ");
            curr = curr.prev;
        }
        System.out.println("null");
    }

    static void countAllBooks(){
        BookNode curr = head;
        int count = 0;
        while (curr!=null) {
            count++;
            curr = curr.next;
        }
        System.out.println("No of Books in library : " + count);
    }

    public static void main(String[] args){
        BookNode b1 = new BookNode("No One", "Raj", "Classic", 1, true);
        BookNode b2 = new BookNode("Else one", "Vijay", "Rom-com", 2,true);
        BookNode b3 = new BookNode("Every One", "Yash", "Thriller", 3, true);
        BookNode b4 = new BookNode("Me One", "Mahesh", "Comedy", 4, true);
        addBegin(b1);
        addBegin(b2);
        addEnd(b3);
        display();
        addPosition(4, b4);
        display();
        removeBook(3);
        display();
        searchBook("No One");
        updateStatus(1, false);
        display();
        displayReverse();
        countAllBooks();
    }
}
