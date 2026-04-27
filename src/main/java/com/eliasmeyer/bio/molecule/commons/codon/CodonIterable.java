package com.eliasmeyer.bio.molecule.commons.codon;

import com.eliasmeyer.bio.molecule.commons.Sequence;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class CodonIterable<T> implements Iterable<Codon<T>> {

	public static final int FRAME_COUNT = 3;

	private static final int CODON_SIZE = 3;

	private final Sequence<T> sequence;

	private final int frame;

	public CodonIterable(Sequence<T> sequence, int frame) {
		this.sequence = Objects.requireNonNull(sequence, "sequence must not be null");
		if (frame < 0 || frame > 2) {
			throw new IllegalArgumentException("frame must be 0, 1 or 2");
		}
		this.frame = frame;
	}

	@Override
	public Iterator<Codon<T>> iterator() {
		return new Iterator<>() {
			private int offset = frame;

			@Override
			public boolean hasNext() {
				return offset + CODON_SIZE - 1 < sequence.size();
			}

			@Override
			public Codon<T> next() {
				if (!hasNext()) {
					throw new NoSuchElementException();
				}
				Codon<T> codon = new Codon<>(sequence, offset);
				offset += CODON_SIZE;
				return codon;
			}
		};
	}

	public Stream<Codon<T>> stream() {
		return StreamSupport.stream(spliterator(), false);
	}
}
