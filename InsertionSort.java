import java.util.*;

public class InsertionSort
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
        printArray(insertionSort(randomArray));

    }

    private static int[] insertionSort(int[] array)
    {
        for (int i = 1; i < array.length; i++)
        {
            int currentValue = array[i];
            int previousIndex = i - 1;

            // While loop for iterating back down array checking previous values
            while(previousIndex >= 0 && array[previousIndex] > currentValue)
            {
                // Swap values
                array[previousIndex + 1] = array[previousIndex];
                // Move down the array
                previousIndex--;
            }
            array[previousIndex + 1] = currentValue;
        }
        return array;
    }

    // Utility method to print passed array
    private static void printArray(int[] array)
    {
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }
}