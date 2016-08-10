package kg.djedai.app.models;

/**
 * @author Zhoodar
 * @since 07.08.2016.
 */
public class Category extends Base{

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name ;
    }
}
