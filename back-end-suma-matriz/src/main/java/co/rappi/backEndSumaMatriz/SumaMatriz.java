package co.rappi.backEndSumaMatriz;

import java.util.ArrayList;
import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.client.MongoDatabase;

import co.rappi.backEndSumaMatriz.businesses.MatrixBusiness;
import co.rappi.backEndSumaMatriz.config.SumaMatrizConfig;
import co.rappi.backEndSumaMatriz.config.TemplateConfig;
import co.rappi.backEndSumaMatriz.config.WsClientsConfig;
import co.rappi.backEndSumaMatriz.persistence.datamappers.LogoDataMapper;
import co.rappi.backEndSumaMatriz.services.MatrixResource;
import co.rappi.backEndSumaMatriz.services.TemplateResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class SumaMatriz extends Application<SumaMatrizConfig> {

    private static final String ALLOW_CREDENTIALS = "allowCredentials";
    private static final String ALLOWED_METHODS_PARAMETERS = "OPTIONS,GET,PUT,POST,DELETE,HEAD";
    private static final String ALLOWED_HEADERS_PARAMETERS = "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin";
    private static final String ALLOWED_HEADERS = "allowedHeaders";
    private MongoClient mongoClient;

    @Override
    public void run(SumaMatrizConfig configuration, Environment environment) throws Exception {

        // Enable CORS headers
        final FilterRegistration.Dynamic corsFilter = environment.servlets().addFilter("CORS", CrossOriginFilter.class);

        // Configure CORS parameters
        corsFilter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "*");
        corsFilter.setInitParameter(CrossOriginFilter.ACCESS_CONTROL_ALLOW_ORIGIN_HEADER, "*");
        corsFilter.setInitParameter(ALLOWED_HEADERS, ALLOWED_HEADERS_PARAMETERS);
        corsFilter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, ALLOWED_METHODS_PARAMETERS);
        corsFilter.setInitParameter(ALLOW_CREDENTIALS, "true");

        // Add URL mapping
        corsFilter.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        String password = configuration.getMongoConfig().getPassword();
        String databaseName = configuration.getMongoConfig().getDatabaseName();
        String username = configuration.getMongoConfig().getUsername();
        String host = configuration.getMongoConfig().getHost();
        
        TemplateConfig templatesConfig = configuration.getTemplateConfig();
        WsClientsConfig wsClientsConfig = configuration.getWsClientsConfig();
        MongoCredential credential = MongoCredential.createCredential(username, databaseName, password.toCharArray());

        ArrayList<MongoCredential> credentialsList = new ArrayList<MongoCredential>();
        credentialsList.add(credential);
        ServerAddress serverAddress = new ServerAddress(host);
        mongoClient = new MongoClient(serverAddress, credentialsList);
        final MongoDatabase mongoDatabase = mongoClient.getDatabase(databaseName);

        final ObjectMapper mapper = new ObjectMapper();

        environment.jersey().register(templateResource);
    }

    public static void main(String[] args) {
        
        SumaMatriz mediRecords = new SumaMatriz();
        try {
            mediRecords.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
