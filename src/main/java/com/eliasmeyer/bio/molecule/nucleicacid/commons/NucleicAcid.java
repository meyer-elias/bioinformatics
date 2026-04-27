package com.eliasmeyer.bio.molecule.nucleicacid.commons;

import com.eliasmeyer.bio.molecule.commons.Polymer;
import com.eliasmeyer.bio.molecule.commons.Sequence;

public class NucleicAcid<T> extends Polymer<T> {

	protected NucleicAcid(Sequence<T> sequence) {
		super(sequence);
	}
}
