package com.khanhlinhit.mychecklist;

import android.provider.BaseColumns;

/**
 * Created by khanhlinh.it on 5/17/2016.
 */
public final class ListReader {
    public ListReader(){

    }

    public static abstract class HeaderEntry implements BaseColumns {
        public static final String TABLE_NAME = "Header";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_DESC = "description";
        public static final String COLUMN_NAME_NOTE = "note";
    }

    public static abstract class ItemEntry implements BaseColumns {
        public static final String TABLE_NAME = "Item";
        public static final String COLUMN_NAME_ENTRY_ID = "entryid";
        public static final String COLUMN_NAME_DESC = "description";
        public static final String COLUMN_NAME_NOTE = "note";
        public static final String COLUMN_NAME_AMOUNT = "amount";
    }
}
