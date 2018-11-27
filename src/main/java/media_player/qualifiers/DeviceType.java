package media_player.qualifiers;

import org.springframework.beans.factory.annotation.Qualifier;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface DeviceType {
    Type value();

    public enum Type {DISK, FLASH}
}
