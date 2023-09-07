import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class JunitTest01 {
    @Test
    public  void test01(){
//Test geçti veya kaldı gibi dönüt alabilmek için doğrulama (assertion) yapmamız gerekir:
    //Assertion Türleri:
        String expectedData ="Hello";
        String actualData = "Hello";
        assertEquals(1,1); //AssertEquals methodunun parametreleri eşit ise test geçer değil ise kalır
     //Assert.assertTrue(actualData.contains("lo"));
     // Assert.assertTrue(actualData.length()==5);
        assertTrue(actualData.length()>1);//method parantez içindeki değeri true dönerse test geçer
    //negatif test için:
        assertFalse(actualData.contains("x"));//method parantez içindeki değeri false dönerse test geçer
        assertNotEquals(1,2);//method parantez içindeki değeri eşit değilse test geçer
    }
    @Test
    public  void test02(){

    }
    @Test
    public void test03(){

    }

}
