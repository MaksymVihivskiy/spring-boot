import ua.kpi.its.lab.rest.entity.Journal

interface Container<T> {
    fun add(car: T)
    fun remove(index: Int)
    fun update(index: Int, car: T)
    fun get(index: Int): T
    fun getAll(): List<T>
}

class JournalContainer : Container<Journal> {
    private val journals: MutableList<Journal> = mutableListOf()
    override fun add(journal: Journal) {
        journals.add(journal)
    }

    override fun remove(index: Int) {
        journals.removeAt(index)
    }

    override fun update(index: Int, journal: Journal) {
        journals[index] = journal
    }

    override fun get(index: Int): Journal {
        return journals[index]
    }

    override fun getAll(): List<Journal> {
        return journals
    }
}