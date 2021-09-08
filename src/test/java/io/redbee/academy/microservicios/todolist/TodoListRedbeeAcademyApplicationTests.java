package io.redbee.academy.microservicios.todolist;

import org.hamcrest.beans.HasPropertyWithValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class TodoListRedbeeAcademyApplicationTests {

	@Autowired
	MockMvc mockMvc;

	@Test
	void nuevaTodoList() throws Exception {
		mockMvc.perform(get("/todo-list"))
				.andExpect(status().isOk())
				.andExpect(view().name("todo-list"))
				.andExpect(model().attribute("todoList", hasProperty("id", isA(String.class))))
				.andExpect(model().attribute("todoList", hasProperty("items", emptyIterable())));
	}

}
