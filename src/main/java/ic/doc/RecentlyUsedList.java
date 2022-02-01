package ic.doc;

public class RecentlyUsedList {
    public int numberOfItems;
    public void setNumberOfItems(int increment){
        numberOfItems = numberOfItems + increment;
        if (numberOfItems < 0){
            throw new IllegalArgumentException("not defined for negative number of items");
        }
    }


}
