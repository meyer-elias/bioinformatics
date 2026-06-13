package com.eliasmeyer.algorithms.probability

import com.eliasmeyer.algorithms.commons.AbstractLineInputProcessor

/*
 *  https://rosalind.info/problems/iev/
 *  Given: Six nonnegative integers, each of which does not exceed 20,000. The integers correspond to the number of couples in a population possessing each genotype pairing for a given factor.
 *  In order, the six given integers represent the number of couples having the following genotypes:
 *
 *  AA-AA
 *  AA-Aa
 *  AA-aa
 *  Aa-Aa
 *  Aa-aa
 *  aa-aa
 *  Return: The expected number of offspring displaying the dominant phenotype in the next generation, under the assumption that every couple has exactly two offspring.
 */
class CalculatingExpectedOffspring : AbstractLineInputProcessor() {

    private var expectedOffspring = 0.0

    // Probability of dominant phenotype for each couple genotype pairing
    private val dominantProbabilities = doubleArrayOf(1.0, 1.0, 1.0, 0.75, 0.5, 0.0)

    override fun processLine(line: String?) {
        val counts = line!!.trim().split("\\s+".toRegex()).map { it.toInt() }
        expectedOffspring = counts
            .zip(dominantProbabilities.toList())
            .sumOf { (count, prob) -> count * 2 * prob }
    }

    override fun printResult() {
        println(expectedOffspring)
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            CalculatingExpectedOffspring().readAndProcessInput()
        }
    }
}