package org.justyoung.sort;

public class InsertionSort {
	static void swap(int a[], int i, int j) {
		assert i < a.length && i > 0 && j < a.length && j >= 0;
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	static void insertionSort(int[] a) {
		if (a.length <= 1) {
			return;
		}
		for (int i = 1; i < a.length; ++i) {
			if (a[i] < a[i - 1]) {
				for (int j = i; j >= 1; --j) {
					if (a[j] < a[j - 1]) {
						swap(a, j - 1, j);
					} else {
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args) {
		int a[] = { 6, 2, 8, 4, 13, 9, 5, 3, 9 };
		insertionSort(a);
		for (int i : a) {
			System.out.println(i);
		}
	}
}
