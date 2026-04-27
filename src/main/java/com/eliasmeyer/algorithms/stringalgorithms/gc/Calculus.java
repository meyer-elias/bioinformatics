package com.eliasmeyer.algorithms.stringalgorithms.gc;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.concurrent.Callable;

public class Calculus implements Callable<GCContent> {

	private final String id;
	private final String sequence;

	public Calculus(String id, String sequence) {
		this.id = id;
		this.sequence = sequence;
	}

	@Override
	public GCContent call() {
		int count = 0;
		for (int i = 0; i < sequence.length(); i++) {
			if ((sequence.charAt(i) == 'C') ||
				(sequence.charAt(i) == 'G')) {
				count++;
			}
		}
		BigDecimal percent;
		if (sequence.isEmpty()) {
			percent = BigDecimal.ZERO;
		} else {
			percent = BigDecimal.valueOf(count)
				.multiply(BigDecimal.valueOf(100))
				.divide(BigDecimal.valueOf(sequence.length()), 6, RoundingMode.HALF_UP);
		}
		return new GCContent(id, sequence, percent);
	}
}
