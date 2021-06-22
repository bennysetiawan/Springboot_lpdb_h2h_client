/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.lpdb.h2h.agent.service;

import com.lpdb.h2h.agent.entity.PdcDetailMitra;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 *
 * @author jp
 */
public interface PdcDetailMitraService {

   Page<PdcDetailMitra> findAll(Pageable pageable);

   PdcDetailMitra getOne(String id);

   PdcDetailMitra save(PdcDetailMitra pdcDetail);

   PdcDetailMitra update(PdcDetailMitra pdcDetail);

   void deleteById(String id);
}
