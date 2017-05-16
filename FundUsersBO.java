package com.cts.cbc.Bo;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import com.cts.cbc.Dao.FundInfoDAO;
import com.cts.cbc.Dao.StockDetailsDAO;
import com.cts.cbc.Model.FundDetailsDTO;
import com.cts.cbc.Model.FundUserTransactionDTO;
import com.cts.cbc.Model.StockDetailsDTO;
import com.cts.cbc.Model.UsersOfFundDTO;

public class FundUsersBO {
	FundInfoDAO fundUserDao = new FundInfoDAO();
	
	public ArrayList<FundDetailsDTO> getAllFundsListBO() throws ClassNotFoundException, IOException, SQLException{
		ArrayList<FundDetailsDTO> fundList = new ArrayList<FundDetailsDTO>();
		fundList = fundUserDao.getAllFundsListDao();
		return fundList;
	}
	
	public ArrayList<UsersOfFundDTO> getFundUsersListByFundIdBO(String fundId) throws ClassNotFoundException, IOException, SQLException{
		FundDetailsDTO fundDetailsDto = new FundDetailsDTO();
		fundDetailsDto.setfundIdByString(fundId);
		ArrayList<UsersOfFundDTO> usersList = new ArrayList<UsersOfFundDTO>();
		usersList = fundUserDao.getUsersByFundIdDao(fundDetailsDto);
		return usersList;
	} 
	public ArrayList<StockDetailsDTO> getAllStocksDetailsBO() throws ClassNotFoundException, IOException, SQLException{
		StockDetailsDAO  stockDao = new StockDetailsDAO();
		ArrayList<StockDetailsDTO> stocksList = new ArrayList<StockDetailsDTO>();
		stocksList =  stockDao.getAllStocksDetailsDao();
		return stocksList;
	}
	
	public boolean buyStockforFundUsersBO(String fundId, int stockId, int noOfStocks,
				ArrayList<UsersOfFundDTO> fundUsersList) throws ClassNotFoundException, IOException, SQLException {
				
				float totalPriceOfStocsks;
				StockDetailsDAO stockDetailsDAO = new StockDetailsDAO();
				ChargeBackFundUsersBO chargeBackFundUsersBO = new ChargeBackFundUsersBO();
				ArrayList<FundUserTransactionDTO> fundTransDTOsList = new ArrayList<FundUserTransactionDTO>();
				
				totalPriceOfStocsks = stockDetailsDAO.getTotalStockPriceDao(stockId, noOfStocks);
				
				fundTransDTOsList = chargeBackFundUsersBO.chargeBackforEachUserInFund(fundId, stockId,
						noOfStocks, totalPriceOfStocsks, fundUsersList);
				
				
				
		
		return false;
	}
}
