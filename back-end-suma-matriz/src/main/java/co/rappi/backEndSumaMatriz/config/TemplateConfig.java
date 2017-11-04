package co.rappi.backEndSumaMatriz.config;

import javax.validation.constraints.NotNull;

public class TemplateConfig {
    
    @NotNull
    private String templateRoot;
    
    public String getTemplateRoot() {
        return templateRoot;
    }
    
}
