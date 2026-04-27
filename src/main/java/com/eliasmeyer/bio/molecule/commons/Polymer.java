package com.eliasmeyer.bio.molecule.commons;

import java.util.Objects;

public class Polymer<T> {

	protected final Sequence<T> sequence;

	public Polymer(Sequence<T> sequence) {
		Objects.requireNonNull(sequence, "sequence must not be null");
		this.sequence = sequence;
	}

	public Sequence<T> sequence() {
		return sequence;
	}

	public int length() {
		return sequence.size();
	}

	@Override
	public final boolean equals(Object o) {
		if (!(o instanceof Polymer<?> polymer)) {
			return false;
		}

		return sequence.equals(polymer.sequence);
	}

	@Override
	public int hashCode() {
		return sequence.hashCode();
	}

	@Override
	public String toString() {
		return "Polymer{" +
			"sequence=" + sequence +
			'}';
	}
}
