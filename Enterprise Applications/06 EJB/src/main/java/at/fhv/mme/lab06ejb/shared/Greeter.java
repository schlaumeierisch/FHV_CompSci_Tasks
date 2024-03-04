package at.fhv.mme.lab06ejb.shared;

import javax.ejb.Remote;
import java.io.Serializable;

@Remote
public interface Greeter extends Serializable {

    String greet(String name);

}
