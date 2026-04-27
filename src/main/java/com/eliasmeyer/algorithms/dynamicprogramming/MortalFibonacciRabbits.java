package com.eliasmeyer.algorithms.dynamicprogramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Objects;

/*
 	https://rosalind.info/problems/fibd/

  	Recall the definition of the Fibonacci numbers from “Rabbits and Recurrence Relations”, which followed the recurrence relation Fn=Fn−1+Fn−2
   	and assumed that each pair of rabbits reaches maturity in one month and produces a single pair of offspring (one male, one female) each subsequent month.
	Our aim is to somehow modify this recurrence relation to achieve a dynamic programming solution in the case that all rabbits die out after a fixed number of months. See Figure 4 for a depiction of a rabbit tree in which rabbits live for three months (meaning that they reproduce only twice before dying).

	Given: Positive integers n≤100 and m≤20.
	Return: The total number of pairs of rabbits that will remain after the n-th month if all rabbits live for m months.
 */
public class MortalFibonacciRabbits {

	static void main() throws IOException {
		MortalFibonacciRabbits mortalFibonacciRabbits = new MortalFibonacciRabbits();
		mortalFibonacciRabbits.processInput();
	}

	public void processInput() throws IOException {
		try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
			String line;

			while (Objects.nonNull(line = reader.readLine()) && !line.isEmpty()) {
				String[] values = line.trim().split("\\s+");
				int months = Integer.parseInt(values[0]);   // n
				int lifespan = Integer.parseInt(values[1]); // m

				BigInteger result = rabbits(months, lifespan);
				IO.println(result.toString());
			}
		}
	}

	private BigInteger rabbits(int months, int lifespan) {
		if (months <= 0 || lifespan <= 0) {
			return BigInteger.ZERO;
		}

		// ages[i] = number of rabbit pairs with age i months (0 = newborn)
		BigInteger[] ages = new BigInteger[lifespan];
		Arrays.fill(ages, BigInteger.ZERO);
		ages[0] = BigInteger.ONE; // month 1

		for (int month = 2; month <= months; month++) {
			BigInteger newborns = BigInteger.ZERO;

			// Rabbits with age >= 1 reproduce
			for (int age = 1; age < lifespan; age++) {
				newborns = newborns.add(ages[age]);
			}

			// Age shift: oldest die, others get older
			for (int age = lifespan - 1; age >= 1; age--) {
				ages[age] = ages[age - 1];
			}

			// Newborns at age 0
			ages[0] = newborns;
		}

		BigInteger total = BigInteger.ZERO;
		for (BigInteger count : ages) {
			total = total.add(count);
		}

		return total;
	}

}
