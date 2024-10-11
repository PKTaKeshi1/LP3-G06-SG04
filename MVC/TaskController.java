package MVC;

import java.util.ArrayList;
import java.util.List;

public class TaskController {
    private List<Task> tasks;
    private TaskView view;

    public TaskController(TaskView view){
        this.view = view;
        this.tasks = new ArrayList<>();
    }

    public void addTask(String taskName){
    Task task = new Task(taskName);
    tasks.add(task);
    view.printMessage("Tarea añadida: " + taskName);
    }

    public void completeTask(int index){
        if(index>= 0 && index<tasks.size()){
            tasks.get(index).complete();
            view.printMessage("Tarea completada: " + tasks.get(index).getName());
        }else{
            view.printMessage("Indice de tarea invalido.");
        }
    }
    public void displayTasks(){
        view.printTasks(tasks);
    }

    public TaskView getView() {
        return view;
    }

    public void setView(TaskView view) {
        this.view = view;
    }

    public List<Task> getTasks() {
        return tasks;
    }

    public void setTasks(List<Task> tasks) {
        this.tasks = tasks;
    }
}