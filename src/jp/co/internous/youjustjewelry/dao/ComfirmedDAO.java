package jp.co.internous.youjustjewelry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.List;

import jp.co.internous.youjustjewelry.dto.GoodsCartDTO;
import jp.co.internous.youjustjewelry.util.DBconnector;

/**
 * ComfirmedDAO  ComfirmedActionがDBにアクセスするためのDAOクラス
 * @author Y.Gouda
 * @since 2015/4/18
 * @version 1.0
 */

public class ComfirmedDAO{
	/**
	 * @author Y.Gouda
	 * @since 2015/4/18
	 * res        レスポンス
	 * orderInfo  セッションに登録されている注文情報
	 */
	boolean res;
	public List<GoodsCartDTO> orderInfo = new ArrayList<GoodsCartDTO>();
	/**
	 * DBhistoryにアクセスして注文された情報を格納するためのメソッド
	 * @author Y.Gouda
	 * @since 2015/4/18
	 * @param userId      ユーザーID
	 * @param ticketId    商品ID
	 * @param ticketCount 商品単体注文枚数
	 * @param totalAmount 商品単体注文総額
	 * @param userIp      ユーザーIP
	 * @return res        例外処理に入らなければレスポンスを返す
	 * @throws Exception
	 * @see GoodsCartDTO
	 * @see DBconnector
	 */
	public boolean insert (String userId, int ticketId, int ticketCount, int totalAmount, String userIp) throws Exception{

		res = false;

		Connection con = DBconnector.getConnection();
		try{
			String sql = "INSERT INTO history (user_id, ticket_id, ticket_count, total_amount, user_ip)VALUE(?, ?, ?, ?, ?);";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);
			ps.setString(1, userId);
			ps.setInt(2, ticketId);
			ps.setInt(3, ticketCount);
			ps.setInt(4, totalAmount);
			ps.setString(5, userIp);
			ps.executeUpdate();

			res = true;
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();

		}

		return res;

	}
}