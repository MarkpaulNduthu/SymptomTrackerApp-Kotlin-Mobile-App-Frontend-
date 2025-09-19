package com.mwema.mum.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "symptom_logs")
data class SymptomLog(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val date: String,
    val canMove: Boolean,
    val painLevel: Int,
    val notes: String
)