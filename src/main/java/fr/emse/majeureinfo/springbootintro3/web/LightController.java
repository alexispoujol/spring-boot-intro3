package fr.emse.majeureinfo.springbootintro3.web;
import fr.emse.majeureinfo.springbootintro3.dao.LightDao;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/api/Light")
@Transactional
public class LightController {
    private final LightDao lightDao;
    public LightController(LightDao lightDao) {
        this.lightDao = lightDao;
    }


    @GetMapping
    public List<LightDto> list() {
        return lightDao.findAll().stream().map(LightDto::new).collect(Collectors.toList());
    }
}
