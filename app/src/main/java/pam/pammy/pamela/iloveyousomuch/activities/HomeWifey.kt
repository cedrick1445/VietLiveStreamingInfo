package pam.pammy.pamela.iloveyousomuch.activities

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import pam.pammy.pamela.iloveyousomuch.R
import pam.pammy.pamela.iloveyousomuch.adapterData.AdapterStaticData
import pam.pammy.pamela.iloveyousomuch.databinding.ActivityHomeBinding
import pam.pammy.pamela.iloveyousomuch.modelView.ViewLSModel

class HomeWifey : AppCompatActivity() {

    private lateinit var wHome: ActivityHomeBinding
    private var exit = 0
    private lateinit var hWifey: ViewLSModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        wHome = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(wHome.root)
        hWifey = ViewModelProvider(this)[ViewLSModel::class.java]
        hWifey.homeW()
        displayData()
        clickSide()
        loadHome()
    }

    private fun loadHome() {
        val handler = Handler()
        handler.postDelayed({
            wHome.loadingHome.visibility = View.GONE
            wHome.recycleHome.visibility = View.VISIBLE
        }, 2600)}


    private fun clickSide() {
        val animH = ActivityOptions.makeCustomAnimation(this, R.anim.blink_anim, R.anim.rotate)
        wHome.stepClickH.setOnClickListener {
            startActivity(Intent(application, StepsWifey::class.java), animH.toBundle())}
        wHome.riskClickH.setOnClickListener {
            startActivity(Intent(application, RiskWifey::class.java), animH.toBundle())}
        wHome.featClickH.setOnClickListener {
            startActivity(Intent(application, FeaturesWifey::class.java), animH.toBundle())}
    }

    private fun displayData() {
        val noData : LinearLayout = wHome.noData
        hWifey.homeW()
        hWifey.live.observe(this, {
            if (it != null){
                val adapt = AdapterStaticData()
                adapt.setData(it)
                wHome.recycleHome.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(applicationContext)
                    adapter = adapt
                } } else{
                    noData.visibility = View.VISIBLE
                    Toast.makeText(applicationContext, "Có lỗi trong Internet!!", Toast.LENGTH_LONG).show()
            } }) }

    override fun onBackPressed() {
        if (exit == 0) {
            exit = 1
            Toast.makeText(this, "Nhấn lại để thoát khỏi ứng dụng!", Toast.LENGTH_LONG).show()
        }else {
            super.finishAffinity()}}
}