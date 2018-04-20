package com.avd.checker.ext

/**
 * Replace element by predicate or add new value if element not found
 */
fun <T> MutableList<T>.replaceIf(predicate: (T) -> Boolean, value: T): MutableList<T> {
    val iterator = this.listIterator()

    while (iterator.hasNext()) {
        if (predicate(iterator.next())) {
            iterator.set(value)
            return this
        }
    }
    iterator.add(value)
    return this
}