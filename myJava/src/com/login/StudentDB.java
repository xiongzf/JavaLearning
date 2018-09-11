package com.login;

import java.util.ArrayList;
import java.util.List;

public class StudentDB {
    private static List<Student> list = new ArrayList<Student>();

    static {
        list.add(new Student("zhangsan", "123456"));
        list.add(new Student("lisi", "111111"));
        list.add(new Student("wangwu", "222222"));
        list.add(new Student("zhaosi", "333333"));
    }

    public static List<Student> getList() {
        return list;
    }
}
