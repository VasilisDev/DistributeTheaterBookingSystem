import java.util.*;


public class Theater implements java.io.Serializable {

   ArrayList<String> clientNames = new ArrayList<String>();
   ArrayList<String> positionType = new ArrayList<String>();
   ArrayList<Integer> numberOfPositions = new ArrayList<Integer>();
   ArrayList<Integer> totalCost = new ArrayList<Integer>();
   List<Object> totalList = new ArrayList<Object>();
   int positionsTypePA=200,positionsTypePB=300,positionsTypePC=500;
   int positionsTypeKE=100,positionsTypePT=50;
   String type;
   int costTypePA=50,costTypePB=40,costTypePC=30;
   int costTypeKE=25,costTypePT=20;

     public void setPositionType(String type,int number)
     {
       switch (type) {
         case "PA":
         positionsTypePA = number;
         break;
         case "PB":
         positionsTypePB = number;
         break;
         case "PC":
         positionsTypePC = number;
         break;
         case "KE":
         positionsTypeKE = number;
         break;
         case "PT":
         positionsTypePT = number;
         break;
         default:
         System.out.println("wrong inputs!");
       }
     }
   }
