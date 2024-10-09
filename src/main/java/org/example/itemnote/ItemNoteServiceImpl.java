package org.example.itemnote;

import org.example.Item;
import org.example.ItemRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemNoteServiceImpl implements ItemNoteService {
    private final ItemNoteRepository itemNoteRepository;
    private final ItemRepository itemRepository;

    public ItemNoteServiceImpl(ItemNoteRepository itemNoteRepository, ItemRepository itemRepository) {
        this.itemNoteRepository = itemNoteRepository;
        this.itemRepository = itemRepository;
    }

    @Override
    public ItemNote addNewItemNote(long userId, ItemNoteDto itemNoteDto) {
        Item item = itemRepository.findById(itemNoteDto.getItemId()).orElseThrow(() -> new RuntimeException("Item not found"));
        return itemNoteRepository.save(ItemNoteMapper.mapToItemNote(itemNoteDto,item));
    }

    @Override
    public List<ItemNoteDto> searchNotesByUrl(String url, Long userId) {
        return itemNoteRepository.findByUrl(url).stream().map(ItemNoteMapper::mapToItemNoteDto).collect(Collectors.toList());
    }

    @Override
    public List<ItemNote> searchNotesByTag(long userId, String tag) {
        return itemNoteRepository.findByTag(userId,tag);
    }

    @Override
    public List<ItemNote> listAllItemsWithNotes(long userId, int from, int size) {
        return null;
    }
}
