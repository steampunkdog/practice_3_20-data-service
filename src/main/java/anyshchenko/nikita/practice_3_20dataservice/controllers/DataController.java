package anyshchenko.nikita.practice_3_20dataservice.controllers;

import anyshchenko.nikita.practice_3_20dataservice.model.DataModel;
import anyshchenko.nikita.practice_3_20dataservice.services.DataHolder;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/data")
public class DataController {

    private DataHolder dataHolder;

    public DataController(DataHolder dataHolder) {
        this.dataHolder = dataHolder;
    }

    @GetMapping
    public Mono<DataModel> getCurrentDateModel(){
        return Mono.fromSupplier(() -> dataHolder.getDataModel());
    }

    @PostMapping
    public void setDataModel(@RequestBody DataModel dataModel){
        dataHolder.setDataModel(dataModel);
    }
}
