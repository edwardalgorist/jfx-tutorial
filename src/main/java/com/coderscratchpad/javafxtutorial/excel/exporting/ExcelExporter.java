package com.coderscratchpad.javafxtutorial.excel.exporting;

import javafx.collections.ObservableList;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/exporting-javafx-table-data-to-excel/">coderscratchpad.com</a>
 */
public class ExcelExporter {

    public static <T> void exportToExcel(TableView<T> tableView, String sheetName, String filePath) throws IOException {

        try (Workbook workbook = new XSSFWorkbook()) {

            Sheet sheet = workbook.createSheet(sheetName);

            ObservableList<TableColumn<T, ?>> columns = tableView.getColumns();

            // Create header row
            Row headerRow = sheet.createRow(0);

            for (int i = 0; i < columns.size(); i++) {
                headerRow.createCell(i).setCellValue(columns.get(i).getText());
            }

            // Fill data
            ObservableList<T> items = tableView.getItems();

            for (int rowIdx = 0; rowIdx < items.size(); rowIdx++) {

                Row row = sheet.createRow(rowIdx + 1);
                T item = items.get(rowIdx);

                for (int colIdx = 0; colIdx < columns.size(); colIdx++) {

                    Object cellValue = columns.get(colIdx).getCellData(item);

                    if (cellValue != null) {
                        row.createCell(colIdx).setCellValue(cellValue.toString());
                    }
                }
            }

            // Save the workbook to a file
            try (FileOutputStream fileOut = new FileOutputStream(filePath)) {
                workbook.write(fileOut);
            }
        }
    }

}