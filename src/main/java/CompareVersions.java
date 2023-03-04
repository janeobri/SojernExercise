package main.java;

public class CompareVersions {
    
    public static void main(String[] args){
       
        //pass in two string versions separated by a space (if only one is passed in then this will assign versions)
        String[] versions = args.length > 1 ? args : new String[]{"1.3", "1.2"};

        System.out.println("1 = version1 > version2\n-1 = version1 < version2\n0 otherwise");

        if(args.length>1){
            System.out.println("You passed in " + versions[0] + " and " + versions[1] +"\nResult = " + compare(versions[0], versions[1]) + "\n");
        } else{
            System.out.println("Default values " + versions[0] + " and " + versions[1] +" used.\nResult = "+ compare(versions[0], versions[1]) + "\n");
        }

        
        //given 0.1 < 1.1 < 1.2 < 1.2.9.9.9.9 < 1.3 < 1.3.4 < 1.10
        System.out.println("Comparing versions 0.1 and 1.1.\nExpected result = -1\nActual result = " + compare("0.1", "1.1")+ "\n");
        System.out.println("Comparing versions 1.2.9.9.9.9 and 1.10:\nExpected result = -1\nActual result = " + compare("1.2.9.9.9.9", "1.10") + "\n");
        System.out.println("Comparing versions 1.2.9.9.9.8 and 1.3.4.2:\nExpected result = -1\nActual result = " + compare("1.2.9.9.9.8", "1.3.4.2") + "\n");
        System.out.println("Comparing versions 4.3 and 1.10:\nExpected result = 1\nActual result = " + compare("4.3", "1.10") + "\n");

    }
    /**
     * This function splits the version strings using regex by each "." found and stores each number as 
     * an element in an array.
     * 
     * if version1 (vers1 containing each number inbetween the ".") is longer than version2 then 
     * the most we need to check is the length of version 2 (+1 if no number has been returned, for example,
     * version1 = "1.3.3" version2 = "1.3.3.4")
     * for example, if we have version1 = 1.2.9.9.9.9 and version2 = 1.3, 1.3 is the higher version,
     * we do not need to check after the 3 in 1.3
     * Vice versa for if vers1 < vers2, the most we need to check is the last place in version1
     *
     * 
     * if the versions have equal length (equal number of elements in the array) then must potentially 
     * check every element 
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

            //if the lengths of the versions are uneven and it is in the last loop
            //for example, version1 = 1.3, version2 = 1.3.4
            //vers1 = {1,3} vers2 = {1,3,4}
            // when i is in the last iteration of the loop, we must check if one version has another element in array
            if(i == length-1 && Integer.valueOf(vers1[i]) == Integer.valueOf(vers2[i])){
                if(vers1.length>vers2.length ){
                    return 1;
                } else if(vers1.length<vers2.length){
                    return -1;
                }
            }
        }


        return 0;
    }

}
