package com.huang.practice.guava.chapter01;

import org.junit.Test;

import static com.google.common.base.Preconditions.checkArgument;
import static com.google.common.base.Preconditions.checkNotNull;

/**
 * PreConditionsTest -
 *
 * @author: huang_jiangling
 * @date: 2019-09-29
 **/
public class PreConditionsTest {


    /**
     * chackArgument:
     * 检查方法参数，表达式的最终结果是布尔值；
     */
    @Test
    public void test1() {
        int i = 1;
        int j = 2;
        checkArgument(i >= 0, "Argument was %s but expected nonnegative", i);
        checkArgument(i < j, "Expected i < j, but %s > %s", i, j);
    }

    /**
     * checkNotNull：
     * 检查对象是否为空，为空时报错；
     * 并且value不为空时，返回value，所以通常可以内嵌使用；
     */
    @Test
    public void test2() {
        String hehe = new String(checkNotNull("hehe"));
    }
}
