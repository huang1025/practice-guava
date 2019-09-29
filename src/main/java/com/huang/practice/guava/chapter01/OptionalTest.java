package com.huang.practice.guava.chapter01;

import com.google.common.base.Optional;
import org.junit.Test;

import java.util.Date;
import java.util.Set;

import static com.google.common.base.Optional.*;
import static org.junit.Assert.*;

/**
 * OptionalTest -
 *
 * @author: huang_jiangling
 * @date: 2019-09-29
 **/
public class OptionalTest {


    /**
     * of:
     * of要求数据不能为null
     */
    @Test
    public void test1() {
        Optional<Integer> num = of(3);
        assertTrue(num.isPresent());
        assertEquals(3, (int) num.get());
    }

    /**
     * absent:
     * 不能从absent中获取数据，会直接报错；
     */
    @Test
    public void test2() {
        Optional<Object> absent = absent();
        // assertNull(absent.get()); 不能从absent中获取数据；
        assertFalse(absent.isPresent());
    }

    /**
     * fromNullable:
     * 可以设置空值，或非空值；
     * 设置空值时，本质是一个Absent对象，不能从这个对象get；
     */
    @Test
    public void test3() {
        Optional<Object> absent = fromNullable(null);
        assertFalse(absent.isPresent());

        Optional<Object> present = fromNullable(new Object());
        assertTrue(present.isPresent());
    }

    /**
     * or:
     * 若包含引用时，返回引用值，若不包含，返回给定的默认值；
     */
    @Test
    public void test4() {
        Optional<Object> absent = absent();
        assertTrue((Boolean) absent.or(true));

        assertEquals(3, absent.or(3));
    }

    /**
     * orNull：
     * 调用该方法时，如果对象是Absent，那么将返回null；
     */
    @Test
    public void test5() {
        Optional<Object> absent = absent();
        assertNull(absent.orNull());
    }

    /**
     * asSet:
     * 存在引用时，将单个元素转为一个元素的集合；
     * 引用为空时，返回一个空集合；
     */
    @Test
    public void test6() {
        Optional<Date> of = of(new Date());
        Set<Date> dates = of.asSet();
        assertEquals(1, dates.size());
    }
}
