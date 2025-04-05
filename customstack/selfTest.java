package customstack;

public class selfTest {
    public static void main(String[] args) {
        System.out.println("CustomArrayStack Demo!");
        CustomArrayStack<Integer> stack = new CustomArrayStack<>();

        // enqueue()
        System.out.print(stack.push(300));
        stack.push(200);
        stack.push(100); //bottom 300, 200, 100 top
        /*
        for(int i = 400; i < 100000; i += 100){
            System.out.println(stack.push(i));
        }
        */
        //default capacity is 8;
        stack.printAll(); //expected output: "PrintAll: 100 200 300"

        // dequeue()
        System.out.println("dequeue(): " + stack.pop()); //dequeue(): 100"
        System.out.println("dequeue(): " + stack.pop()); //dequeue(): 200"
        //System.out.println("dequeue(): " + stack.pop()); //dequeue(): 300"
        stack.printAll(); //expected output: "PrintAll: 100 200""
    }
}
