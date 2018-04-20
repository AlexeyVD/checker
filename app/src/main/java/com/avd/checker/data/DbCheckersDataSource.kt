package com.avd.checker.data

import android.util.Log
import com.avd.checker.data.db.CheckersDatabase
import com.avd.checker.domain.model.CheckerModel
import io.reactivex.Completable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.atomic.AtomicLong
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DbCheckersDataSource @Inject constructor(val db: CheckersDatabase) :
        DataSource<CheckerModel> {

    private val cache = CheckersCache()
    private val ai = AtomicLong()

    override fun init(): Completable {
        return db.checkerDao()
                .getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .map { it.map { it.toModel() } }
                .doOnSuccess {
                    cache.putAll(it.sortedBy { it.id })
                    ai.set(it.map { it.id }.max()?: 0)
                }
                .toCompletable()
    }

    override fun generateId() = ai.getAndIncrement()

    override fun putAll(elements: List<CheckerModel>) {
        cache.putAll(elements)
    }

    override fun put(element: CheckerModel) {
        cache.put(element)
    }

    override fun getAll() = cache.getAll()

    override fun get(id: Long) = cache.get(id)

    override fun removeAll() {
        cache.removeAll()
    }

    override fun remove(id: Long) {
        cache.remove(id)
    }

    override fun apply() {
        db.checkerDao().insertAll(cache.getAll().map { it.toEntity() })
        db.checkerDao().delete(cache.removed().map { it.toEntity() })
        Log.i("DbCheckersDataSource", "Data applied successfully")
    }
}