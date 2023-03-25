import java.util.Random;
import java.util.Scanner;

public class Arrays {
    public static void main(String[] args) {
        // part 1A
        // Array declarations
        final int ARRAY_LENGTH = 100; // constant var for array length
        int[] dataPoints = new int[ARRAY_LENGTH]; // creates an array with 100 integer values, index 0-99
        // part 1B
        Random rnd = new Random(); // sets up random generator
        Scanner in = new Scanner(System.in); // sets up scanner class
        for (int index = 0; index < dataPoints.length; index++) {
            dataPoints[index] = rnd.nextInt(100) + 1; // generates a random value from 1 to 100
        }
        // part 1C
        for (int index = 0; index < dataPoints.length; index++) {
            System.out.print(" " + dataPoints[index] + " " + "|"); // prints out each value in data points with a bar
        }
        // part 1D: sum and average
        int sum = 0; // declares sum var
        for (int index = 0; index < dataPoints.length; index++) {
            sum += dataPoints[index]; //adds the value of every number in dataPoints to the sum var
        }
        System.out.println("\nThe sum of the random array dataPoints is: " + sum); // displays sum
        int average = sum / dataPoints.length; // finds average
        System.out.println("The average of the random array dataPoints is: " + average); // displays average
        // part 2A
        int searchTarget = SafeInput.getRangedInt(in, "Enter a integer value to see how many times it occurs in the random array dataPoints ", 1, 100); // takes input using safe input method and stores it in var
        // part 2B
        int numberOfTimes = 0; // var to store number of times
        for (int index = 0; index < dataPoints.length; index++) {
            if (dataPoints[index] == searchTarget) // tests if the target value is found in the array
            {
                numberOfTimes++; // adds one to number of times
            }
        }

        System.out.println("The number of times the searched value was found is: " + numberOfTimes); // displays the number of times

        // Part 2C
        int targetSearch = SafeInput.getRangedInt(in, "Enter a integer value to search for in the random array dataPoints to get the index that it occurs on first ", 1, 100); // takes input using safe input method and stores it in var
        boolean foundTarget = false; // declaration of var that states if target is found in the array or not.
        for (int index = 0; index < dataPoints.length; index++) {
            if (dataPoints[index] == targetSearch) // tests if the target value is found in the array
            {
                foundTarget = true; // sets to true if test is passed
                System.out.println("Breaking! The value " + targetSearch + " was found at index " + index); // outputs message to show that the value was found
                break; // breaks on the first time value is found
            }
        }
        if (!foundTarget) // if value is not found
        {
            System.out.println("The value " + targetSearch + " was not found in the array"); // outputs message if target value was not found in the array.
        }
// part 2D
        int min = dataPoints[0]; // min var
        int max = dataPoints[0]; // max var
        for (int index = 0; index < dataPoints.length; index++) {
            if (min > dataPoints[index]) // tests if min is greater than the value in the array
            {
                min = dataPoints[index]; // the value becomes the new min if test is passed
            }
            if (max < dataPoints[index]) // tests if the max is less than the value in the array
            {
                max = dataPoints[index]; // the value becomes the new max if the test is passed
            }
        }
        System.out.println("The minimum value is " + min); // displays min
        System.out.println("The maximum value is " + max); // displays max
// part 2E print in main
        System.out.println("The double average of dataPoints is: " + getAverage(dataPoints)); // displays double average
        // Extra credit printing in main
        System.out.println("\n\nExtra credit:\n");
        System.out.println("The minimum of dataPoints is: " + min(dataPoints)); // displays max
        System.out.println("The maximum of dataPoints is: " + max(dataPoints)); // displays min
        System.out.println("The value 1 is found this many times in the array dataPoints: " + occurrenceScan(dataPoints,1)); // uses occurrence scan method
        System.out.println("The sum of the array dataPoints is: " + sum(dataPoints)); // displays sum
        System.out.println("The value 1 is present in the array dataPoints: " + contains(dataPoints,1));

    }

    //part 2E method
    /**
     * @param values a integer array
     * @return a double average of the array
     */
    public static double getAverage(int values[]) {
        double sum = 0; // declares sum var
        for (int index = 0; index < values.length; index++) {
            sum += values[index]; //adds the value of every number in the array to the sum var
        }

        double average = sum / values.length; // finds average

        return average;
    }

    //extra credit
    /**
     * @param values a integer array
     * @return a integer min of the array
     */
    public static int min(int values[]) {
        int min = values[0]; // min var
        for (int index = 0; index < values.length; index++) {
            if (min > values[index]) // tests if min is greater than the value in the array
            {
                min = values[index]; // the value becomes the new min if test is passed
            }

        }
        return min;
    }
    /**
     * @param values a integer array
     * @return a integer max of the array
     */
    public static int max(int values[]) {
        int max = values[0]; // max var
        for (int index = 0; index < values.length; index++) {
            if (max < values[index]) // tests if the max is less than the value in the array
            {
                max = values[index]; // the value becomes the new max if the test is passed
            }
        }

        return max;
    }
    /**
     * @param values a integer array
     * @param target a integer value to search for in the array
     * @return the number of times the value is found in the array
     */
    public static int occurrenceScan(int values[], int target) {
        int numberOfTimes = 0; // var to store number of times
        for (int index = 0; index < values.length; index++) {
            if (values[index] == target) // tests if the target value is found in the array
            {
                numberOfTimes++; // adds one to number of times
            }
        }
        return numberOfTimes;
    }
    /**
     * @param values a integer array
     * @return the sum of the array
     */
    public static int sum(int values[]) {
        int sum = 0; // declares sum var
        for (int index = 0; index < values.length; index++) {
            sum += values[index]; //adds the value of every number in dataPoints to the sum var
        }
        return sum;
    }
    /**
     * @param values a integer array
     * @param target a integer value to search for in the array
     * @return a true or false statement describing if the value was found in the array or not
     */
    public static boolean contains(int values[], int target) {
        boolean foundTarget = false; // declaration of var that states if target is found in the array or not.
        for (int index = 0; index < values.length; index++)
        {
            if (values[index] == target) // tests if the target value is found in the array
            {
                foundTarget = true; // sets to true if test is passed
            }
        }
        if (!foundTarget) // if value is not found
        {
            foundTarget = false;
        }
        return foundTarget;

    }
}