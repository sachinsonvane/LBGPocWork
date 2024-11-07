package com.ss.lloydsbankpoc.data.remote.response


import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName

@Keep
class GetBooksApiResponse : ArrayList<GetBooksApiResponse.GetBooksApiResponseItem>(){
    @Keep
    data class GetBooksApiResponseItem(
        @SerializedName("title") var title: String,
        @SerializedName("originalTitle") var originalTitle: String,
        @SerializedName("releaseDate") var releaseDate: String,
        @SerializedName("description") var description: String,
        @SerializedName("cover") var cover: String
    )
}