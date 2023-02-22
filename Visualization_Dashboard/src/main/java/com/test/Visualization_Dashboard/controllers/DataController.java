package com.test.Visualization_Dashboard.controllers;


import com.test.Visualization_Dashboard.entities.Data;
import com.test.Visualization_Dashboard.services.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin("*")
@RequestMapping("/data")
public class DataController {

    @Autowired
    private DataService dataService;

    @PostMapping("/upload")
    public ResponseEntity<?> saveDataHandler(){
        dataService.saveData();
        return ResponseEntity.ok(Map.of("message","Data saved into database successfully"));
    }

    @GetMapping("/getall")
    public ResponseEntity<List<Data>> getAllDataHandler(){
        return ResponseEntity.ok(dataService.getAllData());
    }


    // end points for the filters

    @GetMapping("/getbyendyear/{endYear}")
    public ResponseEntity<List<Data>> getByEndYearHandler(@PathVariable String endYear){
        return ResponseEntity.ok(dataService.getAllByEndYear(endYear));
    }


    @GetMapping("/getbytopic/{topic}")
    public ResponseEntity<List<Data>> getByTopicHandler(@PathVariable String topic){
        return ResponseEntity.ok(dataService.getAllByTopic(topic));
    }

    @GetMapping("/getbysector/{sector}")
    public ResponseEntity<List<Data>> getBySectorHandler(@PathVariable String sector){
        return ResponseEntity.ok(dataService.getAllBySector(sector));
    }

    @GetMapping("/getbyregion/{region}")
    public ResponseEntity<List<Data>> getByRegionHandler(@PathVariable String region){
        return ResponseEntity.ok(dataService.getAllByRegion(region));
    }

    @GetMapping("/getbypestle/{pestle}")
    public ResponseEntity<List<Data>> getByPestleHandler(@PathVariable String pestle){
        return ResponseEntity.ok(dataService.getAllByPestle(pestle));
    }

    @GetMapping("/getbysource/{source}")
    public ResponseEntity<List<Data>> getBySourceHandler(@PathVariable String source){
        return ResponseEntity.ok(dataService.getAllBySource(source));
    }

    @GetMapping("/getbyswot/{swot}")
    public ResponseEntity<List<Data>> getBySwotHandler(@PathVariable String swot){
        return ResponseEntity.ok(dataService.getAllBySwot(swot));
    }

    @GetMapping("/getbycountry/{country}")
    public ResponseEntity<List<Data>> getByCountryHandler(@PathVariable String country){
        return ResponseEntity.ok(dataService.getAllByCountry(country));
    }

    @GetMapping("/getbycity/{city}")
    public ResponseEntity<List<Data>> getByCityHandler(@PathVariable String city){
        return ResponseEntity.ok(dataService.getAllByCity(city));
    }


}
