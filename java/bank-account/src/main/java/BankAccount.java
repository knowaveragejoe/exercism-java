public class BankAccount {
  protected int balance = 0;
  protected boolean closed = true;

  public void open() {
    this.closed = false;
    this.balance = 0;
  }

  public synchronized float deposit(float amount) throws BankAccountActionInvalidException {
    if (this.closed) {
      throw new BankAccountActionInvalidException("Account closed");
    }

    if (amount <= 0) {
      throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
    }
    this.balance += amount;

    return this.balance;
  }

  public float getBalance() throws BankAccountActionInvalidException {
    if (this.closed) {
      throw new BankAccountActionInvalidException("Account closed");
    }

    return this.balance;
  }

  public synchronized float withdraw(int amount) throws BankAccountActionInvalidException {
    if (this.closed) {
      throw new BankAccountActionInvalidException("Account closed");
    }

    if (this.balance <= 0) {
      throw new BankAccountActionInvalidException("Cannot withdraw money from an empty account");
    }
    
    if (amount <= 0) {
      throw new BankAccountActionInvalidException("Cannot deposit or withdraw negative amount");
    }

    if (amount > this.balance) {
      throw new BankAccountActionInvalidException("Cannot withdraw more money than is currently in the account");
    }

    this.balance -= amount;

    return this.balance;
  }

  public void close() {
    this.closed = true;
    this.balance = 0;
  }
}