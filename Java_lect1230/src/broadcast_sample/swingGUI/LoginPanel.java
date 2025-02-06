package broadcast_sample.swingGUI;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoginPanel extends JFrame {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private JTextField idField;
    private JButton loginButton, signUpButton, backButton;

    public LoginPanel(JFrame parent) {
        setTitle("로그인");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 1));

        idField = new JTextField();
        loginButton = new JButton("로그인");
        signUpButton = new JButton("회원가입");
        backButton = new JButton("뒤로 가기");

        panel.add(new JLabel("아이디 입력:"));
        panel.add(idField);
        panel.add(loginButton);
        panel.add(signUpButton);
        panel.add(backButton);

        add(panel);

        loginButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "로그인 버튼"));
        signUpButton.addActionListener(e -> JOptionPane.showMessageDialog(this, "회원가입 버튼"));

        setVisible(true);
    }
}
