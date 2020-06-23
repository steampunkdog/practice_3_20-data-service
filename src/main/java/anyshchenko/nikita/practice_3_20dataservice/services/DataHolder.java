package anyshchenko.nikita.practice_3_20dataservice.services;

import anyshchenko.nikita.practice_3_20dataservice.model.DataModel;
import org.springframework.stereotype.Service;

@Service
public class DataHolder {
    private DataModel dataModel;

    public DataHolder() {
    }

    public DataHolder(DataModel dataModel) {
        this.dataModel = dataModel;
    }

    public DataModel getDataModel() {
        return dataModel;
    }

    public void setDataModel(DataModel dataModel) {
        this.dataModel = dataModel;
    }
}
