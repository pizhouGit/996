package com.imooc.pz.guava;


import com.google.common.base.Charsets;
import com.google.common.io.CharSink;
import com.google.common.io.CharSource;
import com.google.common.io.Files;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * 演示如何使用流（source）与汇（sink）来对文件进行常用操作
 */
public class IOTest {

    @Test
    public void copeFile() throws IOException {
        /**
         * 1.创建对应的Source和SinK
         */
        CharSource charSource =
                Files.asCharSource(new File("SourcaTest.txt"),
                        Charsets.UTF_8);

        CharSink charSink = Files.asCharSink(new File("TageTest.txt"),
                Charsets.UTF_8);
        /**
         * 2.拷贝
         */

        charSource.copyTo(charSink);
    }



}
