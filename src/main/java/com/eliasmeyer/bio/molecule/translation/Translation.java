package com.eliasmeyer.bio.molecule.translation;

import com.eliasmeyer.bio.molecule.commons.Sequence;
import com.eliasmeyer.bio.molecule.commons.codon.Amino;
import com.eliasmeyer.bio.molecule.commons.codon.Codon;
import com.eliasmeyer.bio.molecule.commons.codon.CodonIterable;
import com.eliasmeyer.bio.molecule.commons.codon.CodonTranslation;
import com.eliasmeyer.bio.molecule.commons.codon.Stop;
import com.eliasmeyer.bio.molecule.protein.AminoAcid;
import com.eliasmeyer.bio.molecule.protein.Protein;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Translation<T> {

	private final GeneticCode<T> geneticCode;

	public Translation(GeneticCode<T> geneticCode) {
		this.geneticCode = geneticCode;
	}

	public Protein from(Sequence<T> sequence) {
		return from(sequence, 0);
	}

	public Protein from(Sequence<T> sequence, int frame) {
		return new Protein(
			new CodonIterable<>(sequence, frame)
				.stream()
				.map(geneticCode::translate)
				.takeWhile(t -> !(t instanceof Stop))
				.map(t -> ((Amino) t).value())
				.collect(Sequence.collector())
		);
	}

	public Set<Protein> allOrfs(Sequence<T> sequence,
		java.util.function.Predicate<Codon<T>> isStartCodon) {
		if (sequence == null) {
			throw new IllegalArgumentException("sequence must not be null");
		}
		if (isStartCodon == null) {
			throw new IllegalArgumentException("isStartCodon must not be null");
		}

		Set<Protein> proteins = new LinkedHashSet<>();

		for (int i = 0; i + 2 < sequence.size(); i++) {
			Codon<T> codon = new Codon<>(sequence, i);
			if (isStartCodon.test(codon)) {
				fromStartUntilStop(sequence, i).ifPresent(proteins::add);
			}
		}

		return proteins;
	}

	private Optional<Protein> fromStartUntilStop(Sequence<T> sequence, int startOffset) {
		if (sequence == null) {
			throw new IllegalArgumentException("sequence must not be null");
		}
		if (startOffset < 0 || startOffset + 2 >= sequence.size()) {
			return Optional.empty();
		}

		List<AminoAcid> aminoAcids = new ArrayList<>();

		for (int offset = startOffset; offset + 2 < sequence.size(); offset += 3) {
			Codon<T> codon = new Codon<>(sequence, offset);
			CodonTranslation translated = geneticCode.translate(codon);

			if (translated instanceof Stop) {
				return Optional.of(new Protein(aminoAcids.stream().collect(Sequence.collector())));
			}

			Amino amino = (Amino) translated;
			aminoAcids.add(amino.value());
		}

		// ORF invalid if it never reaches Stop
		return Optional.empty();
	}

}
