package anyshchenko.nikita.practice_3_20dataservice.listeners;

import anyshchenko.nikita.practice_3_20dataservice.services.DataLoader;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class ApplicationStartupListener implements ApplicationListener<ContextRefreshedEvent> {

    private DataLoader dataLoader;

    public ApplicationStartupListener(DataLoader dataLoader) {
        this.dataLoader = dataLoader;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        dataLoader.loadData().subscribe();
    }
}
