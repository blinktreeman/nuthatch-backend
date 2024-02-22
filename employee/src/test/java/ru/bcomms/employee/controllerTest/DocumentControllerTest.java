package ru.bcomms.employee.controllerTest;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
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
    private final Document UPDATED_DOCUMENT =
            new Document("Certificate", "Employee certificate");

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @AfterEach
    public void deleteAll() throws Exception {
        mockMvc.perform(
                        delete("/api/v1/document/all"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void saveTest() throws Exception {
        mockMvc.perform(
                        post("/api/v1/document")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(this.TEST_DOCUMENT)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpectAll(jsonPath("$.title").value(TEST_DOCUMENT.getTitle()),
                        jsonPath("$.description").value(TEST_DOCUMENT.getDescription()));
    }

    @Test
    public void findByIdTest() throws Exception {
        MvcResult result = mockMvc.perform(
                        post("/api/v1/document")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(this.TEST_DOCUMENT)))
                .andReturn();
        String response = result.getResponse().getContentAsString();
        String documentUuid = String.valueOf(objectMapper.readValue(response, Document.class).getUuid());

        mockMvc.perform(
                        get("/api/v1/document")
                                .param("uuid", documentUuid))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpectAll(jsonPath("$.title").value(TEST_DOCUMENT.getTitle()),
                        jsonPath("$.description").value(TEST_DOCUMENT.getDescription()));
    }

    @Test
    public void findByIdWithWrongUuid_withResponse404() throws Exception {
        mockMvc.perform(
                        get("/api/v1/document")
                                .param("uuid", String.valueOf(UUID.randomUUID())))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateTest() throws Exception {
        MvcResult result = mockMvc.perform(
                        post("/api/v1/document")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(this.TEST_DOCUMENT)))
                .andReturn();
        String response = result.getResponse().getContentAsString();
        String documentUuid = String.valueOf(objectMapper.readValue(response, Document.class).getUuid());
        UPDATED_DOCUMENT.setUuid(UUID.fromString(documentUuid));

        mockMvc.perform(
                        put("/api/v1/document")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(UPDATED_DOCUMENT)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpectAll(jsonPath("$.uuid").value(documentUuid),
                        jsonPath("$.title").value(UPDATED_DOCUMENT.getTitle()),
                        jsonPath("$.description").value(UPDATED_DOCUMENT.getDescription()));
    }

    @Test
    public void deleteTest() throws Exception {
        MvcResult result = mockMvc.perform(
                        post("/api/v1/document")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(this.TEST_DOCUMENT)))
                .andReturn();
        String response = result.getResponse().getContentAsString();
        String documentUuid = String.valueOf(objectMapper.readValue(response, Document.class).getUuid());

        mockMvc.perform(
                        delete("/api/v1/document")
                                .param("uuid", documentUuid))
                .andExpect(status().isNoContent());
    }
}
