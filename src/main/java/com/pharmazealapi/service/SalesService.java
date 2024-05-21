package com.pharmazealapi.service;

import com.pharmazealapi.dto.*;
import com.pharmazealapi.entity.*;
import com.pharmazealapi.repository.*;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.util.Assert.notNull;

@Service
@AllArgsConstructor
public class SalesService {
    private final SalesRepository salesRepository;
    private final SalesItemRepository salesItemRepository;
    private final LocationRepository locationRepository;
    private final DrugRepository drugRepository;
    private final CustomerRepository customerRepository;
    private final UserRepository userRepository;
    @Autowired
    private DTOFactory dtoFactory;
    @Autowired
    private EntityFactory entityFactory;

  // To get list of sales based on location
    public List<SalesDTO> getSalesByLocation(String locationName){
        List<SalesDTO> salesDTOList=new ArrayList<>();
        Location location=locationRepository.findByLocationNameEqualsIgnoreCase(locationName).orElse(null);
        List<Sales> salesList=salesRepository.findAllByLocationId(location.getLocationId());
        for(Sales sale:salesList){
            List<SalesItemDTO> salesItemDTOList=new ArrayList<>();
            Double price=0.00;
           List<SalesItem> salesItemsList=salesItemRepository.findSalesItemsBySalesId(sale.getSalesId());
           for( SalesItem salesItem:salesItemsList){
               Drug drug=drugRepository.findById(salesItem.getDrugId()).get();
               salesItemDTOList.add(dtoFactory.createSalesItemDTO(salesItem,drug));
               price+= salesItem.getPrice();
           }
           User user=userRepository.findById(sale.getEmployeeId()).get();
           Customer customer=customerRepository.findById(sale.getCustomerNHS()).get();
           salesDTOList.add(dtoFactory.createSalesDTO(sale,location,customer,user,price,salesItemDTOList));
        }
        return salesDTOList;
    }

    @Transactional
    public boolean addSales(NewSaleDTO newSaleDTO){
        Location location=locationRepository.findByLocationNameEqualsIgnoreCase(newSaleDTO.getLocation()).orElse(null);
        User user=userRepository.findByEmail(newSaleDTO.getEmployeeEmail()).get();
        Sales sales=salesRepository.saveAndFlush(entityFactory.createSalesEntity(location,user,newSaleDTO));
        for(NewSaleItemDTO newSaleItemDTO:newSaleDTO.getSalesItemDTOList()){
            Drug drug=drugRepository.findByNameAndAndHealthCondition(newSaleItemDTO.getDrugName(),newSaleItemDTO.getCondition()).get();
            salesItemRepository.save(entityFactory.createSalesItemEntity(sales,drug,newSaleItemDTO));
        }
        if (sales!=null && sales.getSalesId()>0)
            return true;
        else
            return false;
    }
}
