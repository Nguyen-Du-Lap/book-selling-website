package vn.edu.hcmuaf.fit.utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

public class MD5Utils {

    public static String encrypt(String input) {
        try {
            // Tạo một instance của MessageDigest với thuật toán MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            // Mã hóa chuỗi đầu vào
            byte[] messageDigest = md.digest(input.getBytes());
            // Chuyển đổi kết quả thành dạng hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : messageDigest) {
                hexString.append(String.format("%02x", b));
            }
            String str = hexString.toString();


            Random rand = new Random();


            char randomChar1 = (char) (rand.nextInt(26) + 'a');
            char randomChar2 = (char) (rand.nextInt(26) + 'a');




            String result = str.substring(0, 1) + randomChar1 + randomChar2 + str.substring(1);
            return result;
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }



}
