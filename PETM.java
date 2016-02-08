import static org.junit.Assert.*;
import org.junit.Test;



public class PETM {
	@Test
	public void test1(){
	String input = "Rued Langgaards Vej 7, 2300 København S";
	Address addr = Address.parse(input);
	assertEquals("street of " + input, "Rued Langgaards Vej", addr.street());
	assertEquals("house of " + input, "7", addr.house());
	assertEquals("postcode of " + input, "2300", addr.postcode());
	assertEquals("city of " + input, "København S", addr.city());
	}

}
