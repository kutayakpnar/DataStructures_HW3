
import java.util.Arrays;
import java.util.EmptyStackException;
//This implementation is getting by our text book.
public final class StackImplementation<T> implements IStack<T> {

    private T[] stack;
    private int topIndex;
    private boolean initialized = false;
    private static final int DEFAULT_CAPACITY = 50;
    private static final int MAX_CAPACITY = 10000;

    public StackImplementation() {
        this(DEFAULT_CAPACITY);
    }

    public StackImplementation(int initialCapacity){

        checkCapacity(initialCapacity);
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[initialCapacity];
        stack = tempStack;
        topIndex = -1;
        initialized = true;
    }

    public void push (T newItem){
        checkInitialization();
        ensureCapacity();
        stack[topIndex + 1] = newItem;
        topIndex++;
    }

    private void ensureCapacity(){

        if (topIndex == stack.length-1) {
            int newLength = 2 * stack.length;
            checkCapacity(newLength);
            stack = Arrays.copyOf(stack, newLength);
        }
    }

    public T peek(){

        checkInitialization();
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else {
            return stack[topIndex];
        }
    }

    public T pop(){
        checkInitialization();
        if(isEmpty()){
            throw new EmptyStackException();
        }
        else {
            T top = stack[topIndex];
            stack[topIndex] = null;
            topIndex--;
            return top;
        }
    }

    public boolean isEmpty() {

        return topIndex < 0;
    }

    public void clear() {

        while(!isEmpty()){
            pop();
        }


    }

    private void checkInitialization() {

        if(!initialized)
            throw new SecurityException("Stack object is not initialized properly.");
    }

    private void checkCapacity(int capacity) {

        if(capacity > MAX_CAPACITY)
            throw new IllegalStateException("Attempt to create a stack whose capacity exceeds allowed maximum of " + MAX_CAPACITY);
    }

    public T getItem(int index){
        return stack[index];
    }

    public void displayItems(){
        for (int a = 0; a < stack.length; a++){
            if (stack[a] == null){
                continue;
            }
            System.out.println(stack[a]);
        }
    }



}