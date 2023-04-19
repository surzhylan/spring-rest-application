package kz.bitlab.rest.RestApplication.repositories;

import kz.bitlab.rest.RestApplication.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface ItemRepository extends JpaRepository<Item, Long> {
    Item findAllById(Long id);
}
