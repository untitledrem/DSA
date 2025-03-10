import java.util.*;

public class SelectionSort
{
    public static void main(String[] args)
    {
        // Initialise variables to create random arrray of size arraySize populated with random numbers between 0 and bound
        int arraySize = 100;
        int bound = 1000;
        Random random = new Random();
        int[] randomArray = new int[arraySize];

        // Populate array with random ints between 0 and bound
        for (int i = 0; i < randomArray.length; i++)
        {
            randomArray[i] = random.nextInt(bound);
        }

        // Print unsorted and sorted arrays to check results 
        System.out.println("\nUnsorted Array");
        printArray(randomArray);
        System.out.println("\nSorted Array");
        printArray(selectionSort(randomArray));

    }

    private static int[] selectionSort(int[] array)
    {
        // Start nested loop to itterate over values from first to last value
        for (int x = 0; x < array.length; x++)
        {
            for (int i =  x; i  < array.length; i++)
            {
                int index = 0;
                int minValue = array[x];
                
                if (array[i] < minValue)
                {
                    // Store minimun value found and it's location
                    minValue = array[i];
                    index = i;

                    // Use temp variable to swap values 
                    int temp = 0;
                    temp = array[x];
                    array[x] = minValue;
                    array[index] = temp;
                }

            }
        } 
        return array;
    }

    // Utility method to print array parameter
    private static void printArray(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }
}