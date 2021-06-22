/*
* SEMUA HANYA MILIK ALLAH
* MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
* TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.lpdb.h2h.agent.entity.h2h;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import lombok.Data;

/**
 *
 * @author jp
 */
@Data
public class PdcDetail implements Serializable {

   private String id;
   private Pdc pdc;
	private Integer custAngsKe;
	private Date custTglJtTempo;
	private BigDecimal custSaldoPokok = BigDecimal.ZERO;
	private BigDecimal custSaldoBasil = BigDecimal.ZERO;
	private BigDecimal custBayarPokok = BigDecimal.ZERO;
	private BigDecimal custBayarBasil = BigDecimal.ZERO;
	private Date custTglBayarPokok;
	private Date custTglBayarBasil;
	private BigDecimal custJumlahDenda = BigDecimal.ZERO;
	private BigDecimal custBayarDenda = BigDecimal.ZERO;
	private Date cust_tglBayarDenda;
	private Integer revNo;

}
