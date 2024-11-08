package com.ss.lloydsbankpoc.data.datasource.remote

import com.ss.lloydsbankpoc.data.remote.response.GetBooksApiResponse
import com.ss.lloydsbankpoc.data.remote.services.MainApiService
import retrofit2.Response

class MockApiService: MainApiService {
    override suspend fun getAllBooks(): Response<GetBooksApiResponse> {
       return Response.success(GetBooksApiResponse().apply { addAll(listOf(
           GetBooksApiResponse.GetBooksApiResponseItem(title = "title", originalTitle = "originalTitle", releaseDate = "releaseDate",description="description",cover="cover"),
           GetBooksApiResponse.GetBooksApiResponseItem(title = "title", originalTitle = "originalTitle", releaseDate = "releaseDate",description="description",cover="cover"),
           GetBooksApiResponse.GetBooksApiResponseItem(title = "title", originalTitle = "originalTitle", releaseDate = "releaseDate",description="description",cover="cover"),
           GetBooksApiResponse.GetBooksApiResponseItem(title = "title", originalTitle = "originalTitle", releaseDate = "releaseDate",description="description",cover="cover"),
           GetBooksApiResponse.GetBooksApiResponseItem(title = "title", originalTitle = "originalTitle", releaseDate = "releaseDate",description="description",cover="cover"),
       )) })
    }
}