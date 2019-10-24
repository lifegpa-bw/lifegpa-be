package com.lambdaschool.lifegpa.controllers;

import com.lambdaschool.lifegpa.models.Habit;
import com.lambdaschool.lifegpa.models.User;
import com.lambdaschool.lifegpa.services.HabitService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Queue;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(value = HabitController.class, secure = false)
public class HabitControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HabitService habitService;

    @Before
    public void setUp() throws Exception {
        User u6 = new User();
        u6.setUserid(6);

        Habit h6 = new Habit();
        h6.setHabitid(6);

//        habitList.add();
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void listAllHabitByUser() {

    }

    @Test
    public void addNewHabit() {
    }

    @Test
    public void updateHabit() {
    }

    @Test
    public void deleteHabitById() {
    }
}