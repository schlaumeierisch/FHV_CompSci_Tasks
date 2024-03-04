package at.fhv.mme.lab06ejb.server;

import at.fhv.mme.lab06ejb.shared.Greeter;

import javax.ejb.Remote;
import javax.ejb.Stateless;

@Remote(Greeter.class)
@Stateless
public class GreeterRemote implements Greeter {

    @Override
    public String greet(String name) {
        return "Hi, " + name + "!";
    }

}