package fr.emse.majeureinfo.springbootintro3.dao;

import fr.emse.majeureinfo.springbootintro3.model.Light;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LightDao extends JpaRepository<Light, Long>,LightDaoCustom  {
}
