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

  public void addItemToList(Object item) {
    for (int i = 0; i < numberOfItems; i++) {
      if (item == list.get(i)) {
        list.remove(i);
      }
    }
    // Add to front of list
    list.add(0, item);
    numberOfItems++;
  }

  public Object retrieveItem(int index) {
    if (index >= getNumberOfItems()) {
      throw new IndexOutOfBoundsException("not defined for index out of bounds");
    }
    return list.get(index);
  }
}
