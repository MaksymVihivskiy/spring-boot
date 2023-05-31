package ua.kpi.its.lab.rest.dto

import java.time.LocalDate

class ArticleRequest {
    var title: String? = null
        private set
    var author: String? = null
        private set
    var dateOfWriting: LocalDate? = null
        private set

    constructor()
    constructor(title: String?, author: String?, dateOfWriting: LocalDate?) {
        this.title = title
        this.author = author
        this.dateOfWriting = dateOfWriting
    }
}


class ArticleResponse {
    var id: Long? = null
        private set
    var title: String? = null
        private set
    var author: String? = null
        private set
    var dateOfWriting: LocalDate? = null
        private set

    constructor()
    constructor(id: Long?, title: String?, author: String?, dateOfWriting: LocalDate?) {
        this.id = id
        this.title = title
        this.author = author
        this.dateOfWriting = dateOfWriting
    }
}


class JournalRequest {
    var title: String? = null
        private set
    var subject: String? = null
        private set
    var language: String? = null
        private set

    constructor()
    constructor(title: String?, subject: String?, language: String?) {
        this.title = title
        this.subject = subject
        this.language = language
    }
}


class JournalResponse {
    var id: Long? = null
        private set
    var title: String? = null
        private set
    var subject: String? = null
        private set
    var language: String? = null
        private set

    constructor()
    constructor(id: Long?, title: String?, subject: String?, language: String?) {
        this.id = id
        this.title = title
        this.subject = subject
        this.language = language
    }
}

