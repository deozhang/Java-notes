package com.xms.test;

import com.xms.dao.StudentDao;
import com.xms.dao.impl.StudentDaoImple;
import org.junit.Test;

public class TestCaseStudent {
    StudentDao dao = new StudentDaoImple();
    @Test
    public void testInsertStudent(){
        dao.insertBatch();
    }
    @Test
    public void testDeleteStudent(){
        dao.deleteBatch();
    }

}
