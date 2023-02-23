package com.example.todolistserver.service;

import com.example.todolistserver.model.TodoEntity;
import com.example.todolistserver.model.TodoRequest;
import com.example.todolistserver.repository.TodoRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@AllArgsConstructor
public class TodoService {

    private final TodoRepository todoRepository;

    // todo 리스트 목록에 아이템 추가
    // todo 리스트 목록 중 특정 아이템 조회
    // todo 리스트 전체 목록 조회
    // todo 리스트 목록 중 특정 아이템 수정
    // todo 리스트 목록 중 특정 아이템을 삭제
    // todo 리스트 전체 목록을 삭제

    public TodoEntity add(TodoRequest request) {
        TodoEntity todoEntity = new TodoEntity();
        todoEntity.setTitle(request.getTitle());
        todoEntity.setOrder(request.getOrder());
        todoEntity.setCompleted(request.getCompleted());
        return this.todoRepository.save(todoEntity);
    }

    public TodoEntity searchById(Long id) {
        return this.todoRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));

    }

    public List<TodoEntity> searchAll() {
        return this.todoRepository.findAll();
    }

    public TodoEntity updateById(Long id, TodoRequest request) {
        TodoEntity todoEntity = this.searchById(id);
        if (request.getTitle() != null){
            todoEntity.setTitle(request.getTitle());
        }
        if (request.getOrder() != null){
            todoEntity.setOrder(request.getOrder());
        }
        if (request.getCompleted() != null){
            todoEntity.setCompleted(request.getCompleted());
        }
        return this.todoRepository.save(todoEntity);
    }

    public void deleteById(Long id) {
        this.todoRepository.deleteById(id);
    }

    public void deleteAll(){
        this.todoRepository.deleteAll();
    }
}
