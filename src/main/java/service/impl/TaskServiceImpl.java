package service.impl;

import model.Task;
import model.TaskRepository;
import service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    @Autowired
    private TaskRepository taskRepository;

    @Override
    public Task getTask(long id) {
        return taskRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid task ID: " + id));
    }

    @Override
    public List<Task> getAllTasks() {
        ArrayList<Task> tasksList = new ArrayList<>();
        taskRepository.findAll().forEach(tasksList::add);
        return tasksList;
    }

    @Override
    public Task addTask(Task task) {
        return taskRepository.save(task);
    }

    @Override
    public Task updateTask(Task newTask, long id) {
        return taskRepository.findById(id).map(task -> {
            task.setContent(newTask.getContent());
            task.setDate(newTask.getDate());
            return taskRepository.save(task);
        }).orElseGet(() -> {
            newTask.setId(id);
            return taskRepository.save(newTask);
        });
    }

    @Override
    public void deleteTask(long id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void deleteAllTasks() {
        taskRepository.deleteAll();
    }
}
