package com.test.Visualization_Dashboard.services;


import com.opencsv.CSVReader;
import com.test.Visualization_Dashboard.entities.Data;
import com.test.Visualization_Dashboard.repositories.DataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.FileReader;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class DataServiceImpl implements DataService {

    @Autowired
    private DataRepository dataRepository;

    String line = "";
    @Override
    public void saveData() {

        try {
            CSVReader cr = new CSVReader(new FileReader("src/main/resources/data.csv"));

            List<String[]> allD = cr.readAll();

            /*
             * To check if the data is being read from the csv file

            System.out.println(allD.size());
            for(int i=0; i<allD.size(); i++){
                System.out.println(Arrays.toString(allD.get(i)));
            }
            System.out.println("Done=========AllD===================");
            */
            List<String[]> alldata = new ArrayList<>();

            /*
             * To check if the data is being read except header from the csv file
             */
            for (int i = 1; i < allD.size(); i++) {
                alldata.add(allD.get(i));
            }
            /*
            System.out.println(alldata.size()); // 1000
            for(int i=0; i<alldata.size(); i++){
                System.out.println(Arrays.toString(alldata.get(i)));
            }
            System.out.println("Done============Alldata================");
            */

            /*
             * To check if the data is being inserted except header from the csv file
             * and converted into Data object
             */

            for (String[] data : alldata) {

                System.out.println(Arrays.toString(data));

                Data d = new Data();

                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM, dd yyyy HH:mm:ss");
                LocalDateTime dateTime1 = LocalDateTime.parse(data[12], formatter);
                LocalDateTime dateTime2 = LocalDateTime.parse(data[13], formatter);
                String addedDate = dateTime1.toString();
                String publishedDate = dateTime2.toString();

                d.setEndyear(data[0]);
                d.setCitylng(data[1]);
                d.setCitylat(data[2]);
                d.setIntensity(data[3]);
                d.setSector(data[4]);
                d.setTopic(data[5]);
                d.setInsight(data[6]);
                d.setSwot(data[7]);
                d.setUrl(data[8]);
                d.setRegion(data[9]);
                d.setStart_year(data[10]);
                d.setImpact(data[11]);
                d.setAdded(addedDate);
                d.setPublished(publishedDate);
                d.setCity(data[14]);
                d.setCountry(data[15]);
                d.setRelevance(data[16]);
                d.setPestle(data[17]);
                d.setSource(data[18]);
                d.setTitle(data[19]);
                d.setLikelihood(data[20]);

                dataRepository.save(d);

            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }

    @Override
    public List<Data> getAllData() {
        return dataRepository.findAll();
    }

    @Override
    public List<Data> getAllByEndYear(String endYear) {
        List<Data> list = dataRepository.findAllByEndyear(endYear);
        return list;
    }


    @Override
    public List<Data> getAllByTopic(String topic) {
        List<Data> list = dataRepository.findAllByTopic(topic);
        return list;
    }

    @Override
    public List<Data> getAllBySector(String sector) {
        List<Data> list = dataRepository.findAllBySector(sector);
        return list;
    }

    @Override
    public List<Data> getAllByRegion(String region) {
        List<Data> list = dataRepository.findAllByRegion(region);
        return list;
    }

    @Override
    public List<Data> getAllByPestle(String pestle) {
        List<Data> list = dataRepository.findAllByPestle(pestle);
        return list;
    }

    @Override
    public List<Data> getAllBySource(String source) {
        List<Data> list = dataRepository.findAllBySource(source);
        return list;
    }

    @Override
    public List<Data> getAllBySwot(String swot) {
        List<Data> list = dataRepository.findAllBySwot(swot);
        return list;
    }

    @Override
    public List<Data> getAllByCountry(String country) {
        List<Data> list = dataRepository.findAllByCountry(country);
        return list;
    }

    @Override
    public List<Data> getAllByCity(String city) {
        List<Data> list = dataRepository.findAllByCity(city);
        return list;
    }


}
