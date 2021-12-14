package com.poohxx.kotlin_practice_recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.poohxx.kotlin_practice_recyclerview.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val adapter = CurrencyAdapter()
    private val  imageList = listOf(
        R.drawable.rubles100,
        R.drawable.rubles200,
        R.drawable.rubles500,
        R.drawable.rubles1k,
        R.drawable.rubles2k,
        R.drawable.rubles5k
    )
    private var i = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        init()
    }
    private fun init(){
        binding.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity,3)
            rcView.adapter = adapter
            btnAdd.setOnClickListener{
                if (i>4) i=0
                val currency = Currency(imageList[i], "Currency: $i")
                adapter.addCurrency(currency)
                i++
            }
        }
    }
}