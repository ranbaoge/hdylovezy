package hdy.zy.system.entity;

public class Role {
    private Long id;

    private String name;

    private String description;

    private Long userId;

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

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

	public Role() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Role(Long id, String name, String description, Long userId) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.userId = userId;
	}

	public Role(String name, String description, Long userId) {
		super();
		this.name = name;
		this.description = description;
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "Role [id=" + id + ", name=" + name + ", description=" + description + ", userId=" + userId + "]";
	}
    
    
}