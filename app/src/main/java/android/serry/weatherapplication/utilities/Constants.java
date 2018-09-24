package android.serry.weatherapplication.utilities;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.migration.Migration;
import android.support.annotation.NonNull;

public class Constants {

    public static final String API_BASE_URL = "api.openweathermap.org/data/2.5/";
    public static final String APP_ID = "d7255890eae9963786f580e3eedadfb0";
    public static final String DATABASE = "Database";

    public static Migration addMigration(int firstNo, int secondNo) {
        return new Migration(firstNo, secondNo) {
            @Override
            public void migrate(@NonNull SupportSQLiteDatabase database) {

            }
        };
    }
}
