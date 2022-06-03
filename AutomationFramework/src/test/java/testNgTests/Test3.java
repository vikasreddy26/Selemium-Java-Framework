package testNgTests;

import lib.util.ExcelReader;

public class Test3 {
    public static void main(String[] args) {
        ExcelReader ex = new ExcelReader("src\\test\\resources\\Data\\TestData.xlsx");
        int rowCount = ex.getRowCount("Sheet1");
        int columnCount = ex.getColCount("Sheet1");
        System.out.println("rows " + rowCount);
        System.out.println("Columns " +columnCount);
        for (int i =1;i<=rowCount;i++){
               String user= ExcelReader.getdata("src\\test\\resources\\Data\\TestData.xlsx", "Sheet1",i,0);
               String pwd = ExcelReader.getdata("src\\test\\resources\\Data\\TestData.xlsx", "Sheet1",i,1);
               System.out.println(user);
               System.out.println(pwd);
        }
    }
}
