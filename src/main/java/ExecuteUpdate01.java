import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ExecuteUpdate01 {
    public static void main(String[] args) throws SQLException {
        //1.query çalışmak için connection oluşturmak lazım
        Connection connection=DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","S230898d.");
        Statement statement=connection.createStatement();
//1. Örnek: companies table dan number_of_employees değeri ortalama çalışan sayısından az olan number_of_employees değerlerini 16000 olarak UPDATE edin.
  int updateEdilenSatirSayisi= statement.executeUpdate("UPDATE companies set number_of_employees=16000 where number_of_employees<(SELECT AVG(number_of_employees) FROM companies);");
        System.out.println("updateEdilenSatirSayisi = " + updateEdilenSatirSayisi);

   connection.close();
   statement.close();




    }
}
