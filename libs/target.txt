package com.imooc.pz.lambda.file;

import org.junit.Test;

import java.io.IOException;

public class FileServiceTest {

    @Test
    public void fileHandle() throws IOException {

        FileService fileService = new FileService();

        //通过lambda表达式，打印文件内容
        fileService.fileHandle("D:\\SSM\\996_gao\\src\\test\\java\\com\\imooc\\pz\\lambda\\file\\FileServiceTest.java",
                fileContent ->
                    System.out.println(fileContent)
                );
    }

}
