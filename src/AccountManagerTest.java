import org.junit.Assert;
import org.junit.Test;
import org.junit.experimental.runners.Enclosed;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.lang.reflect.Array;
import java.util.*;

@RunWith(Enclosed.class)
public class AccountManagerTest {
    @RunWith(Parameterized.class)
    public static class TheParameterizedTests {
        @Parameterized.Parameters
        public static Collection<Object[]> getBalance() {
            return Arrays.asList(new Object[][]{
                    {0, 3, Arrays.asList(new Account(1, 200000, new User(1, "John",
                            "Doe")), new Account(2, 250000, new User(2, "Max",
                            "Maximoff")), new Account(3, 300000, new User(3, "Jonathan", "Cage")))},
                    {199999, 3, Arrays.asList(new Account(1, 200000, new User(1, "John",
                            "Doe")), new Account(2, 250000, new User(2, "Max",
                            "Maximoff")), new Account(3, 300000, new User(3, "Jonathan", "Cage")))},
                    {200000, 2, Arrays.asList(new Account(1, 200000, new User(1, "John",
                            "Doe")), new Account(2, 250000, new User(2, "Max",
                            "Maximoff")), new Account(3, 300000, new User(3, "Jonathan", "Cage")))},
                    {249999, 2, Arrays.asList(new Account(1, 200000, new User(1, "John",
                            "Doe")), new Account(2, 250000, new User(2, "Max",
                            "Maximoff")), new Account(3, 300000, new User(3, "Jonathan", "Cage")))},
                    {250000, 1, Arrays.asList(new Account(1, 200000, new User(1, "John",
                            "Doe")), new Account(2, 250000, new User(2, "Max",
                            "Maximoff")), new Account(3, 300000, new User(3, "Jonathan", "Cage")))},
                    {299999, 1, Arrays.asList(new Account(1, 200000, new User(1, "John",
                            "Doe")), new Account(2, 250000, new User(2, "Max",
                            "Maximoff")), new Account(3, 300000, new User(3, "Jonathan", "Cage")))},
                    {300000, 0, Arrays.asList(new Account(1, 200000, new User(1, "John",
                            "Doe")), new Account(2, 250000, new User(2, "Max",
                            "Maximoff")), new Account(3, 300000, new User(3, "Jonathan", "Cage")))},
            });
        }

        private int balanceToCheck;
        private int expectedCount;
        private Account[] accounts;

        public TheParameterizedTests(int balanceToCheck, int expectedCount, List<Account> accountsList) {
            this.balanceToCheck = balanceToCheck;
            this.expectedCount = expectedCount;
            this.accounts = new Account[accountsList.size()];
            for (int i = 0; i < accountsList.size(); i++){
                this.accounts[i] = accountsList.get(i);
            }
        }

        @Test
        public void shouldCountAccountsWithBalanceGreaterThen () {
            AccountService service = new AccountServiceImpl(accounts);

            int actualCount = (int) service.countAccountsWithBalanceGreaterThan(balanceToCheck);
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

