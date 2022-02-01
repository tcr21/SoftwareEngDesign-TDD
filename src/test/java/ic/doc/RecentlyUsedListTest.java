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

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.fail;

public class RecentlyUsedListTest {

    RecentlyUsedList recentlyUsedList = new RecentlyUsedList();

    // TBC if this is only check for new instance (initiation) of list
    @Test
    public void checksTheListIsEmptyWhenInitialised(){
       assertThat(recentlyUsedList.numberOfItems, is(0));
    }

    @Test
    public void isNotDefinedForNegativeNumberOfItems(){
        try{
            recentlyUsedList.setNumberOfItems(-1);
            fail("should have thrown exception");
        } catch(IllegalArgumentException iae){
            assertThat(iae.getMessage(), containsString("negative number of items"));
        }
    }

}
