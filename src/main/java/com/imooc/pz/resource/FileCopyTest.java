package com.imooc.pz.resource;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * JDK7之前的文件拷贝功能
 */
public class FileCopyTest {

    @Test
    public void copyFile(){

        /**
         * 1.创建输入/输出流
         * 2.执行文件拷贝，读取文件内容，写入到另外一个文件中
         * 3.关闭流资源
         */

        //定义输入路径和输出路径
        String originalUrl = "D:\\SSM\\996_gao\\lib\\FileServiceTest.java";
        String targetUrl = "D:\\SSM\\996_gao\\libs\\target.txt";

        //声明文件输入、输出流
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;

        try {
            fileInputStream = new FileInputStream(originalUrl);

            fileOutputStream = new FileOutputStream(targetUrl);

            //读取的字节信息
            int content;

            //迭代,读取/写入字节
            while ((content = fileInputStream.read()) != -1){
                fileOutputStream.write(content);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //先打开后关闭
            if (fileOutputStream != null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


            if (fileInputStream != null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        }
    }
}
