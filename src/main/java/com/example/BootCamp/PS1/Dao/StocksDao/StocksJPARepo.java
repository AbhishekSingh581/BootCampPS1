package com.example.BootCamp.PS1.Dao.StocksDao;

import com.example.BootCamp.PS1.Model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StocksJPARepo extends JpaRepository<Stock,String> {
}
