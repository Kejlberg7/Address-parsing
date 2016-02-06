
import java.awt.*;
import javax.swing.*;
import java.util.*;
 
public class View extends JFrame implements Observer {
	public static final long serialVersionUID = 20160203;
	Canvas canvas;
	Model model;
	StringBuilder typed = new StringBuilder();

	public void deleteLast() {
		if (typed.length() > 0) typed.deleteCharAt(typed.length() - 1);
		repaint();
	}

	public String clearTyped() {
		String ret = typed.toString();
		typed = new StringBuilder();
		return ret;
	}

	public void append(char c) {
		typed.append(c);
		repaint();
	}


	public void update(Observable obs, Object obj) {
		repaint();
	}

	public View(Model m) {
		model = m;
		model.addObserver(this);
		canvas = new Canvas();
		setLayout(new BorderLayout());
		getContentPane().add(canvas, BorderLayout.CENTER);
		setSize(512, 512);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setVisible(true);
	}

	class Canvas extends JComponent {
		public static final long serialVersionUID = 20160203;

		public void paint(Graphics g) {
			g.drawString(typed.toString(), 10, 20);
			int ycoord = 50;
			for (Address a : model) {
				g.drawString(a.street() + " " + a.house(), 10, ycoord);
				g.drawString(a.postcode() + " " + a.city(), 10, ycoord+20);
				ycoord += 50;
			}
		}
	}
}
