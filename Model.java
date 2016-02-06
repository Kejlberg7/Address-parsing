
import java.io.*;
import java.util.*;
import java.util.stream.*;
import java.util.function.*;

public class Model extends Observable implements Iterable<Address> {
	List<Address> data = new ArrayList<>();

	public void insert(String s) {
		data.add(Address.parse(s));
		setChanged();
		notifyObservers();
	}

	public Model() {}

	public Model(String filename) {
		try (BufferedReader input = new BufferedReader(new FileReader(filename))) {
			for (String line = input.readLine() ; line != null ; line = input.readLine()) {
				data.add(Address.parse(line));
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	public Iterator<Address> iterator() {
		return data.iterator();
	}
}
