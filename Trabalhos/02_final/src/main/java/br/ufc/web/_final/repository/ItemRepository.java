package br.ufc.web._final.repository;

import br.ufc.web._final.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
