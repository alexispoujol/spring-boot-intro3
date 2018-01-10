package fr.emse.majeureinfo.springbootintro3.dao;

import fr.emse.majeureinfo.springbootintro3.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomDao extends JpaRepository<Room, Long>  {
}

