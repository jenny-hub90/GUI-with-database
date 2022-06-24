    //Super Potato Video Game Station
    
    public class VideoGameStation implements Comparable <VideoGameStation>
    {
        /***Question no 1***///declaration of attributes
        private String gameStation;
        private String videoGame;
        private String customerName;
        private String customerType;
        private int bookingDate;
        private int duration;
        private float hourlyRate;
        private boolean availableStatus;
        private int numberofgamesAvailable;
    
        /***Question no 2***///values are assigned
        public VideoGameStation(String gameStation, String videoGame, float hourlyRate){
            this.gameStation = gameStation;
            this.videoGame = videoGame;
            this.hourlyRate = hourlyRate;
    
        }
    
        public static void videogameStation(String[] args){
            String cutomerName = "";
            String customerType = "";
            int bookingDate = 0;
            int duration = 0;
            boolean availableStatus = true;
        }
    
        /***Question no 3***///getter method
        public String getGameStation(){
            return gameStation;
        }
    
        public String getVideoGame(){
            return videoGame;
        }
    
        public String getCustomerName(){
            return customerName;
        }
    
        public String getCustomerType(){
            return customerType;
        }
    
        public int getBookingDate(){
            return bookingDate;
        }
    
        public int getDuration(){
            return duration;
        }
    
        public float getHourlyRate(){
            return hourlyRate;
        }
    
        public boolean getAvailableStatus(){
            return availableStatus;
        }
    
        public int getNumberOfGamesAvailable(){
            return numberofgamesAvailable;
        }
    
        /***Question no.4***/
        public void setHourlyRate(float hourlyRate){
            this.hourlyRate = hourlyRate;
        }
    
        public void setCustomerType(String customerType){
            this.customerType = customerType;
        }
    
        /***Question no 5***///setter method
        public void bookingStation(String customerName, String customerType, int bookingDate, int timeDuration){
            if(availableStatus!= false){
                System.out.println("Sorry for the inconvenience! we are not available! come after 10am"+bookingDate +duration);
            }
            else{
                this.customerName = customerName;
                this.customerType = customerType;
                this.bookingDate = bookingDate;
                this.duration = timeDuration;
                this.availableStatus = false;
            }
        }
    
        /***Question no 6***///conditional statement is used to check whether game station is available or not
        public void checking(){
            if(availableStatus==true){
                System.out.println("Welcome to Super Potato Game Station. Please proceed to counter 1 to select what game you want to play");
            }
            else{
                this.customerName = "";
                this.customerType = "";
                this.bookingDate = 0;
                this.duration = 0;
                this.availableStatus = true;
            }
        }
    
        /***Question no 7***///function is made to display logical statement
        public void display(){
            System.out.println("Yokoso everyone form our Super Potato Game Station.You can get a great gaming experience here."+gameStation);
            System.out.println("Hourly rate charge is Rs:"+hourlyRate);
        }
    
        @Override
        public int compareTo(VideoGameStation mobileLegend) {
            int decide = (this.gameStation).compareTo((mobileLegend.gameStation));
            return decide;
         }
    }
    
