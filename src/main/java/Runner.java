import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Runner {
    public static void main(String[] args) {
       /* JDBCUtils.connectToDatabase();
       // Statement statement=JDBCUtils.createStatement();
        JDBCUtils.createStatement().execute("seelect * from companies");
        //statement.executeQuery("");*/
   JDBCUtils.execute("select * from companies");
   ResultSet resultSet= JDBCUtils.executeQuery("select * from companies");


       // List<String> list= new ArrayList<>();
       // while (resultSet.next()){
          //  System.out.println(resultSet.getString("number_of_employees"));
       // }
    }
}
