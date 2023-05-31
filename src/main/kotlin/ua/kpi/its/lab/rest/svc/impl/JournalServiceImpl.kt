package ua.kpi.its.lab.rest.svc.impl

import org.springframework.stereotype.Service
import ua.kpi.its.lab.rest.dto.JournalRequest
import ua.kpi.its.lab.rest.dto.JournalResponse
import ua.kpi.its.lab.rest.entity.Journal
import ua.kpi.its.lab.rest.repository.JournalRepository
import ua.kpi.its.lab.rest.svc.JournalService

@Service
class JournalServiceImpl(private val journalRepository: JournalRepository) : JournalService {
    @PreAuthorize("hasAuthority('MODERATOR')")
    override fun createJournal(journalRequest: JournalRequest): JournalResponse {
        val journal = Journal(title = journalRequest.title, subject = journalRequest.subject)
        return JournalResponse.fromEntity(journalRepository.save(journal))
    }

    @PreAuthorize("hasAuthority('CLIENT')")
    override fun getJournalById(id: Long): JournalResponse {
        val journal = journalRepository.findById(id).orElseThrow()
        return JournalResponse.fromEntity(journal)
    }

    @PreAuthorize("hasAuthority('MODERATOR')")
    override fun updateJournalById(id: Long, journalRequest: JournalRequest): JournalResponse {
        val journal = journalRepository.findById(id).orElseThrow()
        journal.title = journalRequest.title
        journal.subject = journalRequest.subject
        val resultJournal = journalRepository.save(journal)
        return JournalResponse.fromEntity(resultJournal)
    }

    @PreAuthorize("hasAuthority('MODERATOR')")
    override fun deleteJournalById(id: Long): Boolean {
        journalRepository.deleteById(id)
        return true
    }
}