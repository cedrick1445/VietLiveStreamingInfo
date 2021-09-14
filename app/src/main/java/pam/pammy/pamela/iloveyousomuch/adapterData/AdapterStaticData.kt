package pam.pammy.pamela.iloveyousomuch.adapterData

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import pam.pammy.pamela.iloveyousomuch.databinding.DataLayoutBinding
import pam.pammy.pamela.iloveyousomuch.modelData.LiveSModel

class AdapterStaticData: RecyclerView.Adapter<AdapterStaticData.ViewHolder>() {

    private var dataList = emptyList<LiveSModel>()

    class ViewHolder (val adapt : DataLayoutBinding) : RecyclerView.ViewHolder(adapt.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val adapt = DataLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(adapt) }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder){
            with(dataList[position]){
                adapt.title.text = this.title
                adapt.desc.text = this.vietnamdescription
            } } }

    override fun getItemCount(): Int {
        return dataList.size }

    fun setData(setD : List<LiveSModel>){
        this.dataList = setD
        notifyDataSetChanged() }
}
