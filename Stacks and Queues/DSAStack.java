public class DSAStack
{
    Object[] stack;
    int top;
    int count;
    int capacity;

    // Constructor method for new objects
    public DSAStack(int size)
    {
        this.stack = new Object[size];
        this.capacity = size;
        this.top = -1;
        this.count = 0;
    }

    // Methods
    public void show()
    {
        for (int i = top; i >= 0; i--)
        {
            if (stack[i] != null) 
            {
                System.out.println(stack[i]);
            }
        } 
        System.out.println();
    }

    // Acsessors
    public int getCount()
    {
        return count; 
    }

    // Boolean to check for state of stack
    public boolean isEmpty()
    {
        if (count == 0)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    // Boolean to check for state of stack
    public boolean isFull()
    {
        if (count == capacity)
        {
            return true;
        }

        else
        {
            return false;
        }
    }

    // Return the top value without modifiying it
    public Object top()
    {
        if (isEmpty())
        {
            System.out.println("The stack is empty"); 
            return 0;
        }

        else
        {
            Object topVal = stack[top];
            return topVal;
        }
    }

    // Print top of stack to terminal
    public void peek()
    {
        System.out.println(top());
    }
    
    // Push value onto stack
    public void push(Object obj)
    {
        if (isFull())
        {
            System.out.println("The stack is full.");
        }

        else
        {
            count++;
            top++;
            stack[top] = obj;
        }
    }

    // Remove value from top of stack, clear it's value and amend 'top'
    public Object pop()
    {
        Object pop = stack[top];
        stack[top] = null;
        count--;
        top--;
        return pop;
    }

}
