package pam.pammy.pamela.iloveyousomuch.modelData

import com.google.gson.annotations.SerializedName

class LiveSModel (
    @SerializedName("engdescription")
    val engdescription: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("image")
    val image: String,
    @SerializedName("menu")
    val menu: String,
    @SerializedName("subtitle")
    val subtitle: String,
    @SerializedName("title")
    val title: String,
    @SerializedName("vietnamdescription")
    val vietnamdescription: String
)