package com.eliasmeyer.bio.molecule.nucleicacid.rna;

import com.eliasmeyer.bio.molecule.commons.Sequence;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class RNACodonIterator implements Iterator<RNACodon> {

	private final Sequence<RNABase> sequence;

	private int index;

	public RNACodonIterator(Sequence<RNABase> sequence, int index) {
		this.sequence = sequence;
		this.index = index;
	}

	@Override
	public boolean hasNext() {
		return index + 2 < sequence.size();
	}

	@Override
	public RNACodon next() {
		if (!hasNext()) {
			throw new NoSuchElementException();
		}
		RNACodon codon = new RNACodon(sequence, index);
		index += 3;
		return codon;
	}
}
