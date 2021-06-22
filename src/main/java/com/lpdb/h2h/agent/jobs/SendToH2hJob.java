package com.lpdb.h2h.agent.jobs;

import com.lpdb.h2h.agent.entity.PdcMitra;
import com.lpdb.h2h.agent.entity.h2h.TokenInfo;
import com.lpdb.h2h.agent.entity.h2h.Customer;
import com.lpdb.h2h.agent.entity.h2h.Pdc;
import com.lpdb.h2h.agent.entity.h2h.ResponseMessage;
import com.lpdb.h2h.agent.helper.DateUtils;
import com.lpdb.h2h.agent.rest.PdcClient;
import com.lpdb.h2h.agent.rest.TokenInfoClient;
import com.lpdb.h2h.agent.service.PdcMitraService;
import com.lpdb.h2h.agent.ui.MainFrame;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

public class SendToH2hJob implements Job {
   
   private final Logger LOG = LogManager.getLogger(this.getClass());
   
   @Value("${server-url}")
   private String SERVER_URL;
   
   @Value("${id-mitra}")
   private String ID_MITRA;
   
   @Value("${nama-mitra}")
   private String NAMA_MITRA;
   
   private final PdcClient pdcClient = new PdcClient();
   private final TokenInfoClient tokenInfoClient = new TokenInfoClient();
   @Autowired
   private PdcMitraService pdcMitraService;

   @Override
   public void execute(JobExecutionContext context) {

      LOG.info("\n\n====> SendToH2hJob START");

      if (TokenInfo.getInstance().getAccess_token() == null) {
         LOG.info("\t=> Status belum login");
         MainFrame.txtLog.append("\n\n=> Status belum login");
         login();
      } else {
         List<Pdc> listPdc = new ArrayList<>();
         List<PdcMitra> listPdcMitra = pdcMitraService.findAllByCurrentDate(DateUtils.dateToYearsString(new Date()));
         for (PdcMitra p : listPdcMitra) {
            Customer c = new Customer();
            c.setId(null);
            //set customer
            c.setIdCust(p.getCustomer().getId());
            c.setNameCust(p.getCustomer().getNamaCust());
//            c.setCustAge(p.getCustomer().getCustAge());
//            c.setIdKoperasi(p.getCustomer().getIdKoperasi());
//            c.setCustNik(p.getCustomer().getCustNik());
//            c.setCustJenisKelamin(p.getCustomer().getCustJenisKelamin());
//            c.setCustNamaUsaha(p.getCustomer().getCustNamaUsaha());
//            c.setCustSektorUsaha(p.getCustomer().getCustSektorUsaha());
//            c.setCustBidangUsaha(p.getCustomer().getCustBidangUsaha());
//            c.setCustSektorUsaha(p.getCustomer().getCustSektorUsaha());
//            c.setCustOmset(p.getCustomer().getCustOmset());
//            c.setCustAsset(p.getCustomer().getCustAsset());
//            c.setCustAlamatUsaha(p.getCustomer().getCustAlamatUsaha());
//            c.setCustPenanggungJawab(p.getCustomer().getCustPenanggungJawab());
//            c.setCustJumTenagaKerja(p.getCustomer().getCustJumTenagaKerja());
//            c.setCustNoTelp(p.getCustomer().getCustNoTelp());
//            c.setCustAlamat(p.getCustomer().getCustAlamat());
//            c.setCustProv(p.getCustomer().getCustProv());
//            c.setCustKab(p.getCustomer().getCustKab());
//            c.setCustKec(p.getCustomer().getCustKec());
//            c.setCustPemanfaatan(p.getCustomer().getCustPemanfaatan());
//            c.setCustPlafonPengajuan(p.getCustomer().getCustPlafonPengajuan());
//            c.setCustAkadJenis(p.getCustomer().getCustAkadJenis());
//            c.setCustAkadTgl(p.getCustomer().getCustAkadTgl());
//            c.setCustRealisasiTgl(p.getCustomer().getCustRealisasiTgl());
//            c.setCustRealisasiNilai(p.getCustomer().getCustRealisasiNilai());
//            c.setCustSisaDana(p.getCustomer().getCustSisaDana());
//            c.setCustJangkaWaktu(p.getCustomer().getCustJangkaWaktu());
//            c.setCustSatuanWaktu(p.getCustomer().getCustSatuanWaktu());
//            c.setCustPolaBunga(p.getCustomer().getCustPolaBunga());
//            c.setCustTingkatBunga(p.getCustomer().getCustTingkatBunga());
//            c.setCustTglJatuhTempo(p.getCustomer().getCustTglJatuhTempo());
//            c.setRevNo(p.getCustomer().getRevNo());
//            c.setStatusCust(p.getCustomer().getStatusCust());

            Pdc pdc = new Pdc();
            pdc.setId(null);
            pdc.setIdMitra(ID_MITRA);
            pdc.setNamaMitra(NAMA_MITRA);
            pdc.setIdProposal(p.getIdProposal());
            pdc.setIdPropPencarianKe(p.getIdPropPencairanKe());
            pdc.setPdcNoCust(p.getPdcNoCust());
            pdc.setPdcDateCust(p.getPdcDateCust());
            pdc.setPdcBankCodeCust(p.getPdcBankCodeCust());
            pdc.setPdcBankNameCust(p.getPdcBankNameCust());
            pdc.setPdcAccRekeningCust(p.getPdcAccRekeningCust());
            pdc.setPdcInstallmentCust(p.getPdcInstallmentCust());
            pdc.setPdcContractNoCust(p.getPdcContractNoCust());
            pdc.setPdcNoteCust(p.getPdcNoteCust());
            pdc.setPdcAmmountCust(p.getPdcAmmountCust());
            pdc.setPdcDueDateCust(p.getPdcDueDateCust());
            pdc.setPdcInputDate(p.getPdcInputDate());
            //set pdc detail
            pdc.setPdcDetails(null);
            //set customer
            pdc.setCustomer(c);

            listPdc.add(pdc);
            break;
         }

         ResponseMessage responseMessage = pdcClient.saveAll(SERVER_URL+"/pdc/save-many", listPdc);
         if (responseMessage == null) {
            LOG.info("\t=> Gagal mengirim data");
            MainFrame.txtLog.append("\n=> Gagal mengirim data");

            LOG.info("\t=> Login ulang");
            MainFrame.txtLog.append("\n=> Login ulang");
            login();
         } else {
            
            LOG.info("\t=> ResponseMessage : ");
            LOG.info("\t=> Code            : " + responseMessage.getCode());
            LOG.info("\t=> Message         : " + responseMessage.getMessage());
            LOG.info("\t=> Jumlah Disimpan : " + responseMessage.getJumlahTersimpan());
            
            MainFrame.txtLog.append("\n\n=> ResponseMessage : ");
            MainFrame.txtLog.append("\n=> Code\t\t: " + responseMessage.getCode());
            MainFrame.txtLog.append("\n=> Message\t\t: " + responseMessage.getMessage());
            MainFrame.txtLog.append("\n=> Jumlah Disimpan\t: " + responseMessage.getJumlahTersimpan());
         }
      }
      LOG.info("\nSendToH2hJob END <====");
   }

   private void login() {
      LOG.info("\t===> LoginJob START");
      tokenInfoClient.getTokenRequest(SERVER_URL+"/oauth/token", "user", "123456");
      LOG.info("\tLoginJob END <===");
   }

}
