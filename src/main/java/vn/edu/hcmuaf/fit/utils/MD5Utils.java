package vn.edu.hcmuaf.fit.utils;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }

    
}
