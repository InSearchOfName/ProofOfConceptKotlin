package name.insearchof.demo.dto

import name.insearchof.demo.domain.Book


data class BookDto(
    val id: Long? = null,
    val title: String,
    val author: String,
    val publishedYear: Int? = null,
    val isbn: String? = null
)

fun BookDto.toEntity() = Book(
    id = this.id ?: 0,
    title = this.title,
    author = this.author,
    publishedYear = this.publishedYear,
    isbn = this.isbn
)


fun Book.toDto() = BookDto(
    id = this.id,
    title = this.title,
    author = this.author,
    publishedYear = this.publishedYear,
    isbn = this.isbn
)