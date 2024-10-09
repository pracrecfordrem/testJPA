package org.example.itemnote;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.Item;

import java.time.Instant;


@Data
@AllArgsConstructor
@Entity(name = "item_notes")
@RequiredArgsConstructor
public class ItemNote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NonNull
    private String text;
    @NonNull
    @ManyToOne(fetch = FetchType.LAZY)
    private Item item;
    @Column(name = "note_date")
    private Instant dateOfNote = Instant.now();

    public ItemNote() {
    }
}
