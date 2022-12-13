package com.example.api_aanmaken_jonathan_willemans_r0806072.Model;
import com.sun.istack.NotNull;

import javax.persistence.*;


@Entity
public class Pokemon {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NotNull
    private String name;
    @NotNull
    private String type;
    private int attack;
    private int defence;

    private int speed;

    private int level;

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Pokemon(long id, String name, String type, int attack, int defence, int speed, int level) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.attack = attack;
        this.defence = defence;
        this.speed = speed;
        this.level =level;
    }

    public Pokemon() {

    }
    public void update(Pokemon p){
        this.id = p.id;
        this.name = p.name;
        this.type = p.type;
        this.attack = p.attack;
        this.defence = p.defence;
        this.speed = p.speed;
        this.level =p.level;
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }
}
