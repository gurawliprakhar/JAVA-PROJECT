package currencyConverter;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CurrencyConverter extends Frame {
    Label label1, label2;
    TextField textField1, textField2;
    Button convertButton;

    public CurrencyConverter() {
        setLayout(new FlowLayout());

        label1 = new Label("Enter amount in USD: ");
        textField1 = new TextField(10);
        label2 = new Label("Converted amount in INR: ");
        textField2 = new TextField(10);
        convertButton = new Button("Convert");

        add(label1);
        add(textField1);
        add(label2);
        add(textField2);
        add(convertButton);

        convertButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double usd = Double.parseDouble(textField1.getText());
                    double inr = usd * 83.29; // Assuming 1 USD = 83.29 INR
                    textField2.setText(String.valueOf(inr));
                } catch (NumberFormatException ex) {
                    textField2.setText("Invalid input");
                }
            }
        });

        setTitle("Currency Converter");
        setSize(300, 150);
        setVisible(true);
    }

    public static void main(String[] args) {
        new CurrencyConverter();
    }
}
