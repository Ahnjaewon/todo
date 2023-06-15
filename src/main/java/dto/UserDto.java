package dto;

public class UserDto {
    private Integer id;
    private String username;
    private String name;
    private String password;
    private String cratedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCratedAt() {
        return cratedAt;
    }

    public void setCratedAt(String cratedAt) {
        this.cratedAt = cratedAt;
    }

    public UserDto(Integer id, String username, String name, String password, String cratedAt) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.password = password;
        this.cratedAt = cratedAt;
    }
}
