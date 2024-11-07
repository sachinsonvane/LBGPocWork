package com.ss.lloydsbankpoc.base.usecase

interface UseCase<Params, Result> {
    suspend operator fun invoke(params: Params): Result
}