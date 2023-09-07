import java.sql.*;

public class CallableStatement01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "S230898d.");
        Statement statement = connection.createStatement();
    //1.ORNEK~~~~SELAMLAMA YAPAN BİR FUNCTİON I Callable Statement kullanarak OLUŞTURUP ÇAĞIRIN:
    //CALLABLE STATEMENT Adımları:
        /*
        1.ADIM: Function komutu yazaın
        2.ADIM: Function komutunu çalıştır                              //statement.execute()  ile function yap
        3.ADIM: Functionı çağırıcaz              //(sqlFunction) Callable statement ile Call yapacağız yada resultSet ile de çağırabiliriz    */
        //1. Adım: Function kodunu yaz
        String sql = "create or replace function selamlama(x TEXT) returns text as $$ begin return 'Merhaba ' || x || ', Nasılsın?'; end; $$ language plpgsql;";

        //2. Adım: Function kodunu çalıştır
        statement.execute(sql);

        //3. Adım: Function'ı çağır

        /*Aşağıda normal çağırma yöntemi kullanıldı
        String sqlFunction = "select selamlama('Ali')";
        ResultSet resultSet = statement.executeQuery(sqlFunction);
        resultSet.next();
        System.out.println(resultSet.getString(1)); */
        CallableStatement callableStatement=connection.prepareCall("{?= call selamlama(?)}");
        //4.ADIM: ? yerine atama yap
        callableStatement.registerOutParameter(1,Types.VARCHAR);
        callableStatement.setString(2,"Ali");
        //5.ADIM: Callable Statement ı çalıştır.
        callableStatement.execute();
        //6.ADIM:DATAYI Callable Statement dan çağır
        System.out.println(callableStatement.getObject(1));
    //2.ORNEK~~~İki parametreyi toplayan bir function oluşturup callable ile çağırınız
     //1. Adım: Function kodunu yaz
        String sql2= "create or replace function toplama(x int,y int) returns NUMERIC as $$ begin return x+y; end; $$ language plpgsql;";

        //2. Adım: Function kodunu çalıştır
        statement.execute(sql2);

        //3. Adım: Function'ı çağır
        CallableStatement callableStatement2=connection.prepareCall("{?= call toplama(?,?)}");
        //4.ADIM: ? yerine atama yap
        callableStatement2.registerOutParameter(1,Types.NUMERIC);
        callableStatement2.setInt(2,6);
        callableStatement2.setInt(3,4);
        //5.ADIM: Callable Statement ı çalıştır.
        callableStatement2.execute();
        //6.ADIM:DATAYI Callable Statement dan çağır
        System.out.println(callableStatement2.getObject(1));
    }
}
