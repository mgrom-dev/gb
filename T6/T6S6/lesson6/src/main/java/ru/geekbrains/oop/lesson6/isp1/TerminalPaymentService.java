package ru.geekbrains.oop.lesson6.isp1;

public class TerminalPaymentService extends PayService implements CreditCardPay, WebMoneyPay{
    @Override
    public void payWebMoney(int amount) {
        System.out.printf("Terminal pay by web money %d\n", amount);
    }

    @Override
    public void payCreditCard(int amount) {
        System.out.printf("Terminal pay by credit card %d\n", amount);
    }

}
