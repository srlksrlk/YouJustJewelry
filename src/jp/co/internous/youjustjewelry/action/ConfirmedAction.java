package jp.co.internous.youjustjewelry.action;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.co.internous.youjustjewelry.dao.ComfirmedDAO;
import jp.co.internous.youjustjewelry.dto.GoodsCartDTO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * ConfirmedAction  購入情報をデータベースに保存し購入完了画面へと遷移するアクションクラス
 * @author Y.Matsukawa
 * @since 2015/4/10
 * @version 1.0
 */
public class ConfirmedAction extends ActionSupport implements SessionAware{
	/**
	 * @author Y.Matsukawa
	 * @since 2015/4/10
	 * session      セッション
	 * orderInfo   セッションに登録されている注文情報
	 * userId      ユーザーID
	 * ticketId    商品ID
	 * ticketCount 商品単体注文枚数
	 * totalAmount 商品単体注文総額
	 * userIp      ユーザーIP
	 */
	public Map<String,Object> session;
	private List<GoodsCartDTO> orderInfo = new ArrayList<GoodsCartDTO>();
	private String userId;
	private int ticketId;
	private int ticketCount;
	private int totalAmount;
	private String userIp;
	/**
	 * カート内リストをSQL文に変換してレコードとしてhistoryテーブルに挿入するメソッド
	 * @author Y.Gouda
	 * @since 2015/4/20
	 * @return SUCCESS 例外処理に入らなければSUCCESSを返す
	 * @see GoodsCartDTO
	 * @see ComfirmedDAO
	 */
	public String execute(){

		orderInfo = (List<GoodsCartDTO>)session.get("order_info");
		userId = (String)session.get("user_id");
		userIp = (String)session.get("user_ip");

		Iterator<GoodsCartDTO> it = orderInfo.iterator();
		while(it.hasNext()){
			GoodsCartDTO data = it.next();
			ticketId = data.getTicketId();
			ticketCount = data.getTicketCount();
			totalAmount = data.getTotalAmount();
			ComfirmedDAO dao = new ComfirmedDAO();
			try {
				if(dao.insert(userId, ticketId, ticketCount, totalAmount, userIp)){
					session.remove("order_info");
					session.remove("totalTicket_count");
					session.remove("totalCart_amount");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		return SUCCESS;
	}
	/**
	 * セッション登録メソッド
	 * @author Y.Gouda
	 * @since 2015/4/20
	 * @param session セッションを保存するMap
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	/**
	 * 注文情報取得メソッド
	 * @author Y.Gouda
	 * @since 2015/4/20
	 * @return orderInfo セッションに登録されている注文情報を返す
	 */
	public List<GoodsCartDTO> getOrderInfo() {
		return orderInfo;
	}

}
