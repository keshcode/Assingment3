package com.example.keshav.assignment3.model;


/**
 * Created by keshav on 20/4/17.
 */

public class Items {
    private String itmName, itmValue;

    /**
     * @param itmName  name of item
     * @param itmValue vlaue of item
     */
    public Items(final String itmName, final String itmValue) {
        this.itmName = itmName;
        this.itmValue = itmValue;

    }

    /**
     * gets nmes of the item
     *
     * @return item name
     */
    public String getItmName() {
        return itmName;
    }

    /**
     * sets name of the item
     *
     * @param itmName Name of the item
     */
    public void setItmName(final String itmName) {
        this.itmName = itmName;
    }

    /**
     * get the value of item
     *
     * @return vlaue of the item
     */
    public String getItmValue() {
        return itmValue;
    }

    /**
     * sets the value of item
     *
     * @param itmValue value of item
     */
    public void setItmValue(final String itmValue) {
        this.itmValue = itmValue;
    }


}
