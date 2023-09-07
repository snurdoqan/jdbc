import java.sql.*;

public class PreparedStatement01 {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "S230898d.");
        Statement statement = connection.createStatement();
        //1. Örnek: Prepared statement kullanarak company adı IBM olan number_of_employees değerini 9999 olarak güncelleyin.
        /*preparedStatement oluşturmak için
        1.ADIM: Prepared statement Query sini oluştur!
        2.ADIM: preparedStatement objesi oluştur!
        3.ADIM: Soru işaretleri yerine atamalar yap!
        4.ADIM: QUERY i çalıştır!
         */
        //1.ADIM:preparedStatement QUERYSİNİ oluştur
      String sql1="update companies set number_of_employees= ? where company=?";//? işareti paremetrelendirme yapar.
        //2.ADIM: preparedStatement objesi oluştur
      PreparedStatement preparedStatement=connection.prepareStatement(sql1);
        //3.ADIM: Soru işaretleri yerine atamalar yap
      preparedStatement.setInt(1,9999);
      preparedStatement.setString(2,"IBM");
        //4.ADIM: QUERY i çalıştır
      int guncellenenSatirSayisi= preparedStatement.executeUpdate();//güncellenene satır sayısını verir CONSOL a 1 yazar
      System.out.println("guncellenenSatirSayisi = " + guncellenenSatirSayisi);
      //Güncellenmiş table ı okuyalım
        String sql2="select * from companies";
        ResultSet resultSet1=statement.executeQuery(sql2);

        while (resultSet1.next()){
            System.out.println(resultSet1.getObject(1)+"--"+resultSet1.getObject(2)+"--"+resultSet1.getObject(3));
        }
      //2. Örnek: Prepared statement kullanarak company adı GOOGLE olan number_of_employees değerini 5000 olarak güncelleyin.
    //3.adım: Soru işaretleri yerine atamalar yap
        preparedStatement.setInt(1,5000);
        preparedStatement.setString(2,"GOOGLE");
    //4.ADIM: QUERY i çalıştır
        preparedStatement.executeUpdate();
//güncellenmiş tableı okuyalım
        ResultSet resultSet2=statement.executeQuery(sql2);
        while (resultSet2.next()){
            System.out.println(resultSet2.getObject(1)+"--"+resultSet2.getObject(2)+"--"+resultSet2.getObject(3));
        }


    }
}
