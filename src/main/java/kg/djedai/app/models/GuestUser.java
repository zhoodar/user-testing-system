package kg.djedai.app.models;

/**
 * @author Zhoodar
 * @since 28.07.2016.
 */
public class GuestUser extends  Base {

    private String surname;
    private String name;
    private String lastName;
    private Group group;

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

    public Group getGroup() {
        return group;
    }

    public void setGroup(Group group) {
        this.group = group;
    }
}
