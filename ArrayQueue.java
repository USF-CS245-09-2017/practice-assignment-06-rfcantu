import java.util.*;

public class ArrayQueue<T> implements Queue<T> {

    public int front, rear;
    public Object[] queue;

    //Constructor, initializes the queue
    public ArrayQueue()
    {
        front = 0;
        rear = 0;
        queue = new Object[10];
    }

    //Function to remove the first element from the array\
    @Override
    public T dequeue()
    {
        if (empty())
        {
            return null;
        }
        Object temp = queue[front];
        front = (front + 1)%queue.length; // find if the queue is empty
        if (front == queue.length)
        {
            front = 0;
        }
        return (T) temp;
    }

    //Function to add an item to the end of the array
    @Override
    public void enqueue(T item)
    {
        if ((front + 1) % queue.length == rear) // is the array full
        {
            largerArray();
        }
        queue[rear] = item;
        rear++;
        return;
    }

    @Override
    public boolean empty()
    {
        return (front == rear);
    }

    // Creates new array and copies old array
    protected void largerArray()
    {
        Object[] temp = new Object[queue.length * 2];
        for (int i = 0; i < queue.length; i++)
        {
            temp[i] = queue[i];
        }

        queue = temp;
    }

}
