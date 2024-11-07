package com.ss.lloydsbankpoc.domain.mapper

import com.ss.lloydsbankpoc.data.remote.response.GetBooksApiResponse
import com.ss.lloydsbankpoc.domain.entity.BooksEntity

fun GetBooksApiResponse.toPostsEntities(): List<BooksEntity> {
    return this.map { currentObject ->
        BooksEntity(
            title = currentObject.title,
            originalTitle = currentObject.originalTitle,
            releaseDate = currentObject.releaseDate,
            description = currentObject.description,
            cover = currentObject.cover
        )
    }}

