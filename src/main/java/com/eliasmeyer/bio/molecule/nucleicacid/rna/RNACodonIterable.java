package com.eliasmeyer.bio.molecule.nucleicacid.rna;

import com.eliasmeyer.bio.molecule.commons.Sequence;
import com.eliasmeyer.bio.molecule.commons.codon.CodonIterable;

public class RNACodonIterable extends CodonIterable<RNABase> {

	public RNACodonIterable(Sequence<RNABase> sequence, int frame) {
		super(sequence, frame);
	}
}
