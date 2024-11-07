package com.ss.lloydsbankpoc.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.ss.lloydsbankpoc.R
import com.ss.lloydsbankpoc.presentation.bookspage.BooksScreen
import com.ss.lloydsbankpoc.presentation.bookspage.viewmodel.BooksViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.ss.lloydsbankpoc.base.routes.AppRoutes

@Composable
fun AppNavigation(
    modifier: Modifier = Modifier,
    navController: NavHostController,
    startDestination: String = AppRoutes.BOOKS_SCREEN.routeName
) {
    val booksViewModel: BooksViewModel = viewModel()
    NavHost(
        modifier = modifier,
        navController = navController,
        startDestination = startDestination
    ) {

        composable(
                route = AppRoutes.BOOKS_SCREEN.routeName,
            ) {
                BooksScreen(navController,booksViewModel = booksViewModel)
            }

    }
}



