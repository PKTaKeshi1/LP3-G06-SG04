package MVC;

public class Main {
    public static void main(String[] args){
        TaskView view = new TaskView();
        TaskController controller = new TaskController(view);

        controller.addTask("Aprender Java");
        controller.addTask("Desarrollar una aplicacion MVC");
        controller.displayTasks();

        controller.completeTask(0);
        controller.displayTasks();
    }
}
