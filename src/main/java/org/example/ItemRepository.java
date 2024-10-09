package org.example;

import com.querydsl.core.types.dsl.BooleanExpression;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.Set;


@Component
public interface ItemRepository extends CrudRepository<Item, Long>, QuerydslPredicateExecutor<Item> {

    @Query("select new org.example.ItemCountByUser(1L, 1L)")
    List<ItemCountByUser> countItemsByUser(String urlPart);

    @Query("select it " +
            "from org.example.Item as it "+
            "join it.user as u " +
            "where u.lastName like concat(?1, '%') ")
    List<Item> findItemsByLastNamePrefix(String lastNamePrefix);
    List<Item> findAllByUserLastNameStartingWith(String lastNamePrefix);
}
