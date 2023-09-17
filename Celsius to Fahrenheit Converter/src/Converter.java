import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Converter extends  JFrame{
    private JTextField txtCelsius;
    private JButton clearButton;
    private JButton calculateButton;
    private JLabel valuelbl;
    private JLabel categorylbl;
    private JPanel calpnl;

    public Converter(){
        add(calpnl);
        setSize(500,400);
        setTitle(("Celsius to Fahrenheit Converter"));
        setVisible(true);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculateValue();
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                txtCelsius.setText("");
                valuelbl.setText(" ");
                categorylbl.setText("");
            }
        });
    }
    public void calculateValue(){

        try {
            double celsius = Double.parseDouble(txtCelsius.getText());
            double fahrenheit = (9.0 / 5.0) * celsius + 32;
            valuelbl.setText(String.valueOf(fahrenheit));

            if (fahrenheit < 95.0) {
                categorylbl.setText("Hypothermia");
            } else if (fahrenheit >= 95 && fahrenheit < 100.4) {
                categorylbl.setText("Normal");
            } else if (fahrenheit >= 100.4 && fahrenheit < 103.0) {
                categorylbl.setText("Fever");
            } else if (fahrenheit >= 103.0) {
                categorylbl.setText("High Fever");
                JOptionPane.showMessageDialog(this, "Warning: High Fever!", "High Fever", JOptionPane.WARNING_MESSAGE);
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid input. Please enter a valid temperature in Celsius.", "Invalid Input", JOptionPane.ERROR_MESSAGE);
        }



    }

    public static void main(String[] args) {
        Converter obj=new Converter();
    }


}
