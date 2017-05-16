package com.cts.cbc.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.cts.cbc.Constants.QueryConstants;
import com.cts.cbc.Model.*;
import com.cts.cbc.util.Dbutil;


public class FundInfoDAO {
	private Connection connection;
	public ArrayList<FundDetailsDTO> getAllFundsListDao() throws ClassNotFoundException, IOException, SQLException {
		ArrayList<FundDetailsDTO> fundList = new ArrayList<FundDetailsDTO>();
		connection = Dbutil.getConnection();
		
		if(connection != null){
			System.out.println("Db connection Established in fundInfoDao");
			PreparedStatement preparedStatement = connection
			.prepareStatement(QueryConstants.GETFUNDSLIST);
			ResultSet fundsResult = preparedStatement.executeQuery();
			
			while(fundsResult.next()){
				FundDetailsDTO fund = new FundDetailsDTO();
				fund.setfundIdByInt(fundsResult.getInt(1));
				fund.setFundName(fundsResult.getString(2));
				fundList.add(fund);
			}
			
		}
		else {
			System.out.println("Db connection Problem");
		}
		connection.close();
		return fundList;
	}
	
	public ArrayList<UsersOfFundDTO> getUsersByFundIdDao(FundDetailsDTO fundDetails) throws ClassNotFoundException, IOException, SQLException{
		ArrayList<UsersOfFundDTO> usersList = new ArrayList<UsersOfFundDTO>();
		int fundId = fundDetails.getfundIdByInt();
		connection = Dbutil.getConnection();
		
		if(connection != null){
			PreparedStatement preparedStatement = connection
			.prepareStatement(QueryConstants.GETUSERINFOBYFUNDID);
			preparedStatement.setInt(1, fundId);
			ResultSet fundsResult = preparedStatement.executeQuery();
			while(fundsResult.next()){
				
				UsersOfFundDTO user = new UsersOfFundDTO();
				
				user.setUserIdByInt(fundsResult.getInt(1));
				
				user.setName(fundsResult.getString(2));
				
				user.setBalanceAmountLeft(fundsResult.getDouble(3));
				usersList.add(user);
			}
		}
		connection.close();
		return usersList;
		
	}
	
	public String getFunduserBalanceByUserId(String userID){
		String balance = null;
		return balance;
	}
}
