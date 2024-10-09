package org.example;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.example.user.User;

import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@Entity(name = "items")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "items_id_seq")
    @SequenceGenerator(name = "items_id_seq", sequenceName = "items_id_seq", allocationSize = 1)
    private long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    private String url;

    @ElementCollection
    @CollectionTable(name="tags", joinColumns=@JoinColumn(name="item_id"))
    @Column(name="name")
    private Set<String> tags = new HashSet<>();
    public Item() {
    }
}
