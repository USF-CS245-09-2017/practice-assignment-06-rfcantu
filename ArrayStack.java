import java.util.*;

public class ArrayStack<T> implements Stack<T> {

    private Object[] stack;
    private int size = 10;
    private int z;

    //Constructor, initializes the stack
    ArrayStack()
    {
        stack = new Object[size];
        z = -1;
    }

    @Override
    public void push(T item)
    {
        if (z == stack.length - 1) // is the stack full
        {
            largerArray();
        }
        stack[++z] = item;
    }

    @Override
    public T pop()
    {
        if (empty())
        {
            return null;
        }

        @SuppressWarnings("unchecked") T returner = (T) stack[z--];

        return returner; // return the top of the stack and decrease the index
    }

    @Override
    public T peek()
    {
        if (empty())
        {
            return null;
        }

        @SuppressWarnings("unchecked") T returner = (T) stack[z];
        return returner; // return the top of the stack
    }

    @Override
    public boolean empty()
    {
        return (z < 0);
    }

    protected void largerArray()
    {
        Object[] temp = new Object[stack.length * 2];
        for (int i = 0; i < stack.length; i++)
        {
            temp[i] = stack[i];
        }

        stack = temp;
    }
}

