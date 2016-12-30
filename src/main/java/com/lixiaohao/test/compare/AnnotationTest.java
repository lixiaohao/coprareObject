package com.lixiaohao.test.compare;

import com.lixiaohao.test.annotation.Compare;

/**
 * Created by lixiaohao
 * Date:${DATA}
 * Description:
 */
public class AnnotationTest {

    @Compare(value = Compare.CompareTypeFactory.BASIC_TYPE)
    private String name;

    @Compare
    private int age;

    @Compare
    private Boolean sex;

    @Compare
    private Integer length;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
    }
}
