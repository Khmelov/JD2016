package by.it.luksha.project.java.beans;

/**
 * Created by MMauz on 12.07.2016.
 */

/**
 * Класс DTO на основе BEAN для входа user в свою учетную запись
 */
public class SignIn {
    private String login;
    private String password;

    public SignIn() {
    }

    public SignIn(String login, String password) {
        this.login = login;
        this.password = password;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        SignIn signIn = (SignIn) o;

        if (login != null ? !login.equals(signIn.login) : signIn.login != null) return false;
        return password != null ? password.equals(signIn.password) : signIn.password == null;

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (password != null ? password.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "SignIn{" +
                "login='" + login + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
