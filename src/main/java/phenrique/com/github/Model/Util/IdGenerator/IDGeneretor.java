package phenrique.com.github.Model.Util.IdGenerator;


//
//Class responsible for generating a
//  unique value for the ID of each task
//
public class IDGeneretor {

    private static Long ID = 0L;

    public static Long generateValueId(){
        return ID++;
    }

    public static Long getID() {
        return ID;
    }

}
