/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.lpdb.h2h.agent.service;

import com.lpdb.h2h.agent.entity.PdcMitra;
import com.lpdb.h2h.agent.exceptions.PdcMitraException;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author jp
 */
public interface PdcMitraService {

   Page<PdcMitra> findAll(Pageable pageable);
   
   List<PdcMitra> findAllByCurrentDate(String currentDate);

   PdcMitra getOne(String id);

   PdcMitra save(PdcMitra pdcData) throws PdcMitraException;

   PdcMitra update(PdcMitra pdcData);

   void deleteById(String id);
}
