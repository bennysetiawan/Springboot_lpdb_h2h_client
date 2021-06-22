package com.lpdb.h2h.agent.rest;

import com.lpdb.h2h.agent.entity.h2h.TokenInfo;
import com.lpdb.h2h.agent.ui.MainFrame;
import java.util.Arrays;
import java.util.LinkedHashMap;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

/**
 *
 * @author jp
 */
public class TokenInfoClient {

   private final Logger LOG = LogManager.getLogger(this.getClass());

   private static HttpHeaders getHeaders() {
      String plainClientCredentials = "lpdb-client:123456";
      String base64ClientCredentials = new String(Base64.encodeBase64(plainClientCredentials.getBytes()));

      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      headers.add("Authorization", "Basic " + base64ClientCredentials);
      return headers;
   }

   public TokenInfo getTokenRequest(String linkServer, String username, String password) {

      TokenInfo tokenInfo = null;

      LOG.info("\t==> Start Get Token");

      UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(linkServer)
         .queryParam("grant_type", "password")
         .queryParam("username", username)
         .queryParam("password", password);

      try {
         RestTemplate restTemplate = new RestTemplate();
         HttpEntity<String> request = new HttpEntity<>(getHeaders());
         ResponseEntity<Object> responseEntity = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.POST, request, Object.class);

         if (responseEntity.getStatusCodeValue() == 200) {
            LinkedHashMap<String, Object> map = (LinkedHashMap<String, Object>) responseEntity.getBody();

            if(map != null) {
               TokenInfo.getInstance().setAccess_token((String) map.get("access_token"));
               TokenInfo.getInstance().setToken_type((String) map.get("token_type"));
               TokenInfo.getInstance().setRefresh_token((String) map.get("refresh_token"));
               TokenInfo.getInstance().setExpires_in((int) map.get("expires_in"));
               TokenInfo.getInstance().setScope((String) map.get("scope"));

               LOG.info("\t=> LOGIN BERHASIL");
               MainFrame.txtLog.append("\n=> LOGIN BERHASIL");
               tokenInfo = TokenInfo.getInstance();
            } else {
               LOG.info("\t=> Map = null");
               MainFrame.txtLog.append("\n=> Map = null");
               tokenInfo = null;
            }
         } else {
            LOG.info("\t=> response.getStatusCodeValue() : " + responseEntity.getStatusCodeValue());
         }
      } catch (final HttpClientErrorException ex) {
         //saat terjadi kesalahan dan komputer terkoneksi dengan internet dan server oauth2-authorization
         LOG.info("\t--> HttpClientErrorException : " + ex);
         //400 - {"error" : "invalid_grant","error_description" : "Bad credentials"}
         LOG.info(ex.getRawStatusCode() + " - " + ex.getResponseBodyAsString());
         MainFrame.txtLog.append("\n--> HttpClientErrorException : ");
         MainFrame.txtLog.append(ex.getRawStatusCode() + " - " + ex.getResponseBodyAsString());
         //throw new ExternalCallBadRequestException();
      } catch (HttpServerErrorException ex) {
         //saat terjadi kesalahan dan komputer tidak terkoneksi dengan internet dan server oauth2-authorization
         LOG.info("\t--> HttpServerErrorException : ");
         LOG.info(ex.getRawStatusCode() + " - " + ex.getResponseBodyAsString());
         MainFrame.txtLog.append("\n--> HttpClientErrorException : ");
         MainFrame.txtLog.append(ex.getRawStatusCode() + " - " + ex.getResponseBodyAsString());
         //throw new ExternalCallServerErrorException(httpServerErrorException);
      } catch (RestClientException ex) {
         //saat terjadi kesalahan dan komputer tidak terkoneksi dengan server oauth2-authorization
         LOG.info("\t--> RestClientException : " + ex);
         MainFrame.txtLog.append("\n--> RestClientException : " + ex);
         //throw new ExternalCallServerErrorException(exception);
      }
      LOG.info("\tEnd Get Toke <==");
      return tokenInfo;
   }
}
