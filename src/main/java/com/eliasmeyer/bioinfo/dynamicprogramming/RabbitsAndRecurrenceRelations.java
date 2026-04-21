package com.eliasmeyer.bioinfo.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

/*
	https://rosalind.info/problems/fib/

	Call the definition of the Fibonacci numbers from “Rabbits and Recurrence Relations”, which followed the recurrence relation Fn=Fn−1+Fn−2
	and assumed that each pair of rabbits reaches maturity in one month and produces n pair of offspring (one male, one female) each subsequent month.

	When finding the n -th term of a sequence defined by a recurrence relation, we can simply use the recurrence relation to generate terms for progressively
	larger values of n. This problem introduces us to the computational technique of dynamic programming, which successively builds up solutions by using the
	answers to smaller cases.

	Given: Positive integers n≤40 and k≤5.
	Return: The total number of rabbit pairs that will be present after n months, if we begin with 1 pair and in each generation, every pair of
			reproduction-age rabbits produces a litter of k rabbit pairs (instead of only 1 pair).
*/
public class RabbitsAndRecurrenceRelations {

	static void main() throws IOException {
		RabbitsAndRecurrenceRelations rabbitsAndRecurrenceRelations = new RabbitsAndRecurrenceRelations();
		rabbitsAndRecurrenceRelations.processInput();
	}

	public void processInput() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while (Objects.nonNull(line = reader.readLine()) && !line.isEmpty()) {
			String[] digits = line.split(" ");
			// n is the number of months
			// k is the number of rabbits born per pair
			int n = Integer.parseInt(digits[0]);
			int k = Integer.parseInt(digits[1]);

			long result = rabbits(n, k);
			IO.println(result);
		}
		reader.close();
	}

	private long rabbits(int n, int k) {
		long parents = 1;
		long pairs = 1;

		if (n <= 2) {
			return pairs;
		}

		long children = 0;
		for (int i = 3; i <= n; i++) {
			long temp = children;
			parents = (parents + temp);
			children = (parents - children) * k;
			pairs = parents + children;
		}

		return pairs;
	}
}
