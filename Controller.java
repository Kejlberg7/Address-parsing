
import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;
import java.awt.event.*;

public class Controller implements KeyListener {
	Model model;
	View view;

	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar();
		if (c == '\n') model.insert(view.clearTyped());
		else if (c == 8) view.deleteLast();
		else view.append(c);
	}

	public Controller(Model m, View v) {
		model = m;
		view = v;
		v.addKeyListener(this);
	}
}
