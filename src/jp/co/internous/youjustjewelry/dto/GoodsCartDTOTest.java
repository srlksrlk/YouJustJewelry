package jp.co.internous.youjustjewelry.dto;

import static org.junit.Assert.*;

import org.junit.Test;

public class GoodsCartDTOTest {

	@Test
	public void testGetTicketId() {
		int ticket_id=6;
        GoodsCartDTO expected = new GoodsCartDTO();
        expected.setTicketId(6);
        assertSame(ticket_id, expected.getTicketId());
        assertEquals(ticket_id, expected.getTicketId());
	}

	@Test
	public void testSetTicketId() {
		int ticketId=6;
		GoodsCartDTO expected = new GoodsCartDTO();
        expected.setTicketId(6);
        int value = expected.getTicketId();
        assertSame(value, ticketId);
        assertEquals(value, ticketId);
	}

	@Test
	public void testGetTicketName() {
		String ticketName="パパラチアサファイア/ラトナプラ鉱山";
		GoodsCartDTO expected = new GoodsCartDTO();
        expected.setTicketName("パパラチアサファイア/ラトナプラ鉱山");
        assertSame(ticketName, expected.getTicketName());
        assertEquals(ticketName, expected.getTicketName());
	}

	@Test
	public void testSetTicketName() {
		String ticketName="パパラチアサファイア/ラトナプラ鉱山";
		GoodsCartDTO expected = new GoodsCartDTO();
        expected.setTicketName("パパラチアサファイア/ラトナプラ鉱山");
        String value = expected.getTicketName();
        assertSame(value, ticketName);;
        assertEquals(value, ticketName);;
	}

	@Test
	public void testGetPrice() {
		int price=9999999;
		GoodsCartDTO expected = new GoodsCartDTO();
        expected.setPrice(9999999);
        assertEquals(price, expected.getPrice());
	}

	@Test
	public void testSetPrice() {
		int price=9999999;
		GoodsCartDTO expected = new GoodsCartDTO();
        expected.setPrice(9999999);
        int value = expected.getPrice();
        assertEquals(value, price);;
	}

	@Test
	public void testGetTicket_count() {
		int count=120;
		GoodsCartDTO expected = new GoodsCartDTO();
        expected.setTicketCount(120);
        assertSame(count, expected.getTicketCount());
        assertEquals(count, expected.getTicketCount());
	}

	@Test
	public void testSetTicket_count() {
		int count=120;
		GoodsCartDTO expected = new GoodsCartDTO();
        expected.setTicketCount(120);
        int value = expected.getTicketCount();
        assertSame(value, count);
        assertEquals(value, count);
	}

	@Test
	public void testGetTotalAmount() {
		int amount=9999999;
		GoodsCartDTO expected = new GoodsCartDTO();
        expected.setTotalAmount(9999999);
        int value = expected.getTotalAmount();
        assertEquals(value, amount);
	}

	@Test
	public void testSetTotal_amount() {
		int amount=9999999;
		GoodsCartDTO expected = new GoodsCartDTO();
        expected.setTotalAmount(9999999);
        int value = expected.getTotalAmount();
        assertEquals(value, amount);
	}

}