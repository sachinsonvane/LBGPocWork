package com.sns.lbgpoc.di

import com.ss.lloydsbankpoc.data.repo_impl.BooksRepoImpl
import com.ss.lloydsbankpoc.domain.repo.BooksRepo
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepoModule {
    @Binds
    abstract fun bindPostRepo(impl: BooksRepoImpl): BooksRepo
}