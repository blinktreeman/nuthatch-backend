package ru.bcomms.address.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import ru.bcomms.address.entity.Room;

import java.util.UUID;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
public class RoomControllerTest {
    private final Room TEST_ROOM =
            new Room("hall", "1");
    private final Room UPDATED_ROOM =
            new Room("bathroom", "2");

    @Autowired
    ObjectMapper objectMapper;

    @Autowired
    MockMvc mockMvc;

    @AfterEach
    public void deleteAll() throws Exception {
        mockMvc.perform(
                        delete("/api/v1/room/all"))
                .andExpect(status().isNoContent());
    }

    @Test
    public void saveTest() throws Exception {
        mockMvc.perform(
                        post("/api/v1/room")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(TEST_ROOM)))
                .andExpect(status().isCreated())
                .andExpect(content().contentType("application/json"))
                .andExpectAll(jsonPath("$.roomType").value(TEST_ROOM.getRoomType()),
                        jsonPath("$.roomNumber").value(TEST_ROOM.getRoomNumber()));
    }

    @Test
    public void findByIdTest() throws Exception {
        MvcResult result = mockMvc.perform(
                        post("/api/v1/room")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(this.TEST_ROOM)))
                .andReturn();
        String response = result.getResponse().getContentAsString();
        String roomUuid = String.valueOf(objectMapper.readValue(response, Room.class).getUuid());

        mockMvc.perform(
                        get("/api/v1/room")
                                .param("uuid", roomUuid))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpectAll(jsonPath("$.roomType").value(TEST_ROOM.getRoomType()),
                        jsonPath("$.roomNumber").value(TEST_ROOM.getRoomNumber()));
    }

    @Test
    public void findByIdWithWrongUuid_withResponse404() throws Exception {
        mockMvc.perform(
                        get("/api/v1/room")
                                .param("uuid", String.valueOf(UUID.randomUUID())))
                .andExpect(status().isNotFound());
    }

    @Test
    public void updateTest() throws Exception {
        MvcResult result = mockMvc.perform(
                        post("/api/v1/room")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(TEST_ROOM)))
                .andReturn();
        String response = result.getResponse().getContentAsString();
        String roomUuid = String.valueOf(objectMapper.readValue(response, Room.class).getUuid());
        UPDATED_ROOM.setUuid(UUID.fromString(roomUuid));

        mockMvc.perform(
                        put("/api/v1/room")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(UPDATED_ROOM)))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpectAll(jsonPath("$.uuid").value(roomUuid),
                        jsonPath("$.roomType").value(UPDATED_ROOM.getRoomType()),
                        jsonPath("$.roomNumber").value(UPDATED_ROOM.getRoomNumber()));
    }

    @Test
    public void updateTestWithNewUuid_newEntityWithResponse200() throws Exception {
        mockMvc.perform(
                post("/api/v1/room")
                        .contentType("application/json")
                        .content(objectMapper.writeValueAsString(TEST_ROOM)));
        UPDATED_ROOM.setUuid(UUID.randomUUID());

        mockMvc.perform(
                        put("/api/v1/room")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(UPDATED_ROOM)))
                .andExpect(status().isOk());

        mockMvc.perform(get("/api/v1/room/all"))
                .andExpect(jsonPath("$.length()").value(2));
    }

    @Test
    public void deleteTest() throws Exception {
        MvcResult result = mockMvc.perform(
                        post("/api/v1/room")
                                .contentType("application/json")
                                .content(objectMapper.writeValueAsString(this.TEST_ROOM)))
                .andReturn();
        String response = result.getResponse().getContentAsString();
        String roomUuid = String.valueOf(objectMapper.readValue(response, Room.class).getUuid());

        mockMvc.perform(
                        delete("/api/v1/room")
                                .param("uuid", roomUuid))
                .andExpect(status().isNoContent());
    }
}
