package beans;


public class User {
    private int id;
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String password;
    private Role role;
    private final static String DEFAULT_ROLE_NAME =
            "user";

    private final static int DEFAULT_ROLE_ID = Role.USER_ROLE_ID;

    public static class Builder {
        private final User user;

        public Builder() {
            user = new User();
        }

        public Builder setId(int id) {
            user.setId(id);
            return this;
        }

        public Builder setName(String name) {
            user.setName(name);
            return this;
        }

        public Builder setSurname(String surname) {
            user.setSurname(surname);
            return this;
        }

        public Builder setEmail(String email) {
            user.setEmail(email);
            return this;
        }

        public Builder setPhoneNumber(String phoneNumber) {
            user.setPhoneNumber(phoneNumber);
            return this;
        }

        public Builder setPassword(String hashPass) {
            user.setPassword(hashPass);
            return this;
        }

        public Builder setRole(Role role) {
            user.setRole(role);
            return this;
        }

        public User build() {
            return user;
        }
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public boolean isAdmin() {
        return role.getId() == Role.ADMIN_ROLE_ID;
    }

    public void setDefaultRole() {
        this.role = new Role(DEFAULT_ROLE_ID,
                DEFAULT_ROLE_NAME);
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + name + '\'' +
                ", lastName='" + surname + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        return id == user.id;
    }

    @Override
    public int hashCode() {
        return id;
    }

}