package ru.vershinin.TKK_Portal.persist.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import ru.vershinin.TKK_Portal.persist.entity.ToDo;
import ru.vershinin.TKK_Portal.repr.ToDoRepr;

import java.util.List;

@Repository
public interface ToDoRepository extends CrudRepository<ToDo, Long> {

    @Query
     ("select new ru.vershinin.TKK_Portal.repr.ToDoRepr(t.id, t.description, t.user.username, t.targetDate) " +
            "from ToDo t " +
            "where t.user.id = :userId")
    List<ToDoRepr> findToDosByUserId(@Param("userId") Long userId);

}
