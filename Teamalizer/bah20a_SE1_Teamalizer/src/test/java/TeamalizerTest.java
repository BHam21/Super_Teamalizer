/*
 * CS374 Software Engineering I
 * Brett Hammit
 * Teamalizer Tester
*/

import java.nio.file.Paths;
import java.nio.file.Files;
import java.util.Arrays;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.*;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.junit.*;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TeamalizerTest
{
	Teamalizer team;
	
	@Before
    public void initialize()
	{
		team = new Teamalizer();
		team.basic();	
		team.test = 1;
    }
	
	@Test
	public void goodNames_test1()
	{
		try
		{	
			System.out.println("starting goodNames_test1");
			String content = Files.readString(Paths.get("prefs/prefs2.txt"));
			String splitNames[] = content.split("\n");
			String goodNames[] = team.get(splitNames);
			
			assertEquals("Brent,2,3,7,5,6,4,-8,-10", goodNames[0]);
			assertEquals("Dog,3,4,6,7,8,2,-1,-9", goodNames[goodNames.length/2]);
			assertEquals("pholder", goodNames[goodNames.length-1]);
		}
		catch (Exception e)
		{
			System.out.println("failed goodNames_test1");
		}
	}
	
	@Test
	public void goodNames_test2()
	{
		try
		{
			System.out.println("starting goodNames_test2");
			String content = Files.readString(Paths.get("prefs/prefs.txt"));
			String splitNames[] = content.split("\n");
			String goodNames[] = team.get(splitNames);
			
			assertEquals("Brent,2,3,7,5,6,4,-8,-10", goodNames[0]);
			assertEquals("Dog,3,4,6,7,8,2,-1,-9", goodNames[goodNames.length/2]);
			assertEquals("pholder", goodNames[goodNames.length-1]);
		}
		catch (Exception e)
		{
			System.out.println("goodNames_test2 failed");
		}
	}
	
		@Test
	public void mix_test1()
	{
		try
		{
			System.out.println("starting mix_test1");
			
			team.setPref(2);
			String[] a = new String[] {"Brett","1","2","Glover","1","2","Kennedy","1","2","Ricky","1","2","Gob","1","2","Wizzy","6","4"};
			String[] b = new String[] {"Brett,1,2", "Glover,1,2", "Kennedy,1,2","Ricky,2,3","Gob,2,3","Wizzy,6,4"};
			team.setWeight(a);
			team.setGoodNames(b);
			
			team.mix();
			
			String tempWeight[] = team.getTempWeight();
			String tempNames[] = team.getTempNames();
			
			//This wants to be NOT equal, so the Arrays.equals need to return false.
			assertNotEquals(Arrays.equals(a, tempWeight), true);
			assertNotEquals(Arrays.equals(b, tempNames), true);
			
		}
		catch (Exception e)
		{
			System.out.println("mix_test1 failed");
		}
	}
	
	@Test
	public void mix_test2()
	{
		try
		{
			
			System.out.println("starting mix_test2");
			
			team.setPref(3);
			String[] a = new String[] {"Brett","1","2","2","Glover","1","2","2","Kennedy","1","2","2","Ricky","1","2","2","Gob","1","2","2","Wizzy","6","2","4"};
			String[] b = new String[] {"Brett,1,2,2", "Glover,1,2,2", "Kennedy,1,2,2","Ricky,2,3,2","Gob,2,2,3","Wizzy,6,2,4"};
			team.setWeight(a);
			team.setGoodNames(b);
			
			team.mix();
			
			String tempWeight[] = team.getTempWeight();
			String tempNames[] = team.getTempNames();
			//This wants to be NOT equal, so the Arrays.equals need to return false.
			assertNotEquals(Arrays.equals(a, tempWeight), true);
			assertNotEquals(Arrays.equals(b, tempNames), true);
			
		}
		catch (Exception e)
		{
			System.out.println("mix_test2 failed");
		}
	}
	
	@Test
	public void pholder_test1()
	{
		try
		{
			System.out.println("starting pholder_test1");
			
			team.setTSize(3);
			String content = Files.readString(Paths.get("prefs/prefs.txt"));
			String splitNames[] = content.split("\n");
			String goodNames[] = team.get(splitNames);		
			
			int calcInt = team.getPholder();
			int expectedInt = 1;
			assertEquals(expectedInt, calcInt);
		}
		catch (Exception e)
		{
			System.out.println("pholder_test1 failed");
		}
	}
	
	@Test
	public void pholder_test2()
	{
		try
		{
			System.out.println("starting pholder_test1");
			team.setTSize(5);
			String content = Files.readString(Paths.get("prefs/prefs2.txt"));
			String splitNames[] = content.split("\n");
			String goodNames[] = team.get(splitNames);
			
			

			int calcInt = team.getPholder();
			int expectedInt = 3;
			assertEquals(expectedInt, calcInt);
		}
		catch (Exception e)
		{
			System.out.println("pholder_test2 failed");
		}
	}
	
	@Test
	public void pholder_test3()
	{
		try
		{
			System.out.println("starting pholder_test3");
			team.setTSize(4);
			String content = Files.readString(Paths.get("prefs/prefs.txt"));
			String splitNames[] = content.split("\n");
			String goodNames[] = team.get(splitNames);

			int calcInt = team.getPholder();
			int expectedInt = 0;
			assertEquals(expectedInt, calcInt);
		}
		catch (Exception e)
		{
			System.out.println("pholder_test3 failed");
		}
	}
	
	@Test
	public void pholder_test4()
	{
		try
		{
			System.out.println("starting pholder_test4");
			team.setTSize(5);

			String content = Files.readString(Paths.get("prefs/prefs.txt"));
			String splitNames[] = content.split("\n");
			String goodNames[] = team.get(splitNames);

			int calcInt = team.getPholder();
			
			int expectedInt = 2;
			assertEquals(expectedInt, calcInt);
		}
		catch (Exception e)
		{
			System.out.println("pholder_test4 failed");
		}
	}
	
	@Test
	public void teamSize_test1()
	{
		try
		{
			System.out.println("starting teamSize_test1");
			int calcInt = team.getTeamSize();
			int expectedInt = 3;
			assertEquals(expectedInt, calcInt);
		}
		catch (Exception e)
		{
			System.out.println("teamSize_test1 failed");
		}
	}
	
	@Test
	public void teamSize_test2()
	{
		try
		{
			System.out.println("starting teamSize_test2");
			team.setTSize(5);
			int calcInt = team.getTeamSize();
			int expectedInt = 5;
			assertEquals(expectedInt, calcInt);
		}
		catch (Exception e)
		{
			System.out.println("teamSize_test2 failed");
		}
	}
	
	@Test
	public void teamSize_test3()
	{
		try
		{
			//Change the tSize and check again
			System.out.println("starting teamSize_test3");
			team.setTSize(10);
			int calcInt = team.getTeamSize();
			int expectedInt = 10;
			assertEquals(expectedInt, calcInt);
		}
		catch (Exception e)
		{
			System.out.println("teamSize_test3 failed");
		}
	}
	
	@Test
	public void calc_test1()
	{
		try
		{
			System.out.println("starting calc_test1");
			team.setTSize(2);			
			team.setPref(1);
			
			String[] a = new String[] {"Brett,2", "Glover", "Kennedy","Ricky","Gob","Wizzy"};
			
			String[] b = new String[] {"Brett","2","Glover","___","Kennedy","___","Ricky","___","Gob","___","Wizzy","___"};
			
			String[] c = new String[] {"1","2","3","4","5","6"};
						
			team.setTempNumberArray(c);
			team.calc(a, b);
			
			int is = team.getTestHappiness();
			int expected = 14;
			assertEquals(expected, is);
		}
		catch (Exception e)
		{
			System.out.println("calc_test1 failed");
		}
	}
	
	@Test
	public void calc_test2()
	{
		try
		{
			//Change the tSize and check again
			System.out.println("starting calc_test2");
			team.setTSize(2);	
			team.setPref(1);			
			
			String[] a = new String[] {"Brett,2", "Glover", "Kennedy,4","Ricky","Gob,6","Wizzy"};
			
			String[] b = new String[] {"Brett","2","Glover","___","Kennedy","4","Ricky","___","Gob","6","Wizzy","___"};
			
			String[] c = new String[] {"1","2","3","4","5","6"};
			
	
			team.setTempNumberArray(c);
			team.calc(a, b);
			
			int is = team.getTestHappiness();
			int expected = 18;
			assertEquals(expected, is);
		}
		catch (Exception e)
		{
			System.out.println("calc_test2 failed");
		}
	}
	
	@Test
	public void calc_test3()
	{
		try
		{
			//Change the tSize and check again
			System.out.println("starting calc_test3");
			team.setTSize(3);	
			team.setPref(2);			
			
			String[] a = new String[] {"Brett,2,3", "Glover,1,3", "Kennedy,1,2","Ricky,5,6","Gob,4,6","Wizzy,4,5","Liz,8,9","Josiah,7,9","Morgan,7,8"};
			
			String[] b = new String[] {"Brett","2","3","Glover","1","3","Kennedy","1","2","Ricky","5","6","Gob","4","6","Wizzy","4","5","Liz","8","9","Devan","7","9","Tanner","7","8"};
			
			String[] c = new String[] {"1","2","3","4","5","6","7","8","9"};
			
	
			team.setTempNumberArray(c);
			team.calc(a, b);
			
			int is = team.getTestHappiness();
			int expected = 63;
			assertEquals(expected, is);
		}
		catch (Exception e)
		{
			System.out.println("calc_test3 failed");
		}
	}
	
	@Test
	public void BadAssign_test1()
	{
		try
		{
			String[] a = team.getPeople();
			a[a.length+1] = "a";
		}
		catch (Exception e)
		{
			System.out.println("starting BadAssign_test1");
		}
		
	}
	
	@Test
	public void BadPref_test1()
	{
		try
		{
			team.setTSize(3);	
			team.setPref(10);			
			
			String[] a = new String[] {"Brent,18,13,14,12,4", "Carter,6,18,19,5,1", "Kennedy,8,4,16,12,17",
									   "Glover,6,3,15,13,14","Wizzy,2,1,4,19,16","Brett,4,3,5,2,14",
									   "Ricky,1,2,3,4,5","Jace,19,18,15,13,12","Yoda,1,6,2,7,16",
									   "Justin,16,14,1,2,3", "Josiah,10,12,17,1,2", "Josh,1,5,3,6,10",
									   "A,12,17,4,7,1","B,1,2,3","C,5,6,7",
									   "D,8,1,2,3,4","E,19,1,2,10","F,4,6,16,14,9",
									   "G,9,8,7,6,5,4", "pholder","pholder"};
									   
			String[] b = new String[] {"Brent","18","13","14","12","4","Carter","6","18","19","5","1","Kennedy","8","4","16","12","17",
									   "Glover","6","3","15","13","14","Wizzy","2","1","4","19","16","Brett","4","3","5","2","14",
									   "Ricky","1","2","3","4","5","Jace","19","18","15","13","12","Yoda","1","6","2","7","16",
									   "Justin","16","14","1","2","3", "Josiah","10","12","17","1","2", "Josh","1","5","3","6","10",
									   "A","12","17","4","7","1","B","1","2","3","___","___","C","5","6","7","___","___",
									   "D","8","1","2","3","4","E","19","1","2","10","___","F","4","6","16","14","9",
									   "G","9","8","7","6","5","4", "pholder","___","_._","_._","_._","_._","pholder","___","_._","_._","_._","_._"};
									   
			String[] c = new String[] {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21"};
			
	
			team.setTempNumberArray(c);
			team.calc(a, b);

		}
		catch (Exception e)
		{
			System.out.println("starting BadPref_test1");
		}
	}
	
		@Test
	public void BadTeamSize_test1()
	{
		try
		{
			team.setTSize(3);	
			team.setPref(10);			
			
			String[] a = new String[] {"Brent,18,13,14,12,4", "Carter,6,18,19,5,1", "Kennedy,8,4,16,12,17",
									   "Glover,6,3,15,13,14","Wizzy,2,1,4,19,16","Brett,4,3,5,2,14",
									   "Ricky,1,2,3,4,5","Jace,19,18,15,13,12","Yoda,1,6,2,7,16",
									   "Justin,16,14,1,2,3", "Josiah,10,12,17,1,2", "Josh,1,5,3,6,10",
									   "A,12,17,4,7,1","B,1,2,3","C,5,6,7",
									   "D,8,1,2,3,4","E,19,1,2,10","F,4,6,16,14,9",
									   "G,9,8,7,6,5,4", "pholder","pholder"};
									   
			String[] b = new String[] {"Brent","18","13","14","12","4","Carter","6","18","19","5","1","Kennedy","8","4","16","12","17",
									   "Glover","6","3","15","13","14","Wizzy","2","1","4","19","16","Brett","4","3","5","2","14",
									   "Ricky","1","2","3","4","5","Jace","19","18","15","13","12","Yoda","1","6","2","7","16",
									   "Justin","16","14","1","2","3", "Josiah","10","12","17","1","2", "Josh","1","5","3","6","10",
									   "A","12","17","4","7","1","B","1","2","3","___","___","C","5","6","7","___","___",
									   "D","8","1","2","3","4","E","19","1","2","10","___","F","4","6","16","14","9",
									   "G","9","8","7","6","5","4", "pholder","___","_._","_._","_._","_._","pholder","___","_._","_._","_._","_._"};
									   
			String[] c = new String[] {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21"};
			
	
			team.setTempNumberArray(c);
			team.calc(a, b);

		}
		catch (Exception e)
		{
			System.out.println("starting BadTeamSize_test1");
		}
		
	}

}

