package com.yash.krishnasaysapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import com.yash.krishnasays.databinding.ActivityMainBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    private var chapter: Int = 1
    private var verse: Int = 1
    private val scope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getQuote(chapter, verse)

        binding.nextBtn.setOnClickListener {
            chapter = (1..18).random()
            verse = (1..20).random()
            getQuote(chapter, verse)
        }
    }

    private fun getQuote(chapter: Int, verse: Int){
        setInProgress(true)

        GlobalScope.launch {
            try {
                val response = RetrofitInstance.quoteApi.getSlok(chapter, verse)
                runOnUiThread {
                    setInProgress(false)
                    if (response.isSuccessful) {
                        response.body()?.let { quote ->
                            setUI(quote)
                        }
                    } else {
                        Toast.makeText(applicationContext, "Failed to get quote: ${response.code()}", Toast.LENGTH_SHORT).show()
                    }
                }
            } catch (e: Exception) {
                runOnUiThread {
                    setInProgress(false)
                    Log.e("API_ERROR", "Error fetching quote: ${e.message}", e)
                    Toast.makeText(applicationContext, "Something went wrong", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    private fun setUI(quote: QuoteModel) {
        binding.quoteTv.text = quote.slok
        binding.authorTv.text = quote.adi.et
        binding.hindiTv.text = quote.chinmay.hc
    }

    private fun setInProgress(inProgress: Boolean) {
        if (inProgress) {
            binding.progressBar.visibility = View.VISIBLE
            binding.nextBtn.visibility = View.GONE
        } else {
            binding.progressBar.visibility = View.GONE
            binding.nextBtn.visibility = View.VISIBLE
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}
