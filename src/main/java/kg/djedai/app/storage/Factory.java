package kg.djedai.app.storage;

import kg.djedai.app.models.Role;
import kg.djedai.app.models.User;
import kg.djedai.app.storage.dao.DAO;

/**
 * @author Zhoodar
 * @since 04.08.2016.
 */
public class Factory {

    public DAO<User> userDAO;
    public DAO<Role> roleDAO;

    public Factory(DAO<User> userDAO, DAO<Role> roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }
}
