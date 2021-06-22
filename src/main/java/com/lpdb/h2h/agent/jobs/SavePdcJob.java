package com.lpdb.h2h.agent.jobs;

import com.lpdb.h2h.agent.entity.CustomerMitra;
import com.lpdb.h2h.agent.entity.PdcMitra;
import com.lpdb.h2h.agent.exceptions.PdcMitraException;
import com.lpdb.h2h.agent.service.CustomerMitraService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import com.lpdb.h2h.agent.service.PdcMitraService;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

public class SavePdcJob implements Job {

   private final Logger LOG = LogManager.getLogger(this.getClass());

   @Autowired
   private PdcMitraService pdcService;
   @Autowired
   private CustomerMitraService customerMitraService;

   @Override
   public void execute(JobExecutionContext context) {

      LOG.info("\n[[======= SavePdcJob START =======]]");
      
      CustomerMitra cm = new CustomerMitra();
      cm.setId(null);
      cm.setNamaCust("yose");
//      cm.setIdKoperasi("yose");
//      cm.setCustNik("1234576");
//      cm.setCustAge(23);
//      cm.setCustJenisKelamin(1);
//      cm.setCustNamaUsaha("as");
//      cm.setCustSektorUsaha("aas");
//      cm.setCustBidangUsaha("asd");
//      cm.setCustSektorUsaha("sfessda");
//      cm.setCustOmset(BigDecimal.valueOf(1000000));
//      cm.setCustAsset(BigDecimal.valueOf(1000000));
//      cm.setCustAlamatUsaha("jln. pancoran barat");
//      cm.setCustPenanggungJawab("yose");
//      cm.setCustJumTenagaKerja(10);
//      cm.setCustNoTelp("00999");
//      cm.setCustAlamat("pancoran");
//      cm.setCustProv("jakarta");
//      cm.setCustKab("jakarta");
//      cm.setCustKec("pancoran");
//      cm.setCustPemanfaatan(1);
//      cm.setCustPlafonPengajuan(BigDecimal.valueOf(100000));
//      cm.setCustAkadJenis(12);
//      cm.setCustAkadTgl(new Date());
//      cm.setCustRealisasiTgl(new Date());
//      cm.setCustRealisasiNilai(BigDecimal.valueOf(100000));
//      cm.setCustSisaDana(BigDecimal.valueOf(10000));
//      cm.setCustJangkaWaktu(12);
//      cm.setCustSatuanWaktu(2);
//      cm.setCustPolaBunga(1);
//      cm.setCustTingkatBunga("hbos");
//      cm.setCustTglJatuhTempo(new Date());
//      cm.setRevNo(12);
//      cm.setStatusCust(1);
      
      CustomerMitra customerMitra = customerMitraService.save(cm);
      
      if(customerMitra != null) {
         PdcMitra pdc = new PdcMitra();
         pdc.setId(null);
         pdc.setIdMitra(String.valueOf(555 + 1));
         pdc.setNamaMitra("Mitra 1");
         pdc.setIdProposal(BigInteger.valueOf(66521223 + 1));
         pdc.setIdPropPencairanKe(45 + 1);
         pdc.setPdcNoCust(2345 + 1);
         pdc.setPdcDateCust(new Date());
         pdc.setPdcBankCodeCust("12");
         pdc.setPdcBankNameCust("BNI");
         pdc.setPdcAccRekeningCust(String.valueOf(34525 + 1));
         pdc.setPdcInstallmentCust(2);
         pdc.setPdcContractNoCust(123151);
         pdc.setPdcNoteCust("great");
         pdc.setPdcAmmountCust(BigDecimal.valueOf(88888 + 1));
         pdc.setPdcDueDateCust(new Date());
         pdc.setPdcInputDate(new Date());
         pdc.setPdcDetails(null);
         pdc.setCustomer(cm);

         try {
            pdcService.save(pdc);
         } catch (PdcMitraException ex) {
            LOG.error(ex);
         }
      }

      LOG.info("\n[[======= SavePdc END =======]]");
   }

}
