package md.leonis.assistant.config;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
// A shared object that stores general application settings
public class ConfigHolder {

    private int wordsToLearnCount = 20;
}
