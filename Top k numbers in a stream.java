import java.io.*;
import java.util.*;
class GFG {

	// function to search in top vector for element
	static int find(int[] arr, int ele)
	{
		for (int i = 0; i < arr.length; i++)
			if (arr[i] == ele)
				return i;
		return -1;
	}

	// Function to print top k numbers
	static void kTop(int[] a, int n, int k)
	{
		// vector of size k+1 to store elements
		int[] top = new int[k + 1];

		// array to keep track of frequency
		HashMap<Integer, Integer> freq = new HashMap<>();
		for (int i = 0; i < k + 1; i++)
			freq.put(i, 0);

		// iterate till the end of stream
		for (int m = 0; m < n; m++) {
			// increase the frequency
			if (freq.containsKey(a[m]))
				freq.put(a[m], freq.get(a[m]) + 1);
			else
				freq.put(a[m], 1);

			// store that element in top vector
			top[k] = a[m];

			// search in top vector for same element
			int i = find(top, a[m]);
			i -= 1;

			// iterate from the position of element to zero
			while (i >= 0) {
				// compare the frequency and swap if higher
				// frequency element is stored next to it
				if (freq.get(top[i]) < freq.get(top[i + 1])) {
					int temp = top[i];
					top[i] = top[i + 1];
					top[i + 1] = temp;
				}

				// if frequency is same compare the elements
				// and swap if next element is high
				else if ((freq.get(top[i]) == freq.get(top[i + 1])) && (top[i] > top[i + 1])) {
					int temp = top[i];
					top[i] = top[i + 1];
					top[i + 1] = temp;
				}

				else
					break;
				i -= 1;
			}

			// print top k elements
			for (int j = 0; j < k && top[j] != 0; ++j)
				System.out.print(top[j] + " ");
		}
		System.out.println();
	}

	// Driver program to test above function
	public static void main(String args[])
	{
		int k = 4;
		int[] arr = { 5, 2, 1, 3, 2 };
		int n = arr.length;
		kTop(arr, n, k);
	}
}

// This code is contributed by rachana soma
