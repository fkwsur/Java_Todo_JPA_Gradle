package todo.demo.controller;

import todo.demo.models.*;
import todo.demo.service.*;

// 프레임워크에 탑재된 기능 가져오기
import org.springframework.web.bind.annotation.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

// 자바 가지고 있는 내장 모듈
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.List;
import java.util.Iterator;
import lombok.RequiredArgsConstructor;

@RestController // restApi를 작성할 수 있는 컨트롤러
@RequestMapping("/api/todo") // url을 api로 지정
@CrossOrigin(origins = "*", allowedHeaders = "*") // cors허용
@RequiredArgsConstructor
public class TodolistController {

    private final TodoService todoService;

    @GetMapping("/hello")
    public ResponseEntity<Map<String, String>> Hello() {
        Map<String, String> map = new HashMap<>();
        map.put("result", "hello world");

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @PostMapping("/create")
    public ResponseEntity<Map<String, String>> Create(@RequestBody Todo req) {
        System.out.println(req.getTitle());
        System.out.println(req.getDescription());
        Map<String, String> map = new HashMap<>();

        if (todoService.createTodo(req)) {
            map.put("result", "success");
        } else {
            map.put("result", "failed");
        }

        return new ResponseEntity<>(map, HttpStatus.OK);
    }

    @GetMapping("/list")
    public ResponseEntity<Object> Select() {
        List<Todo> todolist = todoService.selectTodo();
        return new ResponseEntity<>(todolist, HttpStatus.OK);
    }

    @PostMapping("/update")
    public ResponseEntity<Object> Update(@RequestBody Todo req) {
        Todo todolist = todoService.updateTodo(req);
        return new ResponseEntity<>(todolist, HttpStatus.OK);
    }

    @PostMapping("/delete")
    public ResponseEntity<Object> Delete(@RequestBody Map<String, Long> req) {
        todoService.deleteTodo(req.get("id"));
        Map<String, String> map = new HashMap<>();
        map.put("result", "success");
        return new ResponseEntity<>(map, HttpStatus.OK);
    }

}
