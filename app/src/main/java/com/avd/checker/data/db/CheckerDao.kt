package com.avd.checker.data.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface CheckerDao {

    @Query("SELECT * FROM checkers")
    fun getAll(): Single<List<CheckerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(checker: CheckerEntity): Single<Long>

    @Query("DELETE FROM checkers")
    fun deletAll(): Completable

    @Query("DELETE FROM checkers WHERE id = :id")
    fun delete(id: Long): Completable
}