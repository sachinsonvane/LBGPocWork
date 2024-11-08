package com.ss.lloydsbankpoc

import app.cash.turbine.test
import com.ss.lloydsbankpoc.base.failure.Failure
import com.ss.lloydsbankpoc.base.helpers.Either
import com.ss.lloydsbankpoc.domain.entity.BooksEntity
import com.ss.lloydsbankpoc.presentation.bookspage.viewmodel.BooksViewModel
import com.ss.lloydsbankpoc.use_cases.GetAllBooksUseCasesTest
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.TestScope
import kotlinx.coroutines.test.runTest
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations
import assertk.assertThat
import assertk.assertions.isEqualTo

@ExperimentalCoroutinesApi
class BooksViewModelTest {

    private val testDispatcher = StandardTestDispatcher()
    private val testScope = TestScope(testDispatcher)

    @Mock
    lateinit var getAllBooksUseCases: GetAllBooksUseCasesTest

    @InjectMocks
    lateinit var booksViewModel: BooksViewModel

    @BeforeEach
    fun setup() {
        MockitoAnnotations.openMocks(this)
    }

    @Test
    fun `test loading posts success`() = testScope.runTest {
        // Arrange
        val mockPosts = listOf(BooksEntity(title = "title", originalTitle = "", releaseDate = "",description="description",cover="cover"))
        `when`(getAllBooksUseCases.invoke()).thenReturn(flowOf(Either.Right(mockPosts)))

        // Act and Assert using Turbine
        booksViewModel.allItems.test {
            // Trigger the flow
            booksViewModel.allItems
            assertThat(awaitItem().size ).isEqualTo(1)
            awaitComplete()

        }
    }

    @Test
    fun `test loading posts failure`() = testScope.runTest {
        // Arrange
        val failure = Failure.NetworkFailure
        `when`(getAllBooksUseCases.invoke()).thenReturn(flowOf(Either.Left(failure)))

        // Act and Assert using Turbine
        booksViewModel.allItems.test {
            // Trigger the flow
            booksViewModel.allItems
            assertThat(awaitItem().size).isEqualTo(0)
            awaitComplete()
        }
    }

}
