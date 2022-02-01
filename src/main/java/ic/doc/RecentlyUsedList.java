package ic.doc;

import java.util.ArrayList;
import java.util.List;

public class RecentlyUsedList {

  private List<Object> list = new ArrayList<>();
  private int numberOfItems;

  public int getNumberOfItems() {
    numberOfItems = list.size();
    return numberOfItems;
  }

  public void addItemToList(Object item){
    list.add(0, item);
    numberOfItems++;
  }


}
