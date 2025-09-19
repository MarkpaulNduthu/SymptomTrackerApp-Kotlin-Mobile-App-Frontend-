package com.mwema.mum.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.mwema.mum.dto.SymptomLogDTO
import com.mwema.mum.entity.SymptomLog

@Dao
interface SymptomsDao {
    @Insert(entity = SymptomLog::class)
    fun insert(vararg systemLogs: SymptomLogDTO)

    @Query("SELECT * FROM SymptomLog")
    fun getAll(): List<SymptomLogDTO>
}