package ir.postgresql.simple_messenger_postgresql.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity(name = "`group`")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "group_name")
    private String name;

    @ManyToMany(mappedBy = "groups")
    @Setter
    private List<User> members;

    @OneToMany(mappedBy = "group")
    private List<Message> messages;


}
