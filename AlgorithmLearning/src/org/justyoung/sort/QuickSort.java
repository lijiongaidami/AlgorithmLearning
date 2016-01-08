package org.justyoung.sort;

public class QuickSort {

	void swap(int[] a, int left, int right) {
		int temp = a[left];
		a[left] = a[right];
		a[right] = temp;
	}

	int partition(int[] a, int left, int right) {
		int i = left;
		int j = right + 1;
		while (true) {
			while (a[++i] < a[left] && i < right)
				;
			while (a[left] < a[--j] && j > left)
				;
			if (i >= j)
				break;
			swap(a, i, j);
		}
		swap(a, left, j);
		return i;
	}

	void quickSort(int[] a, int left, int right) {
		if (left >= right)
			return;
		int tag = partition(a, left, right);
		quickSort(a, left, tag - 1);
		quickSort(a, tag + 1, right);
	}

	public static void main(String[] args) {
		QuickSort quick = new QuickSort();
		int a[] = { 2, 1 };
		// int a[] = { 7, 7, 1, 2, 6, 6, 4 };
		quick.quickSort(a, 0, a.length - 1);
		for (int i : a)
			System.out.println(i);
	}
}
