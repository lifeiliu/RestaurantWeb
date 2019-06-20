package com.virtualpairprogrammers.main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class test {
	public static void main(String[] args) {
		List<int[]> twoD = new ArrayList<>();
		int[] arr1 = new int[30];
		int[] arr2 = new int[5];
		for (int i = 0; i < arr1.length; i++) {
			arr1[i] = i;
		}
		for (int i = 0; i < arr2.length; i++) {
			arr2[i] = i * 5;
		}
		twoD.add(arr1);
		twoD.add(arr2);

		for (int[] arr : twoD) {
			System.out.println(Arrays.toString(arr));
		}
	}
}
