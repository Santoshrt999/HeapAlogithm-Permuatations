package com.graphs;

import java.util.*;

public class HeapAlgorithm {
	
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> outer = new ArrayList<>();
		List<Integer> inner = new ArrayList<>();

		for(int num: nums){
			inner.add(num);
		}

		permute(nums.length, inner, outer);
		return outer;

	}

	private void permute(int n, List<Integer> inner, List<List<Integer>> outer){
		if(n == 0){
			outer.add(new ArrayList<Integer>(inner));
			return;
		}

		for(int i = 0; i < n; i ++){
			permute(n - 1, inner, outer);

			//if odd swap 0 with n-1.
			if(n % 2 == 1){
				swap(inner, 0, n - 1);
				// Collections.swap(inner, inner.get(0), inner.get(n-1));
			}
			else{
				swap(inner, i, n - 1);
			}
		}
	}

	private void swap(List<Integer> inner, int i, int j){
		int temp = inner.get(i);
		inner.set(i, inner.get(j));
		inner.set(j, temp);
	} 

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr = new int[] {1,2,3};
		
		System.out.println(new HeapAlgorithm().permuteUnique(arr));

	}

}
