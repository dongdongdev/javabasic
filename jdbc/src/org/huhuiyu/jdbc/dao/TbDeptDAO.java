package org.huhuiyu.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Random;

import org.huhuiyu.jdbc.entity.TbDept;

public class TbDeptDAO {
	public static final String ADD = "insert into TbDept(deptName,deptInfo) values(?,?)";

	public static int addTbDept(TbDept dept) throws Exception {
		Connection conn = Db.getConnection();
		PreparedStatement ps = conn.prepareStatement(ADD,PreparedStatement.RETURN_GENERATED_KEYS);
		ps.setString(1, dept.getDeptName());
		ps.setString(2, dept.getDeptInfo());
		int result = ps.executeUpdate();
		ResultSet rs=ps.getGeneratedKeys();
		if(rs.next()) {
			dept.setDeptId(rs.getInt(1));
		}
		rs.close();
		ps.close();
		conn.close();
		return result;
	}

	public static void main(String[] args) throws Exception {
		Random random = new Random();
		TbDept dept = new TbDept();
		dept.setDeptName("部门" + random.nextInt());
		dept.setDeptInfo("描述" + random.nextInt());
		System.out.println("添加的结果：" + TbDeptDAO.addTbDept(dept));
		System.out.println(dept);
	}
}
