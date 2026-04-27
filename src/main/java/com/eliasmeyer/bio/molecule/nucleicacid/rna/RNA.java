package com.eliasmeyer.bio.molecule.nucleicacid.rna;

import com.eliasmeyer.bio.molecule.commons.Sequence;
import com.eliasmeyer.bio.molecule.nucleicacid.commons.NucleicAcid;
import com.eliasmeyer.bio.molecule.nucleicacid.dna.DNA;
import java.util.List;
import java.util.Locale;

public class RNA extends NucleicAcid<RNABase> {

	public RNA(Sequence<RNABase> sequence) {
		super(sequence);
	}

	public RNA(String raw) {
		super(buildSequence(raw));
	}

	private static Sequence<RNABase> buildSequence(String raw) {
		if (raw == null || raw.isBlank()) {
			throw new IllegalArgumentException("RNA sequence must not be null or blank");
		}

		List<RNABase> bases = raw.trim()
			.toUpperCase(Locale.ROOT)
			.chars()
			.mapToObj(c -> parseBase((char) c))
			.toList();

		return new Sequence<>(bases.toArray(RNABase[]::new));
	}


	private static RNABase parseBase(char symbol) {
		try {
			return RNABase.valueOf(String.valueOf(symbol));
		} catch (IllegalArgumentException ex) {
			throw new IllegalArgumentException(
				"Invalid RNA base: '" + symbol + "'. Allowed: A, U, C, G", ex
			);
		}
	}

	public DNA reverseTranscribe() {
		return new DNA(new Sequence<>(sequence.map(RNABase::toDNA)));
	}

	@Override
	public String toString() {
		return "RNA{" +
			"sequence=" + sequence +
			'}';
	}
}