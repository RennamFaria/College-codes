package library.config;

public class ConfigurationManager {
    private static ConfigurationManager instance;

    private ConfigurationManager() {
        // Configurações globais
    }

    public static ConfigurationManager getInstance() {
        if (instance == null) {
            instance = new ConfigurationManager();
        }
        return instance;
    }
    
    // Métodos para gerenciar configurações
}

