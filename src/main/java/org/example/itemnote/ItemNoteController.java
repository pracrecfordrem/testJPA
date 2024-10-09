package org.example.itemnote;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/notes")
@AllArgsConstructor
public class ItemNoteController {
    @Autowired
    private final ItemNoteServiceImpl itemNoteService;
    @GetMapping(params = "url")
    public List<ItemNoteDto> searchByUrl(@RequestHeader("X-Later-User-Id") long userId,
                                      @RequestParam(name="url") String url) {
        return itemNoteService.searchNotesByUrl(url,userId);
    }

    @GetMapping(params = "tag")
    public List<ItemNote> searchByTags(@RequestHeader("X-Later-User-Id") long userId,
                                       @RequestParam(name = "tag") String tag) {
        return itemNoteService.searchNotesByTag(userId,tag);
    }

    @GetMapping
    public List<ItemNote> listAllNotes(@RequestHeader("X-Later-User-Id") long userId,
                                       @RequestParam(name = "from", defaultValue = "0") int from,
                                       @RequestParam(name = "size", defaultValue = "10") int size) {
        System.out.println("listAllNotes");
        return itemNoteService.listAllItemsWithNotes(userId, from, size);
    }

    @PostMapping
    public ItemNote add(@RequestHeader("X-Later-User-Id") Long userId, @RequestBody ItemNoteDto itemNoteDto) {
        System.out.println(itemNoteDto);
        return itemNoteService.addNewItemNote(userId,itemNoteDto);
    }
}
