package vn.edu.hcmuaf.fit.utils;

import java.text.DecimalFormat;

public class PriceFormatUtil {
    public static String formatPrice(double price) {
        DecimalFormat decimalFormat = new DecimalFormat("#,### VNĐ");
        String formattedAmount = decimalFormat.format(price);
        return formattedAmount;
    }
}
