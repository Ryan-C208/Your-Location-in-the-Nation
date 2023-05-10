import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;

import DatabasePersist.DerbyDatabase;
import LocationModel.Location;

public class testViewZipsforAreaName {
	DerbyDatabase data = new DerbyDatabase();
	List<String> Zips = new ArrayList<String>();
	@Before
	public void setUp() {
		//DerbyDatabase data = new DerbyDatabase();
	}

	@Test
	public void testViewZips() throws SQLException {
		
		Zips = data.getZipcodesForAreaName("York");
		
		assertTrue(Zips.contains("17402"));
		
		assertTrue(Zips.contains("17403"));
		
		assertTrue(Zips.contains("17404"));
		
		assertFalse(Zips.contains("17409"));
		
	}
	
	@Test 
	public void testMoreZips() throws SQLException {
		
		Zips = data.getZipcodesForAreaName("Waldorf");
		
		assertTrue(Zips.contains("20601"));
		
		assertTrue(Zips.contains("20602"));
		
		assertTrue(Zips.contains("20603"));
		
		assertFalse(Zips.contains("20604"));
		
	}
	
	@Test
	public void testNonexistantAreaName() throws SQLException {
		
		Zips = data.getZipcodesForAreaName("Washington");
		
		assertTrue(Zips.size() == 0);
		
		
		Zips = data.getZipcodesForAreaName("New York");
		
		assertTrue(Zips.size() == 0);
	}
	
	
}
	
