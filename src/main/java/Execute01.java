import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Execute01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1. ADIM: Driver a kaydol==> JDBC 4 sonrası gerekli değil
       //Class.forName("org.postgresql.Driver");
        //2.ADIM:(1.ADIM) DATABASE E BAĞLAN
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres","postgres","S230898d.");
        //3.ADIM:Statement oluştur
       Statement statement= connection.createStatement();

       //4. ADIM: QUERY çalıştır
        //1.ORNEK: workers adında bir table olusturunuz
       boolean sql1= statement.execute("CREATE TABLE workers(\n" +"worker_id varchar(20), worker_name varchar(20), worker_salary int );");
       //execute() methodu  parantez içerisinde belirtilen string sql komutunu database de uygular
       System.out.println("sql1 = " + sql1);
        /*
        execute methodu DDL  (create drop alter truncate) ile kullanuldığında data dönmeyeceği için false döner
        execute methodu DQL (select) ile kullanıldığında data cağırırsa TRUE data dcağırırsa FALSE döndürür
         */
        //2.ORNEK: Workers table ına worker_addres adında bir sutun ekleyiniz.
        boolean sql2=statement.execute("ALTER TABLE workers ADD worker_addres varchar(100);");
        System.out.println("sql2 = " + sql2);//False döner cünkü bir data cağırılmadı

        //3. Ornek workers tableinı silin
        boolean sql3= statement.execute("DROP TABLE workers");
        System.out.println("sql3 = " + sql3);

        //5.adım: bağlantıyı kapat
        connection.close();
        statement.close();


    }
}
