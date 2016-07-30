package kg.djedai.app.models;

/**
 * @author Zhoodar
 * @since 28.07.2016.
 */
public class Teacher extends Base {

    private String surname;
    private String name;
    private String lastName;
    private User user;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Teacher teacher = (Teacher) o;

        if (!surname.equals(teacher.surname)) return false;
        if (!name.equals(teacher.name)) return false;
        if (!lastName.equals(teacher.lastName)) return false;
        return user.equals(teacher.user);

    }

    @Override
    public int hashCode() {
        int result = surname.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + lastName.hashCode();
        result = 31 * result + user.hashCode();
        return result;
    }
}
