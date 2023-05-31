package ua.kpi.its.lab.rest.svc

import ua.kpi.its.lab.rest.dto.ArticleRequest
import ua.kpi.its.lab.rest.dto.ArticleResponse
interface ArticleService {
    fun createArticle(req: ArticleRequest): ArticleResponse
    fun getArticleById(id: Long): ArticleResponse
    fun updateArticleById(id: Long, req: ArticleRequest): ArticleResponse
    fun deleteArticleById(id: Long): Boolean
}