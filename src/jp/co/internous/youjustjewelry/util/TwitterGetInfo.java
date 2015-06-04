package jp.co.internous.youjustjewelry.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import jp.co.internous.youjustjewelry.dao.TicketInfoDAO;
import jp.co.internous.youjustjewelry.dto.TicketInfoDTO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
/**
 * TwitterGetInfo ツイッターの照合が取れた際に商品一覧に遷移するための情報を取得してくるクラス
 * @author Y.Gouda
 * @since 2015/4/12
 * @version 1.0
 */
public class TwitterGetInfo extends ActionSupport implements SessionAware{
	/**
	 * @author Y.Gouda
	 * @since 2015/4/12
	 * session 		セッション
	 * numberList 	選択できる商品枚数
	 * ticketInfo	セッションに登録されている商品情報
	 * userIp 		ユーザーIP
	 */
	public Map<String,Object>session= new HashMap<String,Object>();
	public List<Integer> numberList = new ArrayList<Integer>();
	public List<TicketInfoDTO> ticketInfo = new ArrayList<TicketInfoDTO>();
	private String userIp;
	/**
	 * 実行メソッド
	 * @author Y.Gouda
	 * @since 2015/4/12
	 * @return SUCCESS 例外処理に入らなければSUCCESSを返す
	 * @see TicketInfoDAO
	 */
	public String execute (){
		TicketInfoDAO ticketInfoDao = new TicketInfoDAO();
		try {
			ticketInfo = ticketInfoDao.select();
			session.put("ticket_info", ticketInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}

		for(Integer i = 1; i < 21; i++){
			numberList.add(i);
		}
		session.put("numberList", numberList);
		userIp = getIP();
		session.put("user_ip", userIp);
		return SUCCESS;
	}
	/**
	 * IP取得メソッド
	 * @author Y.Gouda
	 * @since 2015/4/12
	 * @return ipAddress 例外処理に入らなければIPアドレスを返す
	 */
	public String getIP() {
		InetAddress addr;
		String ipAddress = null;
		try {
			addr = InetAddress.getLocalHost();
			ipAddress = addr.getHostAddress();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}

		return ipAddress;
	}

	public void setSession(Map<String, Object> session) {

		this.session = session;
	}

}
