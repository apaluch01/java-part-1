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
                    {0, 3, Arrays.asList(new Account.Builder().id(1).balance(200000)
                            .owner(new User.Builder().id(1).firstName("John").lastName("Doe").build()).build(),
                            new Account.Builder().id(2).balance(250000)
                                    .owner(new User.Builder().id(2).firstName("Max").lastName("Maximoff").build()).build(),
                            new Account.Builder().id(3).balance(300000)
                            .owner(new User.Builder().id(3).firstName("Jonathan").lastName("Cage").build()).build())},
                    {199999, 3, Arrays.asList(new Account.Builder().id(1).balance(200000)
                                    .owner(new User.Builder().id(1).firstName("John").lastName("Doe").build()).build(),
                            new Account.Builder().id(2).balance(250000)
                                    .owner(new User.Builder().id(2).firstName("Max").lastName("Maximoff").build()).build(),
                            new Account.Builder().id(3).balance(300000)
                                    .owner(new User.Builder().id(3).firstName("Jonathan").lastName("Cage").build()).build())},
                    {200000, 2, Arrays.asList(new Account.Builder().id(1).balance(200000)
                                    .owner(new User.Builder().id(1).firstName("John").lastName("Doe").build()).build(),
                            new Account.Builder().id(2).balance(250000)
                                    .owner(new User.Builder().id(2).firstName("Max").lastName("Maximoff").build()).build(),
                            new Account.Builder().id(3).balance(300000)
                                    .owner(new User.Builder().id(3).firstName("Jonathan").lastName("Cage").build()).build())},
                    {249999, 2, Arrays.asList(new Account.Builder().id(1).balance(200000)
                                    .owner(new User.Builder().id(1).firstName("John").lastName("Doe").build()).build(),
                            new Account.Builder().id(2).balance(250000)
                                    .owner(new User.Builder().id(2).firstName("Max").lastName("Maximoff").build()).build(),
                            new Account.Builder().id(3).balance(300000)
                                    .owner(new User.Builder().id(3).firstName("Jonathan").lastName("Cage").build()).build())},
                    {250000, 1, Arrays.asList(new Account.Builder().id(1).balance(200000)
                                    .owner(new User.Builder().id(1).firstName("John").lastName("Doe").build()).build(),
                            new Account.Builder().id(2).balance(250000)
                                    .owner(new User.Builder().id(2).firstName("Max").lastName("Maximoff").build()).build(),
                            new Account.Builder().id(3).balance(300000)
                                    .owner(new User.Builder().id(3).firstName("Jonathan").lastName("Cage").build()).build())},
                    {299999, 1, Arrays.asList(new Account.Builder().id(1).balance(200000)
                                    .owner(new User.Builder().id(1).firstName("John").lastName("Doe").build()).build(),
                            new Account.Builder().id(2).balance(250000)
                                    .owner(new User.Builder().id(2).firstName("Max").lastName("Maximoff").build()).build(),
                            new Account.Builder().id(3).balance(300000)
                                    .owner(new User.Builder().id(3).firstName("Jonathan").lastName("Cage").build()).build())},
                    {300000, 0, Arrays.asList(new Account.Builder().id(1).balance(200000)
                                    .owner(new User.Builder().id(1).firstName("John").lastName("Doe").build()).build(),
                            new Account.Builder().id(2).balance(250000)
                                    .owner(new User.Builder().id(2).firstName("Max").lastName("Maximoff").build()).build(),
                            new Account.Builder().id(3).balance(300000)
                                    .owner(new User.Builder().id(3).firstName("Jonathan").lastName("Cage").build()).build())},
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

