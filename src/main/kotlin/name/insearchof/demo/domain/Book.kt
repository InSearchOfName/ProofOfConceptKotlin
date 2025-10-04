package name.insearchof.demo.domain

import jakarta.persistence.*

@Entity
@Table(name = "books")
data class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(nullable = false)
    val title: String,
    @Column(nullable = false)
    val author: String,
    val publishedYear: Int? = null,
    val isbn: String? = null
)
