package com.pharmazealapi.service;

import com.pharmazealapi.dto.DTOFactory;
import com.pharmazealapi.dto.SalesDTO;
import com.pharmazealapi.dto.SalesItemDTO;
import com.pharmazealapi.entity.*;
import com.pharmazealapi.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
}
