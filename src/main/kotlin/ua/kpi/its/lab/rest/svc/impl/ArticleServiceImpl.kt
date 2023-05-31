package ua.kpi.its.lab.rest.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.rest.dto.ArticleRequest
import ua.kpi.its.lab.rest.dto.ArticleResponse
import ua.kpi.its.lab.rest.entity.Article
import ua.kpi.its.lab.rest.repository.ArticleRepository
import ua.kpi.its.lab.rest.svc.ArticleService
@Service
class ArticleServiceImpl(private val articleRepository: ArticleRepository) : ArticleService {
    @PreAuthorize("hasAuthority('MODERATOR')")
    override fun createArticle(articleRequest: ArticleRequest): ArticleResponse {
        val article = Article(title = articleRequest.title, author = articleRequest.author)
        val newArticle = articleRepository.save(article)
        return ArticleResponse.fromEntity(newArticle)
    }

    @PreAuthorize("hasAuthority('CLIENT')")
    override fun getArticleById(id: Long): ArticleResponse {
        val article = articleRepository.findById(id).orElseThrow()
        return ArticleResponse.fromEntity(article)
    }

    @PreAuthorize("hasAuthority('MODERATOR')")
    override fun updateArticleById(id: Long, articleRequest: ArticleRequest): ArticleResponse {
        val article = articleRepository.findById(id).orElseThrow()
        article.title = articleRequest.title
        article.author = articleRequest.author
        val updatedArticle = articleRepository.save(article)
        return ArticleResponse.fromEntity(updatedArticle)
    }

    @PreAuthorize("hasAuthority('MODERATOR')")
    override fun deleteArticleById(id: Long): Boolean {
        articleRepository.deleteById(id)
        return true
    }
}