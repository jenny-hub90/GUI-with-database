    import java.util.ArrayList;
    import java.util.*;
    public class GameParlour
    {
        //***Question no.8***//
        private ArrayList<VideoGameStation> gamerList=new ArrayList<VideoGameStation>();
        //creating an attribute of array list of objects of type VideoGameStation
    
        //***Question no.9***//
        public void addVideoGameStation(String gameStation,String videoGame, int hourlyRate){
            gamerList.add(new VideoGameStation(gameStation,videoGame,hourlyRate));
        }
        //method is created to add  a new video game station  
    
        //***Question no.10***//
        public void  iHateYou(int IndexNum){
            try{
                gamerList.remove(IndexNum);//method created to remove a particular object from the arraylist
            }
            catch (IndexOutOfBoundsException caughtError){
    
                System.out.println("Error in your index no.");//outputs when the given index no is more or less than the number we have allocated to the arraylist
            }
        }
        
    
        //***Question no.11***//
        public void  book(int  IndexNum, String  customerName ,String  costumerType, int bookingDate , int timeDuration){
            //method to book station records
    
            try{
                VideoGameStation player = gamerList.get(IndexNum);
                player.bookingStation(customerName, costumerType, bookingDate,timeDuration);
                //calling the method bookingStation of previous class
            }
    
            catch (IndexOutOfBoundsException error){
                System.out.println("Error in your index no.");//Outputs when the index number is inavalid
            }
    
        }
    
        //***Question no.12***//
        public void checked(int index){
            //method to hire the station for its customer
    
            try{
                {
                    gamerList.get(index).checking();
                    //calling the method checking from VideoGameStation to make the video station available for free
    
                }
            }
            catch(IndexOutOfBoundsException error){
                System.out.println("Error in your index no.");//ouputs if you enter invalid index no
            }
    
        }
    
        //***Question no.13***//
        public void available(){
            //method created to list all the objects of previous class in the array list
            for (VideoGameStation playList : gamerList) {
                if (playList.getAvailableStatus()) {//boolean attribute is called from previous class
                    System.out.println(gamerList.indexOf(playList));
                    playList.display();
                }
            }
        }
    
        //***Question no.14***//
        public void searchKey(String  yourName, int hourPlay) {
            //method created for searching a particular objects from previous class that are available
            for (VideoGameStation playList:gamerList){
                if (playList.getAvailableStatus()==false){
                    if (playList.getVideoGame().equalsIgnoreCase(yourName) && playList.getHourlyRate()<=hourPlay){
                        System.out.println(gamerList.indexOf(playList));//outputs when the record does not match with the search list
                    }
                }
            }
        }
    
        //***Question no.15***//
        public void sortGame() {
            //method created to display customer name along with the names of booked video game station in ascending order
            Collections.sort(gamerList);
    
            for (VideoGameStation playList : gamerList) {
                if (!playList.getAvailableStatus())
                    System.out.println(playList.getGameStation() + " " + playList.getCustomerName());
            }
        }
    }
