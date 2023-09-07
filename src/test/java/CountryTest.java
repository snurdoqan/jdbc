import org.junit.Test;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Assert;

import static org.junit.Assert.assertEquals;

public class CountryTest {
    /*
Given
  User connects to the database
  (Kullanıcı veritabanına bağlanır)

When
  User sends the query to get the region ids from "countries" table
  (Kullanıcı, 'countries' table'dan 'region id' almak üzere query gönderir )

Then
  Assert that the number of region ids greater than 1 is 17.
  (1'den büyük region id'lerin sayısının 17 olduğunu doğrula )

And
  User closes the connection
*/
    @Test
    public void countryTest() throws SQLException {
        //user connect to the database
    //User sends the query to get the region ids from "countries" table
  String sql ="select count(*) from  countries where region_id>1";
        ResultSet resultSet=JDBCUtils.executeQuery(sql);
        resultSet.next();
        int numberOfRows= resultSet.getInt(1);
        System.out.println("numberOfRows="+numberOfRows);
    // Assert that the number of region ids greater than 1 is 17.
        assertEquals(17,numberOfRows);
   //User closes the connection
      JDBCUtils.closeConnection();
    }
    //2. Yol: Record sayısını list içine alarak
    @Test
    public void countryTest2() throws SQLException {
        //User connects to the database


        //User sends the query to get the region ids from "countries" table
      List<Object> list= JDBCUtils.getColumnList("countries","region_id");
        System.out.println("List="+ list);

        //Assert that the number of region ids greater than 1 is 17.
        int numberOfRows=0;
        for (Object w: list){
            if ((int)w>1){
                numberOfRows++;
            }
            System.out.println("numberOfRows = " + numberOfRows);
        }
        Assert.assertEquals(17,numberOfRows);

        //User closes the connection
        JDBCUtils.closeConnection();

    }
}
