package customqueue;

public class selfTest {
    public static void main(String[] args) {
        System.out.println("CustomLinkedQueue Demo!");
        CustomLinkedQueue<Integer> queue = new CustomLinkedQueue<>();

        // enqueue()
        queue.enqueue(300);
        queue.enqueue(200);
        queue.enqueue(100);
        queue.printAll(); //expected output: "PrintAll: 300 200 100"


        // dequeue()
        System.out.println("dequeue(): " + queue.dequeue()); //dequeue(): 300"
        System.out.println("dequeue(): " + queue.dequeue()); //dequeue(): 200"
        System.out.println("dequeue(): " + queue.dequeue()); //dequeue(): 100"

        System.out.println(queue.isEmpty());
    }
}