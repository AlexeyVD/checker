package com.avd.checker.data

import io.reactivex.Completable
import io.reactivex.Single

interface DataSource<T> {

    /**
     * Put [elements] to data source
     */
    fun putAll(elements: List<T>): Completable

    /**
     * Put element to data source
     */
    fun put(element: T): Completable

    /**
     * @return Single with list of existing elements
     */
    fun getAll(): Single<List<T>>

    /**
     * @return Single with element by [id]
     */
    fun get(id: Int): Single<T>

    /**
     * Remove all elements from data source
     */
    fun removeAll(): Completable

    /**
     * Remove element from data source by [id]
     */
    fun remove(id: Int): Completable
}