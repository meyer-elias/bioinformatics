package com.eliasmeyer.algorithms.combinatorics;

import com.eliasmeyer.algorithms.commons.AbstractCharInputProcessor;
import java.io.IOException;

/*
	https://rosalind.info/problems/perm/

	A permutation of length n is an ordering of the positive integers {1,2,…,n}. For example, π=(5,3,2,1,4)  is a permutation of length 5.

	Given: A positive integer n≤7.
	Return: The total number of permutations of length n, followed by a list of all such permutations (in any order).
 */

public class EnumeratingGeneOrders extends AbstractCharInputProcessor {

	static void main() throws IOException {
		EnumeratingGeneOrders enumeratingGeneOrders = new EnumeratingGeneOrders();
		enumeratingGeneOrders.readAndProcessInput();
	}

	private final StringBuilder output = new StringBuilder();
	private int[] array;
	private int count;

	@Override
	protected void processChar(char c) {
		int length = Integer.parseInt(String.valueOf(c));

		array = new int[length];
		for (int i = 0; i < length; i++) {
			array[i] = i + 1;
		}

		permute();
	}


	private void permute() {
		count = 0;
		output.setLength(0);
		permuteFrom(0);
	}

	private void permuteFrom(int index) {
		if (index == array.length) {
			for (int i = 0; i < array.length; i++) {
				if (i > 0) {
					output.append(' ');
				}
				output.append(array[i]);
			}
			output.append('\n');
			count++;
			return;
		}

		for (int i = index; i < array.length; i++) {
			swap(index, i);
			permuteFrom(index + 1);
			swap(index, i);
		}
	}

	private void swap(int i, int j) {
		if (i == j) {
			return;
		}
		int tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}

	@Override
	protected void printResult() {
		if (output.length() > 0) {
			output.setLength(output.length() - 1);
		}
		System.out.println(count);
		System.out.println(output);
	}

}
