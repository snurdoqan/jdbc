import java.sql.*;

public class ExecuteQuery01 {
    public static void main(String[] args) throws SQLException, SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "S230898d.");
        Statement statement = connection.createStatement();

        //1. Örnek:  region id'si 1 olan "country name" değerlerini çağırın.
        System.out.println("\n=====ORNEK 1=====\n");
        String sql1 = "select * from countries where region_id = 1";
        boolean r1 = statement.execute(sql1);
        System.out.println("r1 = " + r1);//true döner çünkü select komutu ile data çağırdık.
        //SQL query ile çağrılan datayı görebilmek için executeQuery() methodu kullanmalıyız.

    /*  executeQuery() methodu çağrılan datayı ResultSet datası olarak döner.
        Default olarak ResultSet bir pointer ile döner ve bu pointer sütun isimleri gösterir.
        Datayı okuyabilmek için next() methodu ile pointer'ı sıradaki satıra taşımalıyız.
         next() sırada sayı var ise true döner pointer ı bir sonraki satıra taşır*/
        ResultSet resultSet = statement.executeQuery(sql1);
        while (resultSet.next()) {
        System.out.println("country_id: " + resultSet.getString("country_id") + "|| country_name: " + resultSet.getString("country_name") + "|| region_id: " + resultSet.getString("region_id"));
        }
        //2.Örnek: "region_id"nin 2'den büyük olduğu "country_id" ve "country_name" değerlerini çağırın.
        System.out.println("\n==========Örnek 2==========\n");
        String sql2 = "select country_id, country_name from countries where region_id > 2";
        ResultSet resultSet2 = statement.executeQuery(sql2);

        while (resultSet2.next()) {
            System.out.println(resultSet2.getString(1) + " || " + resultSet2.getString(2));
        }


        //3.Örnek: "number_of_employees" değeri en düşük olan satırın tüm değerlerini çağırın.
        System.out.println("\n==========Örnek 3==========\n");
        String sql3 = "select * from companies where number_of_employees = (select min(number_of_employees) from companies)";
        ResultSet resultSet3 = statement.executeQuery(sql3);
        while (resultSet3.next()) {
            System.out.println(resultSet3.getString(1) + " || " + resultSet3.getString(2) + " || " + resultSet3.getString(3));
        //getObject tüm daTALARI çağırabiliriz
        }

    }
}