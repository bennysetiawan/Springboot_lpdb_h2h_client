/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.lpdb.h2h.agent.service.impl;

import com.lpdb.h2h.agent.entity.PdcMitra;
import com.lpdb.h2h.agent.exceptions.PdcMitraException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.lpdb.h2h.agent.repository.PdcMitraRepository;
import com.lpdb.h2h.agent.service.PdcMitraService;
import java.util.List;

/**
 *
 * @author jp
 */
@Service
@Transactional
public class PdcMitraServiceImpl implements PdcMitraService {
   
   @Autowired
   private PdcMitraRepository pdcDataRepository;

   @Override
   public Page<PdcMitra> findAll(Pageable pageable) {
      return pdcDataRepository.findAll(pageable);
   }
   
   @Override
   public List<PdcMitra> findAllByCurrentDate(String currentDate) {
      return pdcDataRepository.findAllByCurrentDate(currentDate);
   }
   
   @Override
   public PdcMitra getOne(String id) {
      return pdcDataRepository.getOne(id);
   }

   @Override
   public PdcMitra save(PdcMitra pdc) throws PdcMitraException {
      return pdcDataRepository.save(pdc);
   }

   @Override
   public PdcMitra update(PdcMitra pdc) {
      return pdcDataRepository.save(pdc);
   }

   @Override
   public void deleteById(String id) {
      pdcDataRepository.deleteById(id);
   }
   
}
