package day022.swing;

import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class Ex06_KeyEvent {

	public static void main(String[] args) {
		/*
		 * keylistener
		 * -키 입력 감지
		 * -특정 키 이벤트 처리 가능
		 * -한글 입력시 오작동 가능
		 * documentlistener	
		 * -텍스트 변경 감지
		 * -한글 입력 가능
		 * -키 입력(알트,시프트 같은 특수키)감지는 불가	
		 */
		
		//keyListener();
		
		documentListener();

	}


	public static void documentListener() {
		JFrame frame = new JFrame("키 입력 감지");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField textField = new JTextField(40);
		JLabel label = new JLabel("입력된 키 : ");
		
		
		textField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				label.setText("입력된 텍스트 : " + textField.getText());
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				label.setText("입력된 텍스트 : " + textField.getText());
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				// 보통 styledtext에서 사용됨. plaintext는 사용 x				
			}
		});
		
		
		
		frame.setLayout(new FlowLayout());
		frame.add(textField);
		frame.add(label);
		frame.setVisible(true);
		
		
		
	}
	
	public static void keyListener() {
		JFrame frame = new JFrame("키 입력 감지");
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextField textField = new JTextField(50);
		JLabel label = new JLabel("입력된 키 : ");
		
		textField.addKeyListener(new  KeyListener() {		//인터페이스 함수가 3개라 람다식 사용 x
			
			@Override
			public void keyTyped(KeyEvent e) {
				// 타이핑 된 문자. 한글 입력 시 동작이 다를 수 있음.
				label.setText("입력된 문자 : " + e.getKeyChar());
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// 키가 눌려졌을 때
				System.out.println("key pressed : " + e.getKeyCode());
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// 키에서 손을 뗐을 때
				System.out.println("key released : " + e.getKeyCode());
				
			}
		});
		
		frame.setLayout(new FlowLayout());
		frame.add(textField);
		frame.add(label);
		frame.setVisible(true);
		
		
		
	}
	
	
	
}
