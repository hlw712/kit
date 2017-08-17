package com.zl.toolkit.file;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 * 基础文件操作工具类
 *
 * @author huanglw
 * @date 2017/8/16
 */
public class FileUtil {

    /**
     * 读取目录下所有的文件
     *
     * @param path 文件所在路径
     * @return
     */
    public static List<File> readFiles(String path) {

        List<File> list = new LinkedList<File>();
        File file = new File(path);
        if (!file.isDirectory()) {
            list.add(file);
            System.out.println("文件");
            System.out.println("path=" + file.getPath());
        } else if (file.isDirectory()) {
            System.out.println("文件夹");
            String[] fileList = file.list();
            for (int i = 0; i < fileList.length; i++) {
                File readfile = new File(path + "\\" + fileList[i]);
                if (!readfile.isDirectory()) {
                    System.out.println("path=" + readfile.getPath());
                    list.add(readfile);
                } else if (readfile.isDirectory()) {
                    readFiles(path + "\\" + fileList[i]);
                }
            }
        }
        return list;
    }
}
