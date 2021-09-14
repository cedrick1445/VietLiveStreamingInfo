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
import pam.pammy.pamela.iloveyousomuch.databinding.ActivityStepsBinding
import pam.pammy.pamela.iloveyousomuch.modelView.ViewLSModel

class StepsWifey : AppCompatActivity() {
    private lateinit var wSteps: ActivityStepsBinding
    private lateinit var sWifey: ViewLSModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        wSteps = ActivityStepsBinding.inflate(layoutInflater)
        setContentView(wSteps.root)
        sWifey = ViewModelProvider(this)[ViewLSModel::class.java]
        sWifey.stepW()
        stepsData()
        clickS()
        loadSteps()
    }

    private fun loadSteps() {
        val handler = Handler()
        handler.postDelayed({
            wSteps.loadingSteps.visibility = View.GONE
            wSteps.recycleSteps.visibility = View.VISIBLE
        }, 2600)}

    private fun clickS() {
        val animS = ActivityOptions.makeCustomAnimation(this, R.anim.blink_anim, R.anim.rotate)
        wSteps.riskClickS.setOnClickListener {
            startActivity(Intent(application, RiskWifey::class.java), animS.toBundle())}
        wSteps.featClickS.setOnClickListener {
            startActivity(Intent(application, FeaturesWifey::class.java), animS.toBundle())}}

    private fun stepsData() {
        sWifey.live.observe(this, {
            if (it != null) {
                val sAdapt = AdapterStaticData()
                sAdapt.setData(it)
                wSteps.recycleSteps.apply {
                    setHasFixedSize(true)
                    layoutManager = LinearLayoutManager(applicationContext)
                    adapter = sAdapt
                }} else {
                wSteps.noDataS.visibility = View.VISIBLE
                Toast.makeText(applicationContext, "Có lỗi trong Internet!!", Toast.LENGTH_LONG)
                    .show()
            }})}

    override fun onBackPressed() {
        startActivity(Intent(application, HomeWifey::class.java), ActivityOptions.makeCustomAnimation(this, R.anim.blink_anim, R.anim.blink_anim).toBundle())}
}