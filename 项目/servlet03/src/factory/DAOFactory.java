package factory;

import dao.AdminDAOImpl;
import util.ConfigUtil;

public class DAOFactory {
	//type:接口类型
	public static Object getInstance(String type) {
		Object obj = null;
		//根据接口名称获取实现类路径
		//dao.AdminDAOImpl
		String className = ConfigUtil.getValue(type);
		//利用反射技术 创建DAO对象
		try {
			obj = Class.forName(className).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		} 
		return obj;
	}
}
