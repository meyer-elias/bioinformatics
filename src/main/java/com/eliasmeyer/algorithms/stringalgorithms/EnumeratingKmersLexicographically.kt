package com.eliasmeyer.algorithms.stringalgorithms

import com.eliasmeyer.algorithms.commons.AbstractLineInputProcessor

/*
 * https://rosalind.info/problems/lexf/
 *
 * Given: A collection of at most 10 symbols defining an ordered alphabet, and a positive integer n (n≤10).
 * Return: All strings of length n
 *  that can be formed from the alphabet, ordered lexicographically (use the standard order of symbols in the English alphabet).
 */
class EnumeratingKmersLexicographically : AbstractLineInputProcessor() {

    private var alphabet: List<String> = emptyList()
    private var k: Int = 0


    companion object {
        @JvmStatic
        fun main(Args: Array<String>) {
            val processor = EnumeratingKmersLexicographically()
            processor.readAndProcessInput()
        }
    }


    override fun processLine(line: String?) {
        if (alphabet.isEmpty()) {
            alphabet = line!!.split(" ").map { it.trim() }
        } else {
            k = line!!.trim().toInt()
        }
    }

    override fun printResult() {
        if (alphabet.isEmpty() || k <= 0) return

        // Usamos BufferedWriter para uma escrita rápida no console
        System.out.bufferedWriter().use { writer ->
            generateKmers(alphabet, k, StringBuilder(), writer)
            writer.flush()
        }
    }

    private fun generateKmers(
        alphabet: List<String>,
        k: Int,
        current: StringBuilder,
        writer: java.io.BufferedWriter
    ) {
        if (current.length == k) {
            writer.write(current.toString())
            writer.newLine()
            return
        }

        for (char in alphabet) {
            current.append(char)
            generateKmers(alphabet, k, current, writer)
            current.setLength(current.length - 1) // Backtrack eficiente
        }
    }
}