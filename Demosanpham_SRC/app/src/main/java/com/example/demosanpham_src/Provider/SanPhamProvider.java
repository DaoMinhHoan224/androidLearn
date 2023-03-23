package com.example.demosanpham_src.Provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.demosanpham_src.DAO.SanPhamDAO;

public class SanPhamProvider extends ContentProvider {
    public static String AUTHOR="com.example.demosanpham_src.Provider";
    public static String TB_SANPHAM="tb_sanpham";

    UriMatcher  uriMatcher; //quản lý danh sách uri và xác đijnh người dùng vào uri nào
    SanPhamDAO sanPhamDAO;
    Cursor cursor;
    @Override
    public boolean onCreate() {
        //khởi tạo các giá trị
        uriMatcher=new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHOR,TB_SANPHAM,1);// com.example.demosanpham_src.Provider/tb_sanpham
        uriMatcher.addURI(AUTHOR,TB_SANPHAM + "/#",2);// com.example.demosanpham_src.Provider/tb_sanpham/3

        // khởi tạo DAO
        sanPhamDAO=new SanPhamDAO(getContext());
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        int code_uri_matcher=uriMatcher.match(uri);
        Log.d("zzzzz","query: code uri= " + code_uri_matcher);

        switch (code_uri_matcher){
            case 1: //gọi DAO lấy tất cả các dữ liệu trong bảng
                cursor=sanPhamDAO.providerSelectAll(projection,selection,selectionArgs,sortOrder);
                break;
            case 2://xử lý lấy 1 bản ghi trả về
                String strWhere= "id = " + uri.getPathSegments().get(1);
                cursor= sanPhamDAO.providerSelectAll(projection,strWhere,selectionArgs,sortOrder);
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
