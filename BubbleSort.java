import java.util.*;

public class BubbleSort
{
    public static void main(String[] args)
    {
        // Create random class used to generate random numbers
        Random random = new Random(); 
    
        // Initialise array of size n
        int n = 100;
        int[] randomArray = new int[n];
    
        // Populate the array with random numbers between 0 and bound
        int bound = 100;
        for (int i = 0; i < randomArray.length; i++)
        {
            randomArray[i] = random.nextInt(bound);
        }
    
        System.out.println("\nUnsorted Array\n");
        printArray(randomArray);
        System.out.println("\nSorted Array\n");
        printArray(bubbleSort(randomArray));
    
    }
    
    // Method to sort array using a Bubble Sort algorithm
    private static int[] bubbleSort(int[] array)
    {
        // While loop checks for boolean state that only changes once array is sorted
        boolean swapped = true;
        while (swapped)
        {
            swapped = false;
            for (int i = 0; i < array.length - 1; i++)
            {
                if (array[i] > array[i+1])  
                {
                    int swap = array[i];
                    array[i] = array[i+1];
                    array[i+1] = swap;
                    swapped = true;
                }
            }
        }
        return array;
    }
    
    // Method for printing individual array elements
    private static void printArray(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }

}

