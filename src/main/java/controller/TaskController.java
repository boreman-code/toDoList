package controller;

import model.Task;
import service.impl.TaskServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    TaskServiceImpl taskService;

    @GetMapping("/")
    public String index(Model model) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.MM.yyyy");
        Calendar calendar = Calendar.getInstance();
        List<Task> tasks = taskService.getAllTasks();
        model.addAttribute("tasks", tasks);
        model.addAttribute("size", tasks.size());
        model.addAttribute("task", new Task());
        model.addAttribute("today", dateFormat.format(calendar.getTime()));
        return "index";
    }

    @PostMapping("/addTask")
    public String addTask(@ModelAttribute("task") Task task) {
        taskService.addTask(task);
        return "redirect:/";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("newTask", taskService.getTask(id));
        return "edit";
    }

    @PostMapping("/update/{id}")
    public String updateTask(@ModelAttribute("newTask") Task newTask, @PathVariable("id") Long id) {
        taskService.updateTask(newTask, id);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String deleteAll() {
        taskService.deleteAllTasks();
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return "redirect:/";
    }
}
