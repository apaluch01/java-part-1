import java.awt.image.PackedColorModel;

interface AccountService {
    /**
     * It finds an account by owner id
     * @param id owner unique identifier
     * @return account or null
     */
    Account findAccountByOwnerId(long id);
    /**
     * It count the number of account with balance > the given value
     * @param value
     * @return the number of accounts
     */
    long countAccountsWithBalanceGreaterThan(long value);
}

class AccountServiceImpl implements AccountService {
    private final Account[] accounts;

    public AccountServiceImpl (Account[] accounts){
        this.accounts = accounts;
    }

    @Override
    public Account findAccountByOwnerId(long id) {
        for (int i  = 0; i < accounts.length(); i++){
            if (accounts[i].id == id){

            }
        }
        return null;
    }

    @Override
    public long countAccountsWithBalanceGreaterThan(long value) {
        for (int i  = 0; i < accounts.length(); i++){
            if
        }
        return 0;
    }
}

class Account {

    private long id;
    private long balance;
    private User owner;

    public Account(long id, long balance, User owner) {
        this.id = id;
        this.balance = balance;
        this.owner = owner;
    }

    public long getId() {
        return id;
    }

    public long getBalance() {
        return balance;
    }

    public User getOwner() {
        return owner;
    }
}

class User {

    private long id;
    private String firstName;
    private String lastName;

    public User(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}

public class AccountManager {
    public static void main(String[] args){
        Account acc1 = new Account(1,250000, 1);
        User us1 = new User(1, "John", "Smith");

        Account[] accounts = new Account[]{acc1};

        AccountService service = new AccountServiceImpl(accounts);
        service.findAccountByOwnerId(10L); // returns an account where owner id is 10
    }

}
