/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.lpdb.h2h.agent.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
@Table(name = "tb_pdc")
@JsonIgnoreProperties(ignoreUnknown = true)
public class PdcMitra implements Serializable {

   @Id
   @GeneratedValue(generator = "uuid")
   @GenericGenerator(name = "uuid", strategy = "uuid2")
   @Column(name = "id_pdc", length = 49, unique = true, nullable = false)
   private String id;

   //perbedaan database lpdb dengan mitra adalah relasi-nya
   @ManyToOne
   @JoinColumn(name = "id_cust", unique = false, nullable = false)
   private CustomerMitra customer;
   
   //kemungkinan setiap mitra berbeda tipe datanya (int atau varchar)
   @Column(name = "id_mitra", length = 25, unique = false, nullable = true)
	private String idMitra;
   
   @Column(name = "nama_mitra", length = 55, unique = false, nullable = true)
	private String namaMitra;

   @Column(name = "id_proposal", length = 25, unique = false, nullable = false)
   private BigInteger idProposal;

   @Column(name = "id_prop_pencairan_ke", length = 3, unique = false, nullable = true)
   private Integer idPropPencairanKe;

   @Column(name = "pdc_no_cust", length = 11, unique = false, nullable = false)
   private Integer pdcNoCust;

   @Temporal(TemporalType.DATE)
   @Column(name = "pdc_date_cust", unique = false, nullable = true)
   private Date pdcDateCust;
   
   @Temporal(TemporalType.DATE)
   @Column(name = "pdc_due_date_cust", unique = false, nullable = true)
   private Date pdcDueDateCust;

   @Column(name = "pdc_bank_code_cust", length = 7, unique = false, nullable = true)
   private String pdcBankCodeCust;

   @Column(name = "pdc_bank_name_cust", length = 45, unique = false, nullable = true)
   private String pdcBankNameCust;

   @Column(name = "pdc_acc_rekening_cust", length = 25, unique = false, nullable = true)
   private String pdcAccRekeningCust;

   @Column(name = "pdc_installment_cust", length = 11, unique = false, nullable = true)
   private Integer pdcInstallmentCust;

   @Column(name = "pdc_contract_no_cust", length = 11, unique = false, nullable = true)
   private Integer pdcContractNoCust;

   @Column(name = "pdc_note_cust", length = 255, unique = false, nullable = true)
   private String pdcNoteCust;

   @Column(name = "pdc_ammount_cust", unique = false, nullable = true, precision = 15, scale = 0)
   private BigDecimal pdcAmmountCust = BigDecimal.ZERO;
   
   @Temporal(TemporalType.DATE)
   @Column(name = "pdc_input_date", unique = false, nullable = false)
   private Date pdcInputDate;
   
   //orphanRemoval = true : agar bisa menghapus salah satu : salesDetails
   @OneToMany(mappedBy = "pdc", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
   @JsonManagedReference
   private List<PdcDetailMitra> pdcDetails;

}
