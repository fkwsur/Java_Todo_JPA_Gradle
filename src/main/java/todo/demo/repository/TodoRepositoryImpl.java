package todo.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import todo.demo.models.Todo;

public interface TodoRepositoryImpl extends JpaRepository<Todo, Long> {
}
