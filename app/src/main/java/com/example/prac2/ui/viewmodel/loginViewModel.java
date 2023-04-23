package com.example.prac2.ui.viewmodel;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class loginViewModel {

    public void createFileSpecific(Context context, String filename, String fileContent){
        try(FileOutputStream fos = context.openFileOutput(filename+".txt", Context.MODE_PRIVATE)){
            fos.write(fileContent.getBytes());
            Log.i("file", "File path: " + context.getDataDir());
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void createFileExternal(Activity activity, String fileName, String fileContent){
        Context context = activity.getApplicationContext();
        if(context.getApplicationContext().checkSelfPermission(Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED){
            File filep = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
            File file = new File(filep, fileName+".txt");
            FileOutputStream ops;
            try{
                ops = new FileOutputStream(file);
                ops.write(fileContent.getBytes());
                ops.close();
                Log.i("file", "File path: " + filep);
            } catch (FileNotFoundException e) {
                throw new RuntimeException(e);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public void createFileSharedPreferences(Context context, String fileName, String fileContent){
        SharedPreferences pref = context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString("UserName", fileContent);
        editor.apply();
        Log.i("file", "File path: " + pref + fileName);
    }
}

