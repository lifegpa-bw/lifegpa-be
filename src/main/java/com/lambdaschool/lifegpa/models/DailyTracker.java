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
    private long id;

    @Column(nullable = false)
    private LocalDateTime datetime = LocalDateTime.now();

    @Column(nullable = false)
    private String timeSpent;

    @Column(nullable = false)
    private String userIden;

    @Column(nullable = false)
    private String habbitId;


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


    public String getUserIden() {
        return userIden;
    }

    public void setUserIden(String userIden) {
        this.userIden = userIden;
    }

    public DailyTracker(LocalDateTime datetime, String timeSpent, String userIden, String habbitId, User user, Habit habit) {
        this.datetime = datetime;
        this.timeSpent = timeSpent;
        this.userIden = userIden;
        this.habbitId = habbitId;
        this.user = user;
        this.habit = habit;
    }

    public String getHabbitId() {
        return habbitId;
    }

    public void setHabbitId(String habbitId) {
        this.habbitId = habbitId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getTimeSpent() {
        return timeSpent;
    }

    public void setTimeSpent(String timeSpent) {
        this.timeSpent = timeSpent;
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
