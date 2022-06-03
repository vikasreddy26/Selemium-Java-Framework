package lib.util;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelReader {
    public static String filename = System.getProperty("user.dir") + "\\src\\Data\\";
    public String path;
    public static FileInputStream fis = null;
    public static FileOutputStream fileOut = null;
    private static XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow row = null;
    private XSSFCell cell = null;


    public ExcelReader(String path) {
        this.path = path;
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet = workbook.getSheetAt(0);
            fis.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getRowCount(String sheetName) {
        System.out.println("Sheet Name ----" + sheetName);
        int index = workbook.getSheetIndex(sheetName);
        if (index == -1)
            return 0;
        else {
            sheet = workbook.getSheetAt(index);
            int number = sheet.getLastRowNum();
            return number;
        }
    }
    public int getColCount(String sheetName) {
        int index = workbook.getSheetIndex(sheetName);
        int noofColumns = sheet.getRow(index).getPhysicalNumberOfCells();
        if (noofColumns == -1)
            return -1;
        else
            return noofColumns;
    }
    public static String getdata(String path, String sheetName, int rowNum, int colNum) {
        String retVal = null;
        try {
            FileInputStream fis = new FileInputStream(path);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet s = wb.getSheet(sheetName);
            Row r = s.getRow(rowNum);
            Cell c = r.getCell(colNum);
            if(c.getStringCellValue() == null){
                retVal ="";
            }
            retVal = c.getStringCellValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return retVal;
    }

    public int getSheetCount() {
        int count = workbook.getNumberOfSheets();
        if (count == -1)
            return 0;
        else {
            return count;
        }
    }
    public String GetSheetName(int sheetID) {
        String sheetName = workbook.getSheetName(sheetID);
        return sheetName;
    }


}
