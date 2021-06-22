package com.lpdb.h2h.agent.rest;

import com.lpdb.h2h.agent.entity.h2h.ResponseMessage;
import java.util.List;

/**
 *
 * @author jp
 * @param <T>
 */
public interface Rest<T> {
   
//   public T getHome(String linkServer);

   public T save(String linkServer, T domain);
   
   public ResponseMessage saveAll(String linkServer, List<T> domainList);

//   public T update(String linkServer, String id, T domain);
//
//   public Boolean delete(String linkServer, String id);
//
//   //SEARCH
//   public T getOne(String linkServer, String keyCategory, String keyValue);
//
//   public Page<T> getMany(String linkServer, String keyCategori, String keyValue, Integer pageNumber, Integer rowsPerPage);
//
//   //PRINT
//   public ResponseEntity<String> getMany(String linkServer, String keyCategory, String keyValue);
//
//   public ResponseEntity<String> getCurrentDate(String linkServer, String keyCategory, String keyValue, String currentDate);
//
//   public ResponseEntity<String> getPeriode(String linkServer, String keyCategory, String keyValue, String startDate, String endDate);
//   
//   public ResponseEntity<String> getMonth(String linkServer, String keyCategory, String keyValue, String month, String year);
//   
//   public ResponseEntity<String> getYear(String linkServer, String keyCategory, String keyValue, String tahun);

}
