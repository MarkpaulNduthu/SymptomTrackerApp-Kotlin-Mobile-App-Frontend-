package com.mwema.mum.dto

data class SymptomLogDTO(
    val date:String,
    val canMove: Boolean,
    val painLevel: Int,
    val notes: String
)