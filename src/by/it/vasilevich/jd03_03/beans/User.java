package by.it.vasilevich.jd03_03.beans;


public class User {

    private int id;
    private String Login;
    private String Password;
    private String Email;
    private int FK_Role;


    public User() {
    }

    public User(int id, String login, String password, String email, Integer fk_Role) {
        this.id = id;
        this.Login = login;
        this.Password = password;
        this.Email = email;
        this.FK_Role = fk_Role;
    }




    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLogin() {
        return Login;
    }

    public void setLogin(String login) {
        Login = login;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public int getFK_Role() {
        return FK_Role;
    }

    public void setFK_Role(int FK_Role) {
        this.FK_Role = FK_Role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;

        User user = (User) o;

        if (id != user.id) return false;
        if (FK_Role != user.FK_Role) return false;
        if (Login != null ? !Login.equals(user.Login) : user.Login != null) return false;
        if (Password != null ? !Password.equals(user.Password) : user.Password != null) return false;
        return Email != null ? Email.equals(user.Email) : user.Email == null;

    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (Login != null ? Login.hashCode() : 0);
        result = 31 * result + (Password != null ? Password.hashCode() : 0);
        result = 31 * result + (Email != null ? Email.hashCode() : 0);
        result = 31 * result + FK_Role;
        return result;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", Login='" + Login + '\'' +
                ", Password='" + Password + '\'' +
                ", Email='" + Email + '\'' +
                ", FK_Role=" + FK_Role +
                '}';
    }



}

