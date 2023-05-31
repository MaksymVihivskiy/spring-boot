package ua.kpi.its.lab.rest.entity

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "journal")
data class Journal(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long,
    val title: String,
    val subject: String,
    val language: String,
    val dateOfEstablishment: LocalDate,
    val issn: String,
    val recommendedPrice: Int,
    val periodical: Boolean,
    @OneToMany(mappedBy = "journal", cascade = [CascadeType.ALL], orphanRemoval = true)
    var articles: MutableList<Article> = mutableListOf()
) : Comparable<Journal> {
    override fun compareTo(journal: Journal): Int {
        return title.compareTo(journal.title)
    }

    fun addArticle(article: Article) {
        articles.add(article)
        article.journal = this
    }
}