package com.lpdb.h2h.agent.entity.h2h;

import lombok.Data;

@Data
public class ResponseMessage {

   private String code;
   private String message;
   private Integer jumlahTersimpan;
   
}
