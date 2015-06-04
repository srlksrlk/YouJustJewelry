package jp.co.internous.youjustjewelry.dto;
/**
 * GoodsCartDTO 購入ボタンを押された際にチケット情報を格納するクラス
 * @author Y.Gouda
 * @since 2015/4/15
 * @version 1.0
 */
public class GoodsCartDTO {
	/**
	 * @author Y.Gouda
	 * @since 2015/4/15
	 * ticketId		商品ID
	 * ticketName	商品名
	 * price		商品単体価格
	 * ticketCount	商品単体注文枚数
	 * totalAmount	商品単体注文総額
	 */
	private int ticketId;
	private String ticketName;
	private int price;
	private int ticketCount;
	private int totalAmount;
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
	 * @param ticketId 商品IDを格納した変数
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
	 * @param ticketName 商品名を格納した変数
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
	/**
	 * 商品単体価格登録メソッド
	 * @author Y.Gouda
	 * @since 2015/4/15
	 * @param price 商品単体価格を格納した変数
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * 商品単体注文枚数取得メソッド
	 * @author Y.Gouda
	 * @since 2015/4/15
	 * @return ticketCount 必ず商品単体注文枚数を返す
	 */
	public int getTicketCount() {
		return ticketCount;
	}
	/**
	 * 商品単体注文枚数登録メソッド
	 * @author Y.Gouda
	 * @since 2015/4/15
	 * @param ticketCount 商品単体注文枚数を格納した変数
	 */
	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}
	/**
	 * 商品単体注文総額取得メソッド
	 * @author Y.Gouda
	 * @since 2015/4/15
	 * @return totalAmount 必ず商品単体注文総額
	 */
	public int getTotalAmount() {
		return totalAmount;
	}
	/**
	 * 商品単体注文総額登録メソッド
	 * @author Y.Gouda
	 * @since 2015/4/15
	 * @param totalAmount 商品単体注文総額を格納した変数
	 */
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}
}
