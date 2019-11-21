package com.imooc.pz.guava;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Lists/ Sets 使用
 */
public class SetsTest {

    /**
     * Sets工具类的常用方法
     * 并集 / 交集 /差集 / 分解集合中的所有子集 /求两个集合的笛卡尔积
     *
     * Lists工具类的常用方式
     * 反转 / 拆分
     */

    private static final Set set1 =
            Sets.newHashSet(1,2);
    private static final Set set2 =
            Sets.newHashSet(4);

    @Test
    public void union(){
        //并集
        Sets.SetView set = Sets.union(set1, set2);
        System.out.println(set);
    }


    @Test
    public void intersection() {
        //交集
        Sets.SetView intersection = Sets.intersection(set1, set2);
        System.out.println(intersection);
    }

    @Test
    public void difference() {
        //差集：如果元素属于A而且不属于B
        Sets.SetView difference = Sets.difference(set1, set2);
        System.out.println(difference);
    }

    @Test
    public void powerSer(){
        //分解集合中的所有子集
        Set<Set<Integer>> set = Sets.powerSet(set1);
        System.out.println(
                JSON.toJSONString(set,true));
    }

    @Test
    public void car() {
        //计算两个集合笛卡尔积
        Set<List<Integer>> set = Sets.cartesianProduct(set1, set2);
        System.out.println(
                JSON.toJSONString(set)
        );
    }


    @Test
    public void partion() {
        //返回三个数为一组集合
        ArrayList<Integer> list =
                Lists.newArrayList(1,2,3,4,5,6,7);

        List<List<Integer>> partition = Lists.partition(list, 3);

        System.out.println(
                partition
        );
    }

    @Test
    public void reverse(){
        //集合反转
        LinkedList<Integer>list = Lists.newLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);

        List<Integer> reverse = Lists.reverse(list);
        System.out.println(reverse);
    }

}
