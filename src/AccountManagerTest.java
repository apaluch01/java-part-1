import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import javax.xml.validation.Validator;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Enclosed.class)
public class AccountManagerTest {
    @RunWith(Parameterized.class)
    public static class TheParameterizedTests {
        @Parameterized.Parameters
        public static Collection<Object[]> getBalance() {
            return Arrays.asList(new Object[][]{
                    {0, 3},
                    {199999, 3},
                    {200000, 2},
                    {249999, 2},
                    {250000, 1},
                    {299999, 1},
                    {300000, 0},
            });
        }

        private int balance;
        private int expectedCount;

        public TheParameterizedTests(int balance, int expectedCount) {
            this.balance = balance;
            this.expectedCount = expectedCount;
        }

        @Test
        public void shouldCountAccountsWithBalanceGreaterThen () {
            User us1 = new User(10, "John", "Smith");
            User us2 = new User(1, "Max", "Maximoff");
            User us3 = new User(2, "Jonathan", "Cage");
            Account acc1 = new Account(1, 250000, us1);
            Account acc2 = new Account(2, 300000, us2);
            Account acc3 = new Account(3, 200000, us3);

            Account[] accounts = new Account[]{acc1, acc2, acc3};
            AccountService service = new AccountServiceImpl(accounts);

            int actualCount = (int) service.countAccountsWithBalanceGreaterThan(balance);
            Assert.assertEquals(actualCount, expectedCount);
        }
    }

    public static class NotParameterizedTests {
        @Test
        public void canFindAccountByOwnerId() {
            User us1 = new User(10, "John", "Smith");
            Account acc1 = new Account(1,250000, us1);

            Account[] accounts = new Account[]{acc1};
            AccountService service = new AccountServiceImpl(accounts);

            Assert.assertEquals(service.findAccountByOwnerId(10), acc1);
        }
    }
}

