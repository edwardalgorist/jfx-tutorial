package com.coderscratchpad.javafxtutorial.excel.displaying;

import java.io.FileInputStream;
import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/displaying-excel-data-in-javafx/">coderscratchpad.com</a>
 */
public class UserExcelFileReader {

    private Workbook workbook;

    public UserExcelFileReader(String excelFilePath) throws IOException {

        // Open the Excel file
        try (FileInputStream file = new FileInputStream(excelFilePath)) {

            // Create a Workbook object based on the file extension
            if (excelFilePath.endsWith(".xlsx")) {

                workbook = new XSSFWorkbook(file);
            } else if (excelFilePath.endsWith(".xls")) {

                workbook = new HSSFWorkbook(file);
            }
        }
    }

    public ObservableList<User> getUsers() {

        // Get users from the first sheet
        return this.getData(0);
    }

    public ObservableList<User> getUsers(int sheetIndex) {

        // Get users from the specified sheet
        return this.getData(sheetIndex);
    }

    public int getNumberOfSheets() {

        // Return the number of sheets in the workbook
        return workbook.getNumberOfSheets();
    }

    private ObservableList<User> getData(int sheetIndex) {

        ObservableList<User> users = FXCollections.observableArrayList();

        // Get the specific sheet
        Sheet sheet = this.workbook.getSheetAt(sheetIndex);

        // Use a flag to skip the first row (header)
        boolean isFirstRow = true;

        for (Row row : sheet) {

            if (!isEmptyRow(row)) {

                // Skip the first row
                if (isFirstRow) {
                    isFirstRow = false;
                    continue;
                }

                // Extract and create a User object from the row's data
                User user = new User(
                        ((int) row.getCell(0).getNumericCellValue()), // ID
                        row.getCell(1).getStringCellValue(), // First Name
                        row.getCell(2).getStringCellValue(), // Last Name
                        row.getCell(3).getStringCellValue(), // Gender
                        row.getCell(4).getStringCellValue(), // Country
                        ((int) row.getCell(5).getNumericCellValue()), // Age
                        row.getCell(6).getStringCellValue() // Date
                );

                users.add(user);
            }
        }

        return users;
    }

    private boolean isEmptyRow(Row row) {

        boolean emptyRow = true;

        for (Cell cell : row) {

            // Check if the cell is empty or null
            if (cell != null && cell.getCellType() != CellType.BLANK) {

                emptyRow = false;
                break; // No need to continue checking if any cell is not empty
            }

        }

        return emptyRow;
    }

    // Define the User record with attributes
    public record User(int id, String firstName, String lastName, String gender, String country, int age, String date) {

        public int getId() {
            return id;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public String getGender() {
            return gender;
        }

        public String getCountry() {
            return country;
        }

        public int getAge() {
            return age;
        }

        public String getDate() {
            return date;
        }
    }
}