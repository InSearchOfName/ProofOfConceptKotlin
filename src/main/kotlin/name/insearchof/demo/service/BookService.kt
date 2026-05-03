package name.insearchof.demo.service


import name.insearchof.demo.domain.Book
import name.insearchof.demo.dto.BookDto
import name.insearchof.demo.dto.toDto
import name.insearchof.demo.dto.toEntity
import name.insearchof.demo.exception.NotFoundException
import name.insearchof.demo.repository.BookRepository
import org.springframework.stereotype.Service


@Service
class BookService(private val repo: BookRepository) {


    fun listAll(): List<BookDto> {
        return repo.findAll().map { it.toDto() }
    }


    fun getById(id: Long): BookDto {
        return repo.findById(id).map { it.toDto() }
            .orElseThrow { NotFoundException("Book with id=$id not found") }
    }


    fun create(dto: BookDto): BookDto {
        return repo.save(dto.toEntity()).toDto()
    }


    fun update(id: Long, dto: BookDto): BookDto {
        val existing: Book = repo.findById(id).orElseThrow { NotFoundException("Book with id=$id not found") }
        val updated = existing.copy(
            title = dto.title,
            author = dto.author,
            publishedYear = dto.publishedYear,
            isbn = dto.isbn
        )
        return repo.save(updated).toDto()
    }


    fun delete(id: Long) {
        if (!repo.existsById(id)) throw NotFoundException("Book with id=$id not found")
        repo.deleteById(id)
    }


    fun searchByTitle(q: String): List<BookDto> {
        return repo.findByTitleContainingIgnoreCase(q).map { it.toDto() }
    }
}