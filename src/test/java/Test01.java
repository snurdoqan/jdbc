public class Test01 {
    public static void main(String[] args) {
//TEST BEKLENEN DATA VE ASIL DATANIN KARŞILAŞTIRILMASIDIR.

        String expectedData ="Hello";
        String actualData = "Hello";
        if (expectedData.equals(actualData)){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test FAILED");
        }
    //Otomasyon testi yapabilmemiz içi,n bir"TEST FROMEWORK 'üne ihtiyecımız var (JUnit, Test NG, Cucumber,...)


    }
}