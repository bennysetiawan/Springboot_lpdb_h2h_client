/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.lpdb.h2h.agent.service.impl;

import com.lpdb.h2h.agent.entity.CustomerMitra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lpdb.h2h.agent.repository.CustomerMitraRepository;
import com.lpdb.h2h.agent.service.CustomerMitraService;

/**
 *
 * @author jp
 */
@Service
@Transactional
public class CustomerMitraServiceImpl implements CustomerMitraService {
   
   @Autowired
   private CustomerMitraRepository customerRepository;

   @Override
   public Page<CustomerMitra> findAll(Pageable pageable) {
      return customerRepository.findAll(pageable);
   }
   
   @Override
   public CustomerMitra getOne(String id) {
      return customerRepository.getOne(id);
   }

   @Override
   public CustomerMitra save(CustomerMitra customer) {
      return customerRepository.save(customer);
   }

   @Override
   public CustomerMitra update(CustomerMitra customer) {
      return customerRepository.save(customer);
   }

   @Override
   public void deleteById(String id) {
      customerRepository.deleteById(id);
   }
   
}
