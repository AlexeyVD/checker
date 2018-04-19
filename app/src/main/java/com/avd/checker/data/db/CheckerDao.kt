package com.avd.checker.data.db

import android.arch.persistence.room.*
import io.reactivex.Completable
import io.reactivex.Single

@Dao
interface CheckerDao {

    @Query("SELECT * FROM checkers")
    fun getAll(): Single<List<CheckerEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(checker: CheckerEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(checkers: List<CheckerEntity>)

    @Query("DELETE FROM checkers")
    fun deleteAll()

    @Query("DELETE FROM checkers WHERE id = :id")
    fun delete(id: Long)

    @Delete
    fun delete(checkers: List<CheckerEntity>)
}