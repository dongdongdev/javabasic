package cn.huhuiyu.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import cn.huhuiyu.web.entity.TbGoods;

public class TbGoodsDAO {
	public static final String INSERT = "insert into TbGoods(gname,ginfo,price,amount) values(?,?,?,?)";
	public static final String UPDATE = "update TbGoods set gname=?,ginfo=?,price=?,amount=? where gid=?";
	public static final String DELETE = "delete from TbGoods where gid=?";
	public static final String QUERY_BY_KEY = "select * from TbGoods where gid=?";
	public static final String QUERY = "select * from TbGoods";

	public int add(TbGoods goods) throws Exception {
		PreparedStatement ps = connection.prepareStatement(INSERT);
		ps.setString(1, goods.getGname());
		ps.setString(2, goods.getGinfo());
		ps.setBigDecimal(3, goods.getPrice());
		ps.setInt(4, goods.getAmount());
		int result = ps.executeUpdate();
		ps.close();
		return result;
	}

	public int modify(TbGoods goods) throws Exception {
		PreparedStatement ps = connection.prepareStatement(UPDATE);
		ps.setString(1, goods.getGname());
		ps.setString(2, goods.getGinfo());
		ps.setBigDecimal(3, goods.getPrice());
		ps.setInt(4, goods.getAmount());
		ps.setInt(5, goods.getGid());
		int result = ps.executeUpdate();
		ps.close();
		return result;
	}

	public int delete(TbGoods goods) throws Exception {
		PreparedStatement ps = connection.prepareStatement(DELETE);
		ps.setInt(1, goods.getGid());
		int result = ps.executeUpdate();
		ps.close();
		return result;
	}

	public List<TbGoods> query() throws Exception {
		List<TbGoods> list = new ArrayList<TbGoods>();
		PreparedStatement ps = connection.prepareStatement(QUERY);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			TbGoods goods = new TbGoods();
			goods.setGid(rs.getInt("gid"));
			goods.setGname(rs.getString("gname"));
			goods.setGinfo(rs.getString("ginfo"));
			goods.setPrice(rs.getBigDecimal("price"));
			goods.setAmount(rs.getInt("amount"));
			list.add(goods);
		}
		ps.close();
		return list;
	}

	public TbGoods queryByKey(TbGoods goods) throws Exception {
		TbGoods result = null;
		PreparedStatement ps = connection.prepareStatement(QUERY_BY_KEY);
		ps.setInt(1, goods.getGid());
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			result = new TbGoods();
			result.setGid(rs.getInt("gid"));
			result.setGname(rs.getString("gname"));
			result.setGinfo(rs.getString("ginfo"));
			result.setPrice(rs.getBigDecimal("price"));
			result.setAmount(rs.getInt("amount"));
		}
		ps.close();
		return result;
	}

	private Connection connection;

	public Connection getConnection() {
		return connection;
	}

	public void setConnection(Connection connection) {
		this.connection = connection;
	}

}
