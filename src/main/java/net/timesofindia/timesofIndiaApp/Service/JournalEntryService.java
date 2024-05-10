package net.timesofindia.timesofIndiaApp.Service;
import net.timesofindia.timesofIndiaApp.Entity.JournalEntry;

import java.util.List;
import java.util.Optional;

public interface JournalEntryService {

  // Create
  void createJournalEntry(JournalEntry journalEntry, String userName);

  void createJournalEntry(JournalEntry journalEntry);

  // get All Entry
  public List<JournalEntry> getAll();
  //Get by Id Entry

  public Optional<JournalEntry> findById(Long id);
  //Delete Entry

  public void deleteById(Long id, String userName);
  // Update Entry




}
