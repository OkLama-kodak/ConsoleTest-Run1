
package com.example.consoletestrun;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class TaskCreationTest {

    @Before
    public void setUp() {
        // Clear old tasks before every test
        TaskCreation.titles.clear();
        TaskCreation.descriptions.clear();
        TaskCreation.dueDates.clear();
        TaskCreation.priorities.clear();
        TaskCreation.completed.clear();
    }

    @Test
    public void testCreateTask() {

        // Simulate creating a task by directly adding the values
        TaskCreation.titles.add("Finish Java Project");
        TaskCreation.descriptions.add("Complete the Task Manager program");
        TaskCreation.dueDates.add("09/20/2026");
        TaskCreation.priorities.add("High");
        TaskCreation.completed.add(false);

        // Check if task was added
        assertEquals(1, TaskCreation.titles.size());

        // Check task information
        assertEquals("Finish Java Project", TaskCreation.titles.get(0));
        assertEquals(
                "Complete the Task Manager program",
                TaskCreation.descriptions.get(0)
        );
        assertEquals("09/20/2026", TaskCreation.dueDates.get(0));
        assertEquals("High", TaskCreation.priorities.get(0));

        // New task should be pending
        assertFalse(TaskCreation.completed.get(0));
    }

    @Test
    public void testCompleteTask() {

        // Add a sample task
        TaskCreation.titles.add("Study Java");
        TaskCreation.descriptions.add("Review JUnit testing");
        TaskCreation.dueDates.add("09/19/2026");
        TaskCreation.priorities.add("Medium");
        TaskCreation.completed.add(false);

        // Make sure it starts as pending
        assertFalse(TaskCreation.completed.get(0));

        // Complete the first task
        TaskCreation.completed.set(0, true);

        // Check if it is completed
        assertTrue(TaskCreation.completed.get(0));
    }

    @Test
    public void testMultipleTasks() {

        // Add first task
        TaskCreation.titles.add("Task 1");
        TaskCreation.descriptions.add("Description 1");
        TaskCreation.dueDates.add("09/20/2026");
        TaskCreation.priorities.add("Low");
        TaskCreation.completed.add(false);

        // Add second task
        TaskCreation.titles.add("Task 2");
        TaskCreation.descriptions.add("Description 2");
        TaskCreation.dueDates.add("09/21/2026");
        TaskCreation.priorities.add("High");
        TaskCreation.completed.add(false);

        // Check number of tasks
        assertEquals(2, TaskCreation.titles.size());

        // Check individual tasks
        assertEquals("Task 1", TaskCreation.titles.get(0));
        assertEquals("Task 2", TaskCreation.titles.get(1));

        assertEquals("Low", TaskCreation.priorities.get(0));
        assertEquals("High", TaskCreation.priorities.get(1));
    }

    @Test
    public void testNoTasks() {

        // Lists should be empty after setUp()
        assertTrue(TaskCreation.titles.isEmpty());
        assertTrue(TaskCreation.descriptions.isEmpty());
        assertTrue(TaskCreation.dueDates.isEmpty());
        assertTrue(TaskCreation.priorities.isEmpty());
        assertTrue(TaskCreation.completed.isEmpty());
    }
}
