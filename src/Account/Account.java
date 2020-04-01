package Account;

public interface Account {
	public String getNameOfBank();
	public String getAccountType(); // not sure about type?
	public double getBalance();
	public double getInterestRate();
	public boolean deposit();
	public boolean withdraw();
}
