package net.timesofindia.timesofIndiaApp.Entity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Size(min = 4,max = 20,message="UserName must be minimum 4 to 20 charcter !!")
    @Column(name = "user_name",nullable = false, length = 100)
    private String userName;

    @Column(name = "password",nullable = false, length = 20)
    private String password;

    @OneToMany(mappedBy = "user" ,cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<JournalEntry> journalEntries = new ArrayList<>();

}
