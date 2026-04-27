package com.eliasmeyer.bio.molecule.protein;

import java.math.BigDecimal;

public enum AminoAcid {

	A(1, "Alanina", new BigDecimal("71.03711")),
	R(2, "Arginina", new BigDecimal("156.10111")),
	N(3, "Asparagina", new BigDecimal("114.04293")),
	D(4, "Aspartato", new BigDecimal("115.02694")),
	C(5, "Cisteína", new BigDecimal("103.00919")),
	Q(6, "Glutamina", new BigDecimal("128.05858")),
	E(7, "Glutamato", new BigDecimal("129.04259")),
	G(8, "Glicina", new BigDecimal("57.02146")),
	H(9, "Histidina", new BigDecimal("137.05891")),
	I(10, "Isoleucina", new BigDecimal("113.08406")),
	L(11, "Leucina", new BigDecimal("113.08406")),
	K(12, "Lisina", new BigDecimal("128.09496")),
	M(13, "Metionina", new BigDecimal("131.04049")),
	F(14, "Fenilalanina", new BigDecimal("147.06841")),
	P(15, "Prolina", new BigDecimal("97.05276")),
	S(16, "Serina", new BigDecimal("87.03203")),
	T(17, "Treonina", new BigDecimal("101.04768")),
	W(18, "Triptofano", new BigDecimal("186.07931")),
	Y(19, "Tirosina", new BigDecimal("163.06333")),
	V(20, "Valina", new BigDecimal("99.06841"));

	private final int code;

	private final String label;

	private final BigDecimal molecularWeight;

	AminoAcid(int code, String label, BigDecimal molecularWeight) {
		this.code = code;
		this.label = label;
		this.molecularWeight = molecularWeight;
	}

	public int code() {
		return code;
	}

	public String label() {
		return label;
	}

	public BigDecimal molecularWeight() {
		return molecularWeight;
	}
}
