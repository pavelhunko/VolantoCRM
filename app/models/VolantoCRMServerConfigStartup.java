package models;

import com.avaje.ebean.config.ServerConfig;
import com.avaje.ebean.event.ServerConfigStartup;

public class VolantoCRMServerConfigStartup implements ServerConfigStartup {

    @Override
    public void onStart(ServerConfig serverConfig) {
	serverConfig.setDatabaseSequenceBatchSize(1);
    }

}
