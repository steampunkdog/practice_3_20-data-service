package anyshchenko.nikita.practice_3_20dataservice.services;

import anyshchenko.nikita.practice_3_20dataservice.configuration.AppProperties;
import anyshchenko.nikita.practice_3_20dataservice.model.DataModel;
import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.util.Pair;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.logging.Logger;

@Service
public class DataLoader {
    public static final Logger log = Logger.getLogger(DataLoader.class.getName());

    private DataHolder dataHolder;
    private Resource jsonFile;
    private EventApiAdapter eventApiAdapter;
    private ObjectMapper objectMapper;

    public DataLoader(DataHolder dataHolder, EventApiAdapter eventApiAdapter, AppProperties appProperties, ObjectMapper objectMapper) {
        this.eventApiAdapter = eventApiAdapter;
        this.dataHolder = dataHolder;
        this.jsonFile = appProperties.getJsonFilePath();
        this.objectMapper = objectMapper;
    }

    protected void loadData(DataModel dataModel, boolean deduplicated) {
        log.info("Data retrieved");
        if (!deduplicated) {
            //TODO deduplication

        }
        dataHolder.setDataModel(dataModel);
        //TODO inform other services
        saveData(dataModel);
        log.info("Data saved");
    }

    public void loadData(DataModel dataModel){
        loadData(dataModel, true);
    }

    public Mono<Void> loadData() {
        return eventApiAdapter.getData()
                .map(dataModel -> new Pair<>(dataModel, false))
                .doOnError(throwable -> {
                    log.warning(throwable.getMessage());
                    log.info("Trying to retrieve data form " + jsonFile.getFilename());
                })
                .onErrorResume(throwable -> loadFromFile())
                .doOnNext(pair -> {
                    loadData(pair.getKey(), pair.getValue());
                })
                .then();

    }

    protected Mono<Pair<DataModel, Boolean>> loadFromFile(){
        return Mono.fromSupplier(() -> {
            if(jsonFile == null){
                log.warning("File name not provided");
                throw new NullPointerException("File name not provided");
            }
            else if(!jsonFile.isFile()){
                String msg = String.format("File %s doesnt exist", jsonFile.getFilename());
                log.warning(msg);
                throw new RuntimeException(msg);
            }
            else if(!jsonFile.getFilename().contains(".json")){
                log.warning("File format isn`t correct");
                throw new RuntimeException("File format isn`t correct");
            }
            try {
                return new Pair<>(objectMapper.readValue(jsonFile.getFile(), DataModel.class), true);
            } catch (IOException e) {
                log.warning("Cant read file");
                throw new RuntimeException("Cant read file");
            }
        });
    }

    protected void saveData(DataModel dataModel){
        if(jsonFile == null){
            log.warning("File name not provided");
            throw new NullPointerException("File name not provided");
        }

        try {
            if (!jsonFile.exists()){
                log.warning(String.format("File %s doesnt exist", jsonFile.getFilename()));
                if (jsonFile.getFile().createNewFile()){
                    log.info("Data save file created");
                }
            }

            objectMapper.writeValue(Paths.get(jsonFile.getURI()).toFile(), dataModel);


        } catch (IOException e) {
            log.warning("Cant write to file");
            throw new RuntimeException("Cant write to file");
        }
    }
}
