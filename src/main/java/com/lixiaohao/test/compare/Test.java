package com.lixiaohao.test.compare;

import com.lixiaohao.test.annotation.Compare;
import com.lixiaohao.test.annotation.CompareUtils;
import com.lixiaohao.test.annotation.CompareValue;
import org.junit.Before;

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
public class Test {

    Logger logger = Logger.getLogger("test");

//    @Before
    public void init(){
        logger.info("this is innit method!!!");
    }

    @org.junit.Test
    public void unitTest() throws IllegalAccessException {
        logger.info("test...");
        AnnotationTest annotationTest = new AnnotationTest();
        AnnotationTest annotationTest1 = new AnnotationTest();
        annotationTest.setName("刘德华");
        annotationTest.setAge(1);
        annotationTest.setLength(new Integer(189));
        annotationTest.setSex(true);
        annotationTest1.setName("张学友");
        annotationTest1.setAge(2);
        annotationTest1.setLength(new Integer(4));
        annotationTest1.setSex(false);
        List<CompareValue> compareValues = CompareUtils.reflect(annotationTest,annotationTest1);
        logger.info("");
    }

    @org.junit.Test
    public void tests(){

        String[] pss = new String[]{"12"};
        AnnotationTest[] pss1 = new AnnotationTest[1];
        ArrayList list  = new ArrayList();
        list.add(1);list.add(2);
        ArrayList list1  = new ArrayList();
        list1.add(1);list1.add(2);list1.add(2);

        if(pss1.getClass().getName().equals("[Lcom.lixiaohao.test.compare.AnnotationTest;")){
            logger.info("result{}"+ AnnotationTest.class.getName());
        }
        logger.info(pss1.getClass().getName());

        if(list1.containsAll(list)){
            logger.info("dfffffffffffff");

        }

    }
}
