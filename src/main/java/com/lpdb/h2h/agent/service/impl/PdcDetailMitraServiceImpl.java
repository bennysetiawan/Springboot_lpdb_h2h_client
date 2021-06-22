/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.lpdb.h2h.agent.service.impl;

import com.lpdb.h2h.agent.entity.PdcDetailMitra;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lpdb.h2h.agent.repository.PdcDetailMitraRepository;
import com.lpdb.h2h.agent.service.PdcDetailMitraService;

/**
 *
 * @author jp
 */
@Service
@Transactional
public class PdcDetailMitraServiceImpl implements PdcDetailMitraService {
   
   @Autowired
   private PdcDetailMitraRepository pdcDetailRepository;

   @Override
   public Page<PdcDetailMitra> findAll(Pageable pageable) {
      return pdcDetailRepository.findAll(pageable);
   }
   
   @Override
   public PdcDetailMitra getOne(String id) {
      return pdcDetailRepository.getOne(id);
   }

   @Override
   public PdcDetailMitra save(PdcDetailMitra pdcDetail) {
      return pdcDetailRepository.save(pdcDetail);
   }

   @Override
   public PdcDetailMitra update(PdcDetailMitra pdcDetail) {
      return pdcDetailRepository.save(pdcDetail);
   }

   @Override
   public void deleteById(String id) {
      pdcDetailRepository.deleteById(id);
   }
   
}
