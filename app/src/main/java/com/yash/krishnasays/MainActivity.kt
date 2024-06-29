package com.yash.krishnasaysapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.yash.krishnasays.databinding.ActivityMainBinding
import com.yash.krishnasaysapp.QuoteModel
import com.yash.krishnasaysapp.RetrofitInstance
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.lang.Exception

class MainActivity : AppCompatActivity() {

    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        getQuote()

        binding.nextBtn.setOnClickListener {
            getQuote()
        }

    }

    private fun getQuote(){
        setInProgress(true)

        GlobalScope.launch {
            try{
                val response = RetrofitInstance.quoteApi.getSlok()
                runOnUiThread {
                    setInProgress(false)
                    response.body()?.first()?.let {
                        setUI(it)
                    }
                }

            }catch (e : Exception){
                runOnUiThread {
                    setInProgress(false)
                    Toast.makeText(applicationContext,"Something went wrong",Toast.LENGTH_SHORT).show()
                }
            }
        }

    }

    private fun setUI(quote : QuoteModel){
        binding.quoteTv.text = quote.slok
        binding.authorTv.text = quote.transliteration
    }

    private fun setInProgress(inProgress : Boolean){
        if(inProgress){
            binding.progressBar.visibility = View.VISIBLE
            binding.nextBtn.visibility = View.GONE
        }else{
            binding.progressBar.visibility = View.GONE
            binding.nextBtn.visibility = View.VISIBLE
        }
    }
}