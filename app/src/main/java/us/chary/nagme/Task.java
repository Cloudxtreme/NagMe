package us.chary.nagme;

import java.util.Date;

/**
 * Created by Zach on 10/24/2015.
 */
public class Task {
    String description;
    Date due;
    Date created;
    int nags; // number of times the user has been nagged about this
    int difficulty; // difficulty from 0 to 5 with 5 being impossible and 0 being trivial
    int priority; // priority from 0 to 5 with 5 being top priority and 0 being "doesn't matter"
}
