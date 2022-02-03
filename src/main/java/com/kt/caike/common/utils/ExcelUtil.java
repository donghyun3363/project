package com.kt.caike.common.utils;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public class ExcelUtil {

    private int rowNum = 0;

    //File로 만들 경우
    public void createExcelToFile(List<Map<String, Object>> datas, String filepath) throws FileNotFoundException, IOException {
        //workbook = new HSSFWorkbook(); // 엑셀 97 ~ 2003
        //workbook = new XSSFWorkbook(); // 엑셀 2007 버전 이상

        Workbook workbook = new SXSSFWorkbook(); // 성능 개선 버전
        Sheet sheet = workbook.createSheet("데이터");

        rowNum = 0;

        createExcel(sheet, datas);

        FileOutputStream fos = new FileOutputStream(new File(filepath));
        workbook.write(fos);
        workbook.close();

    }

    //HttpServletResponse 경우
    public void createExcelToResponse(List<Map<String, Object>> datas, String filename, HttpServletResponse response) throws IOException {
        Workbook workbook = new SXSSFWorkbook(); // 성능 개선 버전
        Sheet sheet = workbook.createSheet("데이터");

        rowNum = 0;

        createExcel(sheet, datas);

        // 컨텐츠 타입과 파일명 지정
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", String.format("attachment;filename=%s.xlsx", filename));

        workbook.write(response.getOutputStream());
        workbook.close();
    }

    //엑셀 생성
    private void createExcel(Sheet sheet, List<Map<String, Object>> datas) {

        //데이터를 한개씩 조회해서 한개의 행으로 만든다.
        for (Map<String, Object> data : datas) {
            //row 생성
            Row row = sheet.createRow(rowNum++);
            int cellNum = 0;

            //map에 있는 데이터를 한개씩 조회해서 열을 생성한다.
            for (String key : data.keySet()) {
                //cell 생성
                Cell cell = row.createCell(cellNum++);

                //cell에 데이터 삽입
                cell.setCellValue(data.get(key).toString());
            }
        }
    }


    /*
     1. 엑셀 다운로드 response write
    * @GetMapping(value = "/excelDownload")
    public void excelDownload(
            HttpServletResponse response
    ) {
        List<Map<String, Object>> datas = new ArrayList<>();

        Map<String, Object> data1 = new HashMap<>();
        data1.put("id", 1);
        data1.put("name", "kim");

        Map<String, Object> data2 = new HashMap<>();
        data2.put("id", 2);
        data2.put("name", "park");

        datas.add(data1);
        datas.add(data2);

        ExcelUtil excelUtil = new ExcelUtil();

        excelUtil.createExcelToResponse(
                datas,
                String.format("%s-%s", "data", LocalDate.now().toString()),
                response
        );
    }
    * */

    /*
     * 2. 파일 다운로드 경우
     * List<Map<String, Object>> datas = new ArrayList<>();

        Map<String, Object> data1 = new HashMap<>();
        data1.put("id", 1);
        data1.put("name", "kim");

        Map<String, Object> data2 = new HashMap<>();
        data2.put("id", 2);
        data2.put("name", "park");

        datas.add(data1);
        datas.add(data2);

        ExcelUtil excelUtil = new ExcelUtil3();

        String filepath = "D:/data.xlsx";
        excelUtil.createExcelToFile(datas, filepath)
     */
}
