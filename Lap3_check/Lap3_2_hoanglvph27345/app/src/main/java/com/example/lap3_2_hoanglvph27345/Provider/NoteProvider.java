package com.example.lap3_2_hoanglvph27345.Provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lap3_2_hoanglvph27345.DAO.NoteDAO;

public class NoteProvider  extends ContentProvider {
    public static String AUTHOR = "com.example.lap3_2_hoanglvph27345.Provider";
    public static String TB_NOTE = "tb_mynote";

    // URI : content://com.example.lap3_2_hoanglvph27345.Provider/tb_mynote
    UriMatcher uriMatcher;
    NoteDAO noteDAO;
    Cursor cursor;
    @Override
    public boolean onCreate() {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHOR,TB_NOTE, 1);
        uriMatcher.addURI(AUTHOR, TB_NOTE + "/#", 2);
        noteDAO = new NoteDAO(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        int code_matcher = uriMatcher.match( uri );
        Log.d("zzzzzzzzzzzzz", "codematcher: " +code_matcher);
        switch (code_matcher){

            case 1:
                cursor = noteDAO.providerSelectAll(projection,selection,selectionArgs,sortOrder) ;
                break;
            case 2:
                String strWhere = "id_note = " + uri.getPathSegments().get(1);
                cursor = noteDAO.providerSelectAll(projection,strWhere,selectionArgs,sortOrder);
                break;
        }
        return cursor;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
