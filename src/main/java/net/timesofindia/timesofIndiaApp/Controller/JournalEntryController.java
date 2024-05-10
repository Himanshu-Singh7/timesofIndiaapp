package net.timesofindia.timesofIndiaApp.Controller;

import net.timesofindia.timesofIndiaApp.Entity.JournalEntry;
import net.timesofindia.timesofIndiaApp.Entity.User;
import net.timesofindia.timesofIndiaApp.Service.JournalEntryService;
import net.timesofindia.timesofIndiaApp.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/journalentry")
public class JournalEntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @Autowired
    private UserService userService;

    @GetMapping("/{userName}")
    public ResponseEntity<?> getAllJournalEntry(@PathVariable String userName){
        User user = userService.findByUserName(userName);
        List<JournalEntry> all = user.getJournalEntries();
        if (all != null && !all.isEmpty()){
            return new ResponseEntity<>(all , HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/save/{userName}")
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry journalEntry, @PathVariable String userName){
        try {
            journalEntryService.createJournalEntry(journalEntry,userName);
            return new ResponseEntity<>(journalEntry ,HttpStatus.CREATED);
        }catch (Exception e){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/id/{myId}")
    public ResponseEntity<JournalEntry> getEntryById(@PathVariable Long myId){
        Optional<JournalEntry> jornalEntry = journalEntryService.findById(myId);
        if (jornalEntry.isPresent()){
            return new ResponseEntity<>(jornalEntry.get() ,HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

    }

    @DeleteMapping("/id/{userName}/{myId}")
    public ResponseEntity<?> deleteEntry(@PathVariable Long myId , @PathVariable String userName){
        journalEntryService.deleteById(myId,userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/id/{userName}/{myId}")
    public ResponseEntity<?> updateEntryById(
            @RequestBody JournalEntry newEntry ,
            @PathVariable Long myId,
            @PathVariable String userName){

        JournalEntry old = journalEntryService.findById(myId).orElseThrow(null);

        if(old != null){
            old.setTitle(newEntry.getTitle() != null  && !newEntry.getTitle().equals(" ") ? newEntry.getTitle() : old.getTitle());
            old.setContent(newEntry.getContent() != null && !newEntry.getContent().equals("") ? newEntry.getContent():old.getContent());
            journalEntryService.createJournalEntry(old);
            return new ResponseEntity<>(old , HttpStatus.OK);
        }
       return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
}
