package jp.co.internous.youjustjewelry.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jp.co.internous.youjustjewelry.dao.TicketInfoDAO;
import jp.co.internous.youjustjewelry.twitter.TwitterAccessToken;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

/**
 * LoginTwitterAction  Twitter認証画面へと遷移するためのアクションクラス
 * @author T.Iwase
 * @since 2015/4/18
 * @version 1.0
 */

public class LoginTwitterAction extends ActionSupport implements ServletResponseAware,ServletRequestAware,SessionAware{
	/**
	 * @author T.Iwase
	 * @since 2015/4/18
	 * session   セッション
	 * response  レスポンス
	 * request   リクエスト
	 * userData  ユーザー情報
	 * result    実行結果を返す
	 */
	public Map<String, Object> session;
	private HttpServletResponse response;
	private HttpServletRequest request;
	private String[] userData=new String[2];
	private String result;
	/**
	 * 実行メソッド
	 * @author T.Iwase
	 * @since 2015/4/18
	 * @return result 実行結果を返す
	 * @throws Exception
	 * @see TwitterAccessToken
	 * @see TicketInfoDAO
	 */
	public String execute() throws Exception{
		result = ERROR;
		TwitterAccessToken twitter = new TwitterAccessToken();

		userData = twitter.loginOAuth(response, request);

		if(userData[0] != null){
		session.put("NAME", userData[0]);
		session.put("user_name", userData[1]);

		TicketInfoDAO ticketInfoDao = new TicketInfoDAO();
		ticketInfoDao.select();
		result = SUCCESS;
		}

		return result;
	}
	/**
	 * レスポンス格納メソッド
	 * @author T.Iwase
	 * @since 2015/4/18
	 * @param response レスポンス
	 */
	public void setServletResponse(HttpServletResponse response) {
		this.response = response;
	}
	/**
	 * リクエスト格納メソッド
	 * @author T.Iwase
	 * @since 2015/4/18
	 * @param request リクエストを返す
	 */
	public void setServletRequest(HttpServletRequest request) {
		this.request=request;
	}
	/**
	 * セッション格納メソッド
	 * @author T.Iwase
	 * @since 2015/4/18
	 * @param session セッションに保存するMap
	 */
	public void setSession(Map<String, Object> session) {
		this.session=session;

	}

}
