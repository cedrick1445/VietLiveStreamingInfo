package pam.pammy.pamela.iloveyousomuch.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import pam.pammy.pamela.iloveyousomuch.databinding.ActivitySplashBinding

class SplashWifey : AppCompatActivity() {
    private lateinit var wSp : ActivitySplashBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        wSp = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(wSp.root)
        window.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        val handler = Handler()
        handler.postDelayed({
                startActivity(Intent(this, HomeWifey::class.java))
                finish()
            }, 1800)}
}