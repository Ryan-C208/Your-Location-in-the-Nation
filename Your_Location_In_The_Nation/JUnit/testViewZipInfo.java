import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.sql.SQLException;
import java.util.List;
import LocationModel.Location;
import org.junit.Before;
import org.junit.Test;
import DatabasePersist.DerbyDatabase;
import UserModel.PopularLocations;

public class testViewZipInfo {
	DerbyDatabase data = new DerbyDatabase();
	float delta = 0.01f;
	@Before
	public void setUp() {
		//DerbyDatabase data = new DerbyDatabase();
	}

	@Test
	public void testZips() throws SQLException {
		
		Location loc = new Location();
		//test for existing zipcodes
		
		//test 17402
		loc = data.viewZipcodeinfo("17402");
		
		assertEquals(74199, loc.getAvgSalaryPerHouse());
		
		assertEquals(29.0, loc.getCostOfLivingRent(), delta);
		
		assertEquals(20.0, loc.getCostOfLivingOwnWithMortgage(), delta);
		
		assertEquals(12.0, loc.getCostOfLivingOwnNoMortgage(), delta);
		
		
		assertEquals(1139, loc.getCrimeRate());
		
		//test 20677
		loc = data.viewZipcodeinfo("20677");
		
		assertEquals(128750, loc.getAvgSalaryPerHouse());
		
		assertEquals(29.0, loc.getCostOfLivingRent(), delta);
		
		assertEquals(22.0, loc.getCostOfLivingOwnWithMortgage(), delta);
		
		assertEquals(10.0, loc.getCostOfLivingOwnNoMortgage(), delta);
		
		
		assertEquals(2855, loc.getCrimeRate());
		
		
		
		
	}
	
	@Test 
	public void testNonexistantZip() throws SQLException {
		Location loc = new Location();
		//test for existing zipcodes
		loc = data.viewZipcodeinfo("17409");
		assertNull(loc);
		
		loc = data.viewZipcodeinfo("21087");
		assertNull(loc);
		
	}
	
	
	
}
