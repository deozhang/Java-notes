package com.xms.dao;
/**
 * �ӿ�
 * @author Administrator
 *
 */
public interface UserDao {
	//��¼���
	void loginByStatement(String username,String pwd);
	
	void loginByPreparedStatement(String username,String pwd);
	
}
