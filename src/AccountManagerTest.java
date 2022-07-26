import org.junit.Assert;
import org.junit.Test;

public class AccountManagerTest {

    @Test
    public void canFindAccountByOwnerId() {
        User us1 = new User(10, "John", "Smith");
        Account acc1 = new Account(1,250000, us1);

        Account[] accounts = new Account[]{acc1};
        AccountService service = new AccountServiceImpl(accounts);

        Assert.assertEquals(service.findAccountByOwnerId(10), acc1);
    }

    @Test
    public void canCountAccountsWithBalanceGreaterThen() {
        User us1 = new User(10, "John", "Smith");
        User us2 = new User(1, "Max", "Maximoff");
        User us3 = new User(2, "Jonathan", "Cage");
        Account acc1 = new Account(1,250000, us1);
        Account acc2 = new Account(2, 300000, us2);
        Account acc3 = new Account(3, 200000, us3);

        Account[] accounts = new Account[]{acc1, acc2, acc3};
        AccountService service = new AccountServiceImpl(accounts);

        Assert.assertEquals(service.countAccountsWithBalanceGreaterThan(250000), 1);
        Assert.assertEquals(service.countAccountsWithBalanceGreaterThan(249999), 2);
    }
}
