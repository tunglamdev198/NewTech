package com.lamnt.newtech.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "note")
data class Note(@PrimaryKey val id: String = UUID.randomUUID().toString(),
                val title: String?,
                val content: String?)