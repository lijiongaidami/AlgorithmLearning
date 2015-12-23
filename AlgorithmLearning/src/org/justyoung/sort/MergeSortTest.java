package org.justyoung.sort;

public class MergeSortTest {
	private void merge(int[] a, int aBegin, int aLength, int[] b, int bBegin, int bLength) {
		int[] temp = new int[aLength + bLength];
		int i = aBegin, j = bBegin, k = 0;
		while (i < aBegin + aLength && j < bBegin + bLength) {
			if (a[i] <= b[j])
				temp[k++] = a[i++];
			else
				temp[k++] = b[j++];
		}
		if (i >= aBegin + aLength) {
			while (j < bBegin + bLength) {
				temp[k++] = b[j++];
			}
		} else if (j >= bBegin + bLength) {
			while (i < aBegin + aLength) {
				temp[k++] = a[i++];
			}
		}
		for (int m = 0; m < aLength + bLength; ++m) {
			a[aBegin + m] = temp[m];
		}
	}

	private void mergeSort(int[] a, int left, int right) {
		if (right <= left)
			return;
		int middle = (right + left) / 2;
		mergeSort(a, left, middle);
		mergeSort(a, middle + 1, right);
		merge(a, left, middle - left + 1, a, middle + 1, right - middle);
	}

	public static final void main(String[] args) {
		MergeSortTest test = new MergeSortTest();
		int[] a = { 5, 4, 3, 2, 1, 0, 9, 10, 11 };
		test.mergeSort(a, 0, 8);
		for (int i = 0; i < a.length; ++i) {
			System.out.println(a[i]);
		}
	}
}
