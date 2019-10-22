package com.lambdaschool.lifegpa.services;

import com.lambdaschool.lifegpa.exceptions.ResourceFoundException;
import com.lambdaschool.lifegpa.exceptions.ResourceNotFoundException;
import com.lambdaschool.lifegpa.logging.Loggable;
import com.lambdaschool.lifegpa.models.Habit;
import com.lambdaschool.lifegpa.models.User;
import com.lambdaschool.lifegpa.models.Useremail;
import com.lambdaschool.lifegpa.repository.HabitRepository;
import com.lambdaschool.lifegpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Loggable
@Service(value = "habitService")
public class HabitServiceImpl implements HabitService {

    @Autowired
    HabitRepository habitrepos;

    @Autowired
    UserRepository userrepos;

    @Override
    public List<Habit> findAll() {
        return null;
    }

    @Override
    public List<Habit> findAllByUser() {
        List<Habit> habits = new ArrayList<>();
        habitrepos.findAll().iterator().forEachRemaining(habits::add);
        return habits;
    }

    @Override
    public Habit findHabitById(long id) {
        return null;
    }

    @Override
    public void delete(long id) {

    }

    @Override
    public Habit save(Habit habit) {
        Habit newHabit =
    }

    // User newUser = new User();
    //        newUser.setUsername(user.getUsername().toLowerCase());
    //        newUser.setPasswordNoEncrypt(user.getPassword());
    //        newUser.setEmail(user.getEmail().toLowerCase());
    //
    //        ArrayList<UserRoles> newRoles = new ArrayList<>();
    //        for (UserRoles ur : user.getUserroles())
    //        {
    //            long id = ur.getRole()
    //                        .getRoleid();
    //            Role role = rolerepos.findById(id)
    //                                 .orElseThrow(() -> new ResourceNotFoundException("Role id " + id + " not found!"));
    //            newRoles.add(new UserRoles(newUser,
    //                                       ur.getRole()));
    //        }
    //        newUser.setUserroles(newRoles);
    //
    //        for (Useremail ue : user.getUseremails())
    //        {
    //            newUser.getUseremails()
    //                   .add(new Useremail(newUser,
    //                                      ue.getUseremail()));
    //        }
    //
    //        return userrepos.save(newUser);

//    @Override
//    public List<Habit> findByNameContaining(String name) {
//        return habitrepos.findByNameContainingIgnoreCase(name.toLowerCase());
//    }

    @Override
    public Habit update(Habit habit, long id) {
        Habit currentHabit = findHabitById(id);

        if (habit.getDescription() != null)
        {
            currentHabit.setDescription(habit.getDescription());
        }

        if (habit.getScore() != 0)
        {
            currentHabit.setScore(habit.getScore());
        }

        if (habit.isGood_boolean() != false)
        {
            currentHabit.setGood_boolean(habit.isGood_boolean());
        }

        if (habit.getUser() != null)
        {
            currentHabit.setUser(habit.getUser());
        }

        return habitrepos.save(currentHabit);
    }
}

// this.description = description;
//        this.score = score;
//        this.good_boolean = good_boolean;
//        this.user = user;
