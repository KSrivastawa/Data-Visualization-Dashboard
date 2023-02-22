package com.test.Visualization_Dashboard.services;

import com.test.Visualization_Dashboard.entities.Data;
import java.util.List;

public interface DataService {

    public void saveData();
    public List<Data> getAllData();

    public List<Data> getAllByEndYear(String endYear);

    public List<Data> getAllByTopic(String topic);
    public List<Data> getAllBySector(String sector);
    public List<Data> getAllByRegion(String region);
    public List<Data> getAllByPestle(String pestle);
    public List<Data> getAllBySource(String source);
    public List<Data> getAllBySwot(String swot);
    public List<Data> getAllByCountry(String country);
    public List<Data> getAllByCity(String city);


}
