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
 * GoOrderFormAction 商品一覧画面から購入手続き画面へ注文情報を渡して遷移するためのアクションクラス
 * @author Y.Gouda
 * @since 2015/4/19
 * @version 1.0
 */
public class GoOrderFormAction extends ActionSupport implements SessionAware {
	/**
	 * @author Y.Gouda
	 * @since 2015/4/19
	 * session    セッション
	 * orderInfo  セッションに登録されている注文情報
	 * result     実行結果を返す
	 */
	public Map<String,Object> session;
	public List<GoodsCartDTO> orderInfo = new ArrayList<GoodsCartDTO>();
	private String result;

	/**
	 * 注文情報の値を渡し購入手続き画面へ遷移するメソッド
	 * @author Y.Gouda
	 * @since 2015/4/19
	 * @throws Exception
	 * @return result 実行結果を返す
	 * @see CartComparator
	 */
	public String execute() throws Exception{
		orderInfo = (List)session.get("order_info");
		if((orderInfo != null) && (orderInfo.size() > 0)){
			for(int i = 0;i < orderInfo.size();i++){
				for(int j = i+1;j < orderInfo.size();j++){
					if(orderInfo.get(i).getTicketId() == orderInfo.get(j).getTicketId()){
						orderInfo.get(j).setTicketCount(
								orderInfo.get(j).getTicketCount()+
								orderInfo.get(i).getTicketCount());
						orderInfo.get(j).setTotalAmount(
								orderInfo.get(j).getTotalAmount()+
								orderInfo.get(i).getTotalAmount());
						orderInfo.remove(i);
					}
				}
			}
			Collections.sort(orderInfo, new CartComparator());
			session.put("order_info",orderInfo);
			result = SUCCESS;
		}else{
			result = ERROR;
		}
		return result;
	}
	/**
	 * セッション取得メソッド
	 * @author Y.Gouda
	 * @since 2015/4/19
	 * @return session セッションを取り出す
	 */
	public Map<String, Object> getSession() {
		return session;
	}
	/**
	 * セッション登録メソッド
	 * @author Y.Gouda
	 * @since 2015/4/19
	 * @param session セッションを保存するMap
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}








}
