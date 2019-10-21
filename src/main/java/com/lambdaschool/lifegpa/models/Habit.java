package com.lambdaschool.lifegpa.models;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.lifegpa.logging.Loggable;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Loggable
@Entity
@Table(name = "habits")
public class Habit extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long habitid;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private int score;

    @Column(nullable = false)
    private boolean good_boolean;


    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties("habits")
    private User user;

    @OneToMany(mappedBy = "habit",
                cascade = CascadeType.ALL,
                orphanRemoval = true)
    @JsonIgnoreProperties("habit")
    private List<DailyTracker> dailytrackers = new ArrayList<>();

    public Habit() {
    }

    public Habit(String description, int score, boolean good_boolean, User user) {
        this.description = description;
        this.score = score;
        this.good_boolean = good_boolean;
        this.user = user;
    }

    public long getHabitid() {
        return habitid;
    }

    public void setHabitid(long habitid) {
        this.habitid = habitid;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isGood_boolean() {
        return good_boolean;
    }

    public void setGood_boolean(boolean good_boolean) {
        this.good_boolean = good_boolean;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<DailyTracker> getDailytrackers() {
        return dailytrackers;
    }

    public void setDailytrackers(List<DailyTracker> dailytrackers) {
        this.dailytrackers = dailytrackers;
    }
}
