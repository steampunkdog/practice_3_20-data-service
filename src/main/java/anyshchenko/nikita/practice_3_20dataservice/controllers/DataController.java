package anyshchenko.nikita.practice_3_20dataservice.controllers;

import anyshchenko.nikita.practice_3_20dataservice.model.DataModel;
import anyshchenko.nikita.practice_3_20dataservice.services.DataHolder;
import anyshchenko.nikita.practice_3_20dataservice.services.DataLoader;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/data")
public class DataController {

    private DataHolder dataHolder;
    private DataLoader dataLoader;

    public DataController(DataHolder dataHolder, DataLoader dataLoader) {
        this.dataHolder = dataHolder;
        this.dataLoader = dataLoader;
    }

    @GetMapping
    public Mono<DataModel> getCurrentDateModel(){
        return Mono.fromSupplier(() -> dataHolder.getDataModel());
    }

    @PostMapping
    public void setDataModel(@RequestBody DataModel dataModel){
        dataLoader.loadData(dataModel);
    }

    @GetMapping("/load")
    public Mono<Void> loadData(){
        return dataLoader.loadData();
    }

}
