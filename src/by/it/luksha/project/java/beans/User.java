package by.it.luksha.project.java.beans;


/**
 * BEAN для сущности User из таблицы users
 */
public class User {
    private int id;
    private String login;
    private String password;
    private String email;
    private int fk_role;

    public User() {
    }

    public User(int id, String login, String password, String email, int fk_role) {
        this.id = id;
        this.login = login;
        this.password = password;
        this.email = email;
        this.fk_role = fk_role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", login='" + login + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", fk_role=" + fk_role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (fk_role != user.fk_role) return false;
        if (id != user.id) return false;
        if (!email.equals(user.email)) return false;
        if (!login.equals(user.login)) return false;
        if (!password.equals(user.password)) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + login.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + fk_role;
        return result;
    }

    public int getId() {
        return id;
    }

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public int getFk_role() {
        return fk_role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFk_role(int fk_role) {
        this.fk_role = fk_role;
    }

}
