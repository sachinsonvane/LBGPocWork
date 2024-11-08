package com.ss.lloydsbankpoc.use_cases

import com.ss.lloydsbankpoc.domain.repo.BooksRepo
import com.ss.lloydsbankpoc.domain.use_cases.GetAllBooksUseCases


open class GetAllBooksUseCasesTest(postRepoImplTest: BooksRepo): GetAllBooksUseCases(postRepoImplTest){

}