/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.lpdb.h2h.agent.entity.h2h;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import lombok.Data;

/**
 *
 * @author jp
 */
@Data
public class Pdc implements Serializable {
   private String id;
   private Customer customer;
   //kemungkinan setiap mitra berbeda tipe datanya (int atau varchar)
	private String idMitra;
   private String namaMitra;
   private BigInteger idProposal;
   private Integer idPropPencarianKe;
   private Integer pdcNoCust;
   private Date pdcDateCust;
   private Date pdcDueDateCust;
   private String namaCust;
   private String pdcBankCodeCust;
   private String pdcBankNameCust;
   private String pdcAccRekeningCust;
   private Integer pdcInstallmentCust;
   private Integer pdcContractNoCust;
   private String pdcNoteCust;
   private BigDecimal pdcAmmountCust = BigDecimal.ZERO;
   private Date pdcInputDate;
   private List<PdcDetail> pdcDetails;

}
