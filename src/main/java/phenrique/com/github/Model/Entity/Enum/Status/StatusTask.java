package phenrique.com.github.Model.Entity.Enum.Status;

public enum StatusTask {

    IN_PROGRESS("In progress"),
    COMPLETED("Completed"),
    OVERDUE("Overdue");

    private String label;
    private StatusTask(String label){
        this.label = label;
    }
     public String getLabel(){
        return label;
     }


}
