import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.sql.SQLException;
import LocationModel.Location;
import org.junit.Before;
import org.junit.Test;
import SQLData.FactorGetter;
import DatabasePersist.DerbyDatabase;

public class testGetLocation {
	
	DerbyDatabase data = new DerbyDatabase();
	Location loc = new Location();
	FactorGetter factor = new FactorGetter();
	int CrimeFact;
	float COLFact;
	int AvgSalFact;
	
	@Before
	public void setUp() {
		//DerbyDatabase data = new DerbyDatabase();
	}
	
	@Test
	public void getLocationCOLRent() throws SQLException, ClassNotFoundException, IOException {
		CrimeFact = factor.Get_Crime_Factor(4);
		COLFact = factor.Get_CostofLiving_Factor(3, 0);
		AvgSalFact = factor.Get_AvgSalary_Factor(3);
		
		loc = data.getLocation(AvgSalFact, COLFact, CrimeFact, 0, 2);
		
		assertTrue(loc.getAvgSalaryPerHouse() > 40000);
		assertTrue(loc.getCrimeRate() < 6500);
		assertTrue(loc.getCostOfLivingRent() < 34);
		
	}
	
	@Test
	public void getLocationCOLMortgage() throws SQLException, ClassNotFoundException, IOException {
		CrimeFact = factor.Get_Crime_Factor(2);
		COLFact = factor.Get_CostofLiving_Factor(5, 1);
		AvgSalFact = factor.Get_AvgSalary_Factor(3);
		
		loc = data.getLocation(AvgSalFact, COLFact, CrimeFact, 1, 1);
		
		assertTrue(loc.getAvgSalaryPerHouse() > 40000);
		assertTrue(loc.getCrimeRate() < 9000);
		assertTrue(loc.getCostOfLivingOwnWithMortgage() < 22);
		
	}
	
	@Test
	public void getLocationCOLNoMortgage() throws SQLException, ClassNotFoundException, IOException {
		CrimeFact = factor.Get_Crime_Factor(2);
		COLFact = factor.Get_CostofLiving_Factor(2, 2);
		AvgSalFact = factor.Get_AvgSalary_Factor(6);
		
		loc = data.getLocation(AvgSalFact, COLFact, CrimeFact, 2, 0);
		
		assertTrue(loc.getAvgSalaryPerHouse() > 70000);
		assertTrue(loc.getCrimeRate() < 9000);
		assertTrue(loc.getCostOfLivingOwnNoMortgage() < 13.3);
		
	}
	
	
	
	
}
