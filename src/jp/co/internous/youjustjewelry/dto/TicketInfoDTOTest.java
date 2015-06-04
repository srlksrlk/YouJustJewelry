package jp.co.internous.youjustjewelry.dto;

import static org.junit.Assert.*;

import org.junit.Test;

public class TicketInfoDTOTest {

	@Test
	public void testGetTicket_id() {
		int ticket_id=6;
        TicketInfoDTO expected = new TicketInfoDTO();
        expected.setTicketId(6);
        assertSame(ticket_id, expected.getTicketId());
        assertEquals(ticket_id, expected.getTicketId());
	}

	@Test
	public void testSetTicket_id() {
		int ticket_id=6;
		TicketInfoDTO expected = new TicketInfoDTO();
        expected.setTicketId(6);
        int value = expected.getTicketId();
        assertSame(value, ticket_id);
        assertEquals(value, ticket_id);
	}

	@Test
	public void testGetTicket_name() {
		String ticket_name="パパラチアサファイア/ラトナプラ鉱山";
		TicketInfoDTO expected = new TicketInfoDTO();
        expected.setTicketName("パパラチアサファイア/ラトナプラ鉱山");
        assertSame(ticket_name, expected.getTicketName());
        assertEquals(ticket_name, expected.getTicketName());
	}

	@Test
	public void testSetTicket_name() {
		String ticket_name="パパラチアサファイア/ラトナプラ鉱山";
		TicketInfoDTO expected = new TicketInfoDTO();
        expected.setTicketName("パパラチアサファイア/ラトナプラ鉱山");
        String value = expected.getTicketName();
        assertSame(value, ticket_name);
        assertEquals(value, ticket_name);
	}

	@Test
	public void testGetPrice() {
		int price=1234567890;
		TicketInfoDTO expected = new TicketInfoDTO();
        expected.setPrice(1234567890);
        assertEquals(price, expected.getPrice());
	}

	@Test
	public void testSetPrice() {
		int price=1234567890;
		TicketInfoDTO expected = new TicketInfoDTO();
        expected.setPrice(1234567890);
        int value = expected.getPrice();
        assertEquals(value, price);
	}

	@Test
	public void testGetStock() {
		int stock=20;
		TicketInfoDTO expected = new TicketInfoDTO();
        expected.setStock(20);
        assertSame(stock, expected.getStock());
        assertEquals(stock, expected.getStock());
	}

	@Test
	public void testSetStock() {
		int stock=20;
		TicketInfoDTO expected = new TicketInfoDTO();
        expected.setStock(20);
        int value = expected.getStock();
        assertSame(value, stock);
        assertEquals(value, stock);
	}

}
