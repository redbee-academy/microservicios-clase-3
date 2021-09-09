package io.redbee.academy.microservicios.todolist.examples;

import io.redbee.academy.microservicios.todolist.model.TodoList;
import org.hamcrest.beans.HasPropertyWithValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class WebControllerWithSpringBootTestExample {

	@Autowired
	MockMvc mockMvc;

	@Test
	void nuevaTodoListYAgregarItem() throws Exception {
		MvcResult mvcResult = mockMvc.perform(get("/"))
				.andExpect(status().isOk())
				.andExpect(view().name("todo-list"))
				.andExpect(model().attribute("todoList", hasProperty("id", isA(String.class))))
				.andExpect(model().attribute("todoList", hasProperty("items", emptyIterable())))
				.andReturn();

		TodoList nuevaTodoList = (TodoList) mvcResult.getModelAndView().getModelMap().getAttribute("todoList");


		mockMvc.perform(post("/todo-list/agregarItem")
						.contentType(MediaType.APPLICATION_FORM_URLENCODED)
						.param("listId", nuevaTodoList.getId())
						.param("detalle", "mi item"))
				.andExpect(status().isOk())
				.andExpect(view().name("todo-list"))
				.andExpect(model().attribute("todoList", hasProperty("id", is(nuevaTodoList.getId()))))
				.andExpect(model().attribute("todoList", hasProperty("items", iterableWithSize(1))))
				.andExpect(model().attribute("todoList", hasProperty("items", hasItems(hasProperty("descripcion", is("mi item"))))));

	}

}
