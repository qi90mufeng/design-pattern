/**
 * sinafenqi.com
 * Copyright (c) 2018 All Rights Reserved.
 */
package com.util.transfer;

import com.csvreader.CsvReader;

import java.io.FileNotFoundException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * @author fujin
 * @version $Id: CsvToExcleUtil.java, v 0.1 2018-04-24 10:39 Exp $$
 */
public class CsvToExcleUtil {

    public static void main(String[] args) throws Exception {
        CsvReader reader = new CsvReader("E:/保费代扣对账文件.csv", ' ', Charset.forName("UTF-8"));
        String[] head = reader.getHeaders();
        System.out.println(head);


    }
}
