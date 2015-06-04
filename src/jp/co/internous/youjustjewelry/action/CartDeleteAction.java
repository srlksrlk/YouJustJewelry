
package jp.co.internous.youjustjewelry.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import jp.co.internous.youjustjewelry.dto.GoodsCartDTO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * CartDeleteAction カート内を空にするアクションクラス
 * @author Y.Matsukawa
 * @since 2015/4/20
 * @version 1.0
 */
public class CartDeleteAction extends ActionSupport implements SessionAware{
    /**
     * @author Y.Matsukawa
     * @since 2015/4/20
     * session           セッション
     * totalTicketCount  注文総枚数
     * totalCartAmount   注文総額
     * orderInfo         セッションに登録されている注文情報
     * msg               単体商品注文上限枚数を超えて注文された際のエラーメッセージ
     */
	public Map<String,Object> session;
	private int totalTicketCount;
	private int totalCartAmount;
	public List<GoodsCartDTO> orderInfo = new ArrayList<GoodsCartDTO>();
	private String msg;

    /**
     * sessionのカート内リスト、総購入枚数、合計金額をリセットするメソッド
     * @author Y.matsukawa
     * @since 2015/4/20
     * @version 1.0
     * @return SUCCESS 必ずSUCCESSを返す
     * @throws Exception
     */
	public String execute() throws Exception{

		orderInfo.clear();
		session.put("order_info",orderInfo );
		totalTicketCount = 0;
		session.put("totalTicket_count", totalTicketCount);
		totalCartAmount = 0;
		session.put("totalCart_amount", totalCartAmount);
		msg = "";
		session.put("error_msg", msg);
		return SUCCESS;
	}
    /**
     * セッション登録メソッド
     * @author Y.Matsukawa
     * @since 2015/4/20
     * @param session セッションを保存するMap
     */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
