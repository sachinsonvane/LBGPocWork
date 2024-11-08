package com.ss.lloydsbankpoc.domain.repo

import com.ss.lloydsbankpoc.domain.entity.BooksEntity
import com.ss.lloydsbankpoc.base.failure.Failure
import com.ss.lloydsbankpoc.base.helpers.Either
import kotlinx.coroutines.flow.Flow

interface  BooksRepo {

    suspend fun getAllBooks(): Flow<Either<Failure, List<BooksEntity>>>
}