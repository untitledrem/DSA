public class DSAQueue 
{
    Object[] queue;
    int count;
    int defaultSize = 10;
    int capacity;
    int front, back;

    // Default constructor with no capacity
    public DSAQueue()
    {
        this.queue = new Object[defaultSize];
        this.count = 0;
        this.front = -1;
        this.back = -1;
    }

    // Constructor with max capacity
    public DSAQueue(int size)
    {
        this.queue = new Object[size];
        this.count = 0;
        this.capacity = size;
        this.front = -1;
        this.back = -1;
    }
    
    // Return true if queue is empty
    public boolean isEmpty()
    {
        // If no enquing has occured then front = -1
        if (front == -1)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    // Return true is queue is full 
    public boolean isFull()
    {
        // If front is at element 1 AND back is at the end of the queue
        if (front == 0 && back == capacity - 1)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    // Return front of queue without change
    public Object peek()
    {
        Object frontObj = queue[front];
        return frontObj;
    }


    // Helper Methods
    public void show()
    {
        if (isEmpty())
        {
            System.out.println("Queue is empty.");
        }
        
        else
        {
            for(int i = front; i < queue.length; i++)
                System.out.print(queue[i] + " ");
                System.out.println();
        }
    }
    
    public int count()
    {
        return count;
    }
}
