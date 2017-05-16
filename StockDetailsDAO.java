package com.cts.cbc.Dao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.cts.cbc.Constants.QueryConstants;
import com.cts.cbc.Model.StockDetailsDTO;
import com.cts.cbc.util.Dbutil;

public class StockDetailsDAO {
	private Connection connection;
	
	public ArrayList<StockDetailsDTO> getAllStocksDetailsDao() throws ClassNotFoundException, IOException, SQLException{
		
		connection = Dbutil.getConnection();
		ArrayList<StockDetailsDTO> stockList = new ArrayList<StockDetailsDTO>();
		PreparedStatement preparedStatement = connection.prepareStatement(QueryConstants.GETALLSTOCKSDETAILS);
		
		ResultSet stockSet = preparedStatement.executeQuery();
		
		while(stockSet.next()){
			StockDetailsDTO stockInfo = new StockDetailsDTO();
			stockInfo.setStockId(stockSet.getInt(1));
			stockInfo.setSotckName(stockSet.getString(2));
			stockInfo.setStockPrice(stockSet.getFloat(3));
			stockList.add(stockInfo);
		}
		connection.close();
		return stockList;
	}
	
	public float getTotalStockPriceDao(int stockId, int noOfStocks) throws ClassNotFoundException, IOException, SQLException{
		float totalPrice;
		float pricePerUnit;
		
		pricePerUnit = getStockPriceById(stockId);
		totalPrice = noOfStocks * pricePerUnit;
		
		return totalPrice;
	}
	
	public float getStockPriceById(int stockId) throws ClassNotFoundException, IOException, SQLException{
		connection = Dbutil.getConnection();
		float price = 0;
		PreparedStatement preparedStatement = connection.prepareStatement(QueryConstants.GET_STOCK_PRICE_BY_STOCKID);
		preparedStatement.setInt(1, stockId);
		ResultSet executeQuery = preparedStatement.executeQuery();
		
		while(executeQuery.next()){
			 price = executeQuery.getFloat(1);
		}
		connection.close();
		return price;
	}
}
