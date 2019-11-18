package com.imooc.pz.lambda.Stream;

import org.junit.Test;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * 流的四种构建形式
 */
public class StreamConstructor {

    /**
     * 由数值直接构建流
     */
    @Test
    public void streamFromValue(){
        Stream<Integer> integerStream = Stream.of(1, 2, 3, 45);
        integerStream.forEach(System.out::println);
    }


    /**
     * 通数组来构建流
     */

    @Test
    public void streamFromArray(){
        int [] arr = {1,2,3,45,56};

        IntStream stream = Arrays.stream(arr);
        stream.forEach(System.out::println);
    }

    /**
     * 通过文件来生成流
     */
    @Test
    public void streamFromFile() throws IOException {
        Stream<String> lines = Files.lines(
                Paths.get("D:\\SSM\\996_gao\\src\\main\\java\\com\\imooc\\pz\\lambda\\Stream\\StreamOperator.java"));
        lines.forEach(System.out::println);
    }

    /**
     * 通过函数来生成流(无限流)
     */

    @Test
    public void streamFromFunction(){
        /*Stream<Integer> iterate = Stream.iterate(0, n -> n + 2);
        iterate.forEach(System.out::println);*/

        Stream<Double> generate = Stream.generate(Math::random);
        generate.limit(100).forEach(System.out::println);
    }


}
