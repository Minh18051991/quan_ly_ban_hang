package org.example.quan_ly_ban_hang.service.stock;

import org.example.quan_ly_ban_hang.dto.StockDTO;
import org.example.quan_ly_ban_hang.model.Stock;

import java.util.List;
public interface IStockService {
     void insert(StockDTO stockDTO);
     void update( int quantity,int id);
     void delete(int id);
     Stock select(int id);
     List<StockDTO> selectAll();
}
