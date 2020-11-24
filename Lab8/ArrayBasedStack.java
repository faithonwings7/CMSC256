package cmsc256;
import java.util.*;

public class ArrayBasedStack<T> implements StackInterface<T> {

    private T[] data;
    private int topOfStack;
    private static final int INITIAL_CAPACITY = 5;

    public ArrayBasedStack(int capacity){
        if(capacity <= 0) {
            throw new IllegalArgumentException("Array initial size error.");
        }
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[capacity];
        data = tempStack;
        topOfStack = -1;
    }
    public ArrayBasedStack(){
        T[] tempStack = (T[])new Object[INITIAL_CAPACITY];
        data = tempStack;
        topOfStack = -1;
    }
    private void expandArray(){
        int originalSize = data.length;
        int newSize = (originalSize * 2);
        data = Arrays.copyOf(data, newSize);
    }
    private boolean isArrayFull(){
        if(topOfStack >= data.length - 1){
            return true;
        }
        return false;
    }
    @Override
    public void push(T newEntry) {
        if(isArrayFull()){
            expandArray();
        }
        topOfStack++;
        data[topOfStack] = newEntry;
    }
    @Override
    public T pop() {
        if(isEmpty()){
            throw new EmptyStackException("The stack is empty!");
        }
        T temp = data[topOfStack];
        data[topOfStack] = null;
        topOfStack--;
        return temp;
    }
    @Override
    public T peek() {
        if(isEmpty()){
            throw new EmptyStackException("The stack is empty!");
        }
        return data[topOfStack];
    }
    @Override
    public boolean isEmpty() {
        if(topOfStack < 0){
            return true;
        }
        return false;
    }
    @Override
    public void clear() {
        @SuppressWarnings("unchecked")
        T[] tempStack = (T[])new Object[INITIAL_CAPACITY];
        data = tempStack;
        topOfStack = -1;
    }
}
