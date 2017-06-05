package com.role.entity;

import java.util.Date;

public class Role {
    private Long id;

    private String rolecode;

    private String rolename;

    private Long createdby;

    private Date creationdate;

    private Long modifyby;

    private Date modifydate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRolecode() {
        return rolecode;
    }

    public void setRolecode(String rolecode) {
        this.rolecode = rolecode == null ? null : rolecode.trim();
    }

    public String getRolename() {
        return rolename;
    }

    public void setRolename(String rolename) {
        this.rolename = rolename == null ? null : rolename.trim();
    }

    public Long getCreatedby() {
        return createdby;
    }

    public void setCreatedby(Long createdby) {
        this.createdby = createdby;
    }

    public Date getCreationdate() {
        return creationdate;
    }

    public void setCreationdate(Date creationdate) {
        this.creationdate = creationdate;
    }

    public Long getModifyby() {
        return modifyby;
    }

    public void setModifyby(Long modifyby) {
        this.modifyby = modifyby;
    }

    public Date getModifydate() {
        return modifydate;
    }

    public void setModifydate(Date modifydate) {
        this.modifydate = modifydate;
    }

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Long id, String rolecode, String rolename, Long createdby, Date creationdate, Long modifyby,
			Date modifydate) {
		super();
		this.id = id;
		this.rolecode = rolecode;
		this.rolename = rolename;
		this.createdby = createdby;
		this.creationdate = creationdate;
		this.modifyby = modifyby;
		this.modifydate = modifydate;
	}

	public Role(String rolecode, String rolename, Long createdby, Date creationdate, Long modifyby, Date modifydate) {
		super();
		this.rolecode = rolecode;
		this.rolename = rolename;
		this.createdby = createdby;
		this.creationdate = creationdate;
		this.modifyby = modifyby;
		this.modifydate = modifydate;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", rolecode=" + rolecode + ", rolename=" + rolename + ", createdby=" + createdby
				+ ", creationdate=" + creationdate + ", modifyby=" + modifyby + ", modifydate=" + modifydate + "]";
	}
    
}