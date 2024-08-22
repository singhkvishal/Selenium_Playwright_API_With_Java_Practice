package Java_Examples;

public class ByteExample {
    public static void main(String[] args) {
    /*
        Data Type	Size	Description
        --------------------------------------------
        byte	    1 byte	Stores whole numbers from -128 to 127
        short	    2 bytes	Stores whole numbers from -32,768 to 32,767
        int	        4 bytes	Stores whole numbers from -2,147,483,648 to 2,147,483,647
        long	    8 bytes	Stores whole numbers from -9,223,372,036,854,775,808 to 9,223,372,036,854,775,807
        float	    4 bytes	Stores fractional numbers. Sufficient for storing 6 to 7 decimal digits
        double	    8 bytes	Stores fractional numbers. Sufficient for storing 15 decimal digits
        boolean 	1 bit	Stores true or false values
        char	    2 bytes	Stores a single character/letter or ASCII values
    */
      //Range of byte data in java is -128 to 127. But the byte data type in java is cyclic in nature.
      //byte consist of 8 bit ---> 1 bit sign (positive or negative ) 7 bit value
      //so the range -2^7 negative (-128 ) to 2^7 -1 positive(127)

        byte x = 127;// Number range should be between 0 to 7 and 3 decimal
        x++;
        System.out.println(x);

        byte b=065;  //0 --octal number (base 8) -- 0 to 7

        //octal to decimal number:
        //065 --> 0*8^2  + 6*8^1 + 2*8^0=0+48+5=53
        System.out.println(b+20);//53+20=73

    }
}
