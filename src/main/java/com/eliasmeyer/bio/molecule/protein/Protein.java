package com.eliasmeyer.bio.molecule.protein;

import com.eliasmeyer.bio.molecule.commons.Polymer;
import com.eliasmeyer.bio.molecule.commons.Sequence;

public class Protein extends Polymer<AminoAcid> {

	public Protein(Sequence<AminoAcid> sequence) {
		super(sequence);
	}

	@Override
	public String toString() {
		return "Protein{" +
			"sequence=" + sequence +
			'}';
	}
}
