package com.eliasmeyer.bio.molecule.nucleicacid.rna;

import com.eliasmeyer.bio.molecule.commons.Sequence;
import com.eliasmeyer.bio.molecule.commons.codon.Codon;

public class RNACodon extends Codon<RNABase> {

	public RNACodon(Sequence<RNABase> sequence, int offset) {
		super(sequence, offset);
	}
}
