package modules;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class DModule {

	public static <T extends Comparable<T>> int binarySearch(List<T> list, T target) {
		int min = 0;
		int max = list.size() - 1;
		int mid;

		while (min <= max) {
			mid = (min + max) / 2;

			if (list.get(mid).equals(target)) {
				return 0;
			} else if ((list.get(mid).compareTo(target)) > 0) {
				max = mid - 1;
			} else {
				min = mid + 1;
			}
		}
		return -1;
	}

	// bubble sort
	public static <T extends Comparable<T>> void bubbleSort(List<T> list) {
		// T temp = null;
		for (int i = 0; i < list.size(); i++) {
			for (int j = 1; j < list.size() - i; j++) {
				if (list.get(j).compareTo(list.get(j - 1)) < 0) {
					T firstObject = list.get(j);
					T secondObject = list.get(j - 1);
					swap(list, firstObject, secondObject);
				}
			}
		}
	}

	// sorts an array using insertion sort;
	public static <T extends Comparable<T>> void insertionSort(List<T> list) {
		int j;
		for (int i = 1; i < list.size(); i++) {
			j = i;
			while (j > 0 && (list.get(j).compareTo(list.get(j - 1)) < 0)) {

				T firstObject = list.get(j);
				T secondObject = list.get(j - 1);
				swap(list, firstObject, secondObject);
				--j;
			}
		}
	}

	// sorts an array descending order;
	public static <T extends Comparable<T>> void maxInsertionSort(List<T> list) {
		int j;
		for (int i = 1; i < list.size(); i++) {
			j = i;
			while (j > 0 && (list.get(j).compareTo(list.get(j - 1)) > 0)) {
				T firstObject = list.get(j);
				T secondObject = list.get(j - 1);
				swap(list, firstObject, secondObject);
				--j;
			}
		}
	}

	// uses selection sort to sort the list
	public static <T> void selectionSort(List<T> list, Comparator<T> comp) {
		int minIndex;

		for (int i = 0; i < list.size() - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < list.size(); j++) {
				if ((comp.compare(list.get(j), list.get(j - 1)) < 0)) {
					minIndex = j;
				}
			}
			if (minIndex != i) {
				swap(list, minIndex, i);
			}
		}
	}

	// partitions the list for quick sort
	public static <T extends Comparable<T>> int partition(List<T> data, int l, int h) {
		int midpoint = (l + h) / 2;
		T pivot = data.get(midpoint);
		boolean done = false;

		while (!done) {
			while (data.get(l).compareTo(pivot) < 0) {
				++l;
			}
			while (pivot.compareTo(data.get(h)) < 0) {
				--h;
			}
			if (l >= h) {
				done = true;
			} else {
				swap(data, l, h);
				++l;
				--h;
			}
		}
		return h;
	}

	// uses partition & recursively calls its self to sort the array
	public static <T extends Comparable<T>> void quickSort(List<T> list, int low, int high) {
		int mid;
		// Base case: If there are no entries to sort
		if (low >= high) {
			return; // do nothing
		}
		mid = partition(list, low, high);
		quickSort(list, low, mid);
		quickSort(list, mid + 1, high);
	}

	public static <T extends Comparable<T>> void quickSort(List<T> list) {
		quickSort(list, 0, list.size() - 1);
	}

	// merges to lists together for the merge sort algorithm
	public static <T extends Comparable<T>> void merge(List<T> data, List<T> left, List<T> right) {
		int index = 0; // index of data array
		int leftIndex = 0; // index in left array
		int rightIndex = 0; // index in right array
		while (leftIndex < left.size() && rightIndex < right.size()) {
			if (left.get(rightIndex).compareTo(right.get(rightIndex)) < 0)
				data.set(rightIndex++, left.get(leftIndex++));
			else
				data.set(index++, right.get(rightIndex++));
		}

		while (leftIndex < left.size()) {
			data.set(index++, left.get(leftIndex++));

		}
		while (rightIndex < right.size()) {
			data.set(index++, right.get(rightIndex++));

		}
	}

	// sorts list of items in ascending order using the merge sort algorithm
	public static <T extends Comparable<T>> void mergeSort(List<T> data) {
		// split array into halves
		if (data.size() > 1) {
			List<T> left = splitFirstHalf(data);
			List<T> right = splitSecondHalf(data);

			// sort the two halves
			mergeSort(left);
			mergeSort(right);

			// merge the sorted halves into a sorted whole
			merge(data, left, right);
		}
	}

	// returns a list with the first half
	public static <T> List<T> splitFirstHalf(List<T> list) {
		int length = (list.size() - 1) / 2;
		ArrayList<T> newList = new ArrayList<T>();

		for (int i = 0; i <= length; i++) {
			newList.add(list.get(i));
		}
		return newList;
	}

	// returns a list with the second half
	public static <T> List<T> splitSecondHalf(List<T> list) {
		int length = ((list.size() - 1) / 2) + 1;
		ArrayList<T> newList = new ArrayList<T>();
		for (int i = length; i < list.size(); i++) {
			newList.add(list.get(i));
		}
		return newList;
	}

	// swaps using the index of the objects
	public static <T> void swap(List<T> list, int first, int second) {
		T temp = list.get(first);
		T temp2 = list.get(second);

		list.set(first, temp2);
		list.set(second, temp);
	}

	// Swaps the actual objects
	public static <T> void swap(List<T> list, T first, T second) {
		int firstIndex = list.indexOf(first);
		int secondIndex = list.indexOf(second);
		T temp = first;

		list.set(firstIndex, second);
		list.set(secondIndex, temp);
	}

}
