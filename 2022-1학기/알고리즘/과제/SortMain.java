
import java.util.Random;
import java.util.concurrent.TimeUnit;

class Sorting {
	public static void insertionSort(int[] a) {
		for (int i = 1; i < a.length; i++) {
			int temp = a[i];
			int j;
			for (j = i - 1; j >= 0 && temp < a[j]; j--) {
				a[j + 1] = a[j];
			}
			a[j + 1] = temp;
		}
	}

	public static void selectionSort(int[] a) {
		int n = a.length;

		for (int i = 0; i < n - 1; i++) {
			int min_idx = i;
			for (int j = i + 1; j < n; j++)
				min_idx = j;

			int temp = a[min_idx];
			a[min_idx] = a[i];
			a[i] = temp;
		}
	}

	public static void bubbleSort(int[] arr, int n) {
		int i, j, temp;
		boolean swapped;
		for (i = 0; i < n - 1; i++) {
			for (j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap arr[j] and arr[j+1]
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	public static void flagbubbleSort(int[] arr, int n) {
		int i, j, temp;
		boolean swapped;
		for (i = 0; i < n - 1; i++) {
			swapped = false;
			for (j = 0; j < n - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					// swap arr[j] and arr[j+1]
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
					swapped = true;
				}
			}
			// IF no two elements were
			// swapped by inner loop, then break
			if (swapped == false)
				break;
		}
	}

	public static int partition(int a[], int i, int j) {
		int pivot = a[i]; // leftmost value
		int p = i;
		int temp;
		for (int k = i + 1; k <= j; k++) { // find the element<pivot
			if (a[k] < pivot) {
				p = p + 1;
				temp = a[p];
				a[p] = a[k];
				a[k] = temp;
			}
		}
		temp = a[i];
		a[i] = a[p];
		a[p] = temp;
		return p;
	}

	public static void internalQuickSort(int[] a, int m, int n) {
		int p;
		if (m >= n) {
			return;
		}
		p = partition(a, m, n);
		internalQuickSort(a, m, p - 1); // left part
		internalQuickSort(a, p + 1, n); // right part
	}

	public static void quickSort(int[] a) {
		internalQuickSort(a, 0, a.length - 1);
	}

	public static void printArray(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.println(a[i]);
		}
	}
}

public class SortMain {
	private static int SIZE = 5000000;
	private static final int MAX = 1000;

	public static void main(String[] args) {

		int arr[] = new int[SIZE];
		int tmparr[] = new int[SIZE];
		Random r = new Random();
		for (int i = 0; i < SIZE; i++) {
			arr[i] = r.nextInt(MAX);
		}
		Sorting.printArray(arr);
		Sorting.insertionSort(arr);
		for (int i = 0; i < SIZE; i++) {
			tmparr[i] = arr[i];
		}
		for (int i = 0; i < SIZE; i++) {
			arr[i] = tmparr[SIZE - 1 - i];
		}
		Sorting.printArray(arr);
		long start = System.currentTimeMillis();
//		Sorting.insertionSort(arr);
		Sorting.selectionSort(arr);
//		Sorting.bubbleSort(arr, SIZE);
//		Sorting.flagbubbleSort(arr, SIZE);
//		Sorting.quickSort(arr);

		long end = System.currentTimeMillis();
		System.out.println(" Execution Time =" + (end - start));
		// Sorting.printArray(arr);
	}

}
