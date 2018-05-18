
public class BabyName
//Class note: This class stores a name and an array of eleven ints
//            representing the name ranks from the census
{
        private String name;  //This stores the name
        private int [] ranks; //This stores the ranks

        //Method note: “none” preconditions and postconditions are left out
        ///// C O N S T R U C T O R S /////
        public BabyName(String n, int [] r)
        //TAS: initialize the name and rank array
        {
        	name = n;
        	ranks = r;
        }//BabyName Constructor

        public BabyName()
        //POS: name == "None" && ranks == null
        //TAS: initialize the name and rank array
        {
        	name = "None";
        	ranks = null;
        }//BabyName Constructor


        //////// A C C E S S O R S ////////
        public String getName()
        //TAS: return the baby's name
        {
          return name;
        }//getName

        public int [] getRanks ()
        //TAS: Return the rank for a specific decade
        {
        	return ranks;
        }//getRank

        public String toString()
        //TAS: Return the data in this babyname as a String
        {
        	String rankList = "";
        	for(int i = 0; i < ranks.length;i++) {
        		rankList += ranks[i] + " ";
        	}
        	return name + ": " + rankList;
        }//toString

	public void setRanks(int [] r)
	{
		ranks = r;
	}
}// BabyName class	

