package org.justyoung.sort;

public class BinarySearch {
	private static int binarySearch(int[] a, int value) {
		int start = 0;
		int end = a.length - 1;
		int middle = 0;
		while (start <= end) {
			middle = (start + end) >> 1;
			if (value == a[middle])
				return middle;
			if (value < a[middle]) {
				end = middle - 1;
				continue;
			}
			if (value > a[middle]) {
				start = middle + 1;
				continue;
			}
		}
		return -1;
	}

	public static void main(String[] args) {

		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8 };
		System.out.println(binarySearch(a, 6));
	}
}
