package jp.co.internous.youjustjewelry.dto;

import static org.junit.Assert.*;

import org.junit.Test;

public class LoginDTOTest {

	@Test
	public void testGetUser_id() {
		String userid="123";
        LoginDTO expected = new LoginDTO();
        expected.setUserId("123");
        assertEquals(userid, expected.getUserId());
	}

	@Test
	public void testSetUser_id() {
		String userid="123";
        LoginDTO expected = new LoginDTO();
        expected.setUserId("123");
        String value = expected.getUserId();
        assertEquals(value, userid);;
	}

	@Test
	public void testGetUser_pass() {
        String userpass="123";
        LoginDTO expected = new LoginDTO();
        expected.setUserPass("123");
        assertEquals(userpass, expected.getUserPass());
	}

	@Test
	public void testSetUser_pass() {
		String userpass="123";
        LoginDTO expected = new LoginDTO();
        expected.setUserPass("123");
        String value = expected.getUserPass();
        assertEquals(value, userpass);;
	}

	@Test
	public void testGetFirst_name() {
		 String username="松本ゆうた/ユウタ～yuuta";
         LoginDTO expected = new LoginDTO();
         expected.setFirstName("松本ゆうた/ユウタ～yuuta");
         assertSame(username, expected.getFirstName());
         assertEquals(username, expected.getFirstName());
	}

	@Test
	public void testSetFirst_name() {
		 String username="松本ゆうた/ユウタ～yuuta";
         LoginDTO expected = new LoginDTO();
         expected.setFirstName("松本ゆうた/ユウタ～yuuta");
         String value = expected.getFirstName();
         assertSame(value, username);;
         assertEquals(value, username);;
	}
}

