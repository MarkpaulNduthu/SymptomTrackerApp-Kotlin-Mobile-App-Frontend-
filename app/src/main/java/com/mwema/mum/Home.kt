package com.mwema.mum

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.mwema.mum.dao.SymptomsDao
import com.mwema.mum.database.AppDatabase
import com.mwema.mum.databinding.ActivityHomeBinding
import com.mwema.mum.dto.SymptomLogDTO
import java.util.Date

class Home : AppCompatActivity() {
    private lateinit var dao: SymptomsDao
    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        dao = AppDatabase.getInstance(this)?.symptomsDao()!!

        binding.toolbar.fitsSystemWindows = true
        setSupportActionBar(binding.toolbar)
        supportActionBar?.title = "GET WELL"
        supportActionBar?.setDisplayShowTitleEnabled(true)
        binding.bottomNav.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.home -> {
                    true
                }

                R.id.graph -> {
                    startActivity(Intent(this,Chart::class.java))
                    true
                }
                else -> false
            }
        }
        binding.submitButton.setOnClickListener {
            //use coroutines
            val canMove: Boolean = binding.canMoveSwitch.isChecked
            val painLevel: Int = binding.painLevelSeekBar.progress
            val notes: String = binding.notes.text.toString()
            dao.insert(
                SymptomLogDTO(
                    date = Date(System.currentTimeMillis()).toString(),
                    canMove = canMove,
                    painLevel = painLevel,
                    notes = notes,
                )
            )
            Toast.makeText(this, "Data Added to database", Toast.LENGTH_LONG).show()
        }
    }
}