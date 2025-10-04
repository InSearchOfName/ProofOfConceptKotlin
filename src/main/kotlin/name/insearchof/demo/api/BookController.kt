package name.insearchof.demo.api


import jakarta.validation.Valid
import name.insearchof.demo.dto.BookDto
import name.insearchof.demo.service.BookService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*


@RestController
@RequestMapping("/api/books")
class BookController(private val service: BookService) {

    @GetMapping
    fun list(@RequestParam(required = false) q: String?): List<BookDto> =
        q?.let { service.searchByTitle(it) } ?: service.listAll()

    @GetMapping("/{id}")
    fun get(@PathVariable id: Long) = service.getById(id)

    @PostMapping
    fun create(@Valid @RequestBody dto: BookDto): ResponseEntity<BookDto> =
        ResponseEntity.ok(service.create(dto))

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Valid @RequestBody dto: BookDto) = service.update(id, dto)


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long) = ResponseEntity.noContent().apply { service.delete(id) }
}