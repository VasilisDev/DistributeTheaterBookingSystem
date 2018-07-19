import java.util.*;

public class TheaterImpl extends java.rmi.server.UnicastRemoteObject
implements TheaterInterface
{
  Theater theater = new Theater();
  ArrayList<Integer> positionAvailability = new ArrayList<Integer>();
  ArrayList<Integer> costPerType = new ArrayList<Integer>();
  ArrayList<Integer> reserveAnswer = new ArrayList<Integer>();
  ArrayList<Integer> cancel = new ArrayList<Integer>();
  int index;

  public TheaterImpl()throws java.rmi.RemoteException
  {
    super();
    costPerType.add(theater.costTypePA);
    costPerType.add(theater.costTypePB);
    costPerType.add(theater.costTypePC);
    costPerType.add(theater.costTypeKE);
    costPerType.add(theater.costTypePT);
    positionAvailability.add(theater.positionsTypePA);
    positionAvailability.add(theater.positionsTypePB);
    positionAvailability.add(theater.positionsTypePC);
    positionAvailability.add(theater.positionsTypeKE);
    positionAvailability.add(theater.positionsTypePT);
  }

  public ArrayList<Integer> reservePosition(String type,int number,String name)
  throws java.rmi.RemoteException
  {
    index = theater.clientNames.indexOf(name);
    if (!theater.clientNames.contains(name)||(theater.clientNames.contains(name)&&theater.positionType.get(index)!=type))
    switch (type)
    {
      case "PA":
      if(number>theater.positionsTypePA)
      {
        reserveAnswer.clear();
        reserveAnswer.add(0);
        reserveAnswer.add(positionAvailability.get(0));
        reserveAnswer.add(positionAvailability.get(0)*costPerType.get(0));
        return reserveAnswer;
      }
      else
      {
        reserveAnswer.clear();
        theater.positionsTypePA -=number;
        getPositionsList();
        theater.clientNames.add(name);
        theater.positionType.add(type);
        theater.numberOfPositions.add(number);
        theater.totalCost.add(number*costPerType.get(0));
        reserveAnswer.add(1);
        reserveAnswer.add(number);
        reserveAnswer.add(number*costPerType.get(0));
        return reserveAnswer;
      }

      case "PB":
      if(number>theater.positionsTypePB)
      {
        reserveAnswer.clear();
        reserveAnswer.add(0);
        reserveAnswer.add(positionAvailability.get(1));
        reserveAnswer.add(positionAvailability.get(1)*costPerType.get(1));
        return reserveAnswer;
      }
      else
      {
        reserveAnswer.clear();
        theater.positionsTypePB -=number;
        getPositionsList();
        theater.clientNames.add(name);
        theater.positionType.add(type);
        theater.numberOfPositions.add(number);
        theater.totalCost.add(number*costPerType.get(1));
        reserveAnswer.add(1);
        reserveAnswer.add(number);
        reserveAnswer.add(number*costPerType.get(1));
        return reserveAnswer;
      }

      case "PC":
      if(number>theater.positionsTypePC)
      {
        reserveAnswer.clear();
        reserveAnswer.add(0);
        reserveAnswer.add(positionAvailability.get(2));
        reserveAnswer.add(positionAvailability.get(2)*costPerType.get(2));
        return reserveAnswer;
      }
      else
      {
        reserveAnswer.clear();
        theater.positionsTypePC -=number;
        getPositionsList();
        theater.clientNames.add(name);
        theater.positionType.add(type);
        theater.numberOfPositions.add(number);
        theater.totalCost.add(number*costPerType.get(2));
        reserveAnswer.add(1);
        reserveAnswer.add(number);
        reserveAnswer.add(number*costPerType.get(2));
        return reserveAnswer;
      }

      case "KE":
      if(number>theater.positionsTypeKE)
      {
        reserveAnswer.clear();
        reserveAnswer.add(0);
        reserveAnswer.add(positionAvailability.get(3));
        reserveAnswer.add(positionAvailability.get(3)*costPerType.get(3));
        return reserveAnswer;
      }
      else
      {
        reserveAnswer.clear();
        theater.positionsTypeKE -=number;
        getPositionsList();
        theater.clientNames.add(name);
        theater.positionType.add(type);
        theater.numberOfPositions.add(number);
        theater.totalCost.add(number*costPerType.get(3));
        reserveAnswer.add(1);
        reserveAnswer.add(number);
        reserveAnswer.add(number*costPerType.get(3));
        return reserveAnswer;
      }

      case "PT":
      if(number>theater.positionsTypePT)
      {
        reserveAnswer.clear();
        reserveAnswer.add(0);
        reserveAnswer.add(positionAvailability.get(4));
        reserveAnswer.add(positionAvailability.get(4)*costPerType.get(4));
        return reserveAnswer;
      }
      else
      {
        reserveAnswer.clear();
        theater.positionsTypePT -=number;
        getPositionsList();
        theater.clientNames.add(name);
        theater.positionType.add(type);
        theater.numberOfPositions.add(number);
        theater.totalCost.add(number*costPerType.get(4));
        reserveAnswer.add(1);
        reserveAnswer.add(number);
        reserveAnswer.add(number*costPerType.get(4));
        return reserveAnswer;
      }
    }
    reserveAnswer.clear();
    reserveAnswer.add(3);
    return reserveAnswer;
  }

  public ArrayList<Integer> getPositionsList()
  throws java.rmi.RemoteException
  {
    positionAvailability.clear();
    positionAvailability.add(theater.positionsTypePA);
    positionAvailability.add(theater.positionsTypePB);
    positionAvailability.add(theater.positionsTypePC);
    positionAvailability.add(theater.positionsTypeKE);
    positionAvailability.add(theater.positionsTypePT);
    return positionAvailability;
  }

  public ArrayList<Integer> getCostList()
  throws java.rmi.RemoteException
  {
    return costPerType;
  }

  public List<Object> getguests()
  throws java.rmi.RemoteException
  {
    theater.totalList.clear();
    for (int i=0;i<theater.clientNames.size() ;i++ )
    {
      theater.totalList.add(theater.clientNames.get(i));
      theater.totalList.add(theater.positionType.get(i));
      theater.totalList.add(theater.numberOfPositions.get(i));
      theater.totalList.add(theater.totalCost.get(i));
    }
    return theater.totalList;
  }

  public  ArrayList<Integer> cancelBook(String type, int number, String name)
  throws java.rmi.RemoteException
  {
  if(!theater.clientNames.isEmpty())
        if(theater.clientNames.contains(name))
        {
          for (int i =0; i<theater.clientNames.size() ;i++ )
          {
            if(theater.clientNames.get(i).equals(name))
              if(theater.positionType.get(i)==type)
              {
                index = i;
                break;
              }
          }
            if(number<theater.numberOfPositions.get(index))
            {
              theater.totalCost.set(index,(theater.numberOfPositions.get(index)-number)*costPerType.get(index));
              theater.numberOfPositions.set(index,theater.numberOfPositions.get(index)-number);
              theater.setPositionType(type,positionAvailability.get(index)+number);
              positionAvailability.set(index,positionAvailability.get(index)+number);
              cancel.clear();
              cancel.add(1);
              cancel.add(theater.numberOfPositions.get(index));
              cancel.add(theater.totalCost.get(index));
              return cancel;
            }
            else if(number==theater.numberOfPositions.get(index))
            {
              theater.clientNames.remove(index);
              theater.positionType.remove(index);
              theater.numberOfPositions.remove(index);
              theater.totalCost.remove(index);
              theater.setPositionType(type,positionAvailability.get(index)+number);
              positionAvailability.set(index,positionAvailability.get(index)+number);
              cancel.clear();
              cancel.add(2);
              return cancel;
            }
            else
            {
              cancel.clear();
              cancel.add(0);
              return cancel;
            }

        }
        else
        {
          cancel.clear();
          cancel.add(3);
          return cancel;
        }
    else
    {
      cancel.clear();
      cancel.add(3);
      return cancel;
    }
  }
}
