package com.ss.lloydsbankpoc.base.usecase

import com.ss.lloydsbankpoc.base.failure.Failure
import com.ss.lloydsbankpoc.base.helpers.Either
import kotlinx.coroutines.flow.Flow


interface UseCaseNoParams<Result>  {

    suspend operator fun invoke(): Flow<Either<Failure, Result>>
}