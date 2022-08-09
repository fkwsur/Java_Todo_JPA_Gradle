package todo.demo.repository;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import todo.demo.models.Todo;
import java.util.List;

@RequiredArgsConstructor
@Repository
public class TodoRepository {

    private final EntityManager em;

    public void createTodo(Todo todo) {
        em.persist(todo);
    }

    public List<Todo> selectTodo(Todo todo) {
        return em.createQuery("select * from todo", Todo.class)
                .getResultList();
    }

}
