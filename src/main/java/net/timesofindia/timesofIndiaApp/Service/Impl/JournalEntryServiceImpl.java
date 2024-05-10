package net.timesofindia.timesofIndiaApp.Service.Impl;
import jakarta.transaction.Transactional;
import net.timesofindia.timesofIndiaApp.Entity.JournalEntry;
import net.timesofindia.timesofIndiaApp.Entity.User;
import net.timesofindia.timesofIndiaApp.Repository.JournalEntryRepository;
import net.timesofindia.timesofIndiaApp.Service.JournalEntryService;
import net.timesofindia.timesofIndiaApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class JournalEntryServiceImpl implements JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;


    @Autowired
     private UserService userService;

    @Override
    @Transactional
    public void createJournalEntry(JournalEntry journalEntry, String userName) {
       try {

           User user = userService.findByUserName(userName);
           journalEntry.setDate(LocalDateTime.now());
           JournalEntry saved = journalEntryRepository.save(journalEntry);
           user.getJournalEntries().add(saved);
           userService.createUser(user);
       }catch (Exception e){
           System.out.println(e);
       }
    }

    @Override
    public void createJournalEntry(JournalEntry journalEntry) {
        journalEntryRepository.save(journalEntry);
    }


    @Override
    public List<JournalEntry> getAll() {
        return journalEntryRepository.findAll().stream().map(entry -> entry).collect(Collectors.toList());
    }

    @Override
    public Optional<JournalEntry> findById(Long id) {
        return journalEntryRepository.findById(id);
    }

    @Override
    public void deleteById(Long id, String userName) {
        User user = userService.findByUserName(userName);
        user.getJournalEntries().removeIf(x -> x.getId().equals(id));
        userService.createUser(user);
        journalEntryRepository.deleteById(id);

    }


}
