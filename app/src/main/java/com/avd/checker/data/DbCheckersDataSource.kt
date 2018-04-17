package com.avd.checker.data

import com.avd.checker.data.db.CheckersDatabase
import com.avd.checker.domain.model.CheckerModel
import io.reactivex.Completable
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DbCheckersDataSource @Inject constructor(val db: CheckersDatabase) :
        DataSource<CheckerModel> {

    private val cache = CheckersCache()

    override fun putAll(elements: List<CheckerModel>): Completable {
        cache.putAll(elements)
        return Completable.complete()
    }

    override fun put(element: CheckerModel): Single<CheckerModel> {
        cache.put(element)
        return Single.just(element)
    }

    override fun getAll(): Single<List<CheckerModel>> {

        return if (cache.isExpired()) Single.just(emptyList()) else Single.just(cache.getAll())
    }

    override fun get(id: Long): Single<CheckerModel> {
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

    override fun remove(id: Long): Completable {
        cache.remove(id)
        return Completable.complete()
    }
}