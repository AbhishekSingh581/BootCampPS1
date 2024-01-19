package com.example.BootCamp.PS1.Dao.TradesDao;

import com.example.BootCamp.PS1.Model.Trade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TradesJPARepo extends JpaRepository<Trade,Long> {

}
