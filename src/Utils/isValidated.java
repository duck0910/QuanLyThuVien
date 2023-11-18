package Utils;


/*
* Author :
 */
import java.util.regex.Pattern;

public class isValidated {

    public static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    public static boolean isValidMacCD(String macd) {
        return Pattern.matches("[a-zA-Z0-9]*", macd);
    }

    public static boolean isValidTenCD(String tencd) {
        return Pattern.matches("^[\\p{L} .'-]+$", tencd);
    }

    public static boolean isValidHocPhi(String hocphi) {
        return Pattern.matches("[0-9]*", hocphi);
    }

    public static boolean isValidThoiLuong(String thoiluong) {
        return Pattern.matches("[0-9]*", thoiluong);
    }

    public static boolean isValidMaNV(String manv) {
        return Pattern.matches("^[a-zA-Z0-9]{4,12}$", manv);
    }

    public static boolean isValidMatKhau(String matKhau) {
        return Pattern.matches("^[a-zA-Z0-9]{1,16}$", matKhau);
    }

    public static boolean isValidHoTen(String hoTen) {
        return Pattern.matches("^[\\p{L} .'-]+$", hoTen);
    }
}
