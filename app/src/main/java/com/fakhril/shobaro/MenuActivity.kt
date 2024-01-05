package com.fakhril.shobaro

import android.R.id
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.fakhril.shobaro.databinding.ActivityMenuBinding

const val CV_JADWAL = "https://shobarobwi.blogspot.com/2024/01/jadwal-shobaro.html?m=1";
const val CV_FLAYER = "https://shobarobwi.blogspot.com/2024/01/flyer.html"
const val YT_SHOBARO = "https://youtube.com/@shobaroBanyuwangi"
const val YT_DARBY = "https://www.youtube.com/@DarbyChanel"
const val WA_CONTACT = "https://wa.me/6282232818957"


class MenuActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.cvJadwal.setOnClickListener {
            val intent = Intent(this@MenuActivity, MainActivity::class.java)
            intent.putExtra("urlWeb", CV_JADWAL)
            startActivity(intent)
        }

        binding.cvFlayer.setOnClickListener {
            val intent = Intent(this@MenuActivity, MainActivity::class.java)
            intent.putExtra("urlWeb", CV_FLAYER)
            startActivity(intent)
        }

        binding.cvYoutube.setOnClickListener {
            var intent: Intent? = null
            try {
                intent = Intent(Intent.ACTION_VIEW)
                intent.setPackage("com.google.android.youtube")
                intent.data = Uri.parse(YT_SHOBARO)
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(YT_SHOBARO)
                startActivity(intent)
            }
        }

        binding.cvContact.setOnClickListener {
            var intent: Intent? = null
            try {
                intent = Intent(Intent.ACTION_VIEW)
                intent!!.setPackage("com.whatsapp")
                intent!!.data = Uri.parse(WA_CONTACT)
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                intent = Intent(Intent.ACTION_VIEW)
                intent!!.data = Uri.parse(WA_CONTACT)
                startActivity(intent)
            }
        }

        binding.cvNgaji.setOnClickListener {
            var intent: Intent? = null
            try {
                intent = Intent(Intent.ACTION_VIEW)
                intent!!.setPackage("com.google.android.youtube")
                intent!!.data = Uri.parse(YT_DARBY)
                startActivity(intent)
            } catch (e: ActivityNotFoundException) {
                intent = Intent(Intent.ACTION_VIEW)
                intent!!.data = Uri.parse(YT_DARBY)
                startActivity(intent)
            }
        }
    }
}