package hdy.zy.system.entity;

import java.util.Set;

public class User {
    private Long id;

    private Long departmentId;

    private String loginname;

    private String password;

    private String name;

    private String gender;

    private String phonenumber;

    private String email;

    private Long roleId;
    
    private Department department;
    
    private Set<Role> roleSet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    public String getLoginname() {
        return loginname;
    }

    public void setLoginname(String loginname) {
        this.loginname = loginname == null ? null : loginname.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender == null ? null : gender.trim();
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber == null ? null : phonenumber.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }


	public Department getDepartment() {
		return department;
	}

	public void setDepartment(Department department) {
		this.department = department;
	}

	public Long getRoleId() {
		return roleId;
	}

	public void setRoleId(Long roleId) {
		this.roleId = roleId;
	}

	public Set<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(Long id, Long departmentId, String loginname, String password, String name, String gender,
			String phonenumber, String email, Long roleId) {
		super();
		this.id = id;
		this.departmentId = departmentId;
		this.loginname = loginname;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.email = email;
		this.roleId = roleId;
	}

	public User(Long departmentId, String loginname, String password, String name, String gender, String phonenumber,
			String email, Long roleId) {
		super();
		this.departmentId = departmentId;
		this.loginname = loginname;
		this.password = password;
		this.name = name;
		this.gender = gender;
		this.phonenumber = phonenumber;
		this.email = email;
		this.roleId = roleId;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", departmentId=" + departmentId + ", loginname=" + loginname + ", password="
				+ password + ", name=" + name + ", gender=" + gender + ", phonenumber=" + phonenumber + ", email="
				+ email + ", roleId=" + roleId + ", department=" + department + ", roleSet=" + roleSet + "]";
	}


}