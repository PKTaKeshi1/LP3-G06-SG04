package MVC;

public  class Task {
    private String name;
    private boolean completed;

    public Task(String name){
        this.name = name;
        this.completed = false;
    }

    public String getName(){
        return name;
    }
    public boolean isCompleted(){
        return completed;
    }

    public void complete(){
        this.completed = true;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
