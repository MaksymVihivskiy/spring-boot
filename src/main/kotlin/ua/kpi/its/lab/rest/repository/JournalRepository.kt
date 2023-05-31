package ua.kpi.its.lab.rest.repository

import ua.kpi.its.lab.rest.entity.Journal
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface JournalRepository : JpaRepository<Journal, Long>