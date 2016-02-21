package appDB;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import com.j256.ormlite.android.apptools.OrmLiteSqliteOpenHelper;
import com.j256.ormlite.support.ConnectionSource;


public class QuizDBSQLiteHelper extends OrmLiteSqliteOpenHelper {

    private static QuizDBSQLiteHelper instance;

    public static synchronized QuizDBSQLiteHelper getHelper(Context context) {
        if (instance == null)
            instance = new QuizDBSQLiteHelper(context);
        return instance;
    }


    // Logcat tag
    private static final String LOG = QuizDBSQLiteHelper.class.getName();



    private static final String DATABASE_NAME_OLD = "quiznewmobi.db";
    private static final int DATABASE_VERSION_OLD = 1;


    public static final String THEMES_TABLE = "themes";
    public static final String THEMES_ID = "id";
    public static final String THEMES_DESCRIPTION = "description";
    public static final String THEMES_MAIN_BACKGROUND = "main_background";
    public static final String THEMES_QUESTION_BACKGROUND = "question_backeground";

    public static final String CATEGORY_TABLE = "category";
    public static final String CATEGORY_ID = "id";
    public static final String CATEGORY_NAME = "name";

    public static final String QUESTION_TYPE_TABLE = "question_type";
    public static final String QUESTION_TYPE_ID = "id";
    public static final String QUESTION_TYPE_NAME = "name";

    public static final String QUESTIONS_TABLE = "questions";
    public static final String QUESTIONS_ID = "id";
    public static final String QUESTIONS_TYPE = "type";
    public static final String QUESTIONS_DIFFICULT = "difficult";
    public static final String QUESTIONS_CATEGORY = "category_id";
    public static final String QUESTIONS_QUESTION = "question";
    public static final String QUESTIONS_QUESTION_1 = "option1";
    public static final String QUESTIONS_QUESTION_2 = "option2";
    public static final String QUESTIONS_QUESTION_3 = "option3";
    public static final String QUESTIONS_QUESTION_4 = "option4";
    public static final String QUESTIONS_ANSWER = "answer";

    public static final String APPLICATION_TABLE = "application";
    public static final String APPLICATION_ID = "id";
    public static final String APPLICATION_NAME = "name";

    public static final String VOUCHER_INTEGRATION_TABLE = "voucher_integration";
    public static final String VOUCHER_INTEGRATION_ID = "id";
    public static final String VOUCHER_INTEGRATION_NAME = "name";

    public static final String APPLICATION_PROFILE_TABLE = "application_profile";
    public static final String APPLICATION_PROFILE_ID = "id";
    public static final String APPLICATION_PROFILE_DESCRIPTION = "description";
    public static final String APPLICATION_PROFILE_AP_TYPE = "application_type";
    public static final String APPLICATION_PROFILE_MATCH_TIME = "match_time";
    public static final String APPLICATION_PROFILE_TOTAL_QUESTION = "total_questions";
    public static final String APPLICATION_PROFILE_VOUCHER_INTEGRATION_ID = "voucher_integration_id";

    public static final String TOTENS_TABLE = "totens";
    public static final String TOTENS_ID = "id";
    public static final String TOTENS_HASH = "hash";
    public static final String TOTENS_APPLICATION_PROFILE_ID = "application_profile_id";
    public static final String TOTENS_STATUS = "status";
    public static final String TOTENS_GEOLAT = "geolat";
    public static final String TOTENS_GEOLONG = "geolong";

    public static final String VOUCHER_HISTORIC_TABLE = "voucher_historic";
    public static final String VOUCHER_HISTORIC_ID = "id";
    public static final String VOUCHER_HISTORIC_TOTEN_ID = "totem_id";
    public static final String VOUCHER_HISTORIC_CREATION_TIMESTAMP = "creation_timestamp";
    public static final String VOUCHER_HISTORIC_DATA = "voucher_data";

    public static final String QUESTION_DIFICULT_TABLE = "question_difficult";
    public static final String QUESTION_DIFICULT_ID = "id";
    public static final String QUESTION_DIFICULT_NAME = "name";
    public static final String QUESTION_DIFICULT_RIGHT_ANSWER_POINTS = "right_answer_points";
    public static final String QUESTION_DIFICULT_WRONG_ANSWER_POINTS = "wrong_answer_points";


    private static final String CREATE_TABLE_THEMES = "CREATE TABLE IF NOT EXISTS "
            + THEMES_TABLE
            + "("
            + THEMES_ID + " integer primary key autoincrement,"
            + THEMES_DESCRIPTION + " text NOT NULL,"
            + THEMES_MAIN_BACKGROUND + " text NOT NULL,"
            + THEMES_QUESTION_BACKGROUND + " text NOT NULL"
            + ")";


    private static final String CREATE_TABLE_CATEGORY = "CREATE TABLE IF NOT EXISTS "
            + CATEGORY_TABLE
            + "("
            + CATEGORY_ID + " integer primary key autoincrement,"
            + CATEGORY_NAME + " text NOT NULL"
            + ")";


    private static final String CREATE_TABLE_QUESTION_TYPE = "CREATE TABLE IF NOT EXISTS "
            + QUESTION_TYPE_TABLE
            + "("
            + QUESTION_TYPE_ID + " integer primary key autoincrement,"
            + QUESTION_TYPE_NAME + " text NOT NULL"
            + ")";


    private static final String CREATE_TABLE_QUESTIONS = "CREATE TABLE IF NOT EXISTS "
            + QUESTIONS_TABLE
            + "("
            + QUESTIONS_ID + " integer primary key autoincrement,"
            + QUESTIONS_TYPE + " integer NOT NULL,"
            + QUESTIONS_DIFFICULT + " integer NOT NULL,"
            + QUESTIONS_CATEGORY + " integer NOT NULL,"
            + QUESTIONS_QUESTION + " text NOT NULL,"
            + QUESTIONS_QUESTION_1 + " text NOT NULL,"
            + QUESTIONS_QUESTION_2 + " text NOT NULL,"
            + QUESTIONS_QUESTION_3 + " text NOT NULL,"
            + QUESTIONS_QUESTION_4 + " text NOT NULL,"
            + QUESTIONS_ANSWER + " integer NOT NULL"
            + ")";


    private static final String CREATE_TABLE_APPLICATION = "CREATE TABLE IF NOT EXISTS "
            + APPLICATION_TABLE
            + "("
            + APPLICATION_ID + " integer primary key autoincrement,"
            + APPLICATION_NAME + " text NOT NULL"
            + ")";


    private static final String CREATE_TABLE_VOUCHER_INTEGRATION = "CREATE TABLE IF NOT EXISTS "
            + VOUCHER_INTEGRATION_TABLE
            + "("
            + VOUCHER_INTEGRATION_ID + " integer primary key autoincrement,"
            + VOUCHER_INTEGRATION_NAME + " text NOT NULL"
            + ")";


    private static final String CREATE_TABLE_APPLICATION_PROFILE = "CREATE TABLE IF NOT EXISTS "
            + APPLICATION_PROFILE_TABLE
            + "("
            + APPLICATION_PROFILE_ID + " integer primary key autoincrement,"
            + APPLICATION_PROFILE_DESCRIPTION + " text NOT NULL,"
            + APPLICATION_PROFILE_AP_TYPE + " integer NOT NULL,"
            + APPLICATION_PROFILE_MATCH_TIME + " integer NOT NULL,"
            + APPLICATION_PROFILE_TOTAL_QUESTION + " integer NOT NULL,"
            + APPLICATION_PROFILE_VOUCHER_INTEGRATION_ID + " integer NOT NULL"
            + ")";


    private static final String CREATE_TABLE_TOTENS = "CREATE TABLE IF NOT EXISTS "
            + TOTENS_TABLE
            + "("
            + TOTENS_ID + " integer primary key autoincrement,"
            + TOTENS_HASH + " text NOT NULL,"
            + TOTENS_APPLICATION_PROFILE_ID + " integer NOT NULL,"
            + TOTENS_STATUS + " integer NOT NULL,"
            + TOTENS_GEOLAT + " text NOT NULL,"
            + TOTENS_GEOLONG + " text NOT NULL"
            + ")";


    private static final String CREATE_TABLE_VOUCHER_HISTORIC = "CREATE TABLE IF NOT EXISTS "
            + VOUCHER_HISTORIC_TABLE
            + "("
            + VOUCHER_HISTORIC_ID + " integer primary key autoincrement,"
            + VOUCHER_HISTORIC_TOTEN_ID + " integer NOT NULL,"
            + VOUCHER_HISTORIC_CREATION_TIMESTAMP + " TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,"
            + VOUCHER_HISTORIC_DATA + " text NOT NULL"
            + ")";


    private static final String CREATE_TABLE_QUESTION_DIFFICULT = "CREATE TABLE IF NOT EXISTS "
            + QUESTION_DIFICULT_TABLE
            + "("
            + QUESTION_DIFICULT_ID + " integer primary key autoincrement,"
            + QUESTION_DIFICULT_NAME + " text NOT NULL,"
            + QUESTION_DIFICULT_RIGHT_ANSWER_POINTS + " integer NOT NULL,"
            + QUESTION_DIFICULT_WRONG_ANSWER_POINTS + " integer NOT NULL"
            + ")";





    public QuizDBSQLiteHelper(Context context) {
        super(context, DATABASE_NAME_OLD, null, DATABASE_VERSION_OLD);

    }



    @Override
    public void onCreate(SQLiteDatabase database, ConnectionSource connectionSource) {

        database.execSQL(CREATE_TABLE_THEMES);
        database.execSQL(CREATE_TABLE_CATEGORY);
        database.execSQL(CREATE_TABLE_QUESTION_TYPE);
        database.execSQL(CREATE_TABLE_QUESTIONS);
        database.execSQL(CREATE_TABLE_APPLICATION);
        database.execSQL(CREATE_TABLE_APPLICATION_PROFILE);
        database.execSQL(CREATE_TABLE_VOUCHER_HISTORIC);
        database.execSQL(CREATE_TABLE_VOUCHER_INTEGRATION);
        database.execSQL(CREATE_TABLE_TOTENS);
        database.execSQL(CREATE_TABLE_QUESTION_DIFFICULT);


    }

    @Override
    public void onUpgrade(SQLiteDatabase database, ConnectionSource connectionSource, int oldVersion, int newVersion) {

    }





    public void executeQuery(String query) {
        try {

            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(query);

        } catch (Exception e) {

            System.out.println("DATABASE ERROR" + e);
        }
    }

    public Cursor selectQuery(String query) {
        Cursor c1 = null;
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            c1 = db.rawQuery(query, null);


        } catch (Exception e) {

            System.out.println("DATABASE ERROR" + e);

        }

        return c1;
    }


    // closing database //
    public void closeDB() {
        SQLiteDatabase db = this.getReadableDatabase();
        if (db != null && db.isOpen())
            db.close();
    }


}





























  /*
    public static final String THEMES_TABLE = "themes";
    public static final String THEMES_ID = "id";
    public static final String THEMES_DESCRIPTION = "description";
    public static final String THEMES_MAIN_BACKGROUND = "main_background";
    public static final String THEMES_QUESTION_BACKGROUND = "question_backeground";

    public static final String CATEGORY_TABLE = "category";
    public static final String CATEGORY_ID = "id";
    public static final String CATEGORY_NAME = "name";

    public static final String QUESTION_TYPE_TABLE = "question_type";
    public static final String QUESTION_TYPE_ID = "id";
    public static final String QUESTION_TYPE_NAME = "name";

    public static final String QUESTIONS_TABLE = "questions";
    public static final String QUESTIONS_ID = "id";
    public static final String QUESTIONS_TYPE = "type";
    public static final String QUESTIONS_CATEGORY = "category_id";
    public static final String QUESTIONS_QUESTION = "question";
    public static final String QUESTIONS_QUESTION_1 = "option1";
    public static final String QUESTIONS_QUESTION_2 = "option2";
    public static final String QUESTIONS_QUESTION_3 = "option3";
    public static final String QUESTIONS_QUESTION_4 = "option4";
    public static final String QUESTIONS_ANSWER = "answer";

    public static final String APPLICATION_TABLE = "application";
    public static final String APPLICATION_ID = "id";
    public static final String APPLICATION_NAME = "name";

    public static final String VOUCHER_INTEGRATION_TABLE = "application";
    public static final String VOUCHER_INTEGRATION_ID = "id";
    public static final String VOUCHER_INTEGRATION_NAME = "name";

    public static final String APPLICATION_PROFILE_TABLE = "application_profile";
    public static final String APPLICATION_PROFILE_ID = "id";
    public static final String APPLICATION_PROFILE_DESCRIPTION = "description";
    public static final String APPLICATION_PROFILE_AP_TYPE = "application_type";
    public static final String APPLICATION_PROFILE_MATCH_TIME = "match_time";
    public static final String APPLICATION_PROFILE_TOTAL_QUESTION = "total_questions";
    public static final String APPLICATION_PROFILE_VOUCHER_INTEGRATION_ID = "voucher_integration_id";

    public static final String TOTENS_TABLE = "totens";
    public static final String TOTENS_ID = "id";
    public static final String TOTENS_HASH = "hash";
    public static final String TOTENS_APPLICATION_PROFILE_ID = "application_profile_id";
    public static final String TOTENS_STATUS = "status";
    public static final String TOTENS_GEOLAT = "geolat";
    public static final String TOTENS_GEOLONG = "geolong";

    public static final String VOUCHER_HISTORIC_TABLE = "voucher_historic";
    public static final String VOUCHER_HISTORIC_ID = "id";
    public static final String VOUCHER_HISTORIC_TOTEN_ID = "totem_id";
    public static final String VOUCHER_HISTORIC_CREATION_TIMESTAMP = "creation_timestamp";
    public static final String VOUCHER_HISTORIC_DATA = "voucher_data";

    public static final String QUESTION_DIFICULT_TABLE = "question_difficult";
    public static final String QUESTION_DIFICULT_ID = "id";
    public static final String QUESTION_DIFICULT_NAME = "name";
    public static final String QUESTION_DIFICULT_RIGHT_ANSWER_POINTS = "right_answer_points";
    public static final String QUESTION_DIFICULT_WRONG_ANSWER_POINTS = "wrong_answer_points";


    private static final String CREATE_TABLE_THEMES = "CREATE TABLE IF NOT EXISTS "
            + THEMES_TABLE
            + "("
            + THEMES_ID + " integer primary key autoincrement,"
            + THEMES_DESCRIPTION + " text NOT NULL,"
            + THEMES_MAIN_BACKGROUND + " text NOT NULL,"
            + THEMES_QUESTION_BACKGROUND + " text NOT NULL"
            + ")";


    private static final String CREATE_TABLE_CATEGORY = "CREATE TABLE IF NOT EXISTS "
            + CATEGORY_TABLE
            + "("
            + CATEGORY_ID + " integer primary key autoincrement,"
            + CATEGORY_NAME + " text NOT NULL"
            + ")";


    private static final String CREATE_TABLE_QUESTION_TYPE = "CREATE TABLE IF NOT EXISTS "
            + QUESTION_TYPE_TABLE
            + "("
            + QUESTION_TYPE_ID + " integer primary key autoincrement,"
            + QUESTION_TYPE_NAME + " text NOT NULL"
            + ")";


    private static final String CREATE_TABLE_QUESTIONS = "CREATE TABLE IF NOT EXISTS "
            + QUESTIONS_TABLE
            + "("
            + QUESTIONS_ID + " integer primary key autoincrement,"
            + QUESTIONS_TYPE + " integer NOT NULL,"
            + QUESTIONS_CATEGORY + " integer NOT NULL,"
            + QUESTIONS_QUESTION + " text NOT NULL,"
            + QUESTIONS_QUESTION_1 + " text NOT NULL,"
            + QUESTIONS_QUESTION_2 + " text NOT NULL,"
            + QUESTIONS_QUESTION_3 + " text NOT NULL,"
            + QUESTIONS_QUESTION_4 + " text NOT NULL,"
            + QUESTIONS_ANSWER + " integer NOT NULL"
            + ")";


    private static final String CREATE_TABLE_APPLICATION = "CREATE TABLE IF NOT EXISTS "
            + APPLICATION_TABLE
            + "("
            + APPLICATION_ID + " integer primary key autoincrement,"
            + APPLICATION_NAME + " text NOT NULL"
            + ")";


    private static final String CREATE_TABLE_VOUCHER_INTEGRATION = "CREATE TABLE IF NOT EXISTS "
            + VOUCHER_INTEGRATION_TABLE
            + "("
            + VOUCHER_INTEGRATION_ID + " integer primary key autoincrement,"
            + VOUCHER_INTEGRATION_NAME + " text NOT NULL"
            + ")";


    private static final String CREATE_TABLE_APPLICATION_PROFILE = "CREATE TABLE IF NOT EXISTS "
            + APPLICATION_PROFILE_TABLE
            + "("
            + APPLICATION_PROFILE_ID + " integer primary key autoincrement,"
            + APPLICATION_PROFILE_DESCRIPTION + " text NOT NULL,"
            + APPLICATION_PROFILE_AP_TYPE + " integer NOT NULL,"
            + APPLICATION_PROFILE_MATCH_TIME + " integer NOT NULL,"
            + APPLICATION_PROFILE_TOTAL_QUESTION + " integer NOT NULL,"
            + APPLICATION_PROFILE_VOUCHER_INTEGRATION_ID + " integer NOT NULL"
            + ")";


    private static final String CREATE_TABLE_TOTENS = "CREATE TABLE IF NOT EXISTS "
            + TOTENS_TABLE
            + "("
            + TOTENS_ID + " integer primary key autoincrement,"
            + TOTENS_HASH + " text NOT NULL,"
            + TOTENS_APPLICATION_PROFILE_ID + " integer NOT NULL,"
            + TOTENS_STATUS + " integer NOT NULL,"
            + TOTENS_GEOLAT + " text NOT NULL,"
            + TOTENS_GEOLONG + " text NOT NULL"
            + ")";


    private static final String CREATE_TABLE_VOUCHER_HISTORIC = "CREATE TABLE IF NOT EXISTS "
            + VOUCHER_HISTORIC_TABLE
            + "("
            + VOUCHER_HISTORIC_ID + " integer primary key autoincrement,"
            + VOUCHER_HISTORIC_TOTEN_ID + " integer NOT NULL,"
            + VOUCHER_HISTORIC_CREATION_TIMESTAMP + " TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,"
            + VOUCHER_HISTORIC_DATA + " text NOT NULL"
            + ")";


    private static final String CREATE_TABLE_QUESTION_DIFFICULT = "CREATE TABLE IF NOT EXISTS "
            + QUESTION_DIFICULT_TABLE
            + "("
            + QUESTION_DIFICULT_ID + " integer primary key autoincrement,"
            + QUESTION_DIFICULT_NAME + " text NOT NULL,"
            + QUESTION_DIFICULT_RIGHT_ANSWER_POINTS + " integer NOT NULL,"
            + QUESTION_DIFICULT_WRONG_ANSWER_POINTS + " integer NOT NULL"
            + ")";


    public QuizDBSQLiteHelper(Context context) {
        //super(context, DATABASE_NAME_OLD, null, DATABASE_VERSION_OLD);
        super(context, DATABASE_NAME_OLD, context.getExternalFilesDir(null).getAbsolutePath(), null, DATABASE_VERSION_OLD);

    }



    public void onCreate(SQLiteDatabase db, ConnectionSource connectionSource) {
        db.execSQL(CREATE_TABLE_THEMES);
        db.execSQL(CREATE_TABLE_CATEGORY);
        db.execSQL(CREATE_TABLE_QUESTION_TYPE);
        db.execSQL(CREATE_TABLE_QUESTIONS);
        db.execSQL(CREATE_TABLE_APPLICATION);
        db.execSQL(CREATE_TABLE_APPLICATION_PROFILE);
        db.execSQL(CREATE_TABLE_VOUCHER_HISTORIC);
        db.execSQL(CREATE_TABLE_VOUCHER_INTEGRATION);
        db.execSQL(CREATE_TABLE_TOTENS);
        db.execSQL(CREATE_TABLE_QUESTION_DIFFICULT);
    }


    public void onUpgrade(SQLiteDatabase db, ConnectionSource connectionSource, int oldVersion, int newVersion) {


        /*
        db.execSQL("DROP TABLE IF EXISTS " + L_TABELA); // USUARIOS
        db.execSQL("DROP TABLE IF EXISTS " + C_TABELA); // CAMBIO
        db.execSQL("DROP TABLE IF EXISTS " + ML_TABELA); // MAQUINAS
        db.execSQL("DROP TABLE IF EXISTS " + PM_TABELA); // PAGAMENTOS
        db.execSQL("DROP TABLE IF EXISTS " + LEITURAS_TABELA); // LEITURAS
        db.execSQL("DROP TABLE IF EXISTS " + INICIO_TURNO_TABELA); // INICIO TURNO
        db.execSQL("DROP TABLE IF EXISTS " + TURNO_TABELA); // INICIO TURNO
        db.execSQL("DROP TABLE IF EXISTS " + MESTRE_TABELA); // SENHA MESTRE
        db.execSQL("DROP TABLE IF EXISTS " + TURNOS_ATIVADOS_TABELA); // TURNOS ATIVADOS

        //onCreate(db);
    }
*/



/*

    public String alteraTurnosAtivosTerceiro(String id, String terceiroTurno) {
        ContentValues valores;
        String where;

        SQLiteDatabase db = this.getWritableDatabase();
        where = TURNOS_ATIVADOS_ID + "=" + id;

        valores = new ContentValues();
        valores.put(TURNOS_ATIVADOS_TERCEIRO, terceiroTurno);

        db.update(TURNOS_ATIVADOS_TABELA, valores, where, null);

        db.close();
        return where;
    }

    public String alteraTurnosAtivosQuarto(String id, String quartoTurno) {
        ContentValues valores;
        String where;

        SQLiteDatabase db = this.getWritableDatabase();
        where = TURNOS_ATIVADOS_ID + "=" + id;

        valores = new ContentValues();
        valores.put(TURNOS_ATIVADOS_QUARTO, quartoTurno);

        db.update(TURNOS_ATIVADOS_TABELA, valores, where, null);

        db.close();
        return where;
    }


    // Inserir dados
    public String insereTurnosAtivadosPadrao(String primeiroTurno, String segundoTurno, String terceiroTurno, String quartoTurno) {
        ContentValues valores;
        long resultado;

        SQLiteDatabase db = this.getWritableDatabase();
        valores = new ContentValues();

        valores.put(TURNOS_ATIVADOS_PRIMEIRO, primeiroTurno);
        valores.put(TURNOS_ATIVADOS_SEGUNDO, segundoTurno);
        valores.put(TURNOS_ATIVADOS_TERCEIRO, terceiroTurno);
        valores.put(TURNOS_ATIVADOS_QUARTO, quartoTurno);

        resultado = db.insertOrThrow(TURNOS_ATIVADOS_TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }


    // ---------------------------- OPERACOES DE LOGIN ---------------------------- //
    // Inserir dados
    public String insereDadoLogin(String nome, String senha, String statusPadrao, String criadoEmData, String criadoEmHora) {
        ContentValues valores;
        long resultado;

        SQLiteDatabase db = this.getWritableDatabase();
        valores = new ContentValues();
        valores.put(L_NOME, nome);
        valores.put(L_SENHA, senha);
        valores.put(L_STATUS, statusPadrao);
        valores.put(L_CRIADO_EM_DATA, criadoEmData);
        valores.put(L_CRIADO_EM_HORA, criadoEmHora);

        resultado = db.insertOrThrow(L_TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    // Carregar lista de usuarios
    public List<String> carregarUsuario() {
        List<String> allusers = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        cursor = db.query(L_TABELA, new String[]{String.valueOf(L_NOME)}, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                allusers.add(cursor.getString(cursor.getColumnIndex(QuizDBSQLiteHelper.L_NOME)));
                cursor.moveToNext();
            }

        }
        db.close();
        return allusers;

    }

    // Carregar lista de usuarios
    public String senhaMestre() {
        String mestre = "";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        cursor = db.query(MESTRE_TABELA, new String[]{String.valueOf(MESTRE_SENHA)}, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                mestre = cursor.getString(cursor.getColumnIndex(QuizDBSQLiteHelper.MESTRE_SENHA));
                cursor.moveToNext();
            }
        }
        db.close();
        return String.valueOf(mestre);
    }


    // INSERE TURNO
    public String insereSenhaMestre() {
        ContentValues valores;
        long resultado;

        SQLiteDatabase db = this.getWritableDatabase();
        valores = new ContentValues();
        valores.put(MESTRE_SENHA, "123mudar123");
        resultado = db.insertOrThrow(MESTRE_TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }


    // Carrega lista de senhas
    public List<String> carregarSenha() {
        List<String> contentPass = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        cursor = db.query(L_TABELA, new String[]{String.valueOf(L_SENHA)}, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                contentPass.add(cursor.getString(cursor.getColumnIndex(QuizDBSQLiteHelper.L_SENHA)));
                cursor.moveToNext();
            }
        }
        db.close();
        return contentPass;
    }

    // carrega dados por ID
    public Cursor carregaDadoLoginById(int id) {
        Cursor cursor;
        String[] campos = {L_ID, L_NOME, L_SENHA};
        String where = L_ID + "=" + id;
        SQLiteDatabase db = this.getReadableDatabase();
        cursor = db.query(L_TABELA, campos, where, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
        }
        db.close();
        return cursor;
    }

    // ------------------------------------------------------------------------------------ //

    // ---------------------------- OPERACOES DE CAMBIO ---------------------------- //

    // Inserir dados
    public String insereDadoCambio(String valor, String turno, String atendente, String criadoEmData, String criadoEmHora) {
        ContentValues valores;
        long resultado;

        SQLiteDatabase db = this.getWritableDatabase();
        valores = new ContentValues();
        valores.put(C_VALOR, valor);
        valores.put(C_TURNO, turno);
        valores.put(C_ATENDENTE, atendente);
        valores.put(C_CRIADO_EM_DATA, criadoEmData);
        valores.put(C_CRIADO_EM_HORA, criadoEmHora);

        resultado = db.insertOrThrow(C_TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }


    public Cursor carregaDadosCambio() {
        Cursor mCursor;
        String[] campos = {C_ID, C_VALOR, C_ATENDENTE, C_CRIADO_EM_DATA, C_CRIADO_EM_HORA};
        String where = C_ID;
        SQLiteDatabase db = this.getReadableDatabase();
        mCursor = db.query(C_TABELA, campos, where, null, null, null, null, null);

        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        db.close();
        return mCursor;
    }

    // Mostrar cambio
    public List<String> getCambioTotal() {

        List<String> contentCambio = new ArrayList<>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        cursor = db.query(C_TABELA, new String[]{String.valueOf(C_VALOR)}, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                contentCambio.add(cursor.getString(cursor.getColumnIndex(C_VALOR)));
                cursor.moveToNext();
            }
        }

        db.close();
        return contentCambio;

    }


    // ------------------------ OPERACAO LISTA DE MAQUINAS --------------------------------- //


    public String insereListaDeMaquinas(String nome, String identificacao, String valor_em_reais, String criadoEmData, String criadoEmHora) {
        ContentValues valores;
        long resultado;

        SQLiteDatabase db = this.getWritableDatabase();
        valores = new ContentValues();
        valores.put(ML_NOME, nome);
        valores.put(ML_IDENTIFICACAO, identificacao);
        valores.put(ML_VALOR_EM_REAIS, valor_em_reais);
        valores.put(ML_CRIADO_EM_DATA, criadoEmData);
        valores.put(ML_CRIADO_EM_HORA, criadoEmHora);

        resultado = db.insertOrThrow(ML_TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }


    public String importaListaMaquinasServidor() {

        String exporDir = String.valueOf(Environment.getExternalStorageDirectory());
        FileReader file = null;
        try {
            file = new FileReader(exporDir + "/" + "ListaDeMaquinasAtualizadas.csv");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BufferedReader buffer = null;
        if (file != null) {
            buffer = new BufferedReader(file);
        }
        String line = "";
        String tableName = ML_TABELA;
        String str1 = "INSERT OR REPLACE INTO " + tableName + " values(";
        String str2 = ");";

        SQLiteDatabase db = this.getWritableDatabase();
        db.beginTransaction();
        try {
            if (buffer != null) {
                while ((line = buffer.readLine()) != null) {
                    StringBuilder sb = new StringBuilder(str1);
                    String[] str = line.split(",");
                    sb.append("'").append(str[0].replace("\"", "")).append("','");
                    sb.append(str[1].replace("\"", "")).append("','");
                    sb.append(str[2].replace("\"", "")).append("','");
                    sb.append(str[3].replace("\"", "")).append("','");
                    sb.append(str[4].replace("\"", "")).append("','");
                    sb.append(str[5].replace("\"", "")).append("'");
                    sb.append(str2);
                    db.execSQL(sb.toString());
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        db.setTransactionSuccessful();
        db.endTransaction();
        db.close();
        return "OK";
    }


    public void dropTableMaquinas() {

        SQLiteDatabase db = this.getWritableDatabase();
        db.execSQL("DROP TABLE IF EXISTS " + ML_TABELA);
        db.execSQL(CREATE_TABLE_LISTA_MAQUINAS);
        db.close();

    }


    // ------------------------------------------------------------------------------------ //


    // -------------------------- OPERACOES DE PAGAMENTO MANUAL ---------------------------- //


    // Inserir dados
    public String inserePagamentosManuais(String maquina, String grupo, String creditos, String valor, String validacao, String atendente, String turno, String criadoEmData, String criadoEmHora, String hashid, String data_global) {
        ContentValues valores;
        long resultado;

        SQLiteDatabase db = this.getWritableDatabase();
        valores = new ContentValues();
        valores.put(PM_MAQUINA, maquina);
        valores.put(PM_GRUPO, grupo);
        valores.put(PM_CREDITOS, creditos);
        valores.put(PM_VALOR_EM_REAIS, valor);
        valores.put(PM_VALIDACAO, validacao);
        valores.put(PM_ATENDENTE, atendente);
        valores.put(PM_TURNO, turno);
        valores.put(PM_CRIADO_EM_DATA, criadoEmData);
        valores.put(PM_CRIADO_EM_HORA, criadoEmHora);
        valores.put(PM_SINCRONIZACAO, "nsinc");
        valores.put(PM_HASHID, hashid);
        valores.put(PM_CRIADO_EM_HORA_GLOBAL, data_global);


        resultado = db.insertOrThrow(PM_TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Pagamento registrado com sucesso.";
    }


    // Mostrar cambio
    public List<String> getValidacoesPagamentoManual() {

        List<String> contentCambio = new ArrayList<String>();

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor;
        cursor = db.query(PM_TABELA, new String[]{String.valueOf(PM_VALIDACAO)}, null, null, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            while (!cursor.isAfterLast()) {
                contentCambio.add(cursor.getString(cursor.getColumnIndex(PM_VALIDACAO)));
                cursor.moveToNext();
            }
        }

        db.close();
        return contentCambio;

    }


    // ##### ------------------ FUNCOES LEITURA --------------------- ##### //

    // Inserir dados
    public String insereAberturaFechamento(String maquina, String grupo, String entrada, String saida, String atendente, String criadoEmData, String criadoEmHora, String turno, String sinc, String hashid, String l_data_global) {
        ContentValues valores;
        long resultado;

        SQLiteDatabase db = this.getWritableDatabase();
        valores = new ContentValues();
        valores.put(LEITURAS_MAQUINA, maquina);
        valores.put(LEITURAS_GRUPO, grupo);
        valores.put(LEITURAS_ENTRADA, entrada);
        valores.put(LEITURAS_SAIDA, saida);
        valores.put(LEITURAS_ATENDENTE, atendente);
        valores.put(LEITURAS_CRIADO_EM_DATA, criadoEmData);
        valores.put(LEITURAS_CRIADO_EM_HORA, criadoEmHora);
        valores.put(LEITURAS_TURNO, turno);
        valores.put(LEITURAS_SINCRONIZACAO, sinc);
        valores.put(LEITURAS_HASHID, hashid);
        valores.put(LEITURAS_CRIADO_EM_HORA_GLOBAL, l_data_global);

        resultado = db.insertOrThrow(LEITURAS_TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Leitura registrado com sucesso.";
    }


    // ---------------------------------------------------------------------------------------//

    // ---------------------------- OPERACOES DE INICIO TURNO ---------------------------- //

    // INSERE ACESSO TURNO
    public String insereAcessoTurno(String turno, String usuario, String status_fechamento, String criadoEmData, String criadoEmHora, String i_data_global) {
        ContentValues valores;
        long resultado;

        SQLiteDatabase db = this.getWritableDatabase();
        valores = new ContentValues();
        valores.put(INICIO_TURNO_TURNO, turno);
        valores.put(INICIO_TURNO_USUARIO, usuario);
        valores.put(INICIO_TURNO_STATUS_CAIXA, status_fechamento);
        valores.put(INICIO_TURNO_CRIADO_EM_DATA, criadoEmData);
        valores.put(INICIO_TURNO_CRIADO_EM_HORA, criadoEmHora);
        valores.put(INICIO_TURNO_CRIADO_EM_HORA_GLOBAL, i_data_global);

        resultado = db.insertOrThrow(INICIO_TURNO_TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }

    // INSERE TURNO
    public String insereTurnoAtual(String turno) {
        ContentValues valores;
        long resultado;

        SQLiteDatabase db = this.getWritableDatabase();
        valores = new ContentValues();
        valores.put(TURNO_TURNO, turno);
        resultado = db.insertOrThrow(TURNO_TABELA, null, valores);
        db.close();

        if (resultado == -1)
            return "Erro ao inserir registro";
        else
            return "Registro Inserido com sucesso";
    }


    // ALTERA ACESSO TURNO
    public String alteraAcessoTurno(String id, String status_fechamento) {
        ContentValues valores;
        String where;

        SQLiteDatabase db = this.getWritableDatabase();
        where = INICIO_TURNO_ID + "=" + id;
        valores = new ContentValues();
        valores.put(INICIO_TURNO_STATUS_CAIXA, status_fechamento);

        db.update(INICIO_TURNO_TABELA, valores, where, null);

        db.close();
        return where;
    }

    public void drop_INFOS_TURNO_ATUAL() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Criar se nao existir
        db.execSQL(CREATE_TABLE_CAMBIO);
        db.execSQL(CREATE_TABLE_PAGAMENTOS_MANUAIS);
        db.execSQL(CREATE_TABLE_LEITURAS);
        db.execSQL(CREATE_TABLE_TURNO);

        // Apagar caso existir
        db.execSQL("DROP TABLE IF EXISTS " + C_TABELA);
        db.execSQL("DROP TABLE IF EXISTS " + PM_TABELA);
        db.execSQL("DROP TABLE IF EXISTS " + LEITURAS_TABELA);
        db.execSQL("DROP TABLE IF EXISTS " + TURNO_TABELA);

        // Recriar apos apagar
        db.execSQL(CREATE_TABLE_CAMBIO);
        db.execSQL(CREATE_TABLE_PAGAMENTOS_MANUAIS);
        db.execSQL(CREATE_TABLE_LEITURAS);
        db.execSQL(CREATE_TABLE_TURNO);

        // Fecha conexao
        db.close();
    }

    public void drop_ACESSOS_TURNO_ATUAL() {
        SQLiteDatabase db = this.getWritableDatabase();
        // Criar se nao existir
        db.execSQL(CREATE_TABLE_INICIO_TURNO);
        // Apagar caso existir
        db.execSQL("DROP TABLE IF EXISTS " + INICIO_TURNO_TABELA);
        // Recriar apos apagar
        db.execSQL(CREATE_TABLE_INICIO_TURNO);
        // Fecha conexao
        db.close();
    }


    public void executeQuery(String query) {
        try {

            SQLiteDatabase db = this.getWritableDatabase();
            db.execSQL(query);

        } catch (Exception e) {

            System.out.println("DATABASE ERROR" + e);
        }
    }

    public Cursor selectQuery(String query) {
        Cursor c1 = null;
        try {
            SQLiteDatabase db = this.getWritableDatabase();
            c1 = db.rawQuery(query, null);


        } catch (Exception e) {

            System.out.println("DATABASE ERROR" + e);

        }

        return c1;
    }

*/
