package pam.pammy.pamela.iloveyousomuch.activities

import android.app.ActivityOptions
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import pam.pammy.pamela.iloveyousomuch.R
import pam.pammy.pamela.iloveyousomuch.adapterData.AdapterPicture
import pam.pammy.pamela.iloveyousomuch.databinding.ActivityFeaturesBinding
import pam.pammy.pamela.iloveyousomuch.modelView.ViewLSModel

class FeaturesWifey : AppCompatActivity() {

    private lateinit var wFeat : ActivityFeaturesBinding
    private lateinit var fWifey : ViewLSModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        wFeat = ActivityFeaturesBinding.inflate(layoutInflater)
        setContentView(wFeat.root)
        fWifey = ViewModelProvider(this)[ViewLSModel::class.java]
        fWifey.featW()
        featData()
        clickF()
        loadRisk()
    }

    private fun loadRisk() {
        val handler = Handler()
        handler.postDelayed({
            wFeat.loadingFeat.visibility = View.GONE
            wFeat.recycleFeat.visibility = View.VISIBLE
        }, 2600)}

    private fun clickF() {
        val animF = ActivityOptions.makeCustomAnimation(this, R.anim.blink_anim, R.anim.rotate)
        wFeat.stepClickF.setOnClickListener {
            startActivity(Intent(application, StepsWifey::class.java), animF.toBundle())}
        wFeat.riskClickF.setOnClickListener {
            startActivity(Intent(application, RiskWifey::class.java), animF.toBundle())}
    }

    private fun featData() {
        fWifey.live.observe(this, {
            if (it != null){
                val fData = AdapterPicture(applicationContext)
                fData.setFeat(it)
                wFeat.recycleFeat.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(applicationContext)
                    adapter = fData
                }} else{
                    wFeat.noDataF.visibility = View.VISIBLE
                Toast.makeText(applicationContext, "Có lỗi trong Internet!!", Toast.LENGTH_LONG).show()
            }})}

    override fun onBackPressed() {
        startActivity(Intent(application, HomeWifey::class.java), ActivityOptions.makeCustomAnimation(this, R.anim.blink_anim, R.anim.blink_anim).toBundle())}
    }
