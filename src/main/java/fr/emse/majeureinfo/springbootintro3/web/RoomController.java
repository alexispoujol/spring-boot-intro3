package fr.emse.majeureinfo.springbootintro3.web;
import fr.emse.majeureinfo.springbootintro3.dao.LightDao;
import fr.emse.majeureinfo.springbootintro3.dao.RoomDao;
import fr.emse.majeureinfo.springbootintro3.model.Light;
import fr.emse.majeureinfo.springbootintro3.model.Room;
import fr.emse.majeureinfo.springbootintro3.model.Status;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/Room")
@Transactional
public class RoomController {
    private final RoomDao roomDao;
    public RoomController(RoomDao roomDao) {
        this.roomDao = roomDao;
    }


    @GetMapping
    public List<RoomDto> list() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @PostMapping(value = "/test")
    public RoomDto test() {
        Room room = new Room(new Light(20, Status.ON));
        roomDao.save(room);
        return new RoomDto(room);
    }

}
