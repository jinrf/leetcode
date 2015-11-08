import java.util.Stack;

public class JavaTest {
    Stack<Integer> stack = new Stack<Integer>();
    Stack<Integer> mini = new Stack<Integer>();
    public void push(int x) {
        stack.push(x);
        mini.push(x);
    }
    public boolean isSame() {
        return mini.peek() == stack.peek();
    }

    public static void main(String[] args) {
        JavaTest javaTest = new JavaTest();
        javaTest.push(128);
        System.out.println(javaTest.isSame());
        javaTest.push(5);
        System.out.println(javaTest.isSame());
    }
}
