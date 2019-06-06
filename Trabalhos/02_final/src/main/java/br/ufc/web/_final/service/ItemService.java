package br.ufc.web._final.service;

import br.ufc.web._final.model.Item;
import br.ufc.web._final.repository.ItemRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;

    public void save(Item item) {
        itemRepository.save(item);
    }

    public List<Item> listItens() { return itemRepository.findAll(); }

    public void delete(Long id) {
        itemRepository.deleteById(id);
    }

    public Item serchById(Long id) { return itemRepository.getOne(id); }

}
