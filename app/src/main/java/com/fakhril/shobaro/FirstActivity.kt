package com.fakhril.shobaro

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.fakhril.shobaro.databinding.ActivityFirstBinding
import com.fakhril.shobaro.databinding.ActivityMainBinding

class FirstActivity : AppCompatActivity() {
    private lateinit var binding: ActivityFirstBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFirstBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val timer = object: CountDownTimer(2000, 2000) {
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                val intent = Intent(this@FirstActivity, MenuActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        timer.start()


    }
}