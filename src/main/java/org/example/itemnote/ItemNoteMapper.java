package org.example.itemnote;
import org.example.Item;

import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;

public class ItemNoteMapper {
    public static ItemNote mapToItemNote(ItemNoteDto itemNoteDto, Item item) {
        ItemNote itemNote = new ItemNote();
        itemNote.setItem(item);
        itemNote.setText(itemNoteDto.getText());
        return itemNote;
    }
    public static ItemNoteDto mapToItemNoteDto(ItemNote itemNote) {
        ItemNoteDto itemNoteDto = new ItemNoteDto();
        itemNoteDto.setId(itemNote.getId());
        itemNoteDto.setItemId(itemNote.getItem().getId());
        itemNoteDto.setDateOfNote(DateTimeFormatter
                .ofPattern("yyyy.MM.dd hh:mm:ss")
                .withZone(ZoneOffset.UTC)
                .format(itemNote.getDateOfNote()));
        itemNoteDto.setText(itemNote.getText());
        itemNoteDto.setItemUrl(itemNote.getItem().getUrl());
        return itemNoteDto;
    }
}
