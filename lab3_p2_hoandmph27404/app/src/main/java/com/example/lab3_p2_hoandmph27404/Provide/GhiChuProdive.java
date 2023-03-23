package com.example.lab3_p2_hoandmph27404.Provide;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.lab3_p2_hoandmph27404.DAO.GhiChuDAO;

public class GhiChuProdive extends ContentProvider{

    public static String AUTHOR = "com.example.lab3_p2_hoandmph27404.Provide";
    public static String TB_NOTE= "tb_ghichu";

    UriMatcher uriMatcher;
    GhiChuDAO noteDAO;
    Cursor cursor;

    @Override
    public boolean onCreate() {
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHOR,TB_NOTE,1);
        uriMatcher.addURI(AUTHOR,TB_NOTE + "/#", 2);
        noteDAO=new GhiChuDAO(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        int code_matcher=uriMatcher.match(uri);
        switch (code_matcher){
            case 1:
                cursor=noteDAO.providerSelectAll(projection,selection,selectionArgs,sortOrder);
                break;
            case 2:
                String strWhere="id = " +uri.getPathSegments().get(1);
                cursor=noteDAO.providerSelectAll(projection,strWhere,selectionArgs,sortOrder);
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
