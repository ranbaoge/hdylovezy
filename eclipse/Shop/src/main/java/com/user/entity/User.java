package com.user.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.role.entity.Role;

public class User {
    private Long id;

    private String usercode;

    private String username;

    private String userpassword;

    private Integer gender;

    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date birthday;

    private String phone;

    private String address;

    private Long userrole;

    private Long createdby;

    private Date creationdate;

    private Long modifyby;

    private Date modifydate;
    
    private Role role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsercode() {
        return usercode;
    }

    public void setUsercode(String usercode) {
        this.usercode = usercode == null ? null : usercode.trim();
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getUserpassword() {
        return userpassword;
    }

    public void setUserpassword(String userpassword) {
        this.userpassword = userpassword == null ? null : userpassword.trim();
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public Long getUserrole() {
        return userrole;
    }

    public void setUserrole(Long userrole) {
        this.userrole = userrole;
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
    
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, String usercode, String username, String userpassword, Integer gender, Date birthday,
			String phone, String address, Long userrole, Long createdby, Date creationdate, Long modifyby,
			Date modifydate) {
		super();
		this.id = id;
		this.usercode = usercode;
		this.username = username;
		this.userpassword = userpassword;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.userrole = userrole;
		this.createdby = createdby;
		this.creationdate = creationdate;
		this.modifyby = modifyby;
		this.modifydate = modifydate;
	}

	public User(String usercode, String username, String userpassword, Integer gender, Date birthday, String phone,
			String address, Long userrole, Long createdby, Date creationdate, Long modifyby, Date modifydate) {
		super();
		this.usercode = usercode;
		this.username = username;
		this.userpassword = userpassword;
		this.gender = gender;
		this.birthday = birthday;
		this.phone = phone;
		this.address = address;
		this.userrole = userrole;
		this.createdby = createdby;
		this.creationdate = creationdate;
		this.modifyby = modifyby;
		this.modifydate = modifydate;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", usercode=" + usercode + ", username=" + username + ", userpassword=" + userpassword
				+ ", gender=" + gender + ", birthday=" + birthday + ", phone=" + phone + ", address=" + address
				+ ", userrole=" + userrole + ", createdby=" + createdby + ", creationdate=" + creationdate
				+ ", modifyby=" + modifyby + ", modifydate=" + modifydate + "]";
	}
    
    
}