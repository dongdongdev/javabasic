package org.huhuiyu.jdbc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.huhuiyu.jdbc.entity.TbDept;

public class TbDeptDAO {
	public static final String ADD = "insert into TbDept(deptName,deptInfo) values(?,?)";
	public static final String QUERY = "select * from TbDept";

	public static int addTbDept(TbDept dept) throws Exception {
		Connection conn = Db.getConnection();
		PreparedStatement ps = conn.prepareStatement(ADD, PreparedStatement.RETURN_GENERATED_KEYS);
		ps.setString(1, dept.getDeptName());
		ps.setString(2, dept.getDeptInfo());
		int result = ps.executeUpdate();
		ResultSet rs = ps.getGeneratedKeys();
		if (rs.next()) {
			dept.setDeptId(rs.getInt(1));
		}
		rs.close();
		ps.close();
		conn.close();
		return result;
	}

	public static List<TbDept> queryAll() throws Exception {
		List<TbDept> list = new ArrayList<TbDept>();
		Connection conn = Db.getConnection();
		PreparedStatement ps = conn.prepareStatement(QUERY);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			TbDept dept = new TbDept();
			dept.setDeptId(rs.getInt("deptId"));
			dept.setDeptName(rs.getString("deptName"));
			dept.setDeptInfo(rs.getString("deptInfo"));
			dept.setCreated(rs.getTimestamp("created"));
			list.add(dept);
		}
		return list;
	}

	public static void testAddTbDept() throws Exception {
		Random random = new Random();
		TbDept dept = new TbDept();
		dept.setDeptName("部门" + random.nextInt());
		dept.setDeptInfo("描述" + random.nextInt());
		System.out.println("添加的结果：" + TbDeptDAO.addTbDept(dept));
		System.out.println(dept);
	}

	public static void testQueryAll() throws Exception {
		List<TbDept> list = TbDeptDAO.queryAll();
		for (TbDept tbDept : list) {
			System.out.println(tbDept);
		}
	}

	public static void main(String[] args) throws Exception {
		//TbDeptDAO.testAddTbDept();
		TbDeptDAO.testQueryAll();
	}
}
