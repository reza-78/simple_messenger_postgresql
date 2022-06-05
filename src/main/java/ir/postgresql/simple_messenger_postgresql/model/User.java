package ir.postgresql.simple_messenger_postgresql.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "`user`")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "username")
    private String username;

    @Column(name = "groups")
    @ManyToMany
    @JoinTable(name = "user_group", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "group_id"))
    @Setter
    private List<Group> groups;

    @OneToMany(mappedBy = "sender")
    private List<Message> messages;
}
