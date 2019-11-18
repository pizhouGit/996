package com.imooc.pz.resource;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * jdk7之后，实现正确关闭流资源
 * try --with---resource
 */
public class NewFileCopyTest {

    @Test
    public void copyFile(){

        //定义输入输出路径
        String originalUrl = "D:\\SSM\\996_gao\\lib\\FileCopyTest.java";
        String targetUrl = "D:\\SSM\\996_gao\\libs\\1.txt";

        //初始化输入输出对象
        try (
                FileInputStream fileInputStream =
                        new FileInputStream(originalUrl);

                FileOutputStream fileOutputStream =
                        new FileOutputStream(targetUrl);
        ) {

            int content;
            //迭代、拷贝数据
            while ((content = fileInputStream.read()) != -1) {
                fileOutputStream.write(content);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
