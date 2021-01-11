package app.service;

import app.model.Task;

import java.util.List;

public interface TaskService {
    Task getTask(long id);
    List<Task> getAllTasks();
    Task addTask(Task task);
    Task updateTask(Task newTask, long id);
    void deleteTask(long id);
    void deleteAllTasks();
}
