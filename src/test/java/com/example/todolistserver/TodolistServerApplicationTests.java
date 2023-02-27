package com.example.todolistserver;

import com.example.todolistserver.model.TodoEntity;
import com.example.todolistserver.model.TodoRequest;
import com.example.todolistserver.repository.TodoRepository;
import com.example.todolistserver.service.TodoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.AdditionalAnswers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;


@ExtendWith(MockitoExtension.class)
class TodolistServerApplicationTests {

	@InjectMocks
	private TodoService todoService;

	@Mock
	private TodoRepository todoRepository;

	@Test
	public void add() {
		when(this.todoRepository.save(any(TodoEntity.class)))
				.then(AdditionalAnswers.returnsFirstArg());

		TodoRequest request = new TodoRequest();
		request.setTitle("test title");
		TodoEntity actual = this.todoService.add(request);

		//assertEquals(1L, actual.getId());
		assertEquals("test title", actual.getTitle());


	}

}
