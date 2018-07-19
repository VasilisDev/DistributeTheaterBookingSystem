import java.util.*;

public interface TheaterInterface extends java.rmi.Remote
{
  public ArrayList<Integer> reservePosition(String type,int number,String name)
  throws java.rmi.RemoteException;

  public ArrayList<Integer> getPositionsList()
  throws java.rmi.RemoteException;

  public ArrayList<Integer> getCostList()
  throws java.rmi.RemoteException;

  public List<Object> getguests()
  throws java.rmi.RemoteException;

  public  ArrayList<Integer> cancelBook(String type, int number, String name)
  throws java.rmi.RemoteException;
}
