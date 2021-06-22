package com.lpdb.h2h.agent.entity.h2h;

import lombok.Data;

@Data
public class TokenInfo {

   private String access_token;
   private String token_type;
   private String refresh_token;
   private int expires_in;
   private String scope;
   private String jti;

   private static TokenInfo instance = null;

   public static TokenInfo getInstance() {
      if (instance == null) {
         instance = new TokenInfo();
      }
      return instance;
   }
   
}
