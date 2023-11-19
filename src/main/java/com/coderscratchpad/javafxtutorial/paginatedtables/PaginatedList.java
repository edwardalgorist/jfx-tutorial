package com.coderscratchpad.javafxtutorial.paginatedtables;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 * Code of the tutorial described on
 * <a href="https://coderscratchpad.com/handling-big-data-with-javafx-paginated-tables/">coderscratchpad.com</a>
 */
public class PaginatedList<T> {

    private final ObservableList<T> data;
    private final int itemsPerPage;
    private int currentPageIndex;

    public PaginatedList(ObservableList<T> data, int itemsPerPage) {
        this.data = data;
        this.itemsPerPage = itemsPerPage;
        this.currentPageIndex = 0;
    }

    public ObservableList<T> getCurrentPageData() {

        int fromIndex = currentPageIndex * itemsPerPage;
        int toIndex = Math.min(fromIndex + itemsPerPage, data.size());

        return FXCollections.observableArrayList(data.subList(fromIndex, toIndex));

    }

    public int getTotalPages() {
        return (int) Math.ceil((double) data.size() / itemsPerPage);
    }

    public void setCurrentPageIndex(int pageIndex) {
        currentPageIndex = pageIndex;
    }

}