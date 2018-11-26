package media_player;

import lombok.Setter;
import org.springframework.beans.factory.FactoryBean;

import java.util.List;

public class DiskFactory implements FactoryBean<Disk> {

    private String title;

    private List<String> songs;

    public DiskFactory(String title, List<String> songs) {
        this.title = title;
        this.songs = songs;
    }

    @Override
    public Disk getObject() throws Exception {
        System.out.println("Producing Disk ....");
        Disk disk = new Disk(title, songs);
        return disk;
    }

    @Override
    public Class<?> getObjectType() {
        return Disk.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
