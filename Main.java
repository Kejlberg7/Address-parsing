
import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Main {
	void run(String[] args) {
		Model m;
		if (args.length == 0) m = new Model();
		else m = new Model(args[0]);
		View v1 = new View(m);
		Controller c1 = new Controller(m,v1);
	}

	public static void main (String[] args) {
		new Main().run(args);
	}
}
