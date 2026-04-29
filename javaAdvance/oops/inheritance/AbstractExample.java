package javaAdvance.oops.inheritance;

 class Payment {
	double amount;

	Payment(double amount) {
		this.amount = amount;
	}

	 void pay() {
		 
	 }

	void printReceipt() {
		System.out.println("Receipt generated for amount: " + amount);
	}
}

class UpiPayment extends Payment {
	String upiId;

	UpiPayment(double amount, String upiId) {
		super(amount);
		this.upiId = upiId;
	}

	@Override
	void pay() {
		System.out.println("Paid " + amount + " using UPI: " + upiId);
		super.printReceipt();
	}
}

class CardPayment extends Payment {
	String cardNumber;

	CardPayment(double amount, String cardNumber) {
		super(amount);
		this.cardNumber = cardNumber;
	}

	@Override
	void pay() {
		System.out.println("Paid " + amount + " using card: " + cardNumber);
		super.printReceipt();
	}
}

public class AbstractExample {
	public static void main(String[] args) {
		Payment p1 = new UpiPayment(500, "vijay@upi");
		Payment p2 = new CardPayment(1000, "XXXX-1234");

		p1.pay();
		p2.pay();
	}
}
