package com.ss.lloydsbankpoc.data.repo_impl

import com.ss.lloydsbankpoc.base.failure.Failure
import com.ss.lloydsbankpoc.base.helpers.Either
import com.ss.lloydsbankpoc.base.helpers.map
import com.ss.lloydsbankpoc.base.helpers.safeFlowBuilder
import com.ss.lloydsbankpoc.data.remote.response.GetBooksApiResponse
import com.ss.lloydsbankpoc.data.remote.services.MainApiService
import com.ss.lloydsbankpoc.domain.entity.BooksEntity
import com.ss.lloydsbankpoc.domain.mapper.toPostsEntities
import com.ss.lloydsbankpoc.domain.repo.BooksRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class BooksRepoImpl @Inject constructor(private val mainApiService: MainApiService) : BooksRepo {

    override suspend fun getAllPosts(): Flow<Either<Failure, List<BooksEntity>>> =
          safeFlowBuilder { mainApiService.getAllBooks() }.map { value ->
            when (value) {
                is Either.Left -> value
                is Either.Right -> value.map (GetBooksApiResponse::toPostsEntities)
            }
        }

}