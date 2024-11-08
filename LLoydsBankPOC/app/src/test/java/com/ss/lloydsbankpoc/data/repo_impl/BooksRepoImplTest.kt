package com.ss.lloydsbankpoc.data.repo_impl

import com.ss.lloydsbankpoc.data.datasource.remote.FakeApiService
import com.ss.lloydsbankpoc.base.failure.Failure
import com.ss.lloydsbankpoc.base.helpers.Either
import com.ss.lloydsbankpoc.base.helpers.map
import com.ss.lloydsbankpoc.base.helpers.safeFlowBuilder
import com.ss.lloydsbankpoc.data.remote.response.GetBooksApiResponse
import com.ss.lloydsbankpoc.domain.entity.BooksEntity
import com.ss.lloydsbankpoc.domain.repo.BooksRepo
import com.ss.lloydsbankpoc.domain.mapper.toPostsEntities
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class BooksRepoImplTest(private val fakeApiService: FakeApiService) : BooksRepo {
    override suspend fun getAllPosts(): Flow<Either<Failure, List<BooksEntity>>> {

        return safeFlowBuilder { fakeApiService.getAllBooks() }.map { value ->
            when (value) {
                is Either.Left -> value
                is Either.Right -> value.map(GetBooksApiResponse::toPostsEntities)
            }
        }
    }
}