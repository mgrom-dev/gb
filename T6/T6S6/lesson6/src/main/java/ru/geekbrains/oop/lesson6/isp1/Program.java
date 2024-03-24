package ru.geekbrains.oop.lesson6.isp1;

import java.util.ArrayList;

public class Program {

    public static void main(String[] args) {
        InternetPaymentService internetService = new InternetPaymentService();
        TerminalPaymentService terminalService = new TerminalPaymentService();
        ArrayList<PayService> payService = new ArrayList<>();
        payService.add(terminalService);
        payService.add(internetService);

        for (PayService pay : payService){
            if (pay instanceof PhonePay)
            {
                ((PhonePay)pay).payPhoneNumber(2000);
                return;
            }
        }

    }

}
