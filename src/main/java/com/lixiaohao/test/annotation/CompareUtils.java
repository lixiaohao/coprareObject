package com.lixiaohao.test.annotation;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by lixiaohao
 * Date:${DATA}
 * Description:
 */
public class CompareUtils {
    static Logger logger = Logger.getLogger(CompareUtils.class.getName());

    public static List<CompareValue> reflect(Object original, Object o) throws IllegalAccessException {

        List<CompareValue> compareValues = new ArrayList<CompareValue>();
        Class clazz = original.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields){
            Compare compare = (Compare) field.getAnnotation(Compare.class);
            if(compare==null)continue;
                //引用类型
                if(compare.value() == Compare.CompareTypeFactory.REFERENCE_TYPE){
                    field.setAccessible(Boolean.TRUE);
                    String name = field.getName();
                    Object originalValue = field.get(original);
                    Object value         =  field.get(o);
                    if(!compare.loopDown() ){
                        CompareValue c = addCompareValue(name,originalValue,value);
                        List<CompareValue> cs = compareSingle(originalValue,value);
                        c.setCompareValues(cs);
                        compareValues.add(c);
                    }
                }


        }
        compareValues.addAll(compareSingle(original,o));

        return compareValues;
    }

    //非引用类型
    public static List<CompareValue> compareSingle(Object original, Object o) throws IllegalAccessException {
        List<CompareValue> compareValues = new ArrayList<CompareValue>();
        Class clazz = original.getClass();
        Field[] fields = clazz.getDeclaredFields();
        for(Field field:fields){
            Compare compare = (Compare) field.getAnnotation(Compare.class);
            if(compare!=null)continue;
                //引用类型不在此处比较
                if(compare.value() == Compare.CompareTypeFactory.REFERENCE_TYPE)continue;

                field.setAccessible(Boolean.TRUE);
                String name = field.getName();
                Object originalValue = field.get(original);
                Object value         =  field.get(o);
                if(original.getClass().isArray()){
                    //如果是数组
                    Object[] obj = (Object[])original;
                    Object[] obj1 = (Object[])o;
                    if(!Arrays.equals(obj,obj1)){
                        compareValues.add(addCompareValue(name,originalValue,value));
                        continue;
                    }
                }else
                if (original instanceof List){
                    //如果是list
                    List l1 = (List)original;
                    List l2 = (List)o;
                    if(!containsAll(l1,l2)){
                        compareValues.add(addCompareValue(name,originalValue,value));
                        continue;
                    }
                }


                if(!equals(originalValue,value)){
                    compareValues.add(addCompareValue(name,originalValue,value));
                    continue;
                }


        }
        return compareValues;
    }





    private static boolean equals(Object origial,Object str){
        return (origial == str)||(origial!=null && origial.equals(str));
    }

    private static CompareValue addCompareValue(String name,Object originalValue,Object value){
        CompareValue compareValue = new CompareValue();
        compareValue.setName(name);
        compareValue.setOriginalVale(originalValue);
        compareValue.setNewValue(value);
        return compareValue;
    }

    private static boolean containsAll(List<Object> l1,List<Object> l2){
        return (l1 == l2) || (l1 !=null && l1.size()==l2.size() && l1.containsAll(l2));
    }
}
