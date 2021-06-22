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
public class Customer implements Serializable {

   private String id;
   private Pdc pdc;
   private String idCust;
   private String nameCust;
   private String idKoperasi;
   private String custNik;
   private Integer custAge;
   private Integer custJenisKelamin;
   private String custNamaUsaha;
   private String custSektorUsaha;
   private String custBidangUsaha;
   private String cusSektorUsahaDetil;
   private BigDecimal custOmset = BigDecimal.ZERO;
   private BigDecimal custAsset = BigDecimal.ZERO;
   private String custAlamatUsaha;
   private String custPenanggungJawab;
   private Integer custJumTenagaKerja;
   private String custNoTelp;
   private String custAlamat;
   private String custProv;
   private String custKab;
   private String custKec;
   private Integer custPemanfaatan;
   private BigDecimal custPlafonPengajuan = BigDecimal.ZERO;
   private Integer custAkadJenis;
   private Date custAkadTgl;
   private Date custRealisasiTgl;
   private BigDecimal custRealisasiNilai = BigDecimal.ZERO;
   private BigDecimal custSisaDana = BigDecimal.ZERO;
   private Integer custJangkaWaktu;
   private Integer custSatuanWaktu;
   private Integer custPolaBunga;
   private String custTingkatBunga;
   private Date custTglJatuhTempo;
   private Integer revNo;
   private Integer statusCust;

}
