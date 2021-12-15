package com.poohxx.kotlin_practice_recyclerview

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.poohxx.kotlin_practice_recyclerview.databinding.ActivityEditBinding

class EditActivity : AppCompatActivity() {
    lateinit var binding: ActivityEditBinding
    private var indexImage = 0
    private var imageId = R.drawable.rubles100
    private val  imageList = listOf(
        R.drawable.rubles100,
        R.drawable.rubles200,
        R.drawable.rubles500,
        R.drawable.rubles1k,
        R.drawable.rubles2k,
        R.drawable.rubles5k
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initButtons()
    }
    private fun initButtons() = with(binding) {
        btnNextImage.setOnClickListener{
            indexImage++
            if(indexImage>imageList.size-1) indexImage = 0
            imageId = imageList[indexImage]
            imageView.setImageResource(imageId)
        }
        btnDone.setOnClickListener{
            val currency = Currency (imageId,edTitle.text.toString(), edDescript.text.toString())
            val editIntent = Intent().apply {
                putExtra("currency", currency)
            }
            setResult(RESULT_OK, editIntent)
            finish()
        }
    }
}