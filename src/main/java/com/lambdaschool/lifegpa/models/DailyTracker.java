package com.lambdaschool.lifegpa.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.lambdaschool.lifegpa.logging.Loggable;

import javax.persistence.*;
import java.time.LocalDateTime;

@Loggable
@Entity
@Table(name = "dailytracker")
public class DailyTracker extends Auditable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long dailytrackerid;

    @Column(nullable = false)
    private LocalDateTime datetime = LocalDateTime.now();


    @ManyToOne
    @JoinColumn(name = "userid")
    @JsonIgnoreProperties("dailytrackers")
    private User user;


    @ManyToOne
    @JoinColumn(name = "habitid")
    @JsonIgnoreProperties("dailytrackers")
    private Habit habit;

    public DailyTracker() {
    }

    public DailyTracker(LocalDateTime datetime, User user, Habit habit) {
        this.datetime = datetime;
        this.user = user;
        this.habit = habit;
    }

    public long getDailytrackerid() {
        return dailytrackerid;
    }

    public void setDailytrackerid(long dailytrackerid) {
        this.dailytrackerid = dailytrackerid;
    }

    public LocalDateTime getDatetime() {
        return datetime;
    }

    public void setDatetime(LocalDateTime datetime) {
        this.datetime = datetime;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Habit getHabit() {
        return habit;
    }

    public void setHabit(Habit habit) {
        this.habit = habit;
    }
}
