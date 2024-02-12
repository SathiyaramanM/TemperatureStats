package com.sahaj.gurukul

import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader
import java.util.*

fun main() {
    println("Hello World!")
    streamReaderImpl()
}

private fun streamReaderImpl() { // Took 217 seconds
    val treeMap = TreeMap<String, StationDetail>()
    try {
        val fileStream = FileInputStream(File("measurements.txt"))
        val inputStreamReader = InputStreamReader(fileStream)
        BufferedReader(inputStreamReader).use { bufferedReader ->
            var currentLine: String? = bufferedReader.readLine()
            while(true) {
                if(currentLine.isNullOrEmpty()) {
                    break
                }
                val tokens = currentLine.split(';')
                val name = tokens[0]
                val value = tokens[1].toDouble()
                if(treeMap.containsKey(name)) {
                    treeMap[name]?.add(value)
                } else {
                    treeMap[name] = StationDetail(value)
                }
                currentLine = bufferedReader.readLine()
            }
        }
        inputStreamReader.close()
        fileStream.close()
        val stringBuilder = StringBuilder()
        for (pair in treeMap) {
            stringBuilder.append(pair.key)
            stringBuilder.appendLine(pair.value.toString())
        }
        println(stringBuilder.toString())
    } catch (ex: Exception) {
        println(ex.message)
    }
}