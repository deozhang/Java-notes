package com.xms.dao;

public interface AccountDao {
    //转账
    void translate(String from,String to,int num);
}
