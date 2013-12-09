import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainGUI {
    private JTextField textField1;
    private JButton Button;
    private JPanel panel1;
    private JLabel result;
    private JButton Button1;
    private JButton ClearB;
    private String eval = "";

    public static void main(String[] args) {
        JFrame frame = new JFrame("MainGUI");
        frame.setContentPane(new MainGUI().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    public MainGUI() {
        Button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Result expResult = new Result();
                eval = "";
                eval = eval + textField1.getText();
                if(eval.isEmpty()){
                    result.setText("Вы ничего не ввели!!!");
                } else {
                result.setText(expResult.result(eval));
                }
            }
        });
        Button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                Result expResult = new Result();
                System.out.println("Введите ваше выражение!!!");
                eval = "";

                try {
                    eval = eval +  expResult.result( reader.readLine());
                } catch (IOException e1) {
                    e1.printStackTrace();
                }

                System.out.println("Ответ " + eval);
            }
        });
        ClearB.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                result.setText("");
                textField1.setText("");
            }
        });
    }
}
