package com.example.mymuseum.retrofit

import android.text.Editable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class User(
    @field:Expose @field:SerializedName("email") var email: String,
    @field:Expose @field:SerializedName("password") var password: String
) {
    @SerializedName("id")
    @Expose
    var id: Long? = null

    @SerializedName("api_token")
    @Expose
    var api_token: String? = null

    
}