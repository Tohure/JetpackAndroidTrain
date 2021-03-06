package io.tohure.jetpacktest.ui.user.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DaoUserKotlin {

    @Query("SELECT * FROM UserKEntity")
    fun allUser(): LiveData<List<UserKotlin>>

    @Query("SELECT * FROM UserKEntity WHERE id = :id")
    fun getUserById(id: String): UserKotlin

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun addUser(yearEntity: UserKotlin)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllUsers(yearEntities: List<UserKotlin>)

    @Delete
    fun deleteUser(yearEntity: UserKotlin)

}