package dao;

import java.util.List;

import entity.Admin;

public interface AdminDAO {
	//查询所有记录
	public List<Admin> findAll() throws Exception;
	//添加管理员
	public void add() throws Exception;
	//根据id删除管理员
	public void del(int id) throws Exception;
	//根据id查询管理员
	public Admin findById(int id) throws Exception;
	//根据id更新管理员
	public void update(Admin admin) throws Exception;

}
