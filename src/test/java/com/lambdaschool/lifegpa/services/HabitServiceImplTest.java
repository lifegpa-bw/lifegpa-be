package com.lambdaschool.lifegpa.services;

import com.lambdaschool.lifegpa.LifegpaApplication;
import com.lambdaschool.lifegpa.models.Habit;
import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = LifegpaApplication.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@Transactional
public class HabitServiceImplTest {

    @Autowired
    private HabitService habitService;

    @Autowired
    private UserService userService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void findAll() {
        assertEquals(1, habitService.findAll(Pageable.unpaged()).size());
    }

    @Test
    public void findAllByUser() {
        assertEquals(1, habitService.findAllByUser().size());
    }

    @Test
    public void findHabitById() {
        assertEquals("Going to bed early", habitService.findHabitById(21).getDescription());
    }

    @Test
    public void delete() {
        habitService.delete(21);
    }

    @Test
    public void save() {
    }

    @Test
    public void update() {
        Habit h1 = new Habit("Start working out", 80, true, userService.findUserById(14));

    }
}