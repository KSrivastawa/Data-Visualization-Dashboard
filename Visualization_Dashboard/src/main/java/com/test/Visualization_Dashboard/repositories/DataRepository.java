package com.test.Visualization_Dashboard.repositories;

import com.test.Visualization_Dashboard.entities.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DataRepository extends JpaRepository<Data, Long> {

     public List<Data> findAllByEndyear(String endYear);
     public List<Data> findAllByTopic(String topic);
     public List<Data> findAllBySector(String sector);
     public List<Data> findAllByRegion(String region);
     public List<Data> findAllByPestle(String pestle);
     public List<Data> findAllBySource(String source);
     public List<Data> findAllBySwot(String swot);
     public List<Data> findAllByCountry(String country);
     public List<Data> findAllByCity(String city);




}
