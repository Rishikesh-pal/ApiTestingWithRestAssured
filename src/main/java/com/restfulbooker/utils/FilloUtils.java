package com.restfulbooker.utils;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;

public class FilloUtils {

    @DataProvider
    public Iterator<Object[]> getDataFillo() throws FilloException {
        ArrayList<Object[]> data = readCSV();
        return data.iterator();
    }

    public ArrayList<Object[]> readCSV() throws FilloException {
        try {
            Fillo fillo= new Fillo();
            String filepath= System.getProperty("user.dir")+"/src/main/java/resources/TestData.xlsx";
            ArrayList<Object[]> arrayList = null;
            ArrayList<String> objectBaseURL = null;
            ArrayList<String> objectKey = null;
            Connection connection=fillo.getConnection(filepath);
            Recordset recordset = connection.executeQuery("SELECT * FROM Sheet1");
            int numberOfRows = recordset.getCount();
            System.out.println("size: "+numberOfRows);
            int i=0,j=0;
            objectBaseURL = new ArrayList<>();
            objectKey = new ArrayList<>();
            while(recordset.next()){
                objectBaseURL.add(recordset.getField("baseurl"));
                objectKey.add(recordset.getField("key"));
                i++;
                j++;
            }
            recordset.close();
            connection.close();
            arrayList = new ArrayList<>();
            Object[] o ={
                    objectBaseURL,
                    objectKey
            };
            arrayList.add(o);
            return arrayList;
        } catch (FilloException e) {
            e.printStackTrace();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


}
