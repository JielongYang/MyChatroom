import com.yang.dao.UserDao;
import com.yang.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class UserDaoTest {

    @Autowired
    UserDao userDao;
    @Test
    public void getUserById() {
        User user = userDao.getUserByUsername("yang");
        System.out.println(user.getUsername() + user.getPassword());
    }

    @Test
    public void insert() {
        User user = new User("jie","yang");
        userDao.insert(user);

    }

}
