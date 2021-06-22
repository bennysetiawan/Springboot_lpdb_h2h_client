/*
* SEMUA HANYA MILIK ALLAH
* MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
* TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.lpdb.h2h.agent.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

/**
 *
 * @author jp
 */
@Data
@Entity
@Table(name = "tb_pdc_detail")
public class PdcDetailMitra implements Serializable {

   @Id
//   @GeneratedValue(generator = "uuid")
//   @GenericGenerator(name = "uuid", strategy = "uuid2")
   @Column(name = "id_pdc_detail", length = 55, unique = true, nullable = false)
   private String id;
   
   @ManyToOne
   @JoinColumn(name = "id_pdc", unique = false, nullable = false, updatable = true)
   @JsonBackReference
   private PdcMitra pdc;
   
   @Column(name="cust_angs_ke", length = 2, unique = false, nullable = false)
	private Integer custAngsKe;
	
   @Temporal(TemporalType.DATE)
	@Column(name="cust_tgl_jt_tempo", unique = false, nullable = true)
	private Date custTglJtTempo;
	
   @Column(name = "cust_saldo_pokok", unique = false, nullable = true, precision = 15, scale = 0)
	private BigDecimal custSaldoPokok = BigDecimal.ZERO;
	
   @Column(name = "cust_saldo_basil", unique = false, nullable = true, precision = 15, scale = 0)
	private BigDecimal custSaldoBasil = BigDecimal.ZERO;
	
   @Column(name = "cust_bayar_pokok", unique = false, nullable = true, precision = 15, scale = 0)
	private BigDecimal custBayarPokok = BigDecimal.ZERO;
	
   @Column(name = "cust_bayar_basil", unique = false, nullable = true, precision = 15, scale = 0)
	private BigDecimal custBayarBasil = BigDecimal.ZERO;
	
   @Temporal(TemporalType.DATE)
	@Column(name="cust_tgl_bayar_pokok", unique = false, nullable = true)
	private Date custTglBayarPokok;
	
   @Temporal(TemporalType.DATE)
	@Column(name="cust_tgl_bayar_basil", unique = false, nullable = true)
	private Date custTglBayarBasil;
	
   @Column(name = "cust_jumlah_denda", unique = false, nullable = true, precision = 15, scale = 0)
	private BigDecimal custJumlahDenda = BigDecimal.ZERO;
	
   @Column(name = "cust_bayar_denda", unique = false, nullable = true, precision = 15, scale = 0)
	private BigDecimal custBayarDenda = BigDecimal.ZERO;
	
   @Temporal(TemporalType.DATE)
	@Column(name="cust_tgl_bayar_denda", unique = false, nullable = true)
	private Date cust_tglBayarDenda;
	
	@Column(name="rev_no", length = 11, unique = false, nullable = true)
	private Integer revNo;

}
