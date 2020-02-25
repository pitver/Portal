package ru.vershinin.TKK_Portal.persist.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.vershinin.TKK_Portal.persist.entity.ToDo;
import ru.vershinin.TKK_Portal.persist.entity.User;
import ru.vershinin.TKK_Portal.repr.ToDoRepr;

import java.util.List;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {

    List<ToDoRepr> findToDoByUser_Username(String username);

    List<ToDoRepr> findToDoByUser(User user);
}

