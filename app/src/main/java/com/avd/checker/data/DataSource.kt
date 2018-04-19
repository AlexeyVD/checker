package com.avd.checker.data

import io.reactivex.Completable
import io.reactivex.Single

interface DataSource<T> {

    /**
     * Init data source
     */
    fun init(): Completable

    /**
     * Generates next id
     */
    fun generateId(): Long

    /**
     * Put [elements] to data source
     */
    fun putAll(elements: List<T>)

    /**
     * Put element to data source
     */
    fun put(element: T)

    /**
     * @return Single with list of existing elements
     */
    fun getAll(): List<T>

    /**
     * @return Single with element by [id]
     */
    fun get(id: Long): T?

    /**
     * Remove all elements from data source
     */
    fun removeAll()

    /**
     * Remove element from data source by [id]
     */
    fun remove(id: Long)

    /**
     * Applies not saved changes in data source
     */
    fun apply()
}