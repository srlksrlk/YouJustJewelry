package jp.co.internous.youjustjewelry.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import jp.co.internous.youjustjewelry.dto.GoodsCartDTO;
import jp.co.internous.youjustjewelry.util.CartComparator;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * OrderChangeAction オーダーチェンジアクション
 * @author Y.Matsukawa
 * @since 2015/4/18
 * @version 1.0
 */
public class OrderChangeAction extends ActionSupport implements SessionAware{
	/**
	 * @author Y.Matskawa
	 * @since 2015/4/18
	 * @version 1.0
	 * session			セッション
	 * ticketNumber		選択された商品枚数
	 * ticketId			商品ID
	 * ticketName		商品名
	 * price			単体商品価格
	 * ticketCount		商品単体注文枚数
	 * tatalAmount		商品単体注文総額
	 * totalTicketCount 注文総枚数
	 * totalCartAmount  注文総額
	 */
	public Map<String,Object> session;
	public int ticketNumber;
	private int ticketId;
	private String ticketName;
	private int price;
	private int ticketCount;
	private int totalAmount;
	private int totalTicketCount;
	private int totalCartAmount;
	/**
	 * 購入手続き画面での枚数変更を行うメソッド
	 * @author Y.Matsukawa
	 * @since 2015/4/18
	 * @version 1.0
	 * @return SUCCESS チケットの枚数変更したあとSUCCESSを返す
	 * @see GoodsCartDTO
	 * @see CartComparator
	 */
	public String execute() {

		List<GoodsCartDTO> orderInfo= new ArrayList<GoodsCartDTO>();
		if(session.containsKey("order_info")){
			orderInfo = (List<GoodsCartDTO>) session.get("order_info");
		}

		session.remove("order_info");

		GoodsCartDTO item = new GoodsCartDTO();

		item.setTicketId(ticketId);
		item.setTicketName(ticketName);
		item.setPrice(price);
		item.setTicketCount(ticketNumber);
		item.setTotalAmount(totalAmount);
		orderInfo.add(item);

		for(int i = 0;i < orderInfo.size();i++){
			for(int j = i+1;j < orderInfo.size();j++){
				if(orderInfo.get(i).getTicketId() == orderInfo.get(j).getTicketId()){
					orderInfo.get(j).setTotalAmount(
							orderInfo.get(j).getTicketCount()*
							orderInfo.get(i).getPrice());
					orderInfo.remove(i);
				}
			}
			totalTicketCount += orderInfo.get(i).getTicketCount();
			totalCartAmount += orderInfo.get(i).getTotalAmount();
		}
		Collections.sort(orderInfo, new CartComparator());
		session.put("totalTicket_count", totalTicketCount);
		session.put("totalCart_amount", totalCartAmount);
		session.put("order_info",orderInfo);

		return SUCCESS;
	}
	/**
	 * 購入手続き画面でチケットの削除を行うメソッド
	 * @author Y.Gouda
	 * @since 2015/4/24
	 * @version 1.0
	 * @return result カート内に残チケットがあればSUCCESS、空ならERRORを返す
	 * @see GoodsCartDTO
	 * @see CartComparator
	 */
	public String DeleteTicketCount(){
		String result;
		List<GoodsCartDTO> orderInfo= new ArrayList<GoodsCartDTO>();
		if(session.containsKey("order_info")){
			orderInfo = (List<GoodsCartDTO>) session.get("order_info");
		}
		session.remove("order_info");
		for(int i = 0; i < orderInfo.size(); i++){
			if(ticketId == orderInfo.get(i).getTicketId()){
				orderInfo.remove(i);
			}
		}
		for(int i = 0; i < orderInfo.size(); i++){
			totalTicketCount += orderInfo.get(i).getTicketCount();
			totalCartAmount += orderInfo.get(i).getTotalAmount();
		}
		session.put("totalTicket_count", totalTicketCount);
		session.put("totalCart_amount", totalCartAmount);

		if(orderInfo.size() == 0){
			result = ERROR;
			return result;
		}
		Collections.sort(orderInfo, new CartComparator());
		session.put("order_info",orderInfo);
		result = SUCCESS;
		return result;
	}
	/**
	 * セッション取得メソッド
	 * @author Y.Matsukawa
	 * @since 2015/4/18
	 * @return session セッションを返す
	 */
	public Map<String, Object> getSession() {
		return session;
	}
	/**
	 * セッション登録メソッド
	 * @author Y.Matsukawa
	 * @since 2015/4/18
	 * @param session セッションを保存するマップ
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	/**
	 * 商品IDを取得メソッド
	 * @author Y.Matsukawa
	 * @since 2015/4/18
	 * @return ticketId 商品IDを返す
	 */
	public int getTicketId() {
		return ticketId;
	}
	/**
	 * 商品IDを登録メソッド
	 * @author Y.Matsukawa
	 * @since 2015/4/18
	 * @param ticketId 商品ID
	 */
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	/**
	 * 商品名を取得するメソッド
	 * @author Y.Matsukawa
	 * @since 2015/4/18
	 * @return tickeName 商品名を返す
	 */
	public String getTicketName() {
		return ticketName;
	}
	/**
	 * 商品名を登録するメソッド
	 * @author Y.Matsukawa
	 * @since 2015/4/18
	 * @param ticketName 商品名
	 */
	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}
	/**
	 * 単体商品価格を取得するメソッド
	 * @author Y.Matsukawa
	 * @since 2015/4/18
	 * @return price 単体商品の価格を返す
	 */
	public int getPrice() {
		return price;
	}
	/**
	 * 単体商品価格を登録するメソッド
	 * @author Y.Matsukawa
	 * @since 2015/4/18
	 * @param price 単体商品価格
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * 商品単体注文枚数を取得するメソッド
	 * @author Y.Matsukawa
	 * @since 2015/4/18
	 * @return ticketCount 商品単体注文枚数を返す
	 */
	public int getTicketCount() {
		return ticketCount;
	}
	/**
	 * 商品単体注文枚数を登録するメソッド
	 * @author Y.Matsukawa
	 * @since 2015/4/18
	 * @param ticketCount 商品単体注文枚数
	 */
	public void setTicketCount(int ticketCount) {
		this.ticketCount = ticketCount;
	}
	/**
	 * 商品単体注文総額を取得するメソッド
	 * @author Y.Matsukawa
	 * @since 2015/4/18
	 * @return totalAmount 商品単体注文総額を返す
	 */
	public int getTotalAmount() {
		return totalAmount;
	}
	/**
	 * 商品単体注文総額を登録するメソッド
	 * @author Y.Matsukawa
	 * @since 2015/4/18
	 * @param totalAmount 商品単体注文総額数
	 */
	public void setTotalAmount(int totalAmount) {
		this.totalAmount = totalAmount;
	}

}
