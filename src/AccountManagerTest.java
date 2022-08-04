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
        private final static User JOHN_DOE = new User.Builder().id(1).firstName("John").lastName("Doe").build();
        private final static User MAX_MAXIMOFF = new User.Builder().id(2).firstName("Max").lastName("Maximoff").build();
        private final static User JONATHAN_CAGE = new User.Builder().id(3).firstName("Jonathan").lastName("Cage").build();
        private final static Account ACCOUNT_1 = new Account.Builder().id(1).balance(200000)
                .owner(JOHN_DOE).build();
        private final static Account ACCOUNT_2 = new Account.Builder().id(2).balance(250000)
                .owner(MAX_MAXIMOFF).build();
        private final static Account ACCOUNT_3 = new Account.Builder().id(3).balance(300000)
                .owner(JONATHAN_CAGE).build();
        @Parameterized.Parameters
        public static Collection<Object[]> getBalance() {
            return Arrays.asList(new Object[][]{
                    {0, 3, Arrays.asList(ACCOUNT_1, ACCOUNT_2, ACCOUNT_3)},
                    {199999, 3, Arrays.asList(ACCOUNT_1, ACCOUNT_2, ACCOUNT_3)},
                    {200000, 2, Arrays.asList(ACCOUNT_1, ACCOUNT_2, ACCOUNT_3)},
                    {249999, 2, Arrays.asList(ACCOUNT_1, ACCOUNT_2, ACCOUNT_3)},
                    {250000, 1, Arrays.asList(ACCOUNT_1, ACCOUNT_2, ACCOUNT_3)},
                    {299999, 1, Arrays.asList(ACCOUNT_1, ACCOUNT_2, ACCOUNT_3)},
                    {300000, 0, Arrays.asList(ACCOUNT_1, ACCOUNT_2, ACCOUNT_3)},
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
            User us1 = new User.Builder().id(10).firstName("John").lastName("Smith").build();
            Account acc1 = new Account.Builder().id(1).balance(250000).owner(us1).build();

            Account[] accounts = new Account[]{acc1};
            AccountService service = new AccountServiceImpl(accounts);

            Assert.assertEquals(service.findAccountByOwnerId(10), acc1);
        }
    }
}

