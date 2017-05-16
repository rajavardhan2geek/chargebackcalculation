package com.cts.cbc.Constants;

public class QueryConstants {
	public static final String GETFUNDSLIST = "select * from fund_details";
	public static final String 	GETUSERINFOBYFUNDID = "select fu.user_id_master,um.firstname,fu.available_balance from " +
			"fund_users fu, user_master um where um.user_id=fu.user_id_master and fund_id=?";
	public static final String GETALLSTOCKSDETAILS = "select stock_id, stock_name, stock_price from stock_details";
	public static final String GET_STOCK_PRICE_BY_STOCKID = "select stock_price from stock_details where stock_id=?";
}
