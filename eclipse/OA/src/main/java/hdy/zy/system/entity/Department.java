package hdy.zy.system.entity;

public class Department {
    private Long id;

    private String name;

    private String description;

    private Long parentdepartmentId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Long getParentdepartmentId() {
        return parentdepartmentId;
    }

    public void setParentdepartmentId(Long parentdepartmentId) {
        this.parentdepartmentId = parentdepartmentId;
    }

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Department(Long id, String name, String description, Long parentdepartmentId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.parentdepartmentId = parentdepartmentId;
	}

	public Department(String name, String description, Long parentdepartmentId) {
		super();
		this.name = name;
		this.description = description;
		this.parentdepartmentId = parentdepartmentId;
	}

	@Override
	public String toString() {
		return "Department [id=" + id + ", name=" + name + ", description=" + description + ", parentdepartmentId="
				+ parentdepartmentId + "]";
	}
    
}