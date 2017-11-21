package org.huhuiyu.jdbc.entity;

import java.io.Serializable;
import java.util.Date;

public class TbDept implements Serializable {
	private static final long serialVersionUID = 8635665053027042875L;

	private int deptId;
	private String deptName;
	private String deptInfo;
	private Date created;
	
	public TbDept() {
	}

	public int getDeptId() {
		return deptId;
	}

	public void setDeptId(int deptId) {
		this.deptId = deptId;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getDeptInfo() {
		return deptInfo;
	}

	public void setDeptInfo(String deptInfo) {
		this.deptInfo = deptInfo;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	@Override
	public String toString() {
		return "TbDept [deptId=" + deptId + ", deptName=" + deptName + ", deptInfo=" + deptInfo + ", created=" + created
				+ "]";
	}
	
}
