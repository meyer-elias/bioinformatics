package com.eliasmeyer.algorithms.probability;

import com.eliasmeyer.algorithms.commons.AbstractLineInputProcessor;
import java.io.IOException;

/*
 * https://rosalind.info/problems/iprb/
 *
 * Given: Three positive integers k, m, and n, representing a population containing k+m+n organisms, where k represents
 * homozygous dominant, m represents heterozygous, and n represents homozygous recessive.
 * Return: The probability that two randomly selected mating organisms will produce an organism with a dominant phenotype.
 */
public class MendelsFirstLaw extends AbstractLineInputProcessor {

	private double probability;

	static void main() throws IOException {
		new MendelsFirstLaw().readAndProcessInput();
	}


	@Override
	protected void processLine(String line) {
		String[] parts = line.split("\\s+");

		int k = Integer.parseInt(parts[0]);
		int m = Integer.parseInt(parts[1]);
		int n = Integer.parseInt(parts[2]);

		probability = dominantPhenotypeProbability(k, m, n);
	}

	@Override
	protected void printResult() {
		System.out.printf("%.5f%n", probability);
	}

	double dominantPhenotypeProbability(int k, int m, int n) {
		double total = k + m + n;

		double recessiveFromNN = (n / total) * ((n - 1) / (total - 1));
		double recessiveFromMN = (m / total) * (n / (total - 1)) * 0.5;
		double recessiveFromNM = (n / total) * (m / (total - 1)) * 0.5;
		double recessiveFromMM = (m / total) * ((m - 1) / (total - 1)) * 0.25;

		double recessive = recessiveFromNN + recessiveFromMN + recessiveFromNM + recessiveFromMM;
		return 1.0 - recessive;
	}
}