package com.avd.checker.data

import com.avd.checker.domain.model.CheckerModel
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DbCheckersDataSource @Inject constructor() : DataSource<CheckerModel> {

    private val cache = CheckersCache()

    override fun putAll(elements: List<CheckerModel>): Completable {
        cache.putAll(elements)
        return Completable.complete()
    }

    override fun put(element: CheckerModel): Completable {
        cache.put(element)
        return Completable.complete()
    }

    override fun getAll(): Single<List<CheckerModel>> {

        return if (cache.isExpired()) Single.just(emptyList()) else Single.just(cache.getAll())
    }

    override fun get(id: Int): Single<CheckerModel> {
        return if (cache.isExpired())
            Single.error(Throwable("Checker not found"))
        else {
            val checker = cache.get(id) ?: return Single.error(Throwable("Checker not found"))
            Single.just(checker)
        }
    }

    override fun removeAll(): Completable {
        cache.removeAll()
        return Completable.complete()
    }

    override fun remove(id: Int): Completable {
        cache.remove(id)
        return Completable.complete()
    }
}