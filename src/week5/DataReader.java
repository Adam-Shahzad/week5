package week5;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DataReader {

	private Workbook workbook;

    public DataReader(String fileName){
        try {
            FileInputStream excelFile = new FileInputStream(new File(fileName));
            workbook = new XSSFWorkbook(excelFile);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

 
	public List<String> readRow(int rowNo, String sheetName){
        List<String> row = new ArrayList<String>();
        Sheet datatypeSheet = workbook.getSheet(sheetName);
        Row currentRow =   datatypeSheet.getRow(rowNo);
        for (Cell currentCell : currentRow) {
            switch (currentCell.getCellType()) {
                case 1:
                    row.add(currentCell.getStringCellValue());
                    break;
                case 0:
                    row.add(String.valueOf(currentCell.getNumericCellValue()));
                    break;
                case 4:
                    row.add(String.valueOf(currentCell.getBooleanCellValue()));
                    break;
                case 3:
                    row.add(currentCell.getStringCellValue());
                    break;
                case 5:
                    System.out.println("Error in cell");
                    break;
                case 2:
                    row.add(currentCell.getStringCellValue());
                    break;
            }
        }
        return row;
    }



}
