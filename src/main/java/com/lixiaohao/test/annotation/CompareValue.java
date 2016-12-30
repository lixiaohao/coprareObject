package com.lixiaohao.test.annotation;

import java.util.List;

/**
 * Created by lixiaohao
 * Date:${DATA}
 * Description:
 */
public class CompareValue {
    private String name;
    private Object originalVale;
    private Object newValue;
    private List<CompareValue> compareValues;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Object getOriginalVale() {
        return originalVale;
    }

    public void setOriginalVale(Object originalVale) {
        this.originalVale = originalVale;
    }

    public Object getNewValue() {
        return newValue;
    }

    public void setNewValue(Object newValue) {
        this.newValue = newValue;
    }

    public List<CompareValue> getCompareValues() {
        return compareValues;
    }

    public void setCompareValues(List<CompareValue> compareValues) {
        this.compareValues = compareValues;
    }
}
