/**
 * CS374 Software Engineering I
 * Brett Hammit
 *Teamalizer Java
 */

 //making Teamalizer class

import java.util.Arrays;
import java.util.Random;
import java.util.*;

 public class Teamalizer 
 {
     //declaring all string arrays that are going to be used
     private static String[] people;
     private static String[] goodNames;
     private static String[] highestNames;
     private static String[] weight;
     private static String[] tempNames;
     private static String[] tempWeight;
     private static String[] con;
     private static String[] numArray;
     private static String[] TempNumArray;
     private static String[] topNumArray;
     private static String[][] namesLoop;
     private static int[] personTopHappiness;
     private static int[] personHappinessGreater;
     private static int[] teamHappiness;
     private static int[] topTeamHappiness;
     public static String[] Empty = new String[0];

     //for working with random ints later on
     public static Random r = new Random();

     //defining variable values
     private static int pholder = 0;
     private static int tempPholder = 0;
     private static int highestHappiness = 0;
     private static int Happiness = 0;
     private static int testHappiness = 0;
     private static int verb = 0;
     public static int test = 0;
     public static int it = 0;

     //parameters that can be changed
     private static int tSize;
     private static int pref;
     private static double decline; 
    
     //how many times we loop through and how many times we mix up the teams
     private static int numLoops=10 ;
     private static int mixNum=500;
 
     //creating setters that are cloned to be worked with later on
     public static void setGoodNames(String[] input) { goodNames = input.clone(); }
     public static void setHighestNames(String[] input) { highestNames = input.clone(); }
     public static void setTempNames(String[] input) { tempNames = input.clone(); }
     public static void setTempNumberArray(String[] input) { TempNumArray = input.clone(); }
     public static void setWeight(String[] input) { weight = input.clone(); }
     public static void setTempWeight(String input[]) {tempWeight = input.clone();}
     public static void setStr(String input) { str = input; }
     public static void setTSize(int input) {tSize = input;}
     public static void setPref(int input) {pref = input+1;}
     public static void setDecline(double input) {decline = input/100.0;}
     public static void setPholder(int input) {pholder=input;}
     public static void setNumLoops(int input){numLoops=input;}
     public static void setMixNum(int input) { mixNum = input; }
     public static void setTempPholder(int input) { tempPholder = input; }
     public static void setTopHappiness(int input) { Happiness = input; }
     public static void setHappiness(int input) { Happiness = input; }
     public static void setTestHappiness(int input) { testHappiness = input; }
     public static void setContent(String input) { content = input; }
     public static void setVerb(int input) { verb = input; }
 
     
     //defining get functions that allow us to get information regarding to the txt file and code
     public static int getPref() {return pref;}
     public static double getDecline() {return decline;}
     public static String getStr() {return str;}
     public static int getTeamSize() {return tSize;}
     public static int getTestHappiness() {return testHappiness;}
     public static int getVerb() {return verb;}
     public static int getPholder() {return pholder;}
     public static int getNumLoops() {return numLoops;}
     public static int getMixNum() {return mixNum;}
     public static String[] getListofPeople() {return goodNames;}
     public static String[] getWeightList() {return weight;}
     public static String[] getPeople() {return people;}
     public static String[] getTempNames() {return tempNames;}
     public static String[] getTempWeight() {return tempWeight;}
     public static String[] getCon() {return con;}
     public static String[] getHighestNames() {return highestNames;}
 
     //all variables regarding to strings
     private static String content;
     private static String str = "";

     //creating the defaults for the parameters of the loop
     public void basic() 
     {
         setTempPholder(0);
         setHappiness(0); 
         setTestHappiness(0);
         setContent("");
         setTSize(3);
         setPref(9);
         setDecline(2);
         setPholder(0);
         setNumLoops(4);
         setMixNum(500);
         test = 0;
     }
     
     //function that is able to reset happiness for the loop to search for another higher number of happiness
     public static void reset() 
     {
         setTestHappiness(0); 
         setHappiness(0); 
         setContent("");
         it = 0;
         
         goodNames = get(Empty);
         
         weight = getWeight(goodNames);
         
         numArray = new String[goodNames.length];
         
         //loop that fills array in order to compare to the weights students have given their peers
         for(int i = 0; i < numArray.length; i++)
         {
             String stringTemp = String.valueOf(i+1);
             
             numArray[i] = stringTemp;
         }
         
     }
     
     //javac  src/main/java/Teamalizer.java
     //java -cp src/main/java Teamalizer T 2 V 2 N 1 L 500 D 4 P 9 < prefs/prefs.txt
     public static void main (String[] args)
     {
         if(args.length > 0)
         {
             for( int i = 0; i < args.length; i++)
             {
                //setting the correct team size based on the array
                if(args[i].equals("T"))
                 {	
                     setTSize(Integer.parseInt(args[i+1]));
                     if(getVerb() == 1 || getVerb() == 2 || getVerb() == 3 || getVerb() == 4) 
                         System.out.println("tSize: " + getTeamSize());
                 }
                //showing the verbosity
                 if(args[i].equals("V"))
                 {
                     setVerb(Integer.parseInt(args[i+1]));
                     if(getVerb() == 1 || getVerb() == 2 || getVerb() == 3 || getVerb() == 4) 
                         System.out.println("verb: " + getVerb());
                 }
                 //giving the number of loops/swaps for the algo
                 if(args[i].equals("N"))
                 {
                     setNumLoops(Integer.parseInt(args[i+1]));
                     if(getVerb() == 1 || getVerb() == 2 || getVerb() == 3 || getVerb() == 4) 
                         System.out.println("numLoops: " + getNumLoops());
                 }
                 //giving the number of times we want to mix to find highest happiness
                 if(args[i].equals("L"))
                 {
                     setMixNum(Integer.parseInt(args[i+1]));
                     if(getVerb() == 1 || getVerb() == 2 || getVerb() == 3 || getVerb() == 4) 
                         System.out.println("mixNum: " + getMixNum());
                 }
                 //showing the amount of decline in percentage
                 if(args[i].equals("D"))
                 {
                     setDecline(Integer.parseInt(args[i+1]));
                     if(getVerb() == 1 || getVerb() == 2 || getVerb() == 3 || getVerb() == 4) 
                         System.out.println("Decline: " + getDecline());
                 }
                 //giving the number of preferences that students made in the txt file
                 if(args[i].equals("P"))
                 {
                     setPref(Integer.parseInt(args[i+1]));
                     if(getVerb() == 1 || getVerb() == 2 || getVerb() == 3 || getVerb() == 4) 	
                         System.out.println("Preferences: " + (getPref()-1)+"\n");
                 }
             }
         }
         
         //opening scanner to continue to get next lines
         if(test == 0)
         {
             Scanner scanner = new Scanner(System.in);
             while(scanner.hasNext())
             {
                 setStr(getStr() + scanner.next() + " ");
             }
         }
         //using get functions for our empty array and getWeight for the names in the goodNames array
         goodNames = get(Empty);
         
         weight = getWeight(goodNames);
         
         numArray = new String[goodNames.length];
         
         for(int i = 0; i < numArray.length; i++)
         {
             String stringTemp = String.valueOf(i+1);
             numArray[i] = stringTemp;
         }
         
         //finding the size of the arrays so we can store the largest ints that we find in them to comp
         topNumArray = new String[goodNames.length];
         
         highestNames = new String[weight.length];
         
         personTopHappiness = new int[goodNames.length];
         
         topTeamHappiness = new int[goodNames.length/tSize];
         
         namesLoop = new String[mixNum][goodNames.length];
         
         if( getVerb() == 1 || getVerb() == 2 || getVerb() == 3 || getVerb() == 4) 	
             System.out.println("Mixing");
         
         for(int n = 0; n < numLoops; n++)
         {
             //reset the happiness in order to try and find the higher level of happiness
             reset();
             if(getVerb() == 1 || getVerb() == 2 || getVerb() == 3 || getVerb() == 4) 
                 System.out.println("Resetting");
             
             for(int i = 0; i < mixNum; i++)
             {
                //mixing the teams and then finding the happiness for the teams then comparing them  
                mix();
                
                calc(tempNames, tempWeight);
                
                comp();
                 
                if(getVerb() == 2 || getVerb() == 3 || getVerb() == 4) 
                     System.out.printf("[" + i + "]");
                if(getVerb() == 3 || getVerb() == 4) 
                     System.out.println("Happiness: " + Happiness);
                if(getVerb() == 2)
                     System.out.println("");		
             }
         }	
         
         if( getVerb() == 2 || getVerb() == 3 || getVerb() == 4) 
         {	
             System.out.println("Finished");
         }
             
         System.out.println("");
         System.out.println("Top Total Happiness: "+highestHappiness+"\n");
         
         //showing a list of the teams with the highest happiness
         showTeams(highestNames);
     }
 
     //pulls names from the array and also determines team size and finds the placeholder positions
     public static String[] get(String[] testNames) 
     {		
             if(getVerb() == 3 || getVerb() == 4) 
             if(getVerb() == 2 || getVerb() == 3 || getVerb() == 4) 
             
             //setting the placeholder size at 0
             setPholder(0);
             tempPholder = 0;
             
             if(test == 0)
                 people = getStr().split(" ");
             else 
                 people = testNames.clone();
                 
             //finds the length of the array with the people in it and determines if there is a remainder in case of placeholders being needed
             int length = people.length;
             int remainder = length%tSize;
             if( tSize-remainder!=tSize )
                 setPholder(tSize-remainder);
             
             //adding a certain number of placeholders to length and then replacing with the new length
             length += pholder;
             String[] goodNames = new String[length];
             
             //loop through and set the old array length equal to the new one
             for(int i = 0; i < people.length; i++)
                 goodNames[i] = people[i];
             
             
             //determines if pholders are needed and showing where we would need them
             if(remainder > 0)
             {
                 tempPholder = getPholder();
                 int i = length-tempPholder;
                 while(tempPholder != 0)
                 {
                     goodNames[i] = "pholder";
                     
                     i++;
                     
                     tempPholder--; 
                 }
             }
             
             return goodNames;	
     }
 
     //function to splice array and get names and weights and store the in seperate arrays with pholders accounted for
     public static String[] getWeight(String[] people)
     {
         if(getVerb() == 3 || getVerb() == 4) 
         if(getVerb() == 2 || getVerb() == 3 || getVerb() == 4) 

         //make an array to old names and weights seperatly
         weight = new String[people.length * pref];
         int start = 0;
         
         for(int i = 0; i < people.length; i++)
         {
             //splicing the array at each ,
             String[] spliced = people[i].split(",");
             System.arraycopy(spliced, 0, weight, start, spliced.length-1);
             start += pref;		
         }
         
         //dispersing the weights that we can ignore
         for(int i = 0; i < weight.length; i++)
             if(weight[i] == null)
                 weight[i] = "_";
             
         //when adding placeholder there should only be 1 blank dispersed per teeam
         for(int i = 0; i < weight.length; i++)
         {	if(weight[i] == "pholder")
                 for(int p = 2; p < pref; p++)
                     weight[p+i] = "_._";
                 
         }
         return weight;
     }
    //function that checks if person voted for themselves
    public static boolean voteSelf(String people[],int code)
        {
            for (int i=0; i<people.length; i++) {
                if (Integer.toString(code).equals(people[i]))
                    return true;
                }
                return false;
                }
     
     //function that deals with mixing the teams to find the highest happiness value
     public static void mix()
     {
         if(getVerb() == 3 || getVerb() == 4) 
             
         tempNames = new String[goodNames.length];
         
         tempWeight = new String[weight.length];
         
         TempNumArray = new String[goodNames.length];
         
         //creating temporary arrays of the same size so we can fill them
         if(test == 0)	
         {	
             for(int i = 0; i < weight.length; i++)
                 tempWeight[i] = weight[i];

             for(int i = 0; i < tempNames.length; i++)
                 tempNames[i] = goodNames[i];

             for(int i = 0; i < tempNames.length; i++)
                 TempNumArray[i] = numArray[i];
         }
         
         //to see if we need to mix the array again in the same spot or to break the loop with not mixes left to try
         boolean cont = false;
         
         int tryAgain = 0;
         
         while(cont == false)
         {
             Random rand = new Random(); 
             
             //making random integers to fill arrays with for the swaps
             int switchA = rand.nextInt(goodNames.length-1); 
             
             int switchB = rand.nextInt(goodNames.length-1);
             
             //swap until values are different
             while(switchA == switchB)
                 switchB = rand.nextInt(goodNames.length-1); 
             
             //This is for swapping the prefercne lists and to keep weight and name list parallel
             int switchP = switchA * pref;
             int switchQ = switchB * pref;
             
             String nameSwap = "";
             String weightSwap = "";
             
             //making swaps to test and then storing them in temp arrays to be able to check later
             nameSwap = tempNames[switchA];
             
             tempNames[switchA] = tempNames[switchB];
             
             tempNames[switchB] = nameSwap;
             
             nameSwap = TempNumArray[switchA];
             
             TempNumArray[switchA] = TempNumArray[switchB];
             
             TempNumArray[switchB] = nameSwap;
             
             //swapping preference indexes with the weight
             for(int i = 0; i < pref; i++)
             {
                 weightSwap = tempWeight[switchP+i];
                 
                 tempWeight[switchP+i] = tempWeight[switchQ+i];
                 
                 tempWeight[switchQ+i] = weightSwap;
             }
 
             if(test == 0)
             {
                 //loop through to add to the array each time there is a mix that occurs
                 for(int i = 0; i < tempNames.length; i++)	
                     namesLoop[it][i] = tempNames[i];
                     
                 //preveneting reoccuring mixes
                 for(int i = 0; i < it-1; i++)
                     if(Arrays.equals(tempNames, namesLoop[i]))
                     {
                         tryAgain++;
                         if(getVerb() == 3 || getVerb() == 4)
                         cont = false;
                         break;
                     }
                     else
                         cont = true;
                     if(it < 2)
                         cont = true;
             }
             if(test == 1)
                 cont = true;
             
             //telling the algo to move on if it has tried to mix 100 times
             if(tryAgain > 100)
                 cont = true;
         }
         //add after each iteration of the loop
         it++;
     }
     
     //function that handles calculating the happiness of team as well as individuals
     public static void calc(String[] listNames, String[] weightsList)
     {	
         if(getVerb() == 3 || getVerb() == 4) 
                 System.out.println("running calc()");
             
         //creating arrays to help with listing out the calculations of the happiness
         String[] listOfWeightS = new String[pref];
         String[] numList = new String[tSize];
         int[] personHappinessLess = new int[listNames.length/tSize];
         
         personHappinessGreater = new int[listNames.length];
         
         teamHappiness = new int[listNames.length/tSize];
         
         //making sure to put arrays back to 0 so we dont compare a happiness level that we have already compared
         Arrays.fill(personHappinessGreater, 0);
         
         Arrays.fill(teamHappiness, 0);
         
         Arrays.fill(personHappinessLess, 0);
     
         int count = 0;
         for(int n = 0; n < listNames.length/tSize; n++)
         {
             //creates a list of numbers
             System.arraycopy(TempNumArray, tSize*n, numList, 0, tSize);
             for(int j = 0; j < tSize; j++)
             {
                 
                 //creates a list of weights						
                 System.arraycopy(weightsList, pref*count, listOfWeightS, 0, pref);
                 for(int i = 0; i < tSize; i++)
                 {	
                     for(int k = 0; k < pref; k++)
                     {
                         if(getVerb() == 4) 
                         {		
                             System.out.printf(numList[i] + " == " + (listOfWeightS[k]));
                             if(numList[i].equals(listOfWeightS[k]) || "___".equals(listOfWeightS[k]))
                                 System.out.println("added happiness");
                             else 
                                 System.out.println("");
                         }	
                         
                         //dealing with peoples prefs relative to the weights that they carry
                         if(numList[i].equals(listOfWeightS[k]))
                             if(k == 1)
                                 personHappinessLess[j] += 4;
                             else if(k == 2)
                                 personHappinessLess[j] += 3;
                             else if(k == 3)
                                 personHappinessLess[j] += 2;
                             else if(k > 3)
                                 personHappinessLess[j] += 1;
                         
                         if("___".equals(listOfWeightS[k]) )
                             personHappinessLess[j] += 1;
                     }
                 }
                 count++;
             }
             //resetting arrays and filling personHappinessLess into personHappinessGreater
             System.arraycopy(personHappinessLess, 0, personHappinessGreater, tSize*n, tSize);
             Arrays.fill(personHappinessLess, 0);
         }
         
         //loops to get the teams happiness
         int i = 0;
         for(int p = 0; p < teamHappiness.length; p++)
             for (int j = 0; j < tSize; j++)
             {	
                 teamHappiness[p] += personHappinessGreater[i]; 
                 i++;
             }
 
         //gets the total overall happiness
         int total = 0;
         for(int z = 0; z < teamHappiness.length; z++)
         {
             total += teamHappiness[z];
         }
         testHappiness = total;
     }	
     
     
     public static void comp()
     {
         if(getVerb() == 3 || getVerb() == 4) 
                 System.out.println("running comp()");
         
         float chance = r.nextFloat();
         
         //if statement to show the tested happiness compared to the original found happiness
         if(testHappiness > Happiness)
         {
             //setting the currents to the ones we have tested
             weight = tempWeight.clone();
             
             goodNames = tempNames.clone();
             
             numArray = TempNumArray.clone();
             
             Happiness = testHappiness;
         }
         else if(chance < decline)
         {
             //changing the currents even if there was a decline due to hill climbing
             weight = tempWeight.clone();
             
             goodNames = tempNames.clone();
             
             numArray = TempNumArray.clone();
             
             Happiness = testHappiness;
         }
         
         //testing if the current happiness is higher than one we have found and if so storing it as the new highest happiness level found
         if(Happiness > highestHappiness)
         {	
             topTeamHappiness = teamHappiness.clone();
             
             personTopHappiness = personHappinessGreater.clone();
             
             highestHappiness = Happiness;
             
             highestNames = weight.clone();
             
             topNumArray = numArray.clone();
             
             if( getVerb() == 1 || getVerb() == 2 || getVerb() == 3 || getVerb() == 4)
                 System.out.println("\nNew Highest Happiness Value: [" + highestHappiness + "]");
             if(getVerb() == 3 || getVerb() == 4)
                 showTeams(highestNames);
         }    
     }
     
     //function that shows the output of teams
     public static void showTeams(String[] input)
     {
         if(getVerb() == 3 || getVerb() == 4) 
                 System.out.println("running showTeams()");
         
         int k = 0;
         String outTeams = "";
         String[] outputTeams = new String[input.length/pref/tSize];
         String[] outNames = new String[input.length/pref];
         
         //puts just names into array
         Arrays.fill(outputTeams, "");
         for(int i = 0; i < input.length; i++)
             if(i%pref == 0)
             {
                 outNames[k] = input[i];
                 
                 k++;
             }
             
         //putting the names into their respective teams
         int i = 0;	
         for(int p = 0; p < outputTeams.length; p++)
             for(int j = 0; j < tSize; j++)
             {
                 outputTeams[p] += outNames[i] + " (" + personTopHappiness[i] + ")"; 
                 if(j+1 == tSize)
                     outputTeams[p] += " ";
                 else 
                     outputTeams[p] += ", ";
 
                 i++;
             }
         
         //showing teams with total happiness and each persons happiness
         for(int q = 0; q < outputTeams.length; q++)
         {	
             System.out.printf("Team: " + (q+1) + " (" + topTeamHappiness[q] + "): "); 
             System.out.println(outputTeams[q] + "\n");
         }
     }
 }
