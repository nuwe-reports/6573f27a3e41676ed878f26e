package com.example.demo.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.example.demo.entities.Room}
 */
public class RoomDto implements Serializable {
    private String roomName;

    public RoomDto() {
    }

    public RoomDto(String roomName) {
        this.roomName = roomName;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }
}