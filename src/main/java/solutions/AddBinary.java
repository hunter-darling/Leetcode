package src.main.java.solutions;

public class AddBinary {
  public String addBinary(String a, String b) {
    String result = "";
    int carry = 0;
    int i = a.length() - 1;
    int j = b.length() - 1;
    while (i >= 0 || j >= 0 || carry == 1) {
      if (i >= 0)
        carry += a.charAt(i--) - '0';
      if (j >= 0)
        carry += b.charAt(j--) - '0';
      result = String.valueOf(carry % 2) + result;
      carry /= 2;
    }
    return result;
  }
}
