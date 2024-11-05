package org.example.quan_ly_ban_hang.repository.stockRepository;

import org.example.quan_ly_ban_hang.dto.StockDTO;
import org.example.quan_ly_ban_hang.model.Stock;

import java.util.List;

public interface IStockRepository {
    public void insert(StockDTO stockDTO);
    public void update(int quantity,int id);
    public void delete(int id);
    public Stock select(int id);
    public List<StockDTO> selectAll();
}
