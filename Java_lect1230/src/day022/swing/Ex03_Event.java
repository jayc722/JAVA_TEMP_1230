package day022.swing;

import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Ex03_Event {

	public static void main(String[] args) {


		JFrame frame = new JFrame("애플리케이션 예제");
		frame.setLayout(new FlowLayout());		//이건 나중에 설명 -> 버튼 라벨 배치
		frame.setSize(400,500);	//프레임 크기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	//닫기 버튼

		
		
		JButton btn = new JButton("버튼");
		//btn.addActionListener(null);  //추상메소드가 하나뿐인 인터페이스 -> 람다식으로 사용 가능
		btn.addActionListener(e->{
			//System.out.println("버튼 클릭");
			JOptionPane.showMessageDialog(frame, "버튼 클릭");
		});  		
		
		JTextField textField = new JTextField(20);
		
		textField.addActionListener(e->{
			String text = textField.getText();		//텍스트창에 입력된 텍스트값 가져옴
			System.out.println(text);
			textField.setText("");		//엔터로 지우기
				
		});
		
		
		frame.add(textField);
		frame.add(btn);
		
		frame.setVisible(true);
		
	}

}
