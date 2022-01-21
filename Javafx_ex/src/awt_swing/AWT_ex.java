package awt_swing;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
public class AWT_ex extends Frame {
	AWT_ex() {
		setTitle("A Simple BorderLayout Example by AWT");
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we) {
				System.exit(0);
			}
		});

		add(new Button("����"), BorderLayout.NORTH);
		add(new Button("�Ʒ���"), BorderLayout.SOUTH);
		add(new Button("������"), BorderLayout.EAST);
		add(new Button("����"), BorderLayout.WEST);
		add(new Button("�߾�"), BorderLayout.CENTER);

		setSize(500,300);
		setVisible(true);
	}

	public static void main(String[] args) {
		new AWT_ex();
	}
}