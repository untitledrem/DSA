import java.util.*;

public class Towers
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the number of disks you wish to use.");
        int n = sc.nextInt();
        int src = 1;
        int dst = 3;

        // Create array of length n
        int[][] array = createArray(n);

        print2DArray(array);
        towers(n, src, dst, array);

        sc.close();
    }

    public static void towers(int n, int src, int dst, int[][] array)
    {   
        if (n == 1)
        {
            moveDisc(array, src, dst);
        }

        else
        {
            // Recursive logic for tower movement
            int temp = 6 - src - dst;
            towers(n - 1, src, temp, array);
            moveDisc(array, src, dst);
            towers(n - 1, temp, dst, array);
        }
    }

    public static int[][] createArray(int n)
    {
        if (n < 0)
        {
            throw new ArrayIndexOutOfBoundsException();
        }

        else 
        {
            int[][] array = new int[n][3];
            for (int x = 0; x < n; x++)
            {
                array[x][0] = x + 1; 
            }
            return array;
        }
    }

    private static int[][] moveDisc(int[][] array, int source, int dest)
    {
        // Adjust parameters to be used as index values
        int srcCol = source - 1;
        int destCol = dest - 1;

        // Find the top disk in the source column
        int srcTop = findTop(array, srcCol);

        // Find the top disk in the destination column
        int destTop = findTop(array, destCol);

        // Return input array if source peg is empty
        if (srcTop == array.length)
        {
            return array;
        }

        // Get the value to move
        int diskToMove = array[srcTop][srcCol];

        // Check if the move is valid 
        if (destTop == array.length || array[destTop][destCol] > diskToMove)
        {
            // Clear the source position
            array[srcTop][srcCol] = 0; 
            // Place the disk at the destination
            array[destTop - 1][destCol] = diskToMove; 
        }

        else
        {
            System.out.println("Invalid move: Cannot place a larger disk on top of a smaller one.");
        }

        print2DArray(array);
        wait(500);
        return array;
    }

    private static int findTop(int[][] array, int col)
    {
        for (int i = 0; i < array.length; i++)
        {
            if (array[i][col] != 0)
            {
                return i;
            }
        }
        return array.length; // Column is empty so top = bottom
    }

    // Helper method to print 2D arrays
    private static void print2DArray(int[][] array)
    {
        System.out.println();
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < 3; j++)
            {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    // Helper method for slowing down array printing 
    public static void wait(int ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
    }
}