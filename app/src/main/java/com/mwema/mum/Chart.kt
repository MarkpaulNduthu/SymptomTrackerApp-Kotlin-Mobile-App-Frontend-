package com.mwema.mum

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.mwema.mum.dao.SymptomsDao
import com.mwema.mum.database.AppDatabase
import com.mwema.mum.databinding.ActivityChartBinding
import com.mwema.mum.dto.SymptomLogDTO
import com.mwema.mum.recyclerViewAdapter.ChartRecyclerViewAdapter

class Chart : AppCompatActivity() {
    lateinit var dao: SymptomsDao
    lateinit var binding: ActivityChartBinding
    lateinit var list: List<SymptomLogDTO>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityChartBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.toolbar.fitsSystemWindows = true
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "GET WELL"
        supportActionBar?.setDisplayShowTitleEnabled(true)
        dao = AppDatabase.getInstance(this)?.symptomsDao()!!
        binding.dbRecyclerView.layoutManager = LinearLayoutManager(this)
        binding.dbRecyclerView.adapter = ChartRecyclerViewAdapter(dao.getAll())
    }
}