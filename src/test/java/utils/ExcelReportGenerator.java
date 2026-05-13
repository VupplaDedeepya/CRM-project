package utils;

import java.io.FileOutputStream;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import listeners.TestListener;

public class ExcelReportGenerator {

    public static String generateReport() {

        String path = System.getProperty("user.dir")
                + "\\Reports\\SanityReport.xlsx";

        try {

            Workbook workbook = new XSSFWorkbook();

            Sheet sheet =
                    workbook.createSheet("Sanity Results");

            Row header = sheet.createRow(0);

            header.createCell(0)
                  .setCellValue("Test Case");

            header.createCell(1)
                  .setCellValue("Status");

            header.createCell(2)
                  .setCellValue("Execution Time");

            int rowNum = 1;

            for(TestResultData data :
                    TestListener.results) {

                Row row = sheet.createRow(rowNum++);

                row.createCell(0)
                   .setCellValue(data.getTestName());

                row.createCell(1)
                   .setCellValue(data.getStatus());

                row.createCell(2)
                   .setCellValue(data.getTime());
            }

            FileOutputStream fos =
                    new FileOutputStream(path);

            workbook.write(fos);

            workbook.close();
            fos.close();

            System.out.println(
                    "Excel Report Generated");

        } catch(Exception e) {
            e.printStackTrace();
        }

        return path;
    }
}