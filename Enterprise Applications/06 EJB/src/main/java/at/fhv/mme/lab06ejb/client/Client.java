package at.fhv.mme.lab06ejb.client;

import at.fhv.mme.lab06ejb.shared.Greeter;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import java.util.Properties;

public class Client {

    public static void main(String[] args) {

        try {

            Properties props = new Properties();
            props.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
            props.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
            Context ctx = new InitialContext(props);

            Greeter greeter = (Greeter) ctx.lookup("ejb:/EJB-1.0-SNAPSHOT/GreeterRemote!at.fhv.mme.lab06ejb.shared.Greeter");

            System.out.println(greeter.greet("Matthias"));

        } catch (NamingException e) {
            e.printStackTrace();
        }

    }

}
