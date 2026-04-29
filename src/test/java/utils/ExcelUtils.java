package utils;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	   public static XSSFWorkbook wb;
	    public static XSSFSheet ws;

	    // Load workbook ONCE
	    public static void loadExcel(String xlfile, String xlsheet) throws IOException {
	        FileInputStream fi = new FileInputStream(xlfile);
	        wb = new XSSFWorkbook(fi);
	        ws = wb.getSheet(xlsheet);
	    }

	    public static int getRowCount() {
	        return ws.getLastRowNum();
	    }

	    public static int getCellCount(int rownum) {
	        XSSFRow row = ws.getRow(rownum);
	        return row.getLastCellNum();
	    }

	    public static String getCellData(int rownum, int cellnum) {
	        XSSFRow row = ws.getRow(rownum);
	        XSSFCell cell = row.getCell(cellnum);

	        DataFormatter formatter = new DataFormatter();
	        return formatter.formatCellValue(cell);
	    }

	    public static void setCellData(String xlfile, int rownum, int cellnum, String data) throws IOException {
	        XSSFRow row = ws.getRow(rownum);
	        if (row == null) row = ws.createRow(rownum);

	        XSSFCell cell = row.getCell(cellnum);
	        if (cell == null) cell = row.createCell(cellnum);

	        cell.setCellValue(data);

	        FileOutputStream fo = new FileOutputStream(xlfile);
	        wb.write(fo);
	        fo.close();
	    }

	    public static void fillGreenColor(String xlfile, int rownum, int cellnum) throws IOException {
	        XSSFRow row = ws.getRow(rownum);
	        XSSFCell cell = row.getCell(cellnum);

	        XSSFCellStyle style = wb.createCellStyle();
	        style.setFillForegroundColor(IndexedColors.GREEN.getIndex());
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	        cell.setCellStyle(style);

	        FileOutputStream fo = new FileOutputStream(xlfile);
	        wb.write(fo);
	        fo.close();
	    }

	    public static void fillRedColor(String xlfile, int rownum, int cellnum) throws IOException {
	        XSSFRow row = ws.getRow(rownum);
	        XSSFCell cell = row.getCell(cellnum);

	        XSSFCellStyle style = wb.createCellStyle();
	        style.setFillForegroundColor(IndexedColors.RED.getIndex());
	        style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

	        cell.setCellStyle(style);

	        FileOutputStream fo = new FileOutputStream(xlfile);
	        wb.write(fo);
	        fo.close();
	    }

	    public static void closeWorkbook() throws IOException {
	        wb.close();
	    }
}
