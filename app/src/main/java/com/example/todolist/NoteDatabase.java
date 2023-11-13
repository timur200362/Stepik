package com.example.todolist;

import android.app.Application;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Note.class}, version = 1, exportSchema = false)
public abstract class NoteDatabase extends RoomDatabase {

    private static NoteDatabase instance = null;
    private static final String DB_NAME = "notes.db";

    public static NoteDatabase getInstance(Application application){//не храним, т.к при удалении активити у бд будет ссылка и будет работать с
        //удаленной активити, утечка памяти
        if (instance==null){
            instance = Room.databaseBuilder(
                    application,
                    NoteDatabase.class,
                    DB_NAME
            )
                    .build();//build создаст наследника класса NoteDabase и вернёт его объект
        }
        return instance;
    }

    public abstract NotesDao notesDao();
}
