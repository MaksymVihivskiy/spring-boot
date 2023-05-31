package ua.kpi.its.lab.rest.controller;

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import ua.kpi.its.lab.rest.dto.JournalRequest
import ua.kpi.its.lab.rest.dto.JournalResponse
import ua.kpi.its.lab.rest.svc.impl.JournalServiceImpl


@RestController
@RequestMapping("/journal")
class JournalController {

    private final lateinit var journalServiceImpl: JournalServiceImpl;

    @Autowired
    fun JournalController(journalServiceImpl: JournalServiceImpl) {
        this.journalServiceImpl = journalServiceImpl;
    }

    @GetMapping("/{id}")
    fun getJournalById(@PathVariable id: Long): ResponseEntity<JournalResponse>? {
        val response: JournalResponse = journalServiceImpl.getJournalById(id);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/")
    fun createJournal(@Valid @RequestBody request: JournalRequest?): ResponseEntity<JournalResponse>? {
        val response: JournalResponse? = request?.let {
            journalServiceImpl.createJournal(it)
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(response)
    }

    @PutMapping("/{id}")
    fun updateJournalById(
        @PathVariable id: Long,
        @Valid @RequestBody request: JournalRequest?
    ): ResponseEntity<JournalResponse>? {
        val response: JournalResponse? = request?.let {
            journalServiceImpl.updateJournalById(id, it)
        }
        return ResponseEntity.ok(response)
    }

    @DeleteMapping("/{id}")
    fun deleteJournalById(@PathVariable id: Long): ResponseEntity<Void?>? {
        val successful: Boolean = journalServiceImpl.deleteJournalById(id)
        if (successful) {
            println("Journal with id $id deleted successfully")
        } else {
            println("Journal with id $id not found")
        }
        return ResponseEntity.noContent().build()
    }
}