package com.eliasmeyer.bio.molecule.commons.codon;

import com.eliasmeyer.bio.molecule.protein.AminoAcid;

public record Amino(AminoAcid value) implements CodonTranslation {


}
