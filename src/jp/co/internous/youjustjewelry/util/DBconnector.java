package jp.co.internous.youjustjewelry.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * データベースに接続するアクション
 * @author Y.Gouda
 * @since 2015/4/9
 * @version 1.0
 */
public class DBconnector {
	/**
     * @author Y.Gouda
     * @since 2015/4/9
	 * driverName		ドライブの名前
	 * URL				ウェブサイトのアドレス
	 * DB				データベース
	 * URLplusDB		ウェブサイトのアドレスとデータベース
	 * user				ユーザー
	 * pass				パスワード
	 */
    private static String driverName = "com.mysql.jdbc.Driver";
    private static String URL = "jdbc:mysql://localhost/";
    private static String DB = "youJustJewelry";
    private static String URLplusDB = URL.concat(DB);
    private static String user = "root";
    private static String pass = "mysql";
    /**
     * データーベースと接続して管理するメソッド
     * @author Y.Gouda
     * @since 2015/4/9
     * @return con 例外処理に入らなければコネクションを返す
     */
    public static Connection getConnection() {
        Connection con = null;
        try {
            Class.forName(driverName);
            con = DriverManager.getConnection(URLplusDB,user,pass);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}