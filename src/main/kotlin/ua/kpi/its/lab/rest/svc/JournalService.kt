package ua.kpi.its.lab.rest.svc

import ua.kpi.its.lab.rest.dto.JournalRequest
import ua.kpi.its.lab.rest.dto.JournalResponse

interface JournalService {
    fun createJournal(journalRequest: JournalRequest): JournalResponse
    fun getJournalById(id: Long): JournalResponse
    fun updateJournalById(id: Long, journalRequest: JournalRequest): JournalResponse
    fun deleteJournalById(id: Long): Boolean
}