package com.xms.dao;
/**
 * ½Ó¿Ú
 * @author Administrator
 *
 */
public interface UserDao {
	//µÇÂ¼¼ì²â
	void loginByStatement(String username,String pwd);
	
	void loginByPreparedStatement(String username,String pwd);
	
}
