package ua.kpi.its.lab.rest.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name="article")
data class Article(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val title: String,
    val author: String,
    val dateOfWriting: LocalDate,
    val numOfWords: Int,
    val numOfLinks: Int,
    val isNativeLang: Boolean,
    @ManyToOne
    @JoinColumn(name = "journal_id")
    val journal: Journal,
) : Comparable<Article> {
    override fun compareTo(article: Article): Int {
        return title.compareTo(article.title)
    }
}