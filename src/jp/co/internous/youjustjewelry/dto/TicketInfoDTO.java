package jp.co.internous.youjustjewelry.dto;
/**
 * DBticket_infoをレコード毎に格納するDTOクラス
 * @author Y.Gouda
 * @since 2015/4/15
 * @version 1.0
 */
public class TicketInfoDTO {
    /**
     * @author Y.Gouda
     * @since 2015/4/15
     * ticketID     商品ID
     * ticketName   商品名
     * price        商品単体価格
     * stock        商品在庫量
     */
	private int ticketId;
	private String ticketName;
	private int price;
	private int stock;
	/**
	 * 商品ID取得メソッド
	 * @author Y.Gouda
	 * @since 2015/4/15
	 * @return ticketId 必ず商品IDを返す
	 */
	public int getTicketId() {
		return ticketId;
	}
	/**
	 * 商品ID登録メソッド
     * @author Y.Gouda
     * @since 2015/4/15
	 * @param ticketId 商品IDを格納する変数
	 */
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	/**
	 * 商品名取得メソッド
     * @author Y.Gouda
     * @since 2015/4/15
	 * @return ticketName 必ず商品名を返す
	 */
	public String getTicketName() {
		return ticketName;
	}
	/**
	 * 商品名登録メソッド
     * @author Y.Gouda
     * @since 2015/4/15
	 * @param ticketName 商品名を格納する変数
	 */
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	/**
	 * 商品単体価格取得メソッド
     * @author Y.Gouda
     * @since 2015/4/15
	 * @return price 必ず商品単体価格を返す
	 */
	public int getPrice() {
		return price;
	}
	/**商品単体価格登録メソッド
     * @author Y.Gouda
     * @since 2015/4/15
	 * @param price 商品単体価格を格納する変数
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * 商品在庫量取得メソッド
     * @author Y.Gouda
     * @since 2015/4/15
	 * @return stock 必ず商品在庫量を返す
	 */
	public int getStock() {
		return stock;
	}
	/**商品在庫量登録メソッド
     * @author Y.Gouda
     * @since 2015/4/15
	 * @param stock 商品在庫量を格納する変数
	 */
	public void setStock(int stock) {
		this.stock = stock;
	}
}
