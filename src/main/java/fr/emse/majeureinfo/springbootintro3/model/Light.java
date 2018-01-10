package fr.emse.majeureinfo.springbootintro3.model;

import javax.persistence.*;

import static fr.emse.majeureinfo.springbootintro3.model.Status.OFF;
import static fr.emse.majeureinfo.springbootintro3.model.Status.ON;

@Entity
@SuppressWarnings("serial")
public class Light {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Integer level;

    @Enumerated(EnumType.STRING)
    private Status status;

    @SuppressWarnings("unused")
    public Light() {
    }

    public Light(Long id, Integer level, Status status) {
        this.id = id;
        this.level = level;
        this.status = status;
    }

    public Light(Integer level, Status status) {
        this.level = level;
        this.status = status;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void switchStatus(){
        switch(this.status){
            case ON : this.status= OFF ;
                break;
            default : this.status= ON ;
        }
    }
}