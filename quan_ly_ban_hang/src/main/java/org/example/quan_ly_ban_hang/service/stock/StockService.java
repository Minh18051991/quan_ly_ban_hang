package org.example.quan_ly_ban_hang.service.stock;

import org.example.quan_ly_ban_hang.dto.StockDTO;
import org.example.quan_ly_ban_hang.model.Stock;
import org.example.quan_ly_ban_hang.repository.stockRepository.IStockRepository;
import org.example.quan_ly_ban_hang.repository.stockRepository.StockRepository;

import java.util.List;

public class StockService implements IStockService {
    IStockRepository stockRepository = new StockRepository();
    @Override
    public void insert(StockDTO stockDTO) {
        stockRepository.insert(stockDTO);
    }

    @Override
    public void update( int quantity,int id) {
        stockRepository.update(  quantity, id);
    }

    @Override
    public void delete(int id) {
        stockRepository.delete(id);
    }

    @Override
    public Stock select(int id) {
       return stockRepository.select(id);
    }

    @Override
    public List<StockDTO> selectAll() {
        return stockRepository.selectAll();
    }
}
