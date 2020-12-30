import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CalculatorGUI {
    final Color DARK_PURPLE = new Color(66, 28, 82);
    String message = "";
    JLabel calculation = new JLabel(message);
    double math;

    CalculatorGUI() {
        JFrame frame = new JFrame();
        addButtons(frame);

        calculation.setBounds(20, 120, 400, 80);
        calculation.setForeground(Color.WHITE);
        calculation.setHorizontalAlignment(SwingConstants.RIGHT);
        calculation.setFont(new Font("Arial", Font.PLAIN, 48));
        frame.add(calculation);

        frame.getContentPane().setBackground(Color.BLACK);
        frame.setSize(500, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("very cool calculator");
        frame.setLayout(null);
        frame.setResizable(false);
        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new CalculatorGUI();
    }

    public void addButtons(JFrame frame) {
        addNumbers(frame);
        addSymbols(frame);

    }

    public void addNumbers(JFrame frame) {
        JButton num_0 = new JButton("0");
        JButton num_1 = new JButton("1");
        JButton num_2 = new JButton("2");
        JButton num_3 = new JButton("3");
        JButton num_4 = new JButton("4");
        JButton num_5 = new JButton("5");
        JButton num_6 = new JButton("6");
        JButton num_7 = new JButton("7");
        JButton num_8 = new JButton("8");
        JButton num_9 = new JButton("9");
        JButton sym_dot = new JButton(".");

        JButton[] numButtons = new JButton[11];
        numButtons[0] = num_0;
        numButtons[1] = num_1;
        numButtons[2] = num_2;
        numButtons[3] = num_3;
        numButtons[4] = num_4;
        numButtons[5] = num_5;
        numButtons[6] = num_6;
        numButtons[7] = num_7;
        numButtons[8] = num_8;
        numButtons[9] = num_9;
        numButtons[10] = sym_dot;

        for (JButton num : numButtons) {
            num.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Special case for the decimal (can only have one)
                    if (!(num.getText().equals(".") && message.contains("."))) {
                        message = message + num.getText();
                        calculation.setText(message);
                    }
                }
            });
        }

        calculatorButton(frame, num_0, 40, 600, 190, 90, Color.WHITE, Color.DARK_GRAY);
        calculatorButton(frame, num_1, 40, 500, 90, 90, Color.WHITE, Color.DARK_GRAY);
        calculatorButton(frame, num_2, 140, 500, 90, 90, Color.WHITE, Color.DARK_GRAY);
        calculatorButton(frame, num_3, 240, 500, 90, 90, Color.WHITE, Color.DARK_GRAY);
        calculatorButton(frame, num_4, 40, 400, 90, 90, Color.WHITE, Color.DARK_GRAY);
        calculatorButton(frame, num_5, 140, 400, 90, 90, Color.WHITE, Color.DARK_GRAY);
        calculatorButton(frame, num_6, 240, 400, 90, 90, Color.WHITE, Color.DARK_GRAY);
        calculatorButton(frame, num_7, 40, 300, 90, 90, Color.WHITE, Color.DARK_GRAY);
        calculatorButton(frame, num_8, 140, 300, 90, 90, Color.WHITE, Color.DARK_GRAY);
        calculatorButton(frame, num_9, 240, 300, 90, 90, Color.WHITE, Color.DARK_GRAY);
        calculatorButton(frame, sym_dot, 240, 600, 90, 90, Color.WHITE, Color.DARK_GRAY);

    }

    // Method to reduce redundant code when placing buttons
    public void calculatorButton(JFrame frame, JButton button, int x, int y, int width, int height, Color foreground, Color background) {

        button.setBounds(x, y, width, height);
        button.setForeground(foreground);
        button.setBackground(background);
        button.setFont(new Font("Arial", Font.BOLD, 24));
        frame.add(button);
    }

    public void addSymbols(JFrame frame) {
        String symbols = "=+-x/";

        JButton sym_equal = new JButton("=");
        JButton sym_plus = new JButton("+");
        JButton sym_minus = new JButton("-");
        JButton sym_mult = new JButton("x");
        JButton sym_div = new JButton("/");
        JButton sym_perc = new JButton("%");
        JButton sym_sign = new JButton("+/-");
        JButton sym_clear = new JButton("AC");


        // Valid Symbol placements
        sym_equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!message.isEmpty() && !symbols.contains(message.substring(message.length() - 1))) {
                    math = eval(message);
                    calculation.setText(Double.toString(math));
                    message = Double.toString(math);
                    //System.out.println("Calculation: " + calculation.getText());
                }
            }
        });

        sym_plus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!message.isEmpty() && !symbols.contains(message.substring(message.length() - 1))) {
                    message = message + sym_plus.getText();
                    calculation.setText(message);
                }
            }
        });

        sym_minus.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!message.isEmpty() && !symbols.contains(message.substring(message.length() - 1))) {
                    message = message + sym_minus.getText();
                    calculation.setText(message);
                }
            }
        });

        sym_mult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!message.isEmpty() && !symbols.contains(message.substring(message.length() - 1))) {
                    message = message + "*";
                    calculation.setText(message);
                }
            }
        });

        sym_div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!message.isEmpty() && !symbols.contains(message.substring(message.length() - 1))) {
                    message = message + sym_div.getText();
                    calculation.setText(message);
                }
            }
        });

        sym_perc.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!message.isEmpty() && !symbols.contains(message.substring(message.length() - 1))) {
                    String temp = "(" + message + ")*0.01";
                    math = eval(temp);
                    message = Double.toString(math);
                    calculation.setText(Double.toString(math));
                }

            }
        });

        sym_sign.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (!message.isEmpty() && !symbols.contains(message.substring(message.length() - 1))) {
                    String temp = "(" + message + ")*-1";
                    math = eval(temp);
                    message = Double.toString(math);
                    calculation.setText(Double.toString(math));
                }
            }
        });

        sym_clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                message = "";
                calculation.setText(message);
            }
        });

        // Placing all the symbols on the GUI
        calculatorButton(frame, sym_equal, 340, 600, 90, 90, Color.WHITE, DARK_PURPLE);
        calculatorButton(frame, sym_plus, 340, 500, 90, 90, Color.WHITE, DARK_PURPLE);
        calculatorButton(frame, sym_minus, 340, 400, 90, 90, Color.WHITE, DARK_PURPLE);
        calculatorButton(frame, sym_mult, 340, 300, 90, 90, Color.WHITE, DARK_PURPLE);
        calculatorButton(frame, sym_div, 340, 200, 90, 90, Color.WHITE, DARK_PURPLE);
        calculatorButton(frame, sym_perc, 240, 200, 90, 90, Color.WHITE, Color.lightGray);
        calculatorButton(frame, sym_sign, 140, 200, 90, 90, Color.WHITE, Color.lightGray);
        calculatorButton(frame, sym_clear, 40, 200, 90, 90, Color.WHITE, Color.lightGray);


    }

    public double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)`
            //        | number | functionName factor | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('*')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    x = parseFactor();
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}

