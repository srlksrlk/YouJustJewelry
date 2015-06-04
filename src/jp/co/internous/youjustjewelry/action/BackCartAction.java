
package jp.co.internous.youjustjewelry.action;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import jp.co.internous.youjustjewelry.dto.GoodsCartDTO;
import jp.co.internous.youjustjewelry.dto.TicketInfoDTO;
import jp.co.internous.youjustjewelry.util.CartComparator;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * BackCartAction カート一覧画面へ戻る為のアクション
 * @author T.Okamoto
 * @since 2015/4/10
 * @version 1.0
 */
public class BackCartAction extends ActionSupport implements SessionAware{
	/**
	 * @author T.Okamoto
	 * @since 2015/4/10
	 * totalTicketCount 注文総枚数
	 * totalCartAmount  注文総額
	 * ticketInfo       セッションに登録されている商品情報
	 * orderInfo        セッションに登録されている注文情報
	 * session		    セッション
	 */
	private int totalTicketCount;
	private int totalCartAmount;
	private String msg;
	private List<TicketInfoDTO> ticketInfo = new ArrayList<TicketInfoDTO>();
	private List<GoodsCartDTO> orderInfo = new ArrayList<GoodsCartDTO>();
	public Map<String,Object> session;
	/**
	 * 情報を保持したまま画面遷移させるためのメソッド
	 * @author T.Okamoto
	 * @since 2015/4/10
	 * @return result 実行結果を返す
	 * @see CartComparator
	 * @throws Exception
	 */
	public String execute()throws Exception{
		String result = SUCCESS;

		ticketInfo = (List)session.get("ticket_info");
		orderInfo = (List)session.get("order_info");

		Collections.sort(orderInfo, new CartComparator());
		session.put("order_info", orderInfo);

		for(GoodsCartDTO i: orderInfo){
			totalTicketCount += i.getTicketCount();
			totalCartAmount += i.getTotalAmount();
		}

		session.put("totalTicket_count", totalTicketCount);
		session.put("totalCart_amount", totalCartAmount);
		msg = "";
		session.put("error_msg", msg);
		return result;
	}
	/**
	 * セッション登録メソッド
	 * @author T.Okamoto
	 * @since 2015/4/10
	 * @param session セッションを保存するMap
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
