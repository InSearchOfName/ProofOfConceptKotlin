package name.insearchof.demo.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFound(ex: NotFoundException): ResponseEntity<Map<String, String?>> {
        return ResponseEntity.status(404).body(mapOf("error" to ex.message))
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(ex: MethodArgumentNotValidException): ResponseEntity<Map<String, List<String?>>> {
        val errors = ex.bindingResult.fieldErrors.map { it.defaultMessage }
        return ResponseEntity.badRequest().body(mapOf("errors" to errors))
    }


    @ExceptionHandler(Exception::class)
    fun handleGeneric(ex: Exception): ResponseEntity<Map<String, String>> {
        val errorMsg = ex.message ?: "unexpected error"
        return ResponseEntity.status(500).body(mapOf("error" to errorMsg))
    }
}