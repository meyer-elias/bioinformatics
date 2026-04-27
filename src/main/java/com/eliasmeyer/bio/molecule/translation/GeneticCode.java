package com.eliasmeyer.bio.molecule.translation;

import com.eliasmeyer.bio.molecule.commons.codon.Codon;
import com.eliasmeyer.bio.molecule.commons.codon.CodonTranslation;

public interface GeneticCode<T> {

	CodonTranslation translate(Codon<T> codon);
}
