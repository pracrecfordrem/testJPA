package org.example.itemnote;


import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
interface ItemNoteService {

    @Transactional
    ItemNote addNewItemNote(long userId, ItemNoteDto itemNoteDto);

    List<ItemNoteDto> searchNotesByUrl(String url, Long userId);

    List<ItemNote> searchNotesByTag(long userId, String tag);

    List<ItemNote> listAllItemsWithNotes(long userId, int from, int size);
}
  