package fr.emse.majeureinfo.springbootintro3.web;

import fr.emse.majeureinfo.springbootintro3.model.Room;

public class RoomDto {

    private final Long id;
    private final LightDto light;

    public RoomDto(Room room) {
        this.id = room.getId();
        this.light = room.getLight()==null ? null : new LightDto(room.getLight());

    }

    public Long getId() {
        return id;
    }
    public LightDto getLight() {
        return light;
    }
}
