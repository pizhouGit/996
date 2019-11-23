package com.imooc.pz.Lombok;

import lombok.Cleanup;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Cleanup注解
 * 资源的关闭
 */
public class CleanupTest {

    @Test
    public void copyFile(String in,String out) throws IOException {

       @Cleanup FileInputStream fileInputStream =
                new FileInputStream(in);

       @Cleanup FileOutputStream fileOutputStream =
                new FileOutputStream(out);

        int r;
        while ((r = fileInputStream.read()) != -1){
            fileOutputStream.write(r);
        }

    }
}
