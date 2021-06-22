package com.lpdb.h2h.agent.rest;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.lpdb.h2h.agent.entity.h2h.ResponseMessage;
import com.lpdb.h2h.agent.entity.h2h.TokenInfo;
import com.lpdb.h2h.agent.ui.MainFrame;
import java.lang.reflect.ParameterizedType;
import java.net.URI;
import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
 * @param <T>
 */
public class RestClient<T> implements Rest<T> {

   private final Logger LOG = LogManager.getLogger(this.getClass());
   private final RestTemplate restTemplate = new RestTemplate();

   protected Class domainClass;

   public RestClient() {
      this.domainClass = (Class) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
   }

   private static HttpHeaders getHeaders() {
      HttpHeaders headers = new HttpHeaders();
      headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
      return headers;
   }

   @Override
   public T save(String linkServer, T domain) {
      UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(linkServer)
         // Add query parameter
         .queryParam("access_token", TokenInfo.getInstance().getAccess_token());

      final URI uri = builder.build().encode().toUri();

      HttpEntity<T> request = new HttpEntity<>(domain, getHeaders());
      ResponseEntity<T> response = restTemplate.exchange(uri, HttpMethod.POST, request, domainClass);
      return response.getBody();
   }

   @Override
   public ResponseMessage saveAll(String linkServer, List<T> domainList) {

      ResponseMessage responseMessage = null;

      UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(linkServer)
         // Add query parameter
         .queryParam("access_token", TokenInfo.getInstance().getAccess_token());

      try {
         HttpEntity<List<T>> requestEntity = new HttpEntity<>(domainList, getHeaders());
         ResponseEntity<ResponseMessage> responseEntity = restTemplate.exchange(builder.build().encode().toUri(), HttpMethod.POST, requestEntity, ResponseMessage.class);
         ResponseMessage rm = responseEntity.getBody();
         responseMessage = rm;
      } catch (final HttpClientErrorException ex) {
         //saat terjadi kesalahan dan komputer terkoneksi dengan internet dan server oauth2-authorization
         LOG.info("\t--> HttpClientErrorException : " + ex);
         //400 - {"error" : "invalid_grant","error_description" : "Bad credentials"}
         LOG.info(ex.getRawStatusCode() + " - " + ex.getResponseBodyAsString());
         MainFrame.txtLog.append("\n--> HttpClientErrorException : ");
         MainFrame.txtLog.append(ex.getRawStatusCode() + " - " + ex.getResponseBodyAsString());
         //throw new ExternalCallBadRequestException();
         responseMessage = null;
      } catch (HttpServerErrorException ex) {
         //saat terjadi kesalahan dan komputer tidak terkoneksi dengan internet dan server oauth2-authorization
         LOG.info("\t--> HttpServerErrorException : ");
         LOG.info(ex.getRawStatusCode() + " - " + ex.getResponseBodyAsString());
         MainFrame.txtLog.append("\n--> HttpClientErrorException : ");
         MainFrame.txtLog.append(ex.getRawStatusCode() + " - " + ex.getResponseBodyAsString());
         //throw new ExternalCallServerErrorException(httpServerErrorException);
         responseMessage = null;
      } catch (RestClientException ex) {
         //saat terjadi kesalahan dan komputer tidak terkoneksi dengan server oauth2-authorization
         LOG.info("\t--> RestClientException : " + ex);
         MainFrame.txtLog.append("\n--> RestClientException : " + ex);
         //throw new ExternalCallServerErrorException(exception);
         responseMessage = null;
      }
      return responseMessage;
   }

//   @Override
//   public T update(String linkServer, String id, T domain) {
//      // URI (URL) parameters
//      Map<String, String> uriParams = new HashMap<>();
//      uriParams.put("id", id);
//
//      // Query parameters
//      UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(linkServer)
//         // Add query parameter
//         .queryParam("access_token", AuthTokenInfo.getInstance().getAccess_token());
//
//      final URI uri = builder.buildAndExpand(uriParams).toUri();
//
//      HttpEntity<T> request = new HttpEntity<>(domain, getHeaders());
//      ResponseEntity<T> response = restTemplate.exchange(uri, HttpMethod.PUT, request, domainClass);
//      return response.getBody();
//   }
//
//   @Override
//   public Boolean delete(String linkServer, String id) {
//      // URI (URL) parameters
//      Map<String, String> uriParams = new HashMap<>();
//      uriParams.put("id", id);
//
//      // Query parameters
//      UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(linkServer)
//         // Add query parameter
//         .queryParam("access_token", AuthTokenInfo.getInstance().getAccess_token());
//
//      final URI uri = builder.buildAndExpand(uriParams).toUri();
//
//      HttpEntity<String> request = new HttpEntity<>(getHeaders());
//      ResponseEntity response = restTemplate.exchange(uri, HttpMethod.DELETE, request, String.class);
//      return response.getStatusCodeValue() == 200;
//   }
//
//   @Override
//   public T getHome(String linkServer) {
//      // Query parameters
//      UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(linkServer);
//      // Add query parameter
//      //.queryParam("access_token", AuthTokenInfo.getInstance().getAccess_token());
//
//      final URI uri = builder.build().encode().toUri();
//
//      HttpEntity request = new HttpEntity<>(getHeaders());
//      ResponseEntity<T> response = restTemplate.exchange(uri, HttpMethod.GET, request, domainClass);
//      return response.getBody();
//   }
//
//   @Override
//   public T getOne(String linkServer, String keyCategory, String keyValue) {
//
//      // Query parameters
//      UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(linkServer)
//         // Add query parameter
//         .queryParam("access_token", AuthTokenInfo.getInstance().getAccess_token())
//         .queryParam("keyCategory", keyCategory)
//         .queryParam("keyValue", keyValue);
//
//      final URI uri = builder.build().toUri();
//
//      HttpEntity request = new HttpEntity<>(getHeaders());
//      ResponseEntity<T> response = restTemplate.exchange(uri.toString(), HttpMethod.GET, request, domainClass);
//      return response.getBody();
//   }
//
//   //get all no pagging
//   @Override
//   public ResponseEntity<String> getMany(String linkServer, String keyCategory, String keyValue) {
//
//      // Query parameters
//      UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(linkServer)
//         // Add query parameter
//         .queryParam("access_token", AuthTokenInfo.getInstance().getAccess_token())
//         .queryParam("keyCategory", keyCategory)
//         .queryParam("keyValue", keyValue);
//
//      final URI uri = builder.build().toUri();
//
//      HttpEntity<String> request = new HttpEntity<>(getHeaders());
//      ResponseEntity<String> responseEntity = restTemplate.exchange(uri.toString(), HttpMethod.GET, request, String.class);
//      return responseEntity;
//   }
//
//   //get all and pagging
//   @Override
//   public Page<T> getMany(String linkServer, String keyCategory, String keyValue, Integer pageNumber, Integer rowsPerPage) {
//
//      UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(linkServer)
//         // Add query parameter
//         .queryParam("access_token", AuthTokenInfo.getInstance().getAccess_token())
//         .queryParam("keyCategory", keyCategory)
//         .queryParam("keyValue", keyValue)
//         .queryParam("page", (pageNumber - 1))
//         .queryParam("size", rowsPerPage);
//
//      final URI uri = builder.build().toUri();
//      //final URI uri = builder.build().encode().toUri();
//
//      HttpEntity request = new HttpEntity(getHeaders()); //jangan lupa
//      ParameterizedTypeReference<RestPage<T>> responseType = new ParameterizedTypeReference<RestPage<T>>() {
//      };
//      //https://github.com/spring-projects/spring-boot/issues/8888
//      ResponseEntity<RestPage<T>> responseEntity = restTemplate.exchange(uri, HttpMethod.GET, request, responseType);
//      return responseEntity.getBody();
//   }
//
//   @Override
//   public ResponseEntity<String> getCurrentDate(String linkServer, String keyCategory, String keyValue, String currentDate) {
//
//      // Query parameters
//      UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(linkServer)
//         // Add query parameter
//         .queryParam("access_token", AuthTokenInfo.getInstance().getAccess_token())
//         .queryParam("keyCategory", keyCategory)
//         .queryParam("keyValue", keyValue)
//         .queryParam("currentDate", currentDate);
//
//      final URI uri = builder.build().toUri();
//
//      HttpEntity<String> request = new HttpEntity<>(getHeaders());
//      ResponseEntity<String> responseEntity = restTemplate.exchange(uri.toString(), HttpMethod.GET, request, String.class);
//      return responseEntity;
//   }
//
//   @Override
//   public ResponseEntity<String> getPeriode(String linkServer, String keyCategory, String keyValue, String startDate, String endDate) {
//
//      //Query parameters
//      UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(linkServer)
//         // Add query parameter
//         .queryParam("access_token", AuthTokenInfo.getInstance().getAccess_token())
//         .queryParam("keyCategory", keyCategory)
//         .queryParam("keyValue", keyValue)
//         .queryParam("startDate", startDate)
//         .queryParam("endDate", endDate);
//
//      final URI uri = builder.build().toUri();
//
//      HttpEntity<String> request = new HttpEntity<>(getHeaders());
//      ResponseEntity<String> responseEntity = restTemplate.exchange(uri.toString(), HttpMethod.GET, request, String.class);
//      return responseEntity;
//   }
//
//   @Override
//   public ResponseEntity<String> getMonth(String linkServer, String keyCategory, String keyValue, String month, String year) {
//
//      //Query parameters
//      UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(linkServer)
//         // Add query parameter
//         .queryParam("access_token", AuthTokenInfo.getInstance().getAccess_token())
//         .queryParam("keyCategory", keyCategory)
//         .queryParam("keyValue", keyValue)
//         .queryParam("month", month)
//         .queryParam("year", year);
//
//      final URI uri = builder.build().toUri();
//
//      HttpEntity<String> request = new HttpEntity<>(getHeaders());
//      ResponseEntity<String> responseEntity = restTemplate.exchange(uri.toString(), HttpMethod.GET, request, String.class);
//      return responseEntity;
//   }
//
//   @Override
//   public ResponseEntity<String> getYear(String linkServer, String keyCategory, String keyValue, String tahun) {
//
//      //Query parameters
//      UriComponentsBuilder builder = UriComponentsBuilder.fromUriString(linkServer)
//         // Add query parameter
//         .queryParam("access_token", AuthTokenInfo.getInstance().getAccess_token())
//         .queryParam("keyCategory", keyCategory)
//         .queryParam("keyValue", keyValue)
//         .queryParam("tahun", tahun);
//
//      final URI uri = builder.build().toUri();
//
//      HttpEntity<String> request = new HttpEntity<>(getHeaders());
//      ResponseEntity<String> responseEntity = restTemplate.exchange(uri.toString(), HttpMethod.GET, request, String.class);
//      return responseEntity;
//   }
}
