import org.junit.Assert;
import org.junit.Test;

public class AccountManagerTest {

    @Test
    public void canFindAccountByOwnerId() {
        User us1 = new User(10L, "John", "Smith");
        Account acc1 = new Account(1,250000L, us1);

        Account[] accounts = new Account[]{acc1};
        AccountService service = new AccountServiceImpl(accounts);

        Assert.assertEquals(service.findAccountByOwnerId(10L), acc1);
    }
}
