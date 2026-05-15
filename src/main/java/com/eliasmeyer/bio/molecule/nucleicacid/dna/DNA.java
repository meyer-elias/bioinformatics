package com.eliasmeyer.bio.molecule.nucleicacid.dna;

import com.eliasmeyer.bio.molecule.commons.Sequence;
import com.eliasmeyer.bio.molecule.nucleicacid.commons.NucleicAcid;
import com.eliasmeyer.bio.molecule.nucleicacid.rna.RNA;
import java.util.UUID;

public class DNA extends NucleicAcid<DNABase> {

	private final String id;

	public DNA(Sequence<DNABase> sequence, String id) {
		super(sequence);
		this.id = id;
	}

	public DNA(Sequence<DNABase> sequence) {
		super(sequence);
		this.id = UUID.randomUUID().toString();
	}

	public DNA(String raw) {
		this(new Sequence<>(raw, DNA::parseBase));
	}

	private static DNABase parseBase(char symbol) {
		try {
			return DNABase.valueOf(String.valueOf(symbol));
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException(
				"Invalid DNA base: '" + symbol + "'. Allowed: A, T, C, G", ex
			);
		}
	}

	public String id() {
		return id;
	}

	public Sequence<Integer> motifLocations(DNA motif) {
		Sequence<DNABase> source = this.sequence();
		Sequence<DNABase> pattern = motif.sequence();

		if (pattern.size() > source.size()) {
			return new Sequence<>(new Integer[0]);
		}

		Integer[] positions = new Integer[source.size() - pattern.size() + 1];
		int count = 0;

		for (int i = 0; i <= source.size() - pattern.size(); i++) {
			if (matchesAt(source, pattern, i)) {
				positions[count++] = i + 1; // 1-based
			}
		}

		Integer[] result = new Integer[count];
		System.arraycopy(positions, 0, result, 0, count);
		return new Sequence<>(result);
	}

	private boolean matchesAt(Sequence<DNABase> source, Sequence<DNABase> motif, int start) {
		for (int j = 0; j < motif.size(); j++) {
			if (source.get(start + j) != motif.get(j)) {
				return false;
			}
		}
		return true;
	}

	public Sequence<DNABase> complementary() {
		return sequence.map(DNABase::complement);
	}

	public boolean isReversePalindrome() {
		Sequence<DNABase> complementary = complementary();
		return sequence.equals(complementary);
	}

	public boolean isReversePalindrome(int start, int length) {
		for (int i = 0; i < length; i++) {
			var forward = sequence.get(start + i);
			var complement = sequence.get(start + length - 1 - i).complement();

			if (forward != complement) {
				return false;
			}
		}
		return true;
	}

	public RNA transcribe() {
		return new RNA(sequence.map(DNABase::toRNA));
	}

	@Override
	public String toString() {
		return "DNA{" +
			"sequence=" + sequence +
			'}';
	}
}