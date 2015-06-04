package jp.co.internous.youjustjewelry.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jp.co.internous.youjustjewelry.dto.TicketInfoDTO;
import jp.co.internous.youjustjewelry.util.DBconnector;

/**
 * 商品一覧に表示させる商品情報を取得するためのDAOクラス
 * @author Y.Gouda
 * @since 2015/4/15
 * @version 1.0
 */
public class TicketInfoDAO {
	Connection con;
	String firstName;
	boolean res;
	public List<TicketInfoDTO> ticketInfo = new ArrayList<TicketInfoDTO>();
/**
 * DBticket_infoにアクセスしてテーブル内の情報をList<DTO>に格納するメソッド
 * @author Y.Gouda
 * @since 2015/4/15
 * @return res 例外処理に入らなければレスポンスを返す
 * @throws Exception
 * @see TicketInfoDTO
 */
	public List<TicketInfoDTO> select()throws Exception{
		res = false;
		con = DBconnector.getConnection();

		try{

			String sql = "SELECT * FROM ticket_info";
			PreparedStatement ps;
			ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();


			while(rs.next()){
				res = true;
				TicketInfoDTO dto = new TicketInfoDTO();
				dto.setTicketId(rs.getInt(1));
				dto.setTicketName(rs.getString(2));
				dto.setPrice(rs.getInt(3));
				dto.setStock(rs.getInt(4));
				ticketInfo.add(dto);
			}

		}catch(Exception e){
			e.printStackTrace();
		}finally{
			con.close();
		}
		return ticketInfo;
	}
}
