package awt_swing;
import javax.swing.*;
import java.awt.*;
public class Swing_ex extends JFrame {
	Swing_ex()  {
		setTitle("A Simple BorderLayout Example by Swing");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		add(new JButton("위쪽"), BorderLayout.NORTH);
		add(new JButton("아래쪽"), BorderLayout.SOUTH);
		add(new JButton("오른쪽"), BorderLayout.EAST);
		add(new JButton("왼쪽"), BorderLayout.WEST);
		add(new JButton("중앙"), BorderLayout.CENTER);

		setSize(500,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new Swing_ex();
	}
}
