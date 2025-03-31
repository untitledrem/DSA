public class CircularQ extends DSAQueue
{
    // Constructor with size
    public CircularQ(int size)
    {
        super(size);
    }

    // Defauly constructor
    public CircularQ()
    {
        super();
    }

    // Circular queue isFull is slightly different as front and back loop
    @Override
    public boolean isFull()
    {
        return (back + 1) % capacity == front;
    }

    // Same again for isEmpty
    @Override
    public boolean isEmpty()
    {
        return front == -1;
    }

    // Enqueue items onto end of the circular queue
    public void enqueue(Object obj)
    {
        if (isFull())
        {
            System.out.println("Queue is full.");
        }

        else
        {
            if (front == -1)
            {
                front = 0;
            }

            // Modulo operator allows the circular queue to continue to loop
            back = (back + 1) % capacity;
            queue[back] = obj;
            count ++;
        }
    }

    // Remove objects from front of queue and return their value
    public Object dequeue()
    {
        Object obj = null;

        if (isEmpty())
        {
            System.out.println("Queue is empty.");
            return obj;
        }

        else
        {
            obj = queue[front];

            if (front == back)
            {
                front = -1;
                back = -1;
            }

            else
            {
                front = (front + 1) % capacity;
            }
            count--;

            return obj;
        }
    }

    // Circular queue requires a different show method to accommodate the looping indexes
    @Override
    public void show()
    {

        if (isEmpty())
        {
            System.out.println("Queue is empty.");
        }

        // Do while necessary to print out back + 1 statement
        else
        {
            int i = front;
            do 
            {
                System.out.print(queue[i] + " ");
                i = (i + 1) % capacity;
            }

            while (i != (back + 1) % capacity);
            System.out.println();
        }
    }
}
