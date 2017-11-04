package co.rappi.backEndSumaMatriz;

import java.util.EnumSet;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;

import org.eclipse.jetty.servlets.CrossOriginFilter;

import co.rappi.backEndSumaMatriz.businesses.MatrixBusiness;
import co.rappi.backEndSumaMatriz.config.SumaMatrizConfig;
import co.rappi.backEndSumaMatriz.services.MatrixResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;

public class SumaMatriz extends Application<SumaMatrizConfig> {

    private static final String ALLOW_CREDENTIALS = "allowCredentials";
    private static final String ALLOWED_METHODS_PARAMETERS = "OPTIONS,GET,PUT,POST,DELETE,HEAD";
    private static final String ALLOWED_HEADERS_PARAMETERS = "Content-Type,Authorization,X-Requested-With,Content-Length,Accept,Origin";
    private static final String ALLOWED_HEADERS = "allowedHeaders";

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

        final MatrixBusiness matrixBusiness = new MatrixBusiness();
        final MatrixResource matrixResource = new MatrixResource(matrixBusiness); 

        environment.jersey().register(matrixResource);
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
