package io.redbee.academy.microservicios.todolist.examples;

import io.redbee.academy.microservicios.todolist.model.TodoItem;
import io.redbee.academy.microservicios.todolist.model.TodoList;
import io.redbee.academy.microservicios.todolist.repository.TodoListRepository;
import io.redbee.academy.microservicios.todolist.service.TodoListService;
import io.redbee.academy.microservicios.todolist.service.TodoListServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@WebMvcTest
class WebControllerWithWebMvcTestAndTestConfigurationExample {

    @TestConfiguration
    static class MockConfiguration {

        @Bean
        public TodoListService todoListService(TodoListRepository repository) {
            return new TodoListServiceImpl(repository);
        }

        @Bean
        public TodoListRepository todoListRepository() {
            return new TodoListRepository() {
                @Override
                public TodoList getTodoList(String id) {
                    return new TodoList(id, new ArrayList<>());
                }

                @Override
                public void saveTodoList(TodoList todoList) {

                }

            };
        }
    }

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


        mockMvc.perform(post("/agregarItem")
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