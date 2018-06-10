package io.tohure.jetpacktest.ui.user.db

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "UserKEntity")
data class UserKotlin(
        var name: String,
        var phone: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}