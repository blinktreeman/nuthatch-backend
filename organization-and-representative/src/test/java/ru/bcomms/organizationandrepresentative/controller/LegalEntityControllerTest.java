package ru.bcomms.organizationandrepresentative.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.bcomms.organizationandrepresentative.entity.LegalEntity;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class LegalEntityControllerTest {
    private final LegalEntity TEST_LEGAL_ENTITY =
            new LegalEntity("ООО \"Рога и копыта\"", "1234567890123", "1234567890");
    private final LegalEntity UPDATED_LEGAL_ENTITY =
            new LegalEntity("OOO \"Василёк\"", "9876543210987", "9876543210");

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @AfterEach
    public void deleteAll() throws Exception {
        mockMvc.perform(
                        delete("/api/v1/legal-entity/all"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void saveTest() throws Exception {
        mockMvc.perform(
                        post("/api/v1/legal-entity")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(TEST_LEGAL_ENTITY)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpectAll(jsonPath("$.name")
                                .value(TEST_LEGAL_ENTITY.getName()),
                        jsonPath("$.ogrn")
                                .value(TEST_LEGAL_ENTITY.getOgrn()),
                        jsonPath("$.inn")
                                .value(TEST_LEGAL_ENTITY.getInn()));
    }

    @Test
    public void findByIdTest() throws Exception {
        MvcResult result = mockMvc.perform(
                        post("/api/v1/legal-entity")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(this.TEST_LEGAL_ENTITY)))
                .andReturn();
        String response = result.getResponse().getContentAsString();
        String legalEntityUuid = String.valueOf(objectMapper.readValue(response, LegalEntity.class).getUuid());

        mockMvc.perform(
                        get("/api/v1/legal-entity")
                                .param("uuid", legalEntityUuid))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpectAll(jsonPath("$.name")
                                .value(TEST_LEGAL_ENTITY.getName()),
                        jsonPath("$.ogrn")
                                .value(TEST_LEGAL_ENTITY.getOgrn()),
                        jsonPath("$.inn")
                                .value(TEST_LEGAL_ENTITY.getInn()));
    }

    @Test
    public void findByIdWithWrongUuid_withResponse404() throws Exception {
        mockMvc.perform(
                        get("/api/v1/legal-entity")
                                .param("uuid", String.valueOf(UUID.randomUUID())))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateTest() throws Exception {
        MvcResult result = mockMvc.perform(
                        post("/api/v1/legal-entity")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(TEST_LEGAL_ENTITY)))
                .andReturn();
        String response = result.getResponse().getContentAsString();
        String legalEntityUuid = String.valueOf(objectMapper
                .readValue(response, LegalEntity.class)
                .getUuid());
        UPDATED_LEGAL_ENTITY.setUuid(UUID.fromString(legalEntityUuid));

        mockMvc.perform(
                        put("/api/v1/legal-entity")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(UPDATED_LEGAL_ENTITY)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpectAll(jsonPath("$.uuid").value(legalEntityUuid),
                        jsonPath("$.name")
                                .value(UPDATED_LEGAL_ENTITY.getName()),
                        jsonPath("$.ogrn")
                                .value(UPDATED_LEGAL_ENTITY.getOgrn()),
                        jsonPath("$.inn")
                                .value(UPDATED_LEGAL_ENTITY.getInn()));
    }

    @Test
    public void updateTestWithNewUuid_newEntityWithResponse200() throws Exception {
        mockMvc.perform(
                post("/api/v1/legal-entity")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(TEST_LEGAL_ENTITY)));
        UPDATED_LEGAL_ENTITY.setUuid(UUID.randomUUID());

        mockMvc.perform(
                        put("/api/v1/legal-entity")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(UPDATED_LEGAL_ENTITY)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/v1/legal-entity/all"))
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void deleteTest() throws Exception {
        MvcResult result = mockMvc.perform(
                        post("/api/v1/legal-entity")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(this.TEST_LEGAL_ENTITY)))
                .andReturn();
        String response = result.getResponse().getContentAsString();
        String legalEntityUuid = String.valueOf(objectMapper.readValue(response, LegalEntity.class).getUuid());

        mockMvc.perform(
                        delete("/api/v1/legal-entity")
                                .param("uuid", legalEntityUuid))
                .andExpect(status().isNoContent());
    }
}
