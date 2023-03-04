package main.java;

public class CompareVersions {
    
    public static void main(String[] args){
       
        //pass in two string versions separated by a space (if only one version is passed in then default values will be used)
        String[] versions = args.length > 1 ? args : new String[]{"1.3", "1.2"};

        System.out.println("1 = version1 > version2\n-1 = version1 < version2\n0 otherwise");

        if(args.length>1){
            System.out.println("You passed in " + versions[0] + " and " + versions[1] +"\nResult = " + compare(versions[0], versions[1]) + "\n");
        } else{
            System.out.println("Default values " + versions[0] + " and " + versions[1] +" used.\nResult = "+ compare(versions[0], versions[1]) + "\n");
        }

        System.out.println("Comparing versions 0.1 and 1.1.\nExpected result = -1\nActual result = " + compare("0.1", "1.1")+ "\n");
        System.out.println("Comparing versions 1.2.9.9.9.9 and 1.10:\nExpected result = -1\nActual result = " + compare("1.2.9.9.9.9", "1.10") + "\n");
        System.out.println("Comparing versions 1.2.9.9.9.8 and 1.3.4.2:\nExpected result = -1\nActual result = " + compare("1.2.9.9.9.8", "1.3.4.2") + "\n");
        System.out.println("Comparing versions 4.3 and 1.10:\nExpected result = 1\nActual result = " + compare("4.3", "1.10") + "\n");

    }
    /**
     * This function splits the versions by each "." in the strings using regex, and stores each number as 
     * an element in an array. These numbers are then compared with the corresponding number in the other version.
     * 
     * When one number is higher than the other, the appropriate result is returned
     * 
     * if version1 is longer than version2, for example 1.2.9.9.9 and 1.3
     * we need only compare up to the length of version 2 (& vice versa if version2 is longer than version1)
     * However, if we have two versions where one length is shorter than the other but the last number in the
     * shorter version is equal to the same element in the other version at that same index, for example "1.3.3" and "1.3.3.4.2", 
     * then the longer version is the higher ordered one
     *
     * if the versions have equal length (equal number of elements in the array) then we must potentially 
     * check every element in the arrays
     * 
     * Note: this function assumes that 1.3.0 is greater than 1.3 etc. 
     * 
     * 
     * @param version1 - contains a string of numbers separated by "."
     * @param version2 - contains a string of numbers separated by "."
     * @return 1 if version1>version2, -1 if version1<version2, 0 otherwise (if they are even)
     */

    public static int compare(String version1, String version2){
        //first convert versions to array, using regex split each version at the "."
        String[] vers1 = version1.split("\\.");
        String[] vers2 = version2.split("\\.");

    
        int length = 0;
        if(vers1.length<vers2.length){
            length = vers1.length;
        } else if(vers1.length>vers2.length){
            length = vers2.length;
        } else{
            length = vers1.length; //lengths are even, does not matter which one is used
        }

        
        for(int i = 0; i<length; i++){
            
            if(Integer.valueOf(vers1[i]) > Integer.valueOf(vers2[i])){
                return 1;
            } else if(Integer.valueOf(vers1[i]) < Integer.valueOf(vers2[i])){
                return -1;
            } 
            //if they are even then the loop moves onto the next value in the array, 0 is returned if they are always even


            //if the lengths of the versions are uneven and it is in the last iteration
            //for example, version1 = 1.3, version2 = 1.3.4
            //vers1 = {1,3} vers2 = {1,3,4}
            // when i is in the last iteration of the loop, we must check if one version has at least one other element in array
            if(i == length-1 && Integer.valueOf(vers1[i]) == Integer.valueOf(vers2[i])){
                if(vers1.length>vers2.length ){
                    return 1;
                } else if(vers1.length<vers2.length){
                    return -1;
                }
            }
        }


        return 0; //if versions are equal
    }

}
