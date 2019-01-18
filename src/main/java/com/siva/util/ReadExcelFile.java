package com.siva.util;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.siva.domain.Planet;
import com.siva.domain.Route;

public class ReadExcelFile {

	public static void main( String [] args ) {
        String fileName="D:\\siva\\route_test.xlsx";
        System.out.println("File Name is"+ fileName);
        List dataHolder=readPlanetName(fileName);
        System.out.println(dataHolder);
//        List dataHolderTraffic=readPlanetTrafficDelay(fileName);
//        System.out.println(dataHolderTraffic);
        List dataHolderDistance=readPlanetDistance(fileName);
        System.out.println(dataHolderDistance);
        
       
    }
    public static List<Planet> readPlanetName(String fileName)    {
        List<Planet> rowHolder = new ArrayList<Planet>();
        try{
            FileInputStream myInput = new FileInputStream(fileName);
            XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);
            XSSFSheet mySheet = myWorkBook.getSheetAt(3);
            System.out.println(mySheet.getSheetName());
            Iterator rowIter = mySheet.rowIterator();
            while(rowIter.hasNext()){
                XSSFRow myRow = (XSSFRow) rowIter.next();
                rowHolder.add(getPlanet(myRow));
            }
        }catch (Exception e){e.printStackTrace(); }
        return rowHolder;
    }
    
    private static Planet getPlanet(XSSFRow myRow) {
    	Planet planet = new Planet();
        planet.setPlanetCode(myRow.getCell(1)!=null?myRow.getCell(0).getStringCellValue() : null);
        planet.setPlanetCode(myRow.getCell(1)!=null?myRow.getCell(1).getStringCellValue() : null);
		return planet;
	}
	public static List<Route> readPlanetDistance(String fileName)    {
        List<Route> rowHolder = new ArrayList<Route>();
        try{
            FileInputStream myInput = new FileInputStream(fileName);
            XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);
            XSSFSheet mySheet = myWorkBook.getSheetAt(1);
            System.out.println(mySheet.getSheetName());
            Iterator rowIter = mySheet.rowIterator();
            while(rowIter.hasNext()){
                XSSFRow myRow = (XSSFRow) rowIter.next();
                rowHolder.add(getRoute(myRow));
            }
        }catch (Exception e){e.printStackTrace(); }
        return rowHolder;
    }
    
    private static Route getRoute(XSSFRow myRow) {
		// TODO Auto-generated method stub
    	Route route = new Route();
    	route.setId(myRow.getCell(0)!=null?Integer.getInteger(myRow.getCell(0).toString()): null);
    	route.setSource(myRow.getCell(1)!=null?new Planet(myRow.getCell(1).getStringCellValue(), ""): null);
    	route.setDestination(myRow.getCell(2)!=null?new Planet(myRow.getCell(2).getStringCellValue(), ""): null);
    	route.setDistance(myRow.getCell(2)!=null?Double.parseDouble(myRow.getCell(3).toString()): null);
		return route;
	}
	public static List readPlanetTrafficDelay(String fileName)    {
        List<String> cellVectorHolder = new ArrayList<String>();
        try{
            FileInputStream myInput = new FileInputStream(fileName);
            XSSFWorkbook myWorkBook = new XSSFWorkbook(myInput);
            XSSFSheet mySheet = myWorkBook.getSheetAt(2);
            System.out.println(mySheet.getSheetName());
            Iterator rowIter = mySheet.rowIterator();
            while(rowIter.hasNext()){
                XSSFRow myRow = (XSSFRow) rowIter.next();
                Iterator cellIter = myRow.cellIterator();
                List list = new ArrayList();
                while(cellIter.hasNext()){
                    XSSFCell myCell = (XSSFCell) cellIter.next();
                    list.add(myCell);
                }
                cellVectorHolder.addAll(list);
            }
        }catch (Exception e){e.printStackTrace(); }
        return cellVectorHolder;
    }
    
}
