package com.ss.lloydsbankpoc.domain.use_cases

import com.ss.lloydsbankpoc.domain.entity.BooksEntity
import com.ss.lloydsbankpoc.base.failure.Failure
import com.ss.lloydsbankpoc.base.helpers.Either
import com.ss.lloydsbankpoc.base.usecase.UseCaseNoParams
import com.ss.lloydsbankpoc.domain.repo.BooksRepo
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

open class GetAllBooksUseCases @Inject constructor(private val booksRepo: BooksRepo) :
    UseCaseNoParams<List<BooksEntity>> {
    override suspend fun invoke(): Flow<Either<Failure, List<BooksEntity>>> {
        return booksRepo.getAllPosts()
    }

}