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
    fun list(@RequestParam(required = false) q: String?): ResponseEntity<List<BookDto>> {
        val result = if (q != null) {
            service.searchByTitle(q)
        } else {
            service.listAll()
        }
        return ResponseEntity.ok(result)
    }


    @GetMapping("/{id}")
    fun get(@PathVariable id: Long): ResponseEntity<BookDto> {
        return ResponseEntity.ok(service.getById(id))
    }

    @PostMapping
    fun create(@Valid @RequestBody dto: BookDto): ResponseEntity<BookDto> {
        return ResponseEntity.ok(service.create(dto))
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @Valid @RequestBody dto: BookDto): ResponseEntity<BookDto> {
        return ResponseEntity.ok(service.update(id,dto))
    }


    @DeleteMapping("/{id}")
    fun delete(@PathVariable id: Long): ResponseEntity<Unit>{
        service.delete(id)
        return ResponseEntity.ok().build()
    }
}