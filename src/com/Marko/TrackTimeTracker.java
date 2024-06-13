package com.Marko;

import java.util.Scanner;

/**
 * @author Marko Orlando
 * date 06/06/2024
 * Taking different Track and Field times results and finding the fastest, slowest, and average of those times
 */

public class TrackTimeTracker {

	/**
	 * Main method
	 * 
	 * @param args Command line arguments
	 */
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);

		// Ask user how many times they would like to submit and store that as an int
		System.out.println("How many times would you like to input?");
		System.out.print("> ");
		int size = input.nextInt();

		// Create an array of type int with user inputed specified size (i.e the number
		// of times they want to submit a time)
		int times[] = new int[size];

		// The input prompt loops only if the user has more than one time to submit
		for (int i = 0; i < size; i++) {
			if (i == 0) {
				System.out.println("Input the first time (in seconds)");
				System.out.print("> ");
			} else {
				System.out.println("Input the next time (in seconds");
				System.out.print("> ");
			}
			times[i] = input.nextInt();

		}

		// Each function is called to find the index (which will be found in the times
		// array) of the value at need
		int fastestTime = findFastest(times, 0, times.length - 1);

		int slowestTime = findSlowest(times, 0, times.length - 1);

		double totalAverage = findAverage(times);

		// Display the data
		System.out.println("The fastest time is " + fastestTime + " seconds");
		System.out.println("The slowest time is " + slowestTime + " seconds");
		System.out.println("The average time is " + totalAverage + " seconds");

	}

	/**
	 * Finds the fastest time among the runners
	 * 
	 * @param times An array of the runners' times
	 * @param left The index of the leftmost element in the array
	 * @param right The index of the rightmost element in the array
	 * @return The fastest time among the runners
	 */
	public static int findFastest(int[] times, int left, int right) {

	    // Base case: if the left and right elements are equal, then there is only one
	    // element, and we return it as the minimum
	    if (left == right) {
	        return times[left];
	    }

	    // Recursive case: divide the array into two halves, 
	    // find the minimum in each half, and then return the smaller of the two minimums
	    int mid = (left + right) / 2;
	    int minLeft = findFastest(times, left, mid);
	    int minRight = findFastest(times, mid + 1, right);

	    return Math.min(minLeft, minRight);
	}

	/**
	 * Finds the slowest time among the runners
	 * 
	 * @param times An array of the runners' times
	 * @param left The index of the leftmost element
	 * @param right The index of the rightmost element
	 * @return The slowest time among the runners
	 */
	public static int findSlowest(int[] times, int left, int right) {

		// Base case: if the left and right elements are equal, then there is only one
		// element, and we return it as the maximum
		if (left == right) {
			return times[left];
		}

		// Recursive case: divide the array into to halves 
		// find the max in each half, and then return the greater of the two maximums
		int mid = (left + right) / 2;
		int maxLeft = findSlowest(times, left, mid);
		int maxRight = findSlowest(times, mid + 1, right);

		return Math.max(maxLeft, maxRight);
	}

	/**
	 * Finds the average time
	 * 
	 * @param times An array of the runners times
	 * @return The average (mean) of all the times
	 */
	public static double findAverage(int[] times) {
		double average = 0;
		int total = 0;

		for (int i = 0; i < times.length; i++) {
			total = total + times[i];

		}
		average = (double) total / times.length;
		return average;

	}
}

// https://www.w3resource.com/java-exercises/recursive/java-recursive-exercise-12.php