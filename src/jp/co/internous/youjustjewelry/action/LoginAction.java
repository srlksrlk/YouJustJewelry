package jp.co.internous.youjustjewelry.action;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jp.co.internous.youjustjewelry.dao.LoginDAO;
import jp.co.internous.youjustjewelry.dao.TicketInfoDAO;
import jp.co.internous.youjustjewelry.dto.TicketInfoDTO;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * LoginAction ログイン画面から商品一覧画面へと遷移するアクションクラス
 * @author Y.Gouda
 * @since 2015/4/9
 * @version 1.0
 */
public class LoginAction extends ActionSupport implements SessionAware{
	/**
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * email_id    EメールorID
	 * pass        パスワード
	 * firstName   名前
	 * userIp      ユーザーIP
	 * result      実行結果を返す
	 * session     セッション
	 * ticketInfo  セッションに登録されている商品情報
	 * numberList  選択できる商品枚数
	 */
	private String email_id;
	private String pass;
	private String firstName;
	private String userIp;
	private String result;
	public Map<String,Object>session= new HashMap<String,Object>();
	private List<TicketInfoDTO> ticketInfo = new ArrayList<TicketInfoDTO>();
	private List<Integer> numberList = new ArrayList<Integer>();
	HttpServletRequest req;
	/**
	 * 入力されたユーザー情報をＤＢと照合し、resultを返すメソッド
	 *  @author Y.Gouda
	 *  @since 2015/4/9
	 *  @return result 実行結果を返す
	 */
	public String execute() throws Exception{

		result = ERROR;

		userIp = getIP();
		LoginDAO loginDao = new LoginDAO();

		boolean res = loginDao.select(email_id, pass);
		if(res){
			TicketInfoDAO ticketInfoDao = new TicketInfoDAO();
			ticketInfo = ticketInfoDao.select();
			session.put("ticket_info", ticketInfo);
			for(Integer i = 1; i < 21; i++){
				numberList.add(i);
			}
			session.put("numberList", numberList);
			result = SUCCESS;
		}
		session.put("user_name", loginDao.getFirstName());
		session.put("user_id", loginDao.getUserId());
		session.put("user_ip", userIp);

		return result;
	}
	/**
	 * EメールorID取得メソッド
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * @return email_id EメールorIDを返す
	 */
	public String getEmail_id() {
		return email_id;
	}
	/**
	 * EメールorID登録メソッド
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * @param email_id EメールorID
	 */
	public void setEmail_id(String email_id) {
		this.email_id = email_id;
	}
	/**
	 * パスワード取得メソッド
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * @return pass パスワードを返す
	 */
	public String getPass() {
		return pass;
	}
	/**
	 * パスワード登録メソッド
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * @param pass パスワード
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}
	/**
	 * 名前取得メソッド
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * @return firstName 名前を返す
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * 名前登録メソッド
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * @param firstName 名前
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * セッション取得メソッド
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * @return session セッションを返す
	 */
	public Map<String, Object> getSession() {
		return session;
	}
	/**
	 * セッション登録メソッド
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * @param session セッションを保存するマップ
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
	/**
	 * IPを取得するメソッド
	 * @author Y.Gouda
	 * @since 2015/4/9
	 * @return ipAddress ipAddressを返す
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

}
