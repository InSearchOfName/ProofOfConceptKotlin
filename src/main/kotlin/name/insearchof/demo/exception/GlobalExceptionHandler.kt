package name.insearchof.demo.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice


@RestControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException::class)
    fun handleNotFound(ex: NotFoundException) = ResponseEntity.status(404).body(mapOf("error" to ex.message))

    @ExceptionHandler(MethodArgumentNotValidException::class)
    fun handleValidation(ex: MethodArgumentNotValidException) =
        ResponseEntity.badRequest().body(mapOf("errors" to ex.bindingResult.fieldErrors.map { it.defaultMessage }))


    @ExceptionHandler(Exception::class)
    fun handleGeneric(ex: Exception) =
        ResponseEntity.status(500).body(mapOf("error" to (ex.message ?: "unexpected error")))
}