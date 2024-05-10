package net.timesofindia.timesofIndiaApp.Repository;
import net.timesofindia.timesofIndiaApp.Entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JournalEntryRepository extends JpaRepository<JournalEntry ,Long> {
}
