class InvNode{
    String itemName;
    int itemId;
    double quantity;
    double price;
    InvNode next;

    InvNode(String name, int id, double quantity, double price){
        this.itemName = name;
        this.itemId = id;
        this.quantity = quantity;
        this.price = price;
        this.next = null;
    }
}
public class InventoryManagement {

    static InvNode head = null;
    static void addBegin(InvNode n){
        if(head == null){
            head = n;
            return;
        }
        n.next = head;
        head = n;
    }

    static void addEnd(InvNode n){
        if(head == null){
            head = n;
            return;
        }
        InvNode curr = head;
        while(curr.next != null){
            curr  =curr.next;
        }
        curr.next = n;
    }

    static void addPostition(int pos, InvNode n){
        if(pos<=1 || head == null){
            addBegin(n);
            return;
        }
        InvNode curr = head;
        pos--;
        while (curr.next!=null && pos>1) {
            curr = curr.next;
            pos--;
        }
        InvNode temp = curr.next;
        curr.next = n;
        n.next = temp;
    }

    static void removeItem(int id){
        if(head == null){
            System.out.println("Inventory is empty");
            return;
        }
        InvNode curr = head;
        if(head.itemId == id){
            head = head.next;
            return;
        }
        boolean removed = false;
        while (curr.next != null){
            if(curr.next.itemId == id){
                removed = true;
                curr.next = curr.next.next;
                break;
            }
            curr = curr.next;
        }
        if(!removed) System.out.println("Item id not found");
    }

    static void updateItem(int id, int newQuantity){
        boolean updated = false;
        InvNode curr = head;
        while(curr!=null){
            if(curr.itemId == id){
                updated = true;
                curr.quantity = newQuantity;
            }
            curr = curr.next;
        }
        if(!updated) System.out.println("Item id not found");
    }
    
    static void searchItem(int id){
        boolean found = false;
        InvNode curr = head;
        while (curr!=null) {
            if(curr.itemId == id){
                found = true;
                System.out.println("Item Name : " + curr.itemName);
                System.out.println("Item id : " + curr.itemId);
                System.out.println("Quantity : " + curr.quantity);
                System.out.println("Price : " + curr.price);
            }
            curr = curr.next;
        }
        if(!found) System.out.println("Item id not found");
    }

    static void totalBill(){
        InvNode curr = head;
        double sum = 0;
        while (curr!=null) {
            sum += (curr.price*curr.quantity);
            curr =curr.next;
        }
        System.out.println("Iventory Total Bill : " + sum);
    }

    static void displayList(){
        InvNode curr = head;
        while (curr != null) {
            System.out.print(curr.itemName + " -> ");
            curr = curr.next;
        }
        System.out.println(" null");
    }

    public static void main(String[] args){
        InvNode n1 = new InvNode("Rice", 1, 20.5, 60.5);
        InvNode n2 = new InvNode("Sugar", 2, 10, 34);
        InvNode n3 = new InvNode("Salt",3,12,20);
        InvNode n4 = new InvNode("Jaggery", 4, 8, 34.6);
        addBegin(n1);
        addBegin(n2);
        addEnd(n3);
        addPostition(2, n4);
        removeItem(3);
        updateItem(1, 40);
        displayList();
        searchItem(4);
        totalBill();
    }
}