import java.util.Stack;

public class QueueUsingStack {

    Stack<Integer> stackEnqueue = new Stack<>();
    Stack<Integer> stackDequeue = new Stack<>();

    void enqueue(int num){
        stackEnqueue.push(num);
    }

    int dequeue() {
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }    

        if(stackDequeue.isEmpty()){
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        return stackDequeue.pop();
    }

    int peek(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }  

        if(stackDequeue.isEmpty()){
            while (!stackEnqueue.isEmpty()) {
                stackDequeue.push(stackEnqueue.pop());
            }
        }
        return stackDequeue.peek();
    }

    boolean isEmpty(){
        return stackEnqueue.empty() && stackDequeue.empty();
    }

    int size(){
        return stackEnqueue.size()+stackDequeue.size();
    }

    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();
        q.enqueue(10);
        q.enqueue(20);
        System.out.println("Front : " + q.peek());
        System.err.println("Dequeued : " + q.dequeue());
        q.enqueue(30);
        System.out.println("Front : " + q.peek());
        System.out.println("Dequeued : " + q.dequeue());
    }
}