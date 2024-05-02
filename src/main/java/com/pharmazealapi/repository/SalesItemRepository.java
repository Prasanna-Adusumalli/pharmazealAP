package com.pharmazealapi.repository;

import com.pharmazealapi.entity.SalesItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SalesItemRepository extends JpaRepository<SalesItem,Integer> {
    List<SalesItem> findSalesItemsBySalesId(int salesId);
}
