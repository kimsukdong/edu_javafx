package awt_swing;
import javax.swing.*;
import java.awt.*;
public class Swing_ex extends JFrame {
	Swing_ex()  {
		setTitle("A Simple BorderLayout Example by Swing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new JButton("����"), BorderLayout.NORTH);
		add(new JButton("�Ʒ���"), BorderLayout.SOUTH);
		add(new JButton("������"), BorderLayout.EAST);
		add(new JButton("����"), BorderLayout.WEST);
		add(new JButton("�߾�"), BorderLayout.CENTER);

		setSize(500,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Swing_ex();
	}
}
