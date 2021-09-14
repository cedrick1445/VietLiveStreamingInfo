package pam.pammy.pamela.iloveyousomuch.activities

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import pam.pammy.pamela.iloveyousomuch.R
import pam.pammy.pamela.iloveyousomuch.adapterData.AdapterStaticData
import pam.pammy.pamela.iloveyousomuch.databinding.ActivityRiskBinding
import pam.pammy.pamela.iloveyousomuch.modelView.ViewLSModel

class RiskWifey : AppCompatActivity() {
    private lateinit var wRisk: ActivityRiskBinding
    private lateinit var rWifey: ViewLSModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        wRisk = ActivityRiskBinding.inflate(layoutInflater)
        setContentView(wRisk.root)
        rWifey = ViewModelProvider(this)[ViewLSModel::class.java]
        rWifey.riskW()
        riskData()
        clickR()
        loadRisk()
    }

    private fun loadRisk() {
        val handler = Handler()
        handler.postDelayed({
            wRisk.loadingRisk.visibility = View.GONE
            wRisk.recycleRisk.visibility = View.VISIBLE
        }, 2600)}

    private fun clickR() {
        val animR = ActivityOptions.makeCustomAnimation(this, R.anim.blink_anim, R.anim.rotate)
        wRisk.stepClickR.setOnClickListener {
            startActivity(Intent(application, StepsWifey::class.java), animR.toBundle())}
        wRisk.featClickS.setOnClickListener {
            startActivity(Intent(application, FeaturesWifey::class.java), animR.toBundle())}
    }

    private fun riskData() {
        rWifey.live.observe(this, {
            if (it != null){
                val rAdapt = AdapterStaticData()
                rAdapt.setData(it)
                wRisk.recycleRisk.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(applicationContext)
                    adapter = rAdapt
                }}else{
                Toast.makeText(applicationContext, "Có lỗi trong Internet!!", Toast.LENGTH_LONG).show()
                wRisk.noDataR.visibility = View.VISIBLE
            }})}

    override fun onBackPressed() {
        startActivity(Intent(application, HomeWifey::class.java), ActivityOptions.makeCustomAnimation(this, R.anim.blink_anim, R.anim.blink_anim).toBundle())}
}