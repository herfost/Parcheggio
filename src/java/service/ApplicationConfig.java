package service;

import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("resources")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        return resources;
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(qr.QRCode.class);
        resources.add(service.CredenzialiUtenteFacadeREST.class);
        resources.add(service.PermessoFacadeREST.class);
        resources.add(service.UtenteFacadeREST.class);
    }

}
