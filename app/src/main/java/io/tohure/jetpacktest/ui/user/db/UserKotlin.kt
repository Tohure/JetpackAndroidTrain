package io.tohure.jetpacktest.ui.user.db

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "UserKEntity")
data class UserKotlin(
        var name: String,
        var phone: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}