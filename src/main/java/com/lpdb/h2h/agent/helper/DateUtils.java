/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.lpdb.h2h.agent.helper;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author jepesoft
 */
public class DateUtils {
   
   private static final SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd");
   
   public static String dateToYearsString(Date date) {
      return sd.format(date);
   }
   
}
