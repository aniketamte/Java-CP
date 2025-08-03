//✅ Example 1: super with Variable

class Father {
    int money = 1000;
}

class Son extends Father {
    int money = 500;

    void showMoney() {
        System.out.println("Son's Money: " + money);
        System.out.println("Father's Money: " + super.money);  // Using super to access father's money
    }
}

public class Main {
    public static void main(String[] args) {
        Son s = new Son();
        s.showMoney();
    }
}
