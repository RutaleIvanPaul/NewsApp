package com.kotlin.ivanpaulrutale.newsapp

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.kotlin.ivanpaulrutale.newsapp.models.Article_DB
import junit.framework.TestCase.assertEquals
import org.jetbrains.anko.db.*
import org.junit.Before
import org.junit.Test
import org.junit.After
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment

@RunWith(RobolectricTestRunner::class)
class DatabaseInsertRetrieveAndDeleteTest {

    private var databaseHelper: DbHelper? = null
    val article_DB = Article_DB(
        1,
        "BBC",
        "James",
        "Title",
        "Description",
        "url",
        "url/to/image",
        "published"
    )

    @Before
    fun createTestTable(){
        databaseHelper = DbHelper(RuntimeEnvironment.application)
        databaseTest{
            createTable(
                "Test_Article",true,
                "_id" to INTEGER + PRIMARY_KEY + AUTOINCREMENT,
                "source_name" to TEXT,
                "author" to TEXT,
                "title" to TEXT,
                "description" to TEXT,
                "url" to TEXT,
                "urlToImage" to TEXT,
                "publishedAt" to TEXT
            )

            val row_id = insert("Test_Article",
                "source_name" to article_DB.source,
                "author" to article_DB.author,
                "title" to article_DB.title,
                "description" to article_DB.description,
                "url"  to article_DB.url,
                "urlToImage" to article_DB.urlToImage,
                "publishedAt" to article_DB.publishedAt)

            assertEquals(1,row_id)
        }
    }

    @Test
    fun test_insert_saved_article(){
        databaseTest {
            select("Test_Article").exec {
                moveToNext()
                assertEquals(1, getLong(0))
                assertEquals("BBC", getString(1))
            }

        }
    }

    @Test
    fun test_delete_saved_article(){
        databaseTest {
            val number_rows_deleted = delete("Test_Article","_id=1", arrayOf())
            assertEquals(1,number_rows_deleted)
        }
    }

    @After
    fun deleteTestTable(){
        databaseHelper?.close()
        databaseHelper?.deleteDatabase()

    }


    private fun databaseTest(f: SQLiteDatabase.() -> Unit) =
        databaseHelper!!.writableDatabase.let(f)
}


class DbHelper(
    private val context: Context,
    private val dbName: String = "test_db"
) : SQLiteOpenHelper(
    context,
    dbName,
    null ,
    1
) {
    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

    }

    fun deleteDatabase() {
        context.deleteDatabase(dbName)
    }
}
