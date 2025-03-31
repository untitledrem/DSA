public class ShufflingQ extends DSAQueue
{
    // Constructor with size
    public ShufflingQ(int size)
    {
        super(size);
    }

    // Default Constructor
    public ShufflingQ()
    {
        super();
    }

    // Enqueue objects to the queue
    public void enqueue(Object obj)
    {
        try
        {
            if (isFull()) 
            {
                System.out.println("Queue is full.");    
            }
    
            else
            {
                // If first element being added
                if (front == -1)
                {
                    front = 0;
                }
    
                // Increase index of 'back' of queue and add to that place
                back++;
                count++;
                queue[back] = obj;
            }
        }

        // This queue must be cleared before it can be reused
        catch (ArrayIndexOutOfBoundsException e)
        {
            System.out.println("Queue must be empty before items can be added.");
        }
    }

    // Remove objects from queue and return their value
    public Object dequeue()
    {
        Object val;

        if (isEmpty())
        {
            System.out.println("Queue is empty.");
            return -1;
        }

        else
        {
            val = queue[front];
        }

            // If queue contains no elements
            if (front >= back) 
            {
                front = -1;
                back = -1;
            }

            else
            {
                front++;
            }

        return val;
    }

}
