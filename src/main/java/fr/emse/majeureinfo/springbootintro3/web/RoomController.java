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
    private final LightDao lightDao;
    public RoomController(RoomDao roomDao, LightDao lightDao) {
        this.roomDao = roomDao;
        this.lightDao = lightDao;
    }


    @GetMapping
    public List<RoomDto> list() {
        return roomDao.findAll().stream().map(RoomDto::new).collect(Collectors.toList());
    }

    @PostMapping(value = "/test")
    public RoomDto test() {
        Room room = new Room(lightDao.getOne(1l));
        roomDao.save(room);
        return new RoomDto(room);
    }

    @GetMapping(value = "/{id}")
    public RoomDto getroom(@PathVariable Long id) {
        Room room = roomDao.getOne(id);
        return new RoomDto(room);
    }

}
