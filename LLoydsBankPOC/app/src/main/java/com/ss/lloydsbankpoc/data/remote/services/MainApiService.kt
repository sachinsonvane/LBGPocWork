package com.ss.lloydsbankpoc.data.remote.services


import com.ss.lloydsbankpoc.base.constants.AppConstants
import com.ss.lloydsbankpoc.data.remote.response.GetBooksApiResponse
import retrofit2.Response
import retrofit2.http.GET

interface MainApiService {

    @GET(AppConstants.BOOKS_URL)
    suspend fun getAllBooks():Response<GetBooksApiResponse>

}