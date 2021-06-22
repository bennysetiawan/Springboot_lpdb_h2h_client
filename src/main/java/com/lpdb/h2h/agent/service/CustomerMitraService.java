/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.lpdb.h2h.agent.service;

import com.lpdb.h2h.agent.entity.CustomerMitra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author jp
 */
public interface CustomerMitraService {

   Page<CustomerMitra> findAll(Pageable pageable);

   CustomerMitra getOne(String id);

   CustomerMitra save(CustomerMitra customer);

   CustomerMitra update(CustomerMitra customer);

   void deleteById(String id);
}
