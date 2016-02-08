
import java.util.*;
import java.util.regex.*;
import javax.swing.JOptionPane;

public class Address {
	private final String street, house, floor, side, postcode, city;

	private Address(String _street, String _house, String _floor, String _side, String _postcode, String _city) {
		street = _street;
		house = _house;
		floor = _floor;
		side = _side;
		postcode = _postcode;
		city = _city;
	}

	public static class Builder {
		private String street = "Unknown", house, floor, side, postcode, city;
		public Builder street(String _street) { street = _street; return this; }
		public Builder house(String _house)   { house = _house;   return this; }
		public Builder floor(String _floor)   { floor = _floor;   return this; }
		public Builder side(String _side)     { side = _side;     return this; }
		public Builder postcode(String _postcode) { postcode = _postcode; return this; }
		public Builder city(String _city)     { city = _city;     return this; }
		public Address build() {
			return new Address(street, house, floor, side, postcode, city);
		}
	}

	public String street()   { return street; }
	public String house()    { return house; }
	public String floor()    { return floor; }
	public String side()     { return side; }
	public String postcode() { return postcode; }
	public String city()     { return city; }

	static String pattern1="([A-Za-zæøåÆØÅ ]+) ([0-9A-Za-z]+), ([0-9]{4}) ([A-Za-zæøåÆØÅ ]+)";
	static Pattern pat1 = Pattern.compile(pattern1);
//\u00E6\u00f8\u00E5\u00C6\u00D8\u00C5

	public static Address parse(String s) {
		Builder b = new Builder();
		try{
		
		Matcher m1 = pat1.matcher(s);
		if (m1.matches()) {
			return b.street(m1.group(1))
				.house(m1.group(2))
				.postcode(m1.group(3))
				.city(m1.group(4))
				.build();
		}
		else{
			throw new NullPointerException();
		}
		
	} 
	catch (NullPointerException a){
			JOptionPane.showMessageDialog(null,"Du har indtastet en fejl","Fejl",JOptionPane.ERROR_MESSAGE);
			return b.street("")
				.house("")
				.postcode("")
				.city("")
				.build();

	}
	
	}
}
