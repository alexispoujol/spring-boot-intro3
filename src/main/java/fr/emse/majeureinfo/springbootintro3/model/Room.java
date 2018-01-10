
package fr.emse.majeureinfo.springbootintro3.model;

import javax.persistence.*;

@Entity

public class Room {

    @Id
    @GeneratedValue
    private Long id;

    /**
     * The Light of a room
     */
    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Light light;


    @SuppressWarnings("unused")
    public Room() {
    }

    public Room(Light light) {
        this.light = light;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Light getLight() {
        return light;
    }

    public void setLight(Light light) {
        this.light = light;
    }

}

