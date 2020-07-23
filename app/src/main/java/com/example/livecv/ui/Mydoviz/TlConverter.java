package com.example.livecv.ui.Mydoviz;

import java.text.DecimalFormat;

public class TlConverter {

    public static String tlc(String nonTurkishCurrency,String turkishCurrency)
    {

        String currency1 = nonTurkishCurrency;
        String currency2 = turkishCurrency;
        double nonTl=Double.parseDouble(currency1);
        double tl=Double.parseDouble(currency2);



        String result = new DecimalFormat("##.###").format(tl/nonTl);


        return result;
    }
}
