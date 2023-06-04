package com.example.cloudapp;

import android.content.Context;
import android.util.Log;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteFoodList {
    private static Context context;

    public static void setContext(Context ctx) {
        context = ctx;
    }

    public static void writeToExcel(List<GridItem> gridItems, String filename) throws IOException {
        // 创建工作簿
        Workbook workbook = new XSSFWorkbook();

        // 创建指定名称的工作表
        Sheet sheet = workbook.createSheet(filename);

        // 创建标题行
        Row headerRow = sheet.createRow(0);
        headerRow.createCell(0).setCellValue("圖像ID");
        headerRow.createCell(1).setCellValue("名稱");
        headerRow.createCell(2).setCellValue("敘述");

        // 填充数据行
        int rowIndex = 1;
        for (GridItem item : gridItems) {
            Row dataRow = sheet.createRow(rowIndex++);
            dataRow.createCell(0).setCellValue(item.getImageId());
            dataRow.createCell(1).setCellValue(item.getTitle());
            dataRow.createCell(2).setCellValue(item.getContent());
        }

        // 获取应用程序的外部文件目录
        File externalDir = context.getExternalFilesDir(null);
        if (externalDir != null) {
            // 创建文件路径
            File file = new File(externalDir, filename + ".xlsx");

            // 保存工作簿到文件
            try (FileOutputStream fileOutputStream = new FileOutputStream(file)) {
                workbook.write(fileOutputStream);
            } catch (IOException e) {
                Log.e("WriteFoodList", "Error closing workbook: " + e.getMessage());
                e.printStackTrace();
            }
        }

        // 关闭工作簿
        try {
            workbook.close();
        } catch (IOException e) {
            Log.e("WriteFoodList", "Error closing workbook: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public static List<GridItem> Mc_data() {
        List<GridItem> tempgriditems = new ArrayList<>();
        tempgriditems.add(new GridItem(R.drawable.mc_fries,"薯條", "55","查看",MainActivity.class));
        tempgriditems.add(new GridItem(R.drawable.mc_chicken,"雞塊", "60","查看",MainActivity.class));
        tempgriditems.add(new GridItem(R.drawable.mc_icecream,"冰淇淋", "20","查看",MainActivity.class));
        tempgriditems.add(new GridItem(R.drawable.mc_hamburger,"漢堡", "70","查看",MainActivity.class));
        return tempgriditems;
    }

    public static List<GridItem> Kfc_data() {
        List<GridItem> tempgriditems = new ArrayList<>();
        tempgriditems.add(new GridItem(R.drawable.kfc_friedchicken, "炸雞", "100", "查看", MainActivity.class));
        tempgriditems.add(new GridItem(R.drawable.kfc_eggtart, "蛋塔", "70", "查看", MainActivity.class));
        tempgriditems.add(new GridItem(R.drawable.kfc_qqball, "QQ球", "50", "查看", MainActivity.class));
        // 添加其他清单项
        return tempgriditems;
    }

    public static List<GridItem> fd_data() {
        List<GridItem> tempgriditems = new ArrayList<>();
        tempgriditems.add(new GridItem(R.drawable.fd_friedchicken, "炸雞", "110", "查看", MainActivity.class));
         // 添加其他清单项
        return tempgriditems;
    }

    public static List<GridItem> mos_data() {
        List<GridItem> tempgriditems = new ArrayList<>();
        tempgriditems.add(new GridItem(R.drawable.mos_hamburger, "漢堡", "60", "查看", MainActivity.class));
        // 添加其他清单项
        return tempgriditems;
    }
    public static List<GridItem> tkk_data() {
        List<GridItem> tempgriditems = new ArrayList<>();
        tempgriditems.add(new GridItem(R.drawable.tkk_friedchicken, "炸雞", "120", "查看", MainActivity.class));
        // 添加其他清单项
        return tempgriditems;
    }
    public static List<GridItem> dom_data() {
        List<GridItem> tempgriditems = new ArrayList<>();
        tempgriditems.add(new GridItem(R.drawable.dom_pizza, "披薩", "300", "查看", MainActivity.class));
        // 添加其他清单项
        return tempgriditems;
    }
    public static List<GridItem> hb_data() {
        List<GridItem> tempgriditems = new ArrayList<>();
        tempgriditems.add(new GridItem(R.drawable.hb_pizza, "披薩", "300", "查看", MainActivity.class));
        // 添加其他清单项
        return tempgriditems;
    }
    public static List<GridItem> nap_data() {
        List<GridItem> tempgriditems = new ArrayList<>();
        tempgriditems.add(new GridItem(R.drawable.nap_friedchicken, "炸雞", "300", "查看", MainActivity.class));
        // 添加其他清单项
        return tempgriditems;
    }
    public static List<GridItem> readFromExcel(String filename) {
        List<GridItem> gridItems = new ArrayList<>();

        // 获取应用程序的外部文件目录
        File externalDir = context.getExternalFilesDir(null);
        if (externalDir != null) {
            // 创建文件路径
            File file = new File(externalDir, filename + ".xlsx");

            try (FileInputStream fileInputStream = new FileInputStream(file)) {
                // 打开工作簿
                Workbook workbook = WorkbookFactory.create(fileInputStream);

                // 获取工作表
                Sheet sheet = workbook.getSheetAt(0);

                // 遍历行
                for (Row row : sheet) {
                    // 获取单元格数据
                    Cell cell1 = row.getCell(0);
                    Cell cell2 = row.getCell(1);
                    Cell cell3 = row.getCell(2);

                    // 获取单元格值并创建GridItem对象
                    int imageId = (int) cell1.getNumericCellValue();
                    String title = cell2.getStringCellValue();
                    String content = cell3.getStringCellValue();
                    GridItem gridItem = new GridItem(imageId, title, content, "查看", MainActivity.class);

                    // 将GridItem添加到列表中
                    gridItems.add(gridItem);
                }

                // 关闭工作簿
                workbook.close();
            } catch (IOException e) {
                Log.e("workwrong", "Error closing workbook: " + e.getMessage());
                e.printStackTrace();
            }
        }

        return gridItems;
    }

    public static class OrderRecord {
        private static int muchfood;
        private List<FoodItem> foodList;

        private OrderRecord() {
            foodList = new ArrayList<>();
            muchfood = 0;
        }

        public static int getInstance() {
            return muchfood;
        }

        public void addFood(String name, String description) {
            FoodItem foodItem = new FoodItem(name, description);
            foodList.add(foodItem);
        }

        public List<FoodItem> getFoodList() {
            return foodList;
        }

        // 其他操作和记录的方法
        public class FoodItem {
            private String name;
            private String description;

            public FoodItem(String name, String description) {
                this.name = name;
                this.description = description;
            }

            public String getName() {
                return name;
            }

            public String getDescription() {
                return description;
            }
        }
    }
}