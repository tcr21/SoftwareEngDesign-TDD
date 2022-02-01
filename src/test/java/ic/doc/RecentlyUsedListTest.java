/* Recently Used List
- The list should be empty when initialised
- We should be able to add things to the list
- We should be able to retrieve items from the list
- The most recent item should be first in the list
- Items in the list are unique, so duplicate insertions should be moved rather than added
*/

package ic.doc;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.fail;

public class RecentlyUsedListTest {

  RecentlyUsedList recentlyUsedList = new RecentlyUsedList();

  @Test
  public void listIsEmptyWhenInitialised() {
    assertThat(recentlyUsedList.getNumberOfItems(), is(0));
  }

  @Test
  public void canAddThingsToList(){
    int previousNumberOfItems = recentlyUsedList.getNumberOfItems();
    String item = "07000000000";
    recentlyUsedList.addItemToList(item);
    assertEquals(previousNumberOfItems + 1, recentlyUsedList.getNumberOfItems());
  }

  @Test
  public void canAddOtherThingsToList(){
    int previousNumberOfItems = recentlyUsedList.getNumberOfItems();
    int item = 42;
    recentlyUsedList.addItemToList(item);
    assertEquals(previousNumberOfItems + 1, recentlyUsedList.getNumberOfItems());
  }

  @Test
  public void canRetrieveThingsFromList(){
    int index = 0;
    String item = "07000000000";
    recentlyUsedList.addItemToList(item);
    Object retrievedItem = recentlyUsedList.retrieveItem(index);
    assertEquals(item, retrievedItem);
  }

  @Test
  public void isNotDefinedForOutOfBoundsIndex(){
    int index = recentlyUsedList.getNumberOfItems();
    try{
      recentlyUsedList.retrieveItem(index);
      fail("should have thrown exception");
    } catch (IndexOutOfBoundsException e) {
      assertThat(e.getMessage(), containsString("index out of bounds"));
    }
  }

  @Test
  public void mostRecentItemIsFirstInList(){
    String item1 = "07000000001";
    String item2 = "07000000002";
    String item3 = "07000000003";
    recentlyUsedList.addItemToList(item1);
    recentlyUsedList.addItemToList(item2);
    recentlyUsedList.addItemToList(item3);
    assertEquals(recentlyUsedList.retrieveItem(0), item3);
    assertEquals(recentlyUsedList.retrieveItem(1), item2);
    assertEquals(recentlyUsedList.retrieveItem(2), item1);
  }

  @Test
  public void itemsInListAreUnique(){
    for (int i = 0; i < recentlyUsedList.getNumberOfItems(); i++){
      for (int j = 0; j < recentlyUsedList.getNumberOfItems(); j++){
        assertNotEquals(recentlyUsedList.retrieveItem(i), recentlyUsedList.retrieveItem(j));
      }
    }
  }

}
