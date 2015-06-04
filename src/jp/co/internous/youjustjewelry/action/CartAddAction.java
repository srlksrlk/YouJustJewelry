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
 * CartAddAction カートに商品を追加するアクション
 * @author Y.Gouda
 * @since 2015/4/14
 * @version 1.0
 * @see ArrayList<TicketInfoDTO>
 * @see ArrayList<GoodsCartDTO>
 */
public class CartAddAction extends ActionSupport implements SessionAware{
	/**
	 * @author Y.Gouda
	 * @since 2015/4/14
	 * session          セッション
	 * result           実行結果を返す
	 * ticketId 		商品ID
	 * ticketNumber  	選択された商品枚数
	 * totalTicketCount 注文総枚数
	 * totalCartAmount  注文総額
	 * ticketInfo 		セッションに登録されているチケット情報
	 * orderInfo		セッションに登録されているカート内情報
	 */
	public Map<String,Object> session;
	private String result;
	private String msg;
	public int ticketId;
	public int ticketNumber;
	private int totalTicketCount;
	private int totalCartAmount;


	public List<TicketInfoDTO> ticketInfo = new ArrayList<TicketInfoDTO>();
	public List<GoodsCartDTO> orderInfo = new ArrayList<GoodsCartDTO>();
	/**
	 * 商品一覧画面でカートにチケットを追加するメソッド
	 * @author Y.Gouda
	 * @since 2015/4/14
	 * @throws Exception
	 * @return result 実行結果を返す
	 * @see GoodsCartDTO
	 * @see CartComparator
	 */
	public String execute() throws Exception{
		result = SUCCESS;

		if(session.containsKey("ticket_info")){
			ticketInfo = (List)session.get("ticket_info");
		}
		if(session.containsKey("order_info")){
			orderInfo = (List)session.get("order_info");
		}

		GoodsCartDTO orderedTicket = new GoodsCartDTO();
		orderedTicket.setTicketId(ticketId);
		orderedTicket.setTicketName(ticketInfo.get(ticketId - 1).getTicketName());
		orderedTicket.setPrice(ticketInfo.get(ticketId - 1).getPrice());
		orderedTicket.setTicketCount(ticketNumber);
		orderedTicket.setTotalAmount(ticketNumber * (ticketInfo.get(ticketId - 1).getPrice()));
		orderInfo.add(orderedTicket);

		for(int i = 0; i < orderInfo.size(); i++){
			for(int j = i + 1; j < orderInfo.size(); j++){
				if(orderInfo.get(i).getTicketId() == orderInfo.get(j).getTicketId()){
					int k = orderInfo.get(j).getTicketCount();
					int l = orderInfo.get(j).getTotalAmount();
					orderInfo.get(j).setTicketCount((k + orderInfo.get(i).getTicketCount()));
					orderInfo.get(j).setTotalAmount(l + orderInfo.get(i).getTotalAmount());
					if(orderInfo.get(j).getTicketCount() > 20){
						orderInfo.remove(j);
						msg = "エラー：チケットの購入は一度に20枚までです。オーダーを取り消しました。現在の購入枚数：" + orderInfo.get(i).getTicketCount();
						session.put("error_msg", msg);
						return result;
					}
					orderInfo.remove(i);
					break;
				}
			}
		}

		msg = "";
		session.put("error_msg", msg);
		Collections.sort(orderInfo, new CartComparator());
		session.put("order_info", orderInfo);

		for(GoodsCartDTO i: orderInfo){
			totalTicketCount += i.getTicketCount();
			totalCartAmount += i.getTotalAmount();
		}
		session.put("totalTicket_count", totalTicketCount);
		session.put("totalCart_amount", totalCartAmount);

		return result;
	}
	/**
	 * セッション登録メソッド
	 * @author Y.Gouda
	 * @since 2015/4/14
	 * @param session セッションを保存するマップ
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}

}
