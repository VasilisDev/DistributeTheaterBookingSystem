import java.rmi.Naming;
import java.rmi.RemoteException;
import java.net.MalformedURLException;
import java.rmi.NotBoundException;
import java.util.*;

public class TheaterClient {

  public enum Command{
    list,book,guests,cancel
  }

    public static void main(String[] args) {
        try {

            ArrayList<Integer> positionAvailability = new ArrayList<Integer>();
            ArrayList<Integer> positionCost = new ArrayList<Integer>();
            ArrayList<Integer> reserveAnswer = new ArrayList<Integer>();
            ArrayList<Integer> value = new ArrayList<Integer>();
            List<Object> client = new ArrayList<Object>();
            Scanner scan = new Scanner(System.in);
            String answer;

            if (args.length == 0) {
             System.out.println("for availability and cost, type: list <hostname>");
             System.out.println("for booking, type: book <hostname> <position type> <number> <your name> ");
             System.out.println("for guests, type: guests <hostname>");
             System.out.println("for canceling, type: cancel <hostname> <position type> <number> <name>");
            }
            else
            {
              String action = args[0];
              Command command = Command.valueOf(action);
              String hostname = args[1];
              TheaterInterface theaterInterface = (TheaterInterface)
              Naming.lookup("rmi://"+hostname+":7500/TheaterService");
              switch(command)
              {
                case list:
                positionAvailability = theaterInterface.getPositionsList();
                positionCost = theaterInterface.getCostList();
                System.out.println(positionAvailability.get(0)+" positions of type PA costing "+positionCost.get(0)+" €");
                System.out.println(positionAvailability.get(1)+" positions of type PB costing "+positionCost.get(1)+" €");
                System.out.println(positionAvailability.get(2)+" positions of type PC costing "+positionCost.get(2)+" €");
                System.out.println(positionAvailability.get(3)+" positions of type KE costing "+positionCost.get(3)+" €");
                System.out.println(positionAvailability.get(4)+" positions of type PT costing "+positionCost.get(4)+" €");
                break;
                case book:
                reserveAnswer = theaterInterface.reservePosition(args[2],Integer.parseInt(args[3]),args[4]);
                if(reserveAnswer.get(0)==0)
                {
                  System.out.println("Positions not available");
                  System.out.println("There are "+reserveAnswer.get(1)+" positions");
                  if(reserveAnswer.get(1)>0)
                  {
                    System.out.println("Costing:"+reserveAnswer.get(2));
                    System.out.println("Do you want to reserve them?(y/n)");
                    answer = scan.nextLine();
                    if(answer.equals("y"))
                    {
                      reserveAnswer = theaterInterface.reservePosition(args[2],reserveAnswer.get(1),args[4]);
                        if(reserveAnswer.get(0)==3)
                        {
                          System.out.println("Positions reserved");
                          System.out.println("Total cost:"+reserveAnswer.get(2));
                        }
                        else
                        {
                          System.out.println("In the meantime, was another reservation");
                          System.out.println("Sorry for the inconvenience.");  
                        }

                    }
                  }

                }
                else if (reserveAnswer.get(0)==1)
                {
                  System.out.println("There is already a reservetion with that name, cancel and book again!");
                }
                else
                {
                  System.out.println("Positions reserved");
                  System.out.println("Total cost:"+reserveAnswer.get(2));

                }
                break;

                case guests:
                client = theaterInterface.getguests();
                if(!client.isEmpty())
                {
                  System.out.println("Name-----------Position Type------Positions----------Total Cost");
                  for (int i=1;i<=client.size();i++)
                  {
                     System.out.printf("%-15s",client.get(i-1));
                     if(i%4==0&&i!=0)
                     System.out.println("");
                  }
                }
                else
                {
                  System.out.println("There arent any guests yet.");
                }
                break;

               case cancel:
               value = theaterInterface.cancelBook(args[2],Integer.parseInt(args[3]),args[4]);
                 if(value.get(0)==0)
                 System.out.println("Wrong Inputs!");
                 else if(value.get(0)==1)
                 {
                   System.out.println("Success");
                   System.out.println("Positions "+value.get(1));
                  System.out.println("Cost "+value.get(2));

                 }
                 else if(value.get(0)==2)
                 {
                   System.out.println("Canceling, success!");
                 }
                 else
                 {
                   System.out.println("This name it is not in our list!");
                 }
              }
            }

        }
        catch (MalformedURLException murle) {
            System.out.println();
            System.out.println(
              "MalformedURLException");
            System.out.println(murle);
        }
        catch (RemoteException re) {
            System.out.println();
            System.out.println(
                        "RemoteException");
            System.out.println(re);
        }
        catch (NotBoundException nbe) {
            System.out.println();
            System.out.println(
                       "NotBoundException");
            System.out.println(nbe);
        }
        catch (
            java.lang.ArithmeticException
                                      ae) {
            System.out.println();
            System.out.println(
             "java.lang.ArithmeticException");
            System.out.println(ae);
        }
    }


}
