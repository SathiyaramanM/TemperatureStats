package com.sahaj.gurukul

class StationDetail(firstValue: Double) {
    private var min: Double = 0.0
    private var max: Double = 0.0
    private var sum: Double = 0.0
    private var count: Int = 0

    init {
        min = firstValue
        max = firstValue
        sum = firstValue
        count += 1
    }

    fun add(value: Double) {
        min = if (min < value) min else value
        max = if (max < value) max else value
        sum += value
        count += 1
    }

    override fun toString(): String {
        return "Max - $max; Min - $min; Mean - ${sum / count}"
    }
}