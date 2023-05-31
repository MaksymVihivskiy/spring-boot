package ua.kpi.its.lab.rest.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ua.kpi.its.lab.rest.dto.ArticleRequest
import ua.kpi.its.lab.rest.dto.ArticleResponse
import ua.kpi.its.lab.rest.svc.impl.ArticleServiceImpl

@RestController
@RequestMapping("/article")
class ArticleController(private val articleServiceImpl: ArticleServiceImpl) {
    @PostMapping
    fun createArticle(@RequestBody request: ArticleRequest): ResponseEntity<ArticleResponse> {
        val response = articleServiceImpl.createArticle(request)
        return ResponseEntity(response, HttpStatus.CREATED)
    }

    @GetMapping("/{id}")
    fun getArticleById(@PathVariable id: Long): ResponseEntity<ArticleResponse> {
        val response = articleServiceImpl.getArticleById(id)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @PutMapping("/{id}")
    fun updateArticleById(@PathVariable id: Long, @RequestBody request: ArticleRequest): ResponseEntity<ArticleResponse> {
        val response = articleServiceImpl.updateArticleById(id, request)
        return ResponseEntity(response, HttpStatus.OK)
    }

    @DeleteMapping("/{id}")
    fun deleteArticleById(@PathVariable id: Long): ResponseEntity<Void> {
        articleServiceImpl.deleteArticleById(id)
        return ResponseEntity(HttpStatus.NO_CONTENT)
    }
}