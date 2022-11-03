import sun.security.provider.certpath.Builder;

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
        for (int i  = 0; i < accounts.length; i++){
            if (accounts[i].getOwner().getId() == id){
                return accounts[i];
            }
        }
        return null;
    }

    @Override
    public long countAccountsWithBalanceGreaterThan(long value) {
        int counter = 0;
        for (int i  = 0; i < accounts.length; i++) {
            if (accounts[i].getBalance() > value) {
                counter++;
            }
        }
        return counter;
    }
}

class Account {

    private long id;
    private long balance;
    private User owner;

    private Account(Builder builder) {
        this.id = builder.id;
        this.balance = builder.balance;
        this.owner = builder.owner;
    }

    public static class Builder {
        private long id;
        private long balance;
        private User owner;

        public Builder id(final long id){
            this.id = id;
            return this;
        }

        public Builder balance(final long balance){
            this.balance = balance;
            return this;
        }

        public Builder owner(final User owner){
            this.owner = owner;
            return this;
        }

        public Account build() {
            return new Account(this);
        }
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

    private User(Builder builder) {
        this.id = builder.id;
        this.firstName = builder.firstName;
        this.lastName = builder.lastName;
    }

    public static class Builder {
        private long id;
        private String firstName;
        private String lastName;

        public Builder id(final long id) {
            this.id = id;
            return this;
        }

        public Builder firstName(final String firstName) {
            this.firstName = firstName;
            return this;
        }

        public Builder lastName(final String lastName) {
            this.lastName = lastName;
            return this;
        }

        public User build() {
            return new User(this);
        }
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
    }
}
