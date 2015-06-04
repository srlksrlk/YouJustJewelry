package jp.co.internous.youjustjewelry.action;


import java.util.Map;

import org.apache.struts2.dispatcher.SessionMap;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * LogOutAction ログアウト画面へと遷移するアクションクラス
 * @author Y.Matsukawa
 * @since 2015/04/13
 * @version 1.0
 */
public class LogoutAction extends ActionSupport implements SessionAware {
	/**
	 * @author Y.Matsukawa
	 * @since 2015/04/13
	 * session  セッション
	 */
	public Map<String, Object> session;
	/**
	 * ログイン情報を破棄しログアウト画面へ遷移するメソッド
	 * @author Y.Matsukawa
	 * @since 2015/04/13
	 * @return SUCCESS 例外処理に入らなければSUCCESSを返す
	 */
	public String execute() {
		try {
			session.clear();
			((SessionMap)session).invalidate();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return SUCCESS;
	}
	/**
	 * @author Y.Matsukawa
	 * @since 2015/04/13
	 * @return session セッションを返す
	 */
	public Map<String, Object> getSession() {
		return session;
	}
	/**
	 * @author Y.Matsukawa
	 * @since 2015/04/13
	 * @param session セッション
	 */
	public void setSession(Map<String, Object> session) {
		this.session = session;
	}
}
