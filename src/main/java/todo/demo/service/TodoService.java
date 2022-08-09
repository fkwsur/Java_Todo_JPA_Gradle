package todo.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import todo.demo.models.Todo;
import todo.demo.repository.TodoRepository;
import todo.demo.repository.TodoRepositoryImpl;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    private final TodoRepositoryImpl todoRepositoryImpl;

    @Autowired
    public TodoService(TodoRepository todoRepository, TodoRepositoryImpl todoRepositoryImpl) {
        this.todoRepository = todoRepository;
        this.todoRepositoryImpl = todoRepositoryImpl;
    }

    @Transactional
    public boolean createTodo(Todo todo) {
        try {
            todoRepository.createTodo(todo);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception
            return false;
        }
    }

    public List<Todo> selectTodo() {
        return todoRepositoryImpl.findAll();
    }

    public Todo updateTodo(Todo todo) {
        Todo update_todo = todoRepositoryImpl.save(todo);
        return update_todo;
    }

    public void deleteTodo(Long id) {
        todoRepositoryImpl.deleteById(id);
    }

}
