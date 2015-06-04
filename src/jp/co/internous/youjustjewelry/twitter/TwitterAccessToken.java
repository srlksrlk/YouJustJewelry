package jp.co.internous.youjustjewelry.twitter;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.User;
import twitter4j.auth.AccessToken;
import twitter4j.auth.RequestToken;

/**
 * TwitterAccessToken アクセストークンを生成するクラス
 * @author T.Iwase
 * @since 2015/4/14
 * @version 1.0
 */
public class TwitterAccessToken {
	/**
	 * ユーザー情報取得用トークン取得メソッド
	 * @author T.Iwase
	 * @since 2015/4/14
	 * @return userData 例外処理に入らなければ条件によって値の異なるuserDataを返す
	 * @throws TwitterException
	 * @throws IOException
	 */
	public String[] loginOAuth(HttpServletResponse response,HttpServletRequest request) throws TwitterException, IOException{
		HttpSession session = request.getSession();
		Twitter twitter = (Twitter)session.getAttribute("Twitter");
		String verifier = request.getParameter("oauth_verifier");
		AccessToken accessToken = null;
		String userData[] = new String[2];

		try {
			if((session.getAttribute("RequestToken")!=null) || (request.getParameter("denied") != null)){
				accessToken = twitter.getOAuthAccessToken((RequestToken)session.getAttribute("RequestToken"),verifier);
			} else {
				return userData;
			}
		} catch (Exception e) {
		}
		if(accessToken != null) {
			session.setAttribute("AccessToken", accessToken.getToken());
			session.setAttribute("AccessTokenSecret", accessToken.getTokenSecret());
		}
		User user = twitter.verifyCredentials();

		userData[0] = user.getName();
		userData[1] = user.getScreenName();
		return userData;
	}
}
