class Node{
    int rollNumber;
    String name;
    int age;
    char grade;
    Node next;

    Node(int rollNumber, String name, int age, char grade){
        this.rollNumber = rollNumber;
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.next = null;
    }
}

public class StudentRecordManagement {

    static Node head = null;

    static void addBegin(Node n){
        if(head == null){
            head = n;
            return;
        }
        n.next = head;
        head =n;
    }

    static void addEnd(Node n){
        if(head == null){
            head = n;
            return;
        }
        Node curr = head;
        while (curr.next!=null) {
            curr = curr.next;
        }
        curr.next = n;
    }

    static void addPostition(int pos, Node n){
        if(pos<=1 || head == null){
            addBegin(n);
            return;
        }
        
        Node curr = head;
        pos--;
        while(curr.next!=null && pos>1){

            pos--;
            curr = curr.next;
        }
        Node temp = curr.next;
        curr.next = n;
        n.next = temp;
    }

    static void deleteRecord(int rnumber){
        if(head == null){
            System.out.println("record is empty");
            return;
        }
        else if(head.rollNumber == rnumber){
            head= head.next;
            return;
        }

        Node curr = head;
        while(curr.next!=null){
            if(curr.next.rollNumber == rnumber){
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next; 
        }
        System.out.println("Roll number not found");
    }

    static void searchRecord(int rnumber){
        Node curr = head;
        boolean found = false;
        while (curr != null) {
            if(curr.rollNumber == rnumber){
                found = true;
                System.out.println("Found Record : " + curr.name);
            }
            curr = curr.next;
        }
        if(!found) System.out.println("Record not found");
    }

    static void updateGrade(int rnumber, char newGrade){
        Node curr = head;
        boolean updated = false;
        while(curr!=null){
            if(curr.rollNumber == rnumber){
                curr.grade = newGrade;
                updated = true;
                break;
            }
            curr = curr.next;
        }
        if(!updated){
            System.out.println("Roll Number not found");
        }
    }

    static void displayList(){
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.name + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    static void displayAllRecords(){
        Node curr = head;
        int i =0;
        while (curr != null){
            System.out.println("---Record " + (i+1) + "---");
            System.out.println("Name : " + curr.name);
            System.out.println("Roll Number : " + curr.rollNumber);
            System.out.println("Age : " + curr.age);
            System.out.println("Grade : " + curr.grade);
            i++;
            curr = curr.next;
        }
    }

    public static void main(String[] args){
        Node n1 = new Node(1, "Raj", 21, 'A');
        Node n2 = new Node(2, "Yash", 23, 'B');
        Node n3 = new Node(3, "Prabha", 21, 'C');
        Node n4 = new Node(4,"Krish",22,'O');
        Node n5 = new Node(5, "Siva", 22, 'O');
        addBegin(n1);
        addBegin(n2);
       // displayList();
        addEnd(n3);
        addPostition(2, n4);
        addPostition(4, n5);
        displayList();
        deleteRecord(4);
        displayList();
        searchRecord(1);
        //displayAllRecords();
        updateGrade(5, 'X');
        displayAllRecords();
    }
}