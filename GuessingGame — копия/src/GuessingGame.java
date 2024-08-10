import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GuessingGame extends JFrame{

    private JButton OKButton;
    private JTextField txtGuess;
    private JLabel lblOutput;
    private JPanel mainPanel;
    private JButton btnPlayAgain;
    private int theNumber;

//     lblOutput = new JLabel("Нажми на меня");

    public static void main (String[] args){
        GuessingGame theGame = new GuessingGame();
        theGame.newGame();
        theGame.setSize(new Dimension(350,150));
        theGame.setVisible(true);
    }

    public GuessingGame() {
        setContentPane(mainPanel);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        OKButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        txtGuess.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                checkGuess();
            }
        });
        btnPlayAgain.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newGame();
                checkGuess();
                lblOutput.setText("Угадайте число");
                txtGuess.setText("");
                btnPlayAgain.setVisible(false);
            }
        });
    }

    public void checkGuess(){
        String gueessText = txtGuess.getText();
        String message = "";
        try {
            int guess = Integer.parseInt(gueessText);
                if (guess < theNumber) {
                    message = "Больше";
                    lblOutput.setText(message);
                    txtGuess.selectAll();
                } else if (guess > theNumber) {
                    message = "Меньше";
                    lblOutput.setText(message);
                    txtGuess.selectAll();
                } else {
                    message = "Вы угадали!";
                    lblOutput.setText(message);
                    txtGuess.selectAll();
                    btnPlayAgain.setVisible(true);
                }
        } catch (Exception e){
                message = "Вы не корекно ввели число!";
        } finally {
                lblOutput.setText(message);
                txtGuess.selectAll();
        }
    }
    public void newGame(){
        theNumber = (int)(Math.random() * 100 + 1);
    }
}
