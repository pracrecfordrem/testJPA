package org.example.itemnote;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ItemNoteRepository extends CrudRepository<ItemNote, Long> {
    @Query("select in " +
            "from org.example.itemnote.ItemNote as in "+
            "join in.item as i " +
            "where " +
            "  i.url like concat(?1, '%')")
    List<ItemNote> findByUrl(String url);

    @Query("select itNote " +
            "from org.example.itemnote.ItemNote as itNote " +
            "join itNote.item as i " +
            "where i.user.id = ?1" +
            "  and ?2 member of i.tags")
    List<ItemNote> findByTag(Long userId, String tag);
}
