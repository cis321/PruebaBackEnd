package co.rappi.backEndSumaMatriz.config;

import io.dropwizard.Configuration;

public class SumaMatrizConfig extends Configuration {
	
	private MongoConfig mongoConfig;

	private WsClientsConfig wsClientsConfig;
	
	private TemplateConfig templateConfig;
	
	public MongoConfig getMongoConfig() {
		return mongoConfig;
	}

	public WsClientsConfig getWsClientsConfig() {
		return wsClientsConfig;
	}
	
	public TemplateConfig getTemplateConfig() {
	    return templateConfig;
	}
	
}
