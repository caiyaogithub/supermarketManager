package test;

import static org.junit.Assert.*;

import org.junit.Test;

import userManager.service.UserCheck;

public class UserCheckTest {
	UserCheck demo = new UserCheck() ;
	@Test
	public void testCheckUser() {
	}

	@Test
	public void testCheckUserName() {
		assertEquals(true,demo.checkUserName("ÄÐ")) ;
	}

	@Test
	public void testCheckPassword() {
		assertEquals(true,demo.checkPassword("abcdefg1")) ;
	}

	@Test
	public void testCheckGender() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckAge() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckTelephone() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckAddress() {
		fail("Not yet implemented");
	}

}
