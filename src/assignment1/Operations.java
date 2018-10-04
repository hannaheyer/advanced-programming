public class Set {

    private String difference(Set firstSet, Set secondSet)
    {
         Set result = new Set();
            for (String f : firstSet) {
            if(!secondSet.contains(f)){
            result.add(f);
            }
            }
         

         return result; 
    }


    private Set intersection(Set firstSet, Set secondSet)
    {
        Set result = new Set();
    
        for (String f : firstSet) {
        if(secondSet.contains(f))
            result.add(f);
            
        }
        return result; 

    }

    private Set union(Set firstSet, Set secondSet)
    {
        Set result = new Set();
        result.AddAll(firstSet);
        result.AddAll(secondSet);
        return result;
    }

    private Set sd(Set firstSet, Set secondSet)
    {
    Set union = union( firstSet,  secondSet);
    Set intersection = intersection( firstSet, secondSet);
    Set result = new Set();
    for (String f : union) {
        if(intersection.contains(f))
            result.add(f);
            
        }
        return result; 
    }
   }