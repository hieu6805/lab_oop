import javax.swing.JOptionPane;

public class ex225 {
    public static void main(String[] args) {
        String str1, str2;
        str1 = JOptionPane.showInputDialog(null,"Enter first number:");
        str2 = JOptionPane.showInputDialog(null,"Enter second number:");
        double s1 = Double.parseDouble(str1);
        double s2 = Double.parseDouble(str2);
        double sum = s1 + s2;
        double diff = s1 - s2;
        double pro = s1 * s2;
        double quo = 0.0;
        if(s2 == 0) {
            JOptionPane.showMessageDialog(null,"Can't divide by zero");
        } else {
            quo = s1 / s2;
        }
        String notification = "Sum: " + sum + "\nDifference: " + diff + "\nProduct: " + pro + "\nQuotient: " + quo;
        JOptionPane.showMessageDialog(null, notification);
    }
}