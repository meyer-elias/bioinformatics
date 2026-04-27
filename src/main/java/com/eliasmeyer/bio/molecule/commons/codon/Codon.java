package com.eliasmeyer.bio.molecule.commons.codon;

import com.eliasmeyer.bio.molecule.commons.Sequence;
import java.util.Objects;

public class Codon<T> {

	private final Sequence<T> sequence;

	private final int offset;

	public Codon(Sequence<T> sequence, int offset) {
		this.sequence = Objects.requireNonNull(sequence, "sequence must not be null");
		this.offset = offset;

		if (offset < 0 || offset + 2 >= sequence.size()) {
			throw new IllegalArgumentException(
				"Invalid offset " + offset + " for sequence size " + sequence.size()
			);
		}
	}

	public T first() {
		return sequence.get(offset);
	}

	public T second() {
		return sequence.get(offset + 1);
	}

	public T third() {
		return sequence.get(offset + 2);
	}

	public Sequence<T> elements() {
		return new Sequence<>(first(), second(), third());
	}

	public String asString() {
		return "" + first() + second() + third();
	}

	public int offset() {
		return offset;
	}
}
