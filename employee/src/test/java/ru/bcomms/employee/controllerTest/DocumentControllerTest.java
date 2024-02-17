package ru.bcomms.employee.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.bcomms.employee.entity.Document;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class DocumentControllerTest {
    private final Document TEST_DOCUMENT =
            new Document("Passport", "Citizen's passport");

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    private static String documentUuid;

    @Test
    public void saveTest() throws Exception {
        MvcResult result = mockMvc.perform(
                post("/api/v1/document")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(this.TEST_DOCUMENT)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpectAll(jsonPath("$.title").value("Passport"),
                        jsonPath("$.description").value("Citizen's passport"))
                .andReturn();
        String response = result.getResponse().getContentAsString();
        documentUuid = String.valueOf(objectMapper.readValue(response, Document.class).getUuid());
    }

    @Test
    public void findByIdTest() throws Exception {
        mockMvc.perform(
                get("/api/v1/document")
                        .param("uuid", documentUuid))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpectAll(jsonPath("$.title").value("Passport"),
                        jsonPath("$.description").value("Citizen's passport"));
    }

    @Test
    public void findByIdWithWrongUuid_withResponse404() throws Exception {
        mockMvc.perform(
                get("/api/v1/document")
                        .param("uuid", String.valueOf(UUID.randomUUID())))
                .andExpect(status().isNotFound());
    }

    // TODO: update, delete tests
}
