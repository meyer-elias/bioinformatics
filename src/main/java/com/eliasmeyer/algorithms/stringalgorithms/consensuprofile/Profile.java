package com.eliasmeyer.algorithms.stringalgorithms.consensuprofile;

import com.eliasmeyer.bio.molecule.nucleicacid.dna.DNABase;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;

public class Profile {

	private final EnumMap<DNABase, List<Integer>> frequencies = new EnumMap<>(DNABase.class);
	private int length = -1;

	public Profile() {
		frequencies.put(DNABase.A, new ArrayList<>());
		frequencies.put(DNABase.C, new ArrayList<>());
		frequencies.put(DNABase.G, new ArrayList<>());
		frequencies.put(DNABase.T, new ArrayList<>());
	}

	void compute(List<DNABase> sequence) {
		if (sequence == null || sequence.isEmpty()) {
			throw new IllegalArgumentException("sequence must not be null or empty");
		}

		if (length == -1) {
			length = sequence.size();
			ensureLength(length);
		} else if (sequence.size() != length) {
			throw new IllegalArgumentException(
				"all sequences must have same length: expected " + length + ", got "
					+ sequence.size()
			);
		}

		for (int i = 0; i < sequence.size(); i++) {
			DNABase base = sequence.get(i);
			List<Integer> counts = frequencies.get(base);
			counts.set(i, counts.get(i) + 1);
		}
	}

	public List<Integer> countsOf(DNABase base) {
		return Collections.unmodifiableList(frequencies.get(base));
	}

	public int length() {
		return Math.max(length, 0);
	}

	public String consensus() {
		if (length <= 0) {
			return "";
		}

		StringBuilder sb = new StringBuilder(length);
		for (int i = 0; i < length; i++) {
			DNABase best = DNABase.A;
			int bestCount = frequencies.get(DNABase.A).get(i);

			// Tie-break deterministic: A, C, G, T
			for (DNABase base : List.of(DNABase.C, DNABase.G, DNABase.T)) {
				int count = frequencies.get(base).get(i);
				if (count > bestCount) {
					best = base;
					bestCount = count;
				}
			}

			sb.append(best.name());
		}

		return sb.toString();
	}

	private void ensureLength(int length) {
		for (DNABase base : List.of(DNABase.A, DNABase.C, DNABase.G, DNABase.T)) {
			List<Integer> counts = frequencies.get(base);
			counts.clear();
			counts.addAll(Collections.nCopies(length, 0));
		}
	}

}
