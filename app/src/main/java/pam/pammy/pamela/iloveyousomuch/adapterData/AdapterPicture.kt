package pam.pammy.pamela.iloveyousomuch.adapterData

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import pam.pammy.pamela.iloveyousomuch.databinding.FeatLayoutBinding
import pam.pammy.pamela.iloveyousomuch.modelData.LiveSModel

class AdapterPicture (private val context : Context) : RecyclerView.Adapter<AdapterPicture.FeaturesHolder>(){
    private var listF = emptyList<LiveSModel>()

    class FeaturesHolder (val flBind : FeatLayoutBinding) : RecyclerView.ViewHolder(flBind.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FeaturesHolder {
        val flBind = FeatLayoutBinding.inflate(LayoutInflater.from(parent.context), parent,false)
        return FeaturesHolder(flBind)}

    override fun onBindViewHolder(holder: FeaturesHolder, position: Int) {
        with(holder){
            with(listF[position]){
                flBind.title.text = this.title
                flBind.desc.text = this.vietnamdescription
                Glide.with(context)
                    .load(this.image)
                    .apply(RequestOptions.fitCenterTransform())
                    .into(flBind.icon)}}}

    override fun getItemCount(): Int {
      return listF.size}

    fun setFeat(setF : List<LiveSModel>){
        this.listF = setF
        notifyDataSetChanged()}

}
