/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.lpdb.h2h.agent.repository;

import com.lpdb.h2h.agent.entity.PdcMitra;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author jp
 */
public interface PdcMitraRepository extends JpaRepository<PdcMitra, String> {
   
   @Query("SELECT t FROM PdcMitra t WHERE date(t.pdcInputDate)=date(:currentDate) ORDER BY t.pdcInputDate ASC")
   List<PdcMitra> findAllByCurrentDate(@Param("currentDate") String currentDate);

}
