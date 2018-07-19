import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class TheaterServer {

   public TheaterServer() {
     try {
       TheaterInterface theater = new TheaterImpl();
       LocateRegistry.createRegistry(7500);
       Naming.rebind("rmi://localhost:7500/TheaterService", theater);
     } catch (Exception e) {
       System.out.println("Trouble: " + e);
     }
   }

   public static void main(String args[]) {
     new TheaterServer();
   }
}
