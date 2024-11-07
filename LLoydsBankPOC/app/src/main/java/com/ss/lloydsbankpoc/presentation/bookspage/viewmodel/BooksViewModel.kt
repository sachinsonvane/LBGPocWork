package com.ss.lloydsbankpoc.presentation.bookspage.viewmodel

import com.ss.lloydsbankpoc.R
import com.ss.lloydsbankpoc.base.helpers.Either
import com.ss.lloydsbankpoc.base.viewmodel.CoreViewModel
import com.ss.lloydsbankpoc.domain.use_cases.GetAllBooksUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class BooksViewModel @Inject constructor(private val getAllPostsUseCases: GetAllBooksUseCases
) : CoreViewModel() {

    val allItems = executeApi { getAllPostsUseCases.invoke() }.map { value ->  when(value){
        is Either.Left -> emptyList()
        is Either.Right -> value.r
    } }
}