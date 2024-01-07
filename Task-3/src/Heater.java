public class Heater {

    public static void main(String[] args){
        
    }

    //Exercise 2.92
    private double temperature;

    private Heater(){
        temperature = 15.0;
    }
/*     private void warmer(){
       temperature -= 5.0;
    }

      private void cooler(){
        temperature -= 5.0;
    }
*/
    private double getTemperature(){
        return temperature;
    }

    //Exercise 2.93
    private double min;
    private double max;
    private double increment;

    private Heater(double min, double max){
        temperature = 15.0;
        this.min = min;
        this.max = max;
        increment = 5.0;
    }

    private void warmer(){
        if((temperature + increment) > max){
            System.out.println("The temperature cannot be increased any more!");
        }
        else{
            temperature += increment;
        }

    }
    private void cooler(){
        if((temperature - increment) < min){
            System.out.println("The temperature cannot be decreased any more!");
        }
        else{
            temperature -= increment;
        }
    }

    //If negative values are allowed, the program will not function as expected because the cooler method will act as a warmer and vice versa.
    //For example, cooler() with an increment of -5 will increase  the temperature to 20
    //Additionally, the min and max values can be exceeded.
    private void setIncrement(double increment){
        if(increment > 0){
            this.increment = increment;
        }
        else{
            System.out.println("The increment must be positive!");
        }
    }
}
