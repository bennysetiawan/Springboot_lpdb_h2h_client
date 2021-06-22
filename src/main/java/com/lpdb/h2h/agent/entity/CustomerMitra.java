/*
 * SEMUA HANYA MILIK ALLAH
 * MAHA SUCI ALLAH, SEGALA PUJI BAGI ALLAH, TIDAK ADA TUHAN SELAIN ALLAH, MAHA BESAR ALLAH
 * TIDAK ADA DAYA DAN UPAYA KECUALI DENGAN PERTOLONGAN ALLAH
 */
package com.lpdb.h2h.agent.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
@Table(name = "tb_customer")
public class CustomerMitra implements Serializable {

   @Id
   @GeneratedValue(generator = "uuid")
   @GenericGenerator(name = "uuid", strategy = "uuid2")
   @Column(name = "id_cust", length = 49, unique = true, nullable = false)
   private String id;
   
   @Column(name = "nama_cust", length = 45, unique = false, nullable = true)
   private String namaCust;

//   @Column(name = "id_koperasi", length = 55, unique = false, nullable = true)
//   private String idKoperasi;
//
//   @Column(name = "cust_nik", length = 25, unique = false, nullable = true)
//   private String custNik;
//
//   @Column(name = "cust_age", length = 2, unique = false, nullable = true)
//   private Integer custAge;
//   
//   @Column(name = "cust_jenis_kelamin", length = 1, unique = false, nullable = true)
//   private Integer custJenisKelamin;
//
//   @Column(name = "cust_nama_usaha", length = 150, unique = false, nullable = true)
//   private String custNamaUsaha;
//
//   @Column(name = "cust_sektor_usaha", length = 150, unique = false, nullable = true)
//   private String custSektorUsaha;
//
//   @Column(name = "cust_bidang_usaha", length = 150, unique = false, nullable = true)
//   private String custBidangUsaha;
//
//   @Column(name = "cus_sektor_usaha_detil", length = 255, unique = false, nullable = true)
//   private String cusSektorUsahaDetil;
//
//   @Column(name = "cust_omset", unique = false, nullable = true, precision = 15, scale = 0)
//   private BigDecimal custOmset = BigDecimal.ZERO;
//
//   @Column(name = "cust_asset", unique = false, nullable = true, precision = 15, scale = 0)
//   private BigDecimal custAsset = BigDecimal.ZERO;
//
//   @Column(name = "cust_alamat_usaha", length = 255, unique = false, nullable = true)
//   private String custAlamatUsaha;
//
//   @Column(name = "cust_penanggung_jawab", length = 55, unique = false, nullable = true)
//   private String custPenanggungJawab;
//
//   @Column(name = "cust_jum_tenaga_kerja", length = 7, unique = false, nullable = true)
//   private Integer custJumTenagaKerja;
//
//   @Column(name = "cust_no_telp", length = 32, unique = false, nullable = true)
//   private String custNoTelp;
//
//   @Column(name = "cust_alamat", length = 255, unique = false, nullable = true)
//   private String custAlamat;
//
//   @Column(name = "cust_prov", length = 35, unique = false, nullable = true)
//   private String custProv;
//
//   @Column(name = "cust_kab", length = 35, unique = false, nullable = true)
//   private String custKab;
//
//   @Column(name = "cust_kec", length = 35, unique = false, nullable = true)
//   private String custKec;
//
//   @Column(name = "cust_pemanfaatan", length = 3, unique = false, nullable = true)
//   private Integer custPemanfaatan;
//
//   @Column(name = "cust_plafon_pengajuan", unique = false, nullable = true, precision = 15, scale = 0)
//   private BigDecimal custPlafonPengajuan = BigDecimal.ZERO;
//
//   @Column(name = "cust_akad_jenis", length = 3, unique = false, nullable = true)
//   private Integer custAkadJenis;
//
//   @Temporal(TemporalType.DATE)
//   @Column(name = "cust_akad_tgl", unique = false, nullable = true)
//   private Date custAkadTgl;
//
//   @Temporal(TemporalType.DATE)
//   @Column(name = "cust_realisasi_tgl", unique = false, nullable = true)
//   private Date custRealisasiTgl;
//
//   @Column(name = "cust_realisasi_nilai", unique = false, nullable = true, precision = 15, scale = 0)
//   private BigDecimal custRealisasiNilai = BigDecimal.ZERO;
//
//   @Column(name = "cust_sisa_dana", unique = false, nullable = true, precision = 15, scale = 0)
//   private BigDecimal custSisaDana = BigDecimal.ZERO;
//
//   @Column(name = "cust_jangka_waktu", length = 3, unique = false, nullable = true)
//   private Integer custJangkaWaktu;
//
//   @Column(name = "cust_satuan_waktu", length = 2, unique = false, nullable = true)
//   private Integer custSatuanWaktu;
//
//   @Column(name = "cust_pola_bunga", length = 2, unique = false, nullable = true)
//   private Integer custPolaBunga;
//
//   @Column(name = "cust_tingkat_bunga", length = 50, unique = false, nullable = true)
//   private String custTingkatBunga;
//
//   @Temporal(TemporalType.DATE)
//   @Column(name = "cust_tgl_jatuh_tempo", unique = false, nullable = true)
//   private Date custTglJatuhTempo;
//
//   @Column(name = "rev_no", length = 11, unique = false, nullable = true)
//   private Integer revNo;
//
//   @Column(name = "status_cust", length = 1, unique = false, nullable = true)
//   private Integer statusCust;

}
